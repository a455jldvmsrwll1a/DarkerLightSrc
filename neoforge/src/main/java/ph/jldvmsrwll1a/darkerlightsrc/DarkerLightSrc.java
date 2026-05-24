package ph.jldvmsrwll1a.darkerlightsrc;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.TagsUpdatedEvent;

@Mod(Constants.MOD_ID)
public class DarkerLightSrc {

    public DarkerLightSrc(ModContainer container) {
        Constants.LOG.info("Hello world! DarkerLightSrc (NeoForge)");

        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        NeoForge.EVENT_BUS.addListener(DarkerLightSrc::onTagsUpdated);
    }

    private static void onTagsUpdated(TagsUpdatedEvent event) {
        DarkerLightSrcCore.setTable(new BlockLightLevels.Builder().useBuiltin().build());
    }
}
