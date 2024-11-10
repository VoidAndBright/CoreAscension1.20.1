package com.blah.coreascension.block.entities.renderer;

import com.blah.coreascension.entity.model.CoreAscensionModelLayers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

public class ReinforcedChest<T extends BlockEntity> implements BlockEntityRenderer<T> {
	private final ModelPart Chest;
	private final ModelPart Lid;
	public ReinforcedChest(BlockEntityRendererFactory.Context context) {
		ModelPart modelPart = context.getLayerModelPart(CoreAscensionModelLayers.REINFORCED_CHEST);
		this.Chest = modelPart.getChild("Chest");
		this.Lid = Chest.getChild("Lid");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Chest = modelPartData.addChild("Chest", ModelPartBuilder.create().uv(0, 22).cuboid(-16.0F, -11.0F, 0.0F, 16.0F, 11.0F, 16.0F, new Dilation(0.0F))
		.uv(5, 49).cuboid(-15.0F, -10.0F, 1.0F, 14.0F, 9.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

		ModelPartData Lid = Chest.addChild("Lid", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -5.5F, -15.5F, 16.0F, 6.0F, 16.0F, new Dilation(0.0F))
		.uv(5, 72).cuboid(-7.0F, -4.5F, -14.5F, 14.0F, 4.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -1.5F, -16.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -16.5F, 15.5F));
		return TexturedModelData.of(modelData, 96, 96);
	}

	public ModelPart getPart() {return Chest;}

	public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		matrices.push();
		matrices.pop();

	}

}