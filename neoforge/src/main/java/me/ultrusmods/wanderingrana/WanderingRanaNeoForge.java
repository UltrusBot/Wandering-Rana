package me.ultrusmods.wanderingrana;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class WanderingRanaNeoForge {

    public WanderingRanaNeoForge(IEventBus eventBus) {
        WanderingRanaMod.init();
    }
}