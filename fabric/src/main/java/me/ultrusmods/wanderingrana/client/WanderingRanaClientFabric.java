package me.ultrusmods.wanderingrana.client;

import me.ultrusmods.wanderingrana.client.model.FrogArmorModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModelLayers;
import me.ultrusmods.wanderingrana.client.renderer.WanderingRanaRenderer;
import me.ultrusmods.wanderingrana.registry.EntityTypeRegistry;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class WanderingRanaClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityTypeRegistry.WANDERING_RANA, WanderingRanaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(WanderingRanaModelLayers.RANA_MODEL_LAYER, WanderingRanaModel::createLayerDefinition);
        EntityModelLayerRegistry.registerModelLayer(WanderingRanaModelLayers.FROG_ARMOR_MODEL_LAYER, FrogArmorModel::createLayerDefinition);


        ArmorRenderer.register(new FrogArmorRendererFabric(),
                ItemRegistry.COLD_FROG_BOOTS, ItemRegistry.COLD_FROG_HELMET,
                ItemRegistry.TEMPERATE_FROG_BOOTS, ItemRegistry.TEMPERATE_FROG_HELMET,
                ItemRegistry.WARM_FROG_BOOTS, ItemRegistry.WARM_FROG_HELMET
        );
    }
}
