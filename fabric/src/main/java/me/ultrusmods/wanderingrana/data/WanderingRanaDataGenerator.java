package me.ultrusmods.wanderingrana.data;

import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class WanderingRanaDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(WanderingRanaModelGenerator::new);

    }


    public static class WanderingRanaModelGenerator extends FabricModelProvider {
        public WanderingRanaModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        }

        @Override
        public void generateItemModels(ItemModelGenerators itemModelGenerator) {
            ModelTemplate EGG_TEMPLATE = new ModelTemplate(
                    Optional.of(ResourceLocation.withDefaultNamespace("item/template_spawn_egg")),
                    Optional.empty()
            );

            itemModelGenerator.generateFlatItem(ItemRegistry.WANDERING_RANA_SPAWN_EGG, EGG_TEMPLATE);
            itemModelGenerator.generateFlatItem(ItemRegistry.COLD_FROG_HELMET, ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemRegistry.COLD_FROG_BOOTS, ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemRegistry.WARM_FROG_HELMET, ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemRegistry.WARM_FROG_BOOTS, ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemRegistry.TEMPERATE_FROG_HELMET, ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(ItemRegistry.TEMPERATE_FROG_BOOTS, ModelTemplates.FLAT_ITEM);
        }
    }
}
