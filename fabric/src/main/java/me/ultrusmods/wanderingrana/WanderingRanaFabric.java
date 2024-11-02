package me.ultrusmods.wanderingrana;

import net.fabricmc.api.ModInitializer;

public class WanderingRanaFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Constants.LOG.info("Hello Fabric world!");
        WanderingRanaMod.init();
    }
}
