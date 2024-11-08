package me.ultrusmods.wanderingrana.registry;

import me.ultrusmods.wanderingrana.Constants;
import me.ultrusmods.wanderingrana.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class CreativeModeTabRegistry {

    public static final CreativeModeTab WANDERING_RANA_ITEMS = Services.PLATFORM.getCreativeTab()
            .title(Component.translatable("itemGroup.wanderingrana.items"))
            .icon(ItemRegistry.COLD_FROG_HELMET::getDefaultInstance)
            .displayItems(((itemDisplayParameters, output) -> {
                output.accept(ItemRegistry.WANDERING_RANA_SPAWN_EGG);
                output.accept(ItemRegistry.WARM_FROG_HELMET);
                output.accept(ItemRegistry.WARM_FROG_BOOTS);
                output.accept(ItemRegistry.TEMPERATE_FROG_HELMET);
                output.accept(ItemRegistry.TEMPERATE_FROG_BOOTS);
                output.accept(ItemRegistry.COLD_FROG_HELMET);
                output.accept(ItemRegistry.COLD_FROG_BOOTS);
            })).build();


    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.id("items"), WANDERING_RANA_ITEMS);
    }
}
