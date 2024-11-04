package me.ultrusmods.wanderingrana.platform;

import me.ultrusmods.wanderingrana.platform.services.IPlatformHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class WanderingRanaPlatformHelperNeoForge implements IPlatformHelper {

    @Override
    public String getPlatformName() {
            return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public CreativeModeTab.Builder getCreativeTab() {
        return CreativeModeTab.builder();
    }
}