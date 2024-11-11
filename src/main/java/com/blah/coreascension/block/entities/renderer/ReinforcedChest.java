package com.blah.coreascension.block.entities.renderer;

import com.blah.coreascension.block.entities.ReinforcedChestBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;

public class ReinforcedChest extends ChestBlockEntityRenderer<ReinforcedChestBlockEntity> {
	public ReinforcedChest(BlockEntityRendererFactory.Context context) {
        super(context);
	}
}