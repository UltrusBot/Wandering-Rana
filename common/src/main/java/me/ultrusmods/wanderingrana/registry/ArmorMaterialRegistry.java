package me.ultrusmods.wanderingrana.registry;

import me.ultrusmods.wanderingrana.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ArmorMaterialRegistry {

    public static Holder<ArmorMaterial> COLD_FROG;
    public static Holder<ArmorMaterial> TEMPERATE_FROG;
    public static Holder<ArmorMaterial> WARM_FROG;

    public static void init() {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class) {{
            put(ArmorItem.Type.BOOTS, 1);
            put(ArmorItem.Type.LEGGINGS, 2);
            put(ArmorItem.Type.CHESTPLATE, 3);
            put(ArmorItem.Type.HELMET, 1);
            put(ArmorItem.Type.BODY, 3);
        }};
        COLD_FROG = register(
                "cold_frog",
                enumMap,
                15,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                0.0F,
                0.0F,
                () -> Ingredient.of(Items.LEATHER));
        TEMPERATE_FROG = register(
                "temperate_frog",
                enumMap,
                15,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                0.0F,
                0.0F,
                () -> Ingredient.of(Items.LEATHER));
        WARM_FROG = register(
                "warm_frog",
                enumMap,
                15,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                0.0F,
                0.0F,
                () -> Ingredient.of(Items.LEATHER));
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Constants.id(name)));
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] armorTypes = ArmorItem.Type.values();

        for (ArmorItem.Type armorType : armorTypes) {
            enummap.put(armorType, defense.get(armorType));
        }

        return register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngridient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] armorTypes = ArmorItem.Type.values();

        for (ArmorItem.Type armorType : armorTypes) {
            enummap.put(armorType, defense.get(armorType));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace(name), new ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance));
    }
}
