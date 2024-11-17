package com.blah.coreascension.entity.model;

import com.blah.coreascension.entity.entities.SkyderEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SkyderModel <T extends SkyderEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Body;
	private final ModelPart head;
	private final ModelPart thorax;
	private final ModelPart leftLegs;
	private final ModelPart leftLeg1;
	private final ModelPart leftLeg2;
	private final ModelPart leftLeg3;
	private final ModelPart leftLeg4;
	private final ModelPart rightLegs;
	private final ModelPart rightLeg1;
	private final ModelPart rightLeg2;
	private final ModelPart rightLegs3;
	private final ModelPart rightLeg4;
	private final ModelPart rightWing;
	private final ModelPart leftWing;
	private final ModelPart abdomen;
	public SkyderModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.head = this.Body.getChild("head");
		this.thorax = this.Body.getChild("thorax");
		this.leftLegs = this.thorax.getChild("leftLegs");
		this.leftLeg1 = this.leftLegs.getChild("leftLeg1");
		this.leftLeg2 = this.leftLegs.getChild("leftLeg2");
		this.leftLeg3 = this.leftLegs.getChild("leftLeg3");
		this.leftLeg4 = this.leftLegs.getChild("leftLeg4");
		this.rightLegs = this.thorax.getChild("rightLegs");
		this.rightLeg1 = this.rightLegs.getChild("rightLeg1");
		this.rightLeg2 = this.rightLegs.getChild("rightLeg2");
		this.rightLegs3 = this.rightLegs.getChild("rightLegs3");
		this.rightLeg4 = this.rightLegs.getChild("rightLeg4");
		this.rightWing = this.thorax.getChild("rightWing");
		this.leftWing = this.thorax.getChild("leftWing");
		this.abdomen = this.Body.getChild("abdomen");
	}

    public SkyderModel(ModelPart body, ModelPart head, ModelPart thorax, ModelPart leftLegs, ModelPart leftLeg1, ModelPart leftLeg2, ModelPart leftLeg3, ModelPart leftLeg4, ModelPart rightLegs, ModelPart rightLeg1, ModelPart rightLeg2, ModelPart rightLegs3, ModelPart rightLeg4, ModelPart rightWing, ModelPart leftWing, ModelPart abdomen)
    {
        Body = body;
        this.head = head;
        this.thorax = thorax;
        this.leftLegs = leftLegs;
        this.leftLeg1 = leftLeg1;
        this.leftLeg2 = leftLeg2;
        this.leftLeg3 = leftLeg3;
        this.leftLeg4 = leftLeg4;
        this.rightLegs = rightLegs;
        this.rightLeg1 = rightLeg1;
        this.rightLeg2 = rightLeg2;
        this.rightLegs3 = rightLegs3;
        this.rightLeg4 = rightLeg4;
        this.rightWing = rightWing;
        this.leftWing = leftWing;
        this.abdomen = abdomen;
    }

    public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 15.0F, 0.5F));

		ModelPartData head = Body.addChild("head", ModelPartBuilder.create().uv(32, 4).cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.5F));

		ModelPartData thorax = Body.addChild("thorax", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftLegs = thorax.addChild("leftLegs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.5F));

		ModelPartData leftLeg1 = leftLegs.addChild("leftLeg1", ModelPartBuilder.create().uv(19, 0).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 2.0F, 0.0F, -0.7854F, 0.7854F));

		ModelPartData leftLeg2 = leftLegs.addChild("leftLeg2", ModelPartBuilder.create().uv(19, 0).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 1.0F, 0.0F, -0.2618F, 0.6109F));

		ModelPartData leftLeg3 = leftLegs.addChild("leftLeg3", ModelPartBuilder.create().uv(19, 0).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.6109F));

		ModelPartData leftLeg4 = leftLegs.addChild("leftLeg4", ModelPartBuilder.create().uv(19, 0).cuboid(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, -1.0F, 0.0F, 0.7854F, 0.7854F));

		ModelPartData rightLegs = thorax.addChild("rightLegs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -0.5F));

		ModelPartData rightLeg1 = rightLegs.addChild("rightLeg1", ModelPartBuilder.create().uv(19, 0).cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 2.0F, 0.0F, 0.7854F, -0.7854F));

		ModelPartData rightLeg2 = rightLegs.addChild("rightLeg2", ModelPartBuilder.create().uv(19, 0).cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 1.0F, 0.0F, 0.2618F, -0.6109F));

		ModelPartData rightLegs3 = rightLegs.addChild("rightLegs3", ModelPartBuilder.create().uv(19, 0).cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 0.0F, 0.0F, -0.2618F, -0.6109F));

		ModelPartData rightLeg4 = rightLegs.addChild("rightLeg4", ModelPartBuilder.create().uv(19, 0).cuboid(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, -1.0F, 0.0F, -0.7854F, -0.7854F));

		ModelPartData rightWing = thorax.addChild("rightWing", ModelPartBuilder.create().uv(-6, 33).cuboid(-18.0F, 0.0F, -3.0F, 18.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -3.0F, -0.5F));

		ModelPartData leftWing = thorax.addChild("leftWing", ModelPartBuilder.create().uv(-6, 39).cuboid(0.0F, 0.0F, -3.0F, 18.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -3.0F, -0.5F));

		ModelPartData abdomen = Body.addChild("abdomen", ModelPartBuilder.create().uv(0, 13).cuboid(-5.0F, -3.5F, -1.0F, 10.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 4.5F));
		return TexturedModelData.of(modelData, 64, 48);
	}
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	public ModelPart getPart()
	{
		return null;
	}
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch)
	{

	}
}