package ph.jldvmsrwll1a.darkerlightsrc;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public final class BlockLightLevels {

    private final HashMap<ResourceLocation, Integer> levels;
    private final ConcurrentHashMap<Block, Integer> cache = new ConcurrentHashMap<>();

    public BlockLightLevels() {
        levels = new HashMap<>(DefaultLevels.DEFAULT_TABLE);
    }

    public int getLightCap(Block block) {
        return cache.computeIfAbsent(
                block, b -> levels.getOrDefault(BuiltInRegistries.BLOCK.getKey(b), DefaultLevels.DEFAULT_LEVEL));
    }
}
