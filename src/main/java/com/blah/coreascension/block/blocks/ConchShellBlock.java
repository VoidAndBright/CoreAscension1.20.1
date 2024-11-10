package com.blah.coreascension.block.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class ConchShellBlock extends HorizontalFacingBlock implements Waterloggable
{
    public static BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public ConchShellBlock(Settings settings)
    {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, RandomFacing(new Random())).with(WATERLOGGED, false));
    }
<<<<<<< Updated upstream

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return switch (state.get(FACING))
        {
            case NORTH -> Block.createCuboidShape(5, 0, 1, 13, 9, 13);
            case EAST -> Block.createCuboidShape(3, 0, 5, 15, 9, 13);
            case WEST -> Block.createCuboidShape(1, 0, 3, 13, 9, 11);
            default -> Block.createCuboidShape(3, 0, 3, 11, 9, 15);
=======
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context)
    {
        return switch (state.get(FACING)) {
            case NORTH -> VoxelShapes.cuboid(3, 0, 3, 11, 9, 15);
            case EAST -> VoxelShapes.cuboid(1, 0, 3, 13, 9, 11);
            case WEST -> VoxelShapes.cuboid(3, 0, 5, 15, 9, 13);
            default -> VoxelShapes.cuboid(5, 0, 1, 13, 9, 13);
>>>>>>> Stashed changes
        };
    }
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext)
    {
        Direction direction = itemPlacementContext.getHorizontalPlayerFacing();
        return this.getDefaultState().with(FACING, direction);
    }
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos)
    {
        if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(FACING,WATERLOGGED);
    }
    public FluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    public static Direction RandomFacing(Random random)
    {
        int bob = random.nextInt(1, 5);
        return switch (bob)
        {
            case 1 -> Direction.NORTH;
            case 2 -> Direction.EAST;
            case 3 -> Direction.SOUTH;
            case 4 -> Direction.WEST;
            default -> throw new IllegalStateException("Unexpected value: " + bob);
        };
    }
}
