package me.ultrusmods.wanderingrana.client.renderer;

import com.google.common.collect.Maps;
import me.ultrusmods.wanderingrana.Constants;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModel;
import me.ultrusmods.wanderingrana.client.model.WanderingRanaModelLayers;
import me.ultrusmods.wanderingrana.entity.WanderingRana;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;
import java.util.Map;

public class WanderingRanaRenderer<T extends WanderingRana> extends HumanoidMobRenderer<T, WanderingRanaModel<T>> {

    public static final ResourceLocation TEXTURE = Constants.id("textures/entity/rana_cold.png");
    private static final Map<WanderingRana.RanaVariant, ResourceLocation> RANA_VARIANT_TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        WanderingRana.RanaVariant[] ranaVariants = WanderingRana.RanaVariant.values();
        for (WanderingRana.RanaVariant ranaVariant : ranaVariants) {
            map.put(ranaVariant, Constants.id(String.format(Locale.ROOT, "textures/entity/rana_%s.png", ranaVariant.getSerializedName())));
        }
    });
    public WanderingRanaRenderer(EntityRendererProvider.Context context) {
        super(context, new WanderingRanaModel<>(context.bakeLayer(WanderingRanaModelLayers.RANA_MODEL_LAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return RANA_VARIANT_TEXTURES.getOrDefault(t.getVariant(), TEXTURE);
    }
}
