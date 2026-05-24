package ph.jldvmsrwll1a.darkerlightsrc;

import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class Config {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.IntValue DEFAULT_CAP;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> RULESET_OVERRIDES;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        DEFAULT_CAP = builder.translation("config.darkerlightsrc.default_cap")
                .comment("The default limit to apply to blocks not covered by the ruleset.")
                .defineInRange("default_cap", 8, 0, 15);

        RULESET_OVERRIDES = builder.translation("config.darkerlightsrc.ruleset_overrides")
                .comment("A list of overrides to apply to the built-in ruleset.")
                .defineListAllowEmpty("ruleset_overrides", List.of(), Config::checkIfRuleStringValid);

        SPEC = builder.build();
    }

    private static boolean checkIfRuleStringValid(Object value) {
        if (!(value instanceof String str)) {
            return false;
        }

        String[] tokens = str.strip().split("\\s+");

        if (tokens.length < 1 || tokens.length > 2) {
            return false;
        }

        if (tokens[0].startsWith("#")) {
            if (ResourceLocation.tryParse(tokens[0].substring(1)) == null) {
                return false;
            }
        } else {
            if (ResourceLocation.tryParse(tokens[0]) == null) {
                return false;
            }
        }

        if (tokens.length == 2) {
            int parsedValue;

            try {
                parsedValue = Integer.parseInt(tokens[1]);
            } catch (NumberFormatException ignored) {
                return false;
            }

            return parsedValue >= 0 && parsedValue <= 15;
        }

        return true;
    }
}
