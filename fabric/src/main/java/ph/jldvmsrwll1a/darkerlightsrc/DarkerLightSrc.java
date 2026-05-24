package ph.jldvmsrwll1a.darkerlightsrc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;

public class DarkerLightSrc implements ModInitializer {

    @Override
    public void onInitialize() {
        Constants.LOG.info("Hello world! DarkerLightSrc (Fabric)");

        CommonLifecycleEvents.TAGS_LOADED.register((a, b) -> DarkerLightSrcCore.setTable(
                new BlockLightLevels.Builder().useBuiltin().build()));
    }
}
