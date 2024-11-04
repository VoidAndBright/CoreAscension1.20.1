package com.blah.coreascension.block.blocks;


import com.blah.coreascension.blockentity.CoreAscensionBlockEntities;
import com.blah.coreascension.blockentity.blockentities.PrismaerionFurnaceBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class PrismaerionFurnaceBlock extends BlockWithEntity {
    public PrismaerionFurnaceBlock(Settings settings) {
        super(settings);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PrismaerionFurnaceBlockEntity(pos, state);
    }
	public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
		if (!state.isOf(newState.getBlock())) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof Inventory) {
				ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
				world.updateComparators(pos, this);
			}
			super.onStateReplaced(state, world, pos, newState, moved);
		}
	}
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			NamedScreenHandlerFactory namedScreenHandlerFactory = this.createScreenHandlerFactory(state, world, pos);
			if (namedScreenHandlerFactory != null) {
				player.openHandledScreen(namedScreenHandlerFactory);
			}
			return ActionResult.CONSUME;
		}
	}
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, CoreAscensionBlockEntities.PRISMAERION_FURNACE_ENTITY,(world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
