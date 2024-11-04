package me.ultrusmods.wanderingrana;

import me.ultrusmods.wanderingrana.entity.WanderingRana;
import me.ultrusmods.wanderingrana.registry.ArmorMaterialRegistry;
import me.ultrusmods.wanderingrana.registry.CreativeModeTabRegistry;
import me.ultrusmods.wanderingrana.registry.EntityTypeRegistry;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class WanderingRanaFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        WanderingRanaMod.init();
        ArmorMaterialRegistry.init();
//        ArmorMaterialRegistry.init(((resourceLocation, armorMaterial) -> Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, resourceLocation, armorMaterial)));
        ItemRegistry.init();
        CreativeModeTabRegistry.init();
        EntityTypeRegistry.init();
        FabricDefaultAttributeRegistry.register(
                EntityTypeRegistry.WANDERING_RANA,
                WanderingRana.createMobAttributes()
        );
    }
}
