package ph.jldvmsrwll1a.darkerlightsrc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import ph.jldvmsrwll1a.darkerlightsrc.platform.Services;

public final class DarkerLightSrcCore {

    public static BlockLightLevels BLOCK_LIGHT_LEVELS;

    public static void init() {
        BLOCK_LIGHT_LEVELS = new BlockLightLevels();
    }
}
