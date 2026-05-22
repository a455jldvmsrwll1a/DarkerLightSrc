package ph.jldvmsrwll1a.darkerlightsrc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import ph.jldvmsrwll1a.darkerlightsrc.platform.Services;

public class DarkerLightSrcCore {

    public static void init() {
        Constants.LOG.info(
                "Hello from Common init on {}! we are currently in a {} environment!",
                Services.PLATFORM.getPlatformName(),
                Services.PLATFORM.getEnvironmentName());
        Constants.LOG.info("The ID for diamonds is {}", BuiltInRegistries.ITEM.getKey(Items.DIAMOND));

        if (Services.PLATFORM.isModLoaded("darkerlightsrc")) {
            Constants.LOG.info("Hello to darkerlightsrc");
        }
    }
}
