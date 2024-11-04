package me.ultrusmods.wanderingrana.registry;

import me.ultrusmods.wanderingrana.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class ItemRegistry {

    public static final Item WANDERING_RANA_SPAWN_EGG = new SpawnEggItem(EntityTypeRegistry.WANDERING_RANA, 0xA7ff5E, 0xFAFF5E, new Item.Properties());
    public static final Item COLD_FROG_HELMET = new ArmorItem(ArmorMaterialRegistry.COLD_FROG, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(22)));
    public static final Item COLD_FROG_BOOTS = new ArmorItem(ArmorMaterialRegistry.COLD_FROG, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(22)));
    public static final Item TEMPERATE_FROG_HELMET = new ArmorItem(ArmorMaterialRegistry.TEMPERATE_FROG, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(22)));
    public static final Item TEMPERATE_FROG_BOOTS = new ArmorItem(ArmorMaterialRegistry.TEMPERATE_FROG, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(22)));
    public static final Item WARM_FROG_HELMET = new ArmorItem(ArmorMaterialRegistry.WARM_FROG, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(22)));
    public static final Item WARM_FROG_BOOTS = new ArmorItem(ArmorMaterialRegistry.WARM_FROG, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(22)));

    public static void init() {
        register("wandering_rana_spawn_egg", WANDERING_RANA_SPAWN_EGG);
        register("cold_frog_helmet", COLD_FROG_HELMET);
        register("cold_frog_boots", COLD_FROG_BOOTS);
        register("temperate_frog_helmet", TEMPERATE_FROG_HELMET);
        register("temperate_frog_boots", TEMPERATE_FROG_BOOTS);
        register("warm_frog_helmet", WARM_FROG_HELMET);
        register("warm_frog_boots", WARM_FROG_BOOTS);
    }

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Constants.id(id), item);
    }
}
