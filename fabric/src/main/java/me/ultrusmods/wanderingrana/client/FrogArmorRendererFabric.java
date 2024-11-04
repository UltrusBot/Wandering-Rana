package me.ultrusmods.wanderingrana.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import me.ultrusmods.wanderingrana.Constants;
import me.ultrusmods.wanderingrana.client.model.FrogArmorModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModelLayers;
import me.ultrusmods.wanderingrana.entity.WanderingRana;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;
import java.util.Map;

public class FrogArmorRendererFabric implements ArmorRenderer {

    private static FrogArmorModel hatModel;
    private static FrogArmorModel bootsModel;
    public static final ResourceLocation TEXTURE = Constants.id("textures/entity/rana_cold.png");

    public FrogArmorRendererFabric() {
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, HumanoidModel<LivingEntity> contextModel) {
        if (hatModel == null) {
            var modelPart = Minecraft.getInstance().getEntityModels().bakeLayer(WanderingRanaModelLayers.FROG_ARMOR_MODEL_LAYER);
            hatModel = new FrogArmorModel(modelPart, true);
            bootsModel = new FrogArmorModel(modelPart, false);
        }
        if (!(stack.getItem() instanceof ArmorItem armorItem)) return;

        var layers = armorItem.getMaterial().value().layers();
        var texture = layers.isEmpty() ? TEXTURE : layers.get(0).texture(false);
        if (stack.is(ItemRegistry.COLD_FROG_HELMET)) {
            contextModel.copyPropertiesTo(hatModel);
            hatModel.setupAnim(entity, 0, 0, 0, 0, 0);
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, hatModel, texture);
        } else if (stack.is(ItemRegistry.COLD_FROG_BOOTS)) {
            contextModel.copyPropertiesTo(bootsModel);
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, bootsModel, texture);
        }

    }
}
