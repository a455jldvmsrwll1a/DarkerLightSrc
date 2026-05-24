package ph.jldvmsrwll1a.darkerlightsrc;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import ph.jldvmsrwll1a.darkerlightsrc.exception.RuleConfigParseException;

public final class BlockLightLevels {

    private final IdentityHashMap<Block, Rule> levels;
    private final int defaultLevel;

    private BlockLightLevels(IdentityHashMap<Block, Rule> levels, int defaultLevel) {
        this.levels = levels;
        this.defaultLevel = defaultLevel;
    }

    public int getLightCap(Block block) {
        Rule rule = levels.get(block);

        if (rule != null) {
            return rule.lightLevel;
        } else {
            return defaultLevel;
        }
    }

    public int tableSize() {
        return levels.size();
    }

    public record Rule(boolean appliedByTag, int lightLevel) {}

    public static class Builder {

        private int defaultCap;
        private final IdentityHashMap<Block, Rule> states = new IdentityHashMap<>();
        private final ArrayList<String> errors = new ArrayList<>();

        public BlockLightLevels build() {
            if (!errors.isEmpty()) {
                throw RuleConfigParseException.fromErrors(errors);
            }

            return new BlockLightLevels(states, defaultCap);
        }

        public Builder useBuiltin() {
            defaultCap = DefaultLevels.DEFAULT_LEVEL;
            DefaultLevels.DEFAULT_TABLE.forEach(rule -> addRule(rule, -1));

            return this;
        }

        public Builder defaultCap(int cap) {
            defaultCap = cap;

            return this;
        }

        public Builder addRule(String rule, int line) {
            String[] tokens = rule.strip().split("\\s+");

            if (tokens.length == 0) {
                return this;
            }

            if (tokens.length > 2) {
                errors.add("Line %d: unexpected trailing data.".formatted(line));
                return this;
            }

            int value = 15;
            if (tokens.length == 2) {
                try {
                    value = Integer.parseInt(tokens[1]);
                } catch (NumberFormatException ignored) {
                    errors.add("Line %d: cannot parse '%s' as an integer.".formatted(line, tokens[1]));
                    return this;
                }

                if (value < 0 || value > 15) {
                    errors.add("Line %d: the value %d is not a valid light level [0, 15].".formatted(line, value));
                    return this;
                }
            }

            if (rule.startsWith("#")) {
                addTagRule(tokens[0], value);
            } else {
                addBlockRule(tokens[0], value);
            }

            return this;
        }

        private void addBlockRule(String blockId, int value) {
            ResourceLocation parsedId = ResourceLocation.parse(blockId);

            BuiltInRegistries.BLOCK
                    .getOptional(parsedId)
                    .ifPresentOrElse(
                            block -> states.put(block, new Rule(false, value)),
                            () -> Constants.LOG.debug("Skipping unknown block {}!", parsedId));
        }

        private void addTagRule(String tagId, int value) {
            ResourceLocation parsedId = ResourceLocation.parse(tagId.substring(1));
            TagKey<Block> key = TagKey.create(Registries.BLOCK, parsedId);

            BuiltInRegistries.BLOCK.getTagOrEmpty(key).forEach(holder -> {
                Rule current = states.get(holder.value());

                // Only overwrite if there is not already a rule, or it is also a tag rule.
                // Block rules should take precedence.
                if (current == null || current.appliedByTag) {
                    states.put(holder.value(), new Rule(true, value));
                }
            });
        }
    }
}
