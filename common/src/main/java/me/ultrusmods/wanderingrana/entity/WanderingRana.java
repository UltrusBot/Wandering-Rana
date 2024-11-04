package me.ultrusmods.wanderingrana.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class WanderingRana extends WanderingTrader {
    private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(WanderingRana.class, EntityDataSerializers.INT);

    public WanderingRana(EntityType<? extends WanderingTrader> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant().ordinal());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(RanaVariant.values()[compound.getInt("Variant")]);
    }

    public RanaVariant getVariant() {
        return RanaVariant.values()[this.entityData.get(DATA_VARIANT)];
    }

    public void setVariant(RanaVariant variant) {
        this.entityData.set(DATA_VARIANT, variant.ordinal());
    }

    @Override
    public void updateTrades() {
        MerchantOffers merchantOffers = this.getOffers();
        for (VillagerTrades.ItemListing trade : WanderingRanaTrades.TRADES) {
            merchantOffers.add(trade.getOffer(this, this.random));
        }
    }

    ;public enum RanaVariant implements StringRepresentable {
        // TODO: Eventually make this a registry instead of an enum
        COLD("cold"),
        TEMPERATE("temperate"),
        WARM("warm");

        private final String name;


        RanaVariant(String name) {
            this.name = name;
        }
        @Override
        public String getSerializedName() {
            return name;
        }
    }

}
