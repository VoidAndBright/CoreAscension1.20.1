package com.blah.coreascension.block.blocks;


import com.blah.coreascension.screen.screens.CatalyzerScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class CatalyzerTableBlock extends BlockWithEntity {
	public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public CatalyzerTableBlock(Settings settings) {super(settings);}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder.add(FACING));
	}
	public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
		Direction direction = itemPlacementContext.getHorizontalPlayerFacing();
		return this.getDefaultState().with(FACING,direction.getOpposite());
	}
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			NamedScreenHandlerFactory namedScreenHandlerFactory = this.createScreenHandlerFactory(state,world,pos);
			if (namedScreenHandlerFactory != null) player.openHandledScreen(namedScreenHandlerFactory);
			return ActionResult.CONSUME;
		}
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return null;
	}
}
