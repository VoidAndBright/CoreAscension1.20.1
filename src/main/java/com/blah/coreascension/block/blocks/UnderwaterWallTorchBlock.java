package com.blah.coreascension.block.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class UnderwaterWallTorchBlock extends WallTorchBlock implements Waterloggable {
    public static BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public UnderwaterWallTorchBlock(AbstractBlock.Settings settings, ParticleEffect particleEffect)
    {
        super(settings, particleEffect);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    public FluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext)
    {
        BlockState blockState = this.getDefaultState();
        WorldView world = itemPlacementContext.getWorld();
        BlockPos blockPos = itemPlacementContext.getBlockPos();
        Direction[] directions = itemPlacementContext.getPlacementDirections();
        for (Direction value : directions) {
            Direction direction = value.getOpposite();
            if (direction.getAxis().isHorizontal()) {
                blockState = blockState.with(FACING, direction);
                if (blockState.canPlaceAt(world, blockPos)) {
                    FluidState fluidState = itemPlacementContext.getWorld().getFluidState(blockPos);
                    blockState = blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
                    return blockState;
                }
            }
        }
        return null;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, WATERLOGGED);
    }
}
