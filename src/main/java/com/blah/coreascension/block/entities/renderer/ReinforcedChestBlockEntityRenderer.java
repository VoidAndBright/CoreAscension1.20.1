package com.blah.coreascension.block.entities.renderer;

import com.blah.coreascension.block.blocks.ReinforcedChestBlock;
import com.blah.coreascension.block.entities.ReinforcedChestBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class ReinforcedChestBlockEntityRenderer implements BlockEntityRenderer<ReinforcedChestBlockEntity> {
    public ReinforcedChestBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    public void render(ReinforcedChestBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        BlockState blockState = blockEntity.getCachedState();
        float Rotation = blockState.get(ReinforcedChestBlock.FACING).asRotation();
        ItemStack Base = new ItemStack(Blocks.BAMBOO_BLOCK);
        matrices.push();
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        matrices.translate(0.5, 1.25 + offset, 0.5);
        matrices.scale(4,4,4);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(Rotation));
        itemRenderer.renderItem(Base, ModelTransformationMode.GROUND,light,overlay, matrices, vertexConsumers, blockEntity.getWorld(), 1);
        matrices.pop();
    }
    private int getLightLevel(World world, BlockPos pos) {
        int OtherLights = world.getLightLevel(LightType.BLOCK, pos);
        int SkyLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(OtherLights, SkyLight);
    }
}
