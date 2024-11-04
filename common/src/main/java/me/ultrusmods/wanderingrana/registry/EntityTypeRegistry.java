package me.ultrusmods.wanderingrana.registry;

import me.ultrusmods.wanderingrana.Constants;
import me.ultrusmods.wanderingrana.entity.WanderingRana;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityTypeRegistry {

    public static final EntityType<WanderingRana> WANDERING_RANA = EntityType.Builder.of(WanderingRana::new, MobCategory.CREATURE)
            .sized(0.6F, 1.95F)
            .eyeHeight(0.62f)
            .clientTrackingRange(10)
            .build("wandering_rana");

    public static void init() {
        register("wandering_rana", WANDERING_RANA);
    }

    private static EntityType<?> register(String id, EntityType<?> entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, Constants.id(id), entityType);
    }
}
