package me.ultrusmods.wanderingrana.entity;

import com.google.common.collect.ImmutableMap;
import me.ultrusmods.wanderingrana.registry.ItemRegistry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class WanderingRanaTrades {

    public static final Map<WanderingRana.RanaVariant, VillagerTrades.ItemListing> FROGLIGHT_TRADE = ImmutableMap.of(
            WanderingRana.RanaVariant.WARM,
            new VillagerTrades.ItemsForEmeralds(Items.PEARLESCENT_FROGLIGHT, 4, 8, 3, 3),
            WanderingRana.RanaVariant.COLD,
            new VillagerTrades.ItemsForEmeralds(Items.VERDANT_FROGLIGHT, 4, 8, 3, 3),
            WanderingRana.RanaVariant.TEMPERATE,
            new VillagerTrades.ItemsForEmeralds(Items.OCHRE_FROGLIGHT, 4, 8, 3, 3)
    );
    public static final Map<WanderingRana.RanaVariant, VillagerTrades.ItemListing> FROG_HELMET_TRADE = ImmutableMap.of(
            WanderingRana.RanaVariant.WARM,
            new VillagerTrades.ItemsForEmeralds(ItemRegistry.WARM_FROG_HELMET, 12, 1, 1, 10),
            WanderingRana.RanaVariant.COLD,
            new VillagerTrades.ItemsForEmeralds(ItemRegistry.COLD_FROG_HELMET, 12, 1, 1, 10),
            WanderingRana.RanaVariant.TEMPERATE,
            new VillagerTrades.ItemsForEmeralds(ItemRegistry.TEMPERATE_FROG_HELMET, 12, 1, 1, 10)
    );

    public static final Map<WanderingRana.RanaVariant, VillagerTrades.ItemListing> FROG_BOOTS_TRADE = ImmutableMap.of(
            WanderingRana.RanaVariant.WARM,
            new VillagerTrades.ItemsForEmeralds(ItemRegistry.WARM_FROG_BOOTS, 12, 1, 1, 10),
            WanderingRana.RanaVariant.COLD,
            new VillagerTrades.ItemsForEmeralds(ItemRegistry.COLD_FROG_BOOTS, 12, 1, 1, 10),
            WanderingRana.RanaVariant.TEMPERATE,
            new VillagerTrades.ItemsForEmeralds(ItemRegistry.TEMPERATE_FROG_BOOTS, 12, 1, 1, 10)
    );

    public static final List<VillagerTrades.ItemListing> TRADES = List.of(
            new VariantBasedTrade(FROGLIGHT_TRADE),
            new VariantBasedTrade(FROG_HELMET_TRADE),
            new VariantBasedTrade(FROG_BOOTS_TRADE)
    );

    public record VariantBasedTrade(Map<WanderingRana.RanaVariant, VillagerTrades.ItemListing> trades) implements VillagerTrades.ItemListing {

        @Override
        public @Nullable MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
            if (entity instanceof WanderingRana wanderingRana) {
                return trades.get(wanderingRana.getVariant()).getOffer(entity, randomSource);
            }
            return null;
        }
    }
}
