package me.ultrusmods.wanderingrana.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class FrogArmorModel extends HumanoidModel<LivingEntity> {

    public final ModelPart ear_right;
    public final ModelPart ear_left;
    private final boolean isHelmet;
    public FrogArmorModel(ModelPart root, boolean isHelmet) {
        super(root);
        this.ear_right = this.getHead().getChild("FrogHat").getChild("ear_right");
        this.ear_left = this.getHead().getChild("FrogHat").getChild("ear_left");
        this.isHelmet = isHelmet;
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.getChild(PartNames.HEAD);



        PartDefinition FrogHat = head.addOrReplaceChild("FrogHat",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
                PartPose.offset(3.0F, -0.25F, -3.0F));

        PartDefinition ear_right = FrogHat.addOrReplaceChild("ear_right", CubeListBuilder.create(), PartPose.offset(-5.25F, -7.75F, 2.0F));

        PartDefinition ear_right_r1 = ear_right.addOrReplaceChild("ear_right_r1", CubeListBuilder.create().texOffs(24, 16).addBox(-4.0F, -5.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition ear_left = FrogHat.addOrReplaceChild("ear_left", CubeListBuilder.create(), PartPose.offset(-0.75F, -7.75F, 2.0F));

        PartDefinition ear_left_r1 = ear_left.addOrReplaceChild("ear_left_r1", CubeListBuilder.create().texOffs(24, 23).addBox(-1.0F, -5.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.2618F));

        PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, -3.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 8.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 8.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        toggleParts();
        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, color);
    }

    public void toggleParts() {
        setAllVisible(false);
        if (isHelmet) {
            this.head.visible = true;
            this.hat.visible = true;
            this.ear_right.visible = true;
            this.ear_left.visible = true;
        } else {
            this.leftLeg.visible = true;
            this.rightLeg.visible = true;
        }
    }

    @Override
    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float radians = (float) Math.toRadians(12.5F * Math.sin(0.1F * ageInTicks));
        this.ear_right.xRot = radians;
        this.ear_left.xRot = radians;

    }
}
