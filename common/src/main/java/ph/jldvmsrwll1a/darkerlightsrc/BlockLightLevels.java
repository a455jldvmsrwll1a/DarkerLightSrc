package ph.jldvmsrwll1a.darkerlightsrc;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class BlockLightLevels {

    private final HashMap<ResourceLocation, Integer> levels;
    private final ConcurrentHashMap<BlockBehaviour.BlockStateBase, Integer> cache = new ConcurrentHashMap<>();

    public BlockLightLevels() {
        levels = new HashMap<>(DefaultLevels.DEFAULT_TABLE);
    }

    public int getLightCap(BlockBehaviour.BlockStateBase block) {
        return cache.computeIfAbsent(
                block, b -> levels.getOrDefault(BuiltInRegistries.BLOCK.getKey(b.getBlock()), DefaultLevels.DEFAULT_LEVEL));
    }
}
