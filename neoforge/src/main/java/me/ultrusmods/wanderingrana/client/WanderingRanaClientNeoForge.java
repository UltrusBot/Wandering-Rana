package me.ultrusmods.wanderingrana.client;

import me.ultrusmods.wanderingrana.Constants;
import me.ultrusmods.wanderingrana.client.model.FrogArmorModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModelLayers;
import me.ultrusmods.wanderingrana.client.renderer.WanderingRanaRenderer;
import me.ultrusmods.wanderingrana.registry.EntityTypeRegistry;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WanderingRanaClientNeoForge {

    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
//        ArmorRenderer.register(new FrogArmorRendererNeoForge(), ItemRegistry.FROG_BOOTS, ItemRegistry.FROG_HELMET);
    }

    @SubscribeEvent
    public static void registerEntityLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WanderingRanaModelLayers.RANA_MODEL_LAYER, WanderingRanaModel::createLayerDefinition);
        event.registerLayerDefinition(WanderingRanaModelLayers.FROG_ARMOR_MODEL_LAYER, FrogArmorModel::createLayerDefinition);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeRegistry.WANDERING_RANA, WanderingRanaRenderer::new);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new FrogArmorItemExtensions(),
                ItemRegistry.COLD_FROG_BOOTS, ItemRegistry.COLD_FROG_HELMET,
                ItemRegistry.TEMPERATE_FROG_BOOTS, ItemRegistry.TEMPERATE_FROG_HELMET,
                ItemRegistry.WARM_FROG_BOOTS, ItemRegistry.WARM_FROG_HELMET
        );
    }

}
