package me.ultrusmods.wanderingrana.client.model;

import me.ultrusmods.wanderingrana.entity.WanderingRana;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class WanderingRanaModel<T extends WanderingRana> extends HumanoidModel<T> {

    public final ModelPart ear_right;
    public final ModelPart ear_left;
    public WanderingRanaModel(ModelPart root) {
        super(root);
        this.ear_right = this.getHead().getChild("FrogHat").getChild("ear_right");
        this.ear_left = this.getHead().getChild("FrogHat").getChild("ear_left");
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition FrogHat = head.addOrReplaceChild("FrogHat", CubeListBuilder.create().texOffs(0, 16).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(3.0F, -0.25F, -3.0F));

        PartDefinition ear_right = FrogHat.addOrReplaceChild("ear_right", CubeListBuilder.create(), PartPose.offset(-5.25F, -7.5F, 2.0F));

        PartDefinition ear_right_r1 = ear_right.addOrReplaceChild("ear_right_r1", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, -5.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition ear_left = FrogHat.addOrReplaceChild("ear_left", CubeListBuilder.create(), PartPose.offset(-0.75F, -7.5F, 2.0F));

        PartDefinition ear_left_r1 = ear_left.addOrReplaceChild("ear_left_r1", CubeListBuilder.create().texOffs(56, 7).addBox(-1.0F, -5.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.2618F));

        PartDefinition right_pigtail = head.addOrReplaceChild("right_pigtail", CubeListBuilder.create(), PartPose.offset(-4.0F, 0.0F, -3.0F));

        PartDefinition cube_r1 = right_pigtail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 40).addBox(-3.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F))
                .texOffs(56, 32).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -1.0F, 6.0F, 0.0F, 0.3927F, -0.3927F));

        PartDefinition left_pigtail = head.addOrReplaceChild("left_pigtail", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, -3.0F));

        PartDefinition cube_r2 = left_pigtail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(56, 44).addBox(1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F))
                .texOffs(56, 36).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -1.0F, 6.0F, 0.0F, -0.3927F, 0.3927F));

        PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(30, 68).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(3.0F, 0.0F, -3.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(48, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(30, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(0, 71).addBox(-2.0F, 8.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(0, 71).mirror().addBox(-2.0F, 8.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float speed = entity.isPanicking() ? 5.0F : 0.1F;
        float radians = (float) Math.toRadians(12.5F * Math.sin(speed * ageInTicks));
        this.ear_right.xRot = radians;
        this.ear_left.xRot = radians;
    }
}
