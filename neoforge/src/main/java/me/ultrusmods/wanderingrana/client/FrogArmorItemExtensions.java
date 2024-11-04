package me.ultrusmods.wanderingrana.client;

import me.ultrusmods.wanderingrana.client.model.FrogArmorModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModelLayers;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class FrogArmorItemExtensions implements IClientItemExtensions {
    private static FrogArmorModel hatModel;
    private static FrogArmorModel bootsModel;

    public FrogArmorItemExtensions() {
    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack stack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        if (hatModel == null) {
            var modelPart = Minecraft.getInstance().getEntityModels().bakeLayer(WanderingRanaModelLayers.FROG_ARMOR_MODEL_LAYER);
            hatModel = new FrogArmorModel(modelPart, true);
            bootsModel = new FrogArmorModel(modelPart, false);
        }

        if (stack.is(ItemRegistry.COLD_FROG_HELMET) || stack.is(ItemRegistry.TEMPERATE_FROG_HELMET) || stack.is(ItemRegistry.WARM_FROG_HELMET)) {
            return hatModel;
        } else if (stack.is(ItemRegistry.COLD_FROG_BOOTS) || stack.is(ItemRegistry.TEMPERATE_FROG_BOOTS) || stack.is(ItemRegistry.WARM_FROG_BOOTS)) {
            return bootsModel;
        }

        return null;
    }
}
