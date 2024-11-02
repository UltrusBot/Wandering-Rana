package me.ultrusmods.wanderingrana.platform;

import me.ultrusmods.wanderingrana.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class WanderingRanaPlatformHelperFabric implements IPlatformHelper {

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
