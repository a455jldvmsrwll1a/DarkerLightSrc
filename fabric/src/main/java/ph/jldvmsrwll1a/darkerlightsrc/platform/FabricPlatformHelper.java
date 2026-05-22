package ph.jldvmsrwll1a.darkerlightsrc.platform;

import net.fabricmc.loader.api.FabricLoader;
import ph.jldvmsrwll1a.darkerlightsrc.platform.services.IPlatformHelper;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
