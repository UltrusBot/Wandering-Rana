package me.ultrusmods.wanderingrana;


import me.ultrusmods.wanderingrana.entity.WanderingRana;
import me.ultrusmods.wanderingrana.registry.ArmorMaterialRegistry;
import me.ultrusmods.wanderingrana.registry.CreativeModeTabRegistry;
import me.ultrusmods.wanderingrana.registry.EntityTypeRegistry;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class WanderingRanaNeoForge {

    public WanderingRanaNeoForge(IEventBus eventBus) {
        WanderingRanaMod.init();
        eventBus.addListener(this::onRegisterEvent);
        eventBus.addListener(this::onEntityAttributeCreationEvent);
    }


    private void onRegisterEvent(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.ITEM) {
            ItemRegistry.init();
        }
        if (event.getRegistryKey() == Registries.ENTITY_TYPE) {
            EntityTypeRegistry.init();
        }
        if (event.getRegistryKey() == Registries.ARMOR_MATERIAL) {
            ArmorMaterialRegistry.init();
        }
        if (event.getRegistryKey() == Registries.CREATIVE_MODE_TAB) {
            CreativeModeTabRegistry.init();
        }
    }

    private void onEntityAttributeCreationEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypeRegistry.WANDERING_RANA, WanderingRana.createMobAttributes().build());
    }
}