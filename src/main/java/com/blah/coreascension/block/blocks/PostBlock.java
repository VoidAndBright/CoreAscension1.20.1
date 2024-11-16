package com.blah.coreascension.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PostBlock extends PillarBlock {
    protected static final VoxelShape SHAPE_X = Block.createCuboidShape(0, 4, 4, 16, 12, 12);
    protected static final VoxelShape SHAPE_Y = Block.createCuboidShape(4, 0, 4, 12, 16, 12);
    protected static final VoxelShape SHAPE_Z = Block.createCuboidShape(4, 4, 0, 12, 12, 16);

    public PostBlock(Settings settings)
    {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return switch (state.get(AXIS)) {
            case X -> SHAPE_X;
            case Y -> SHAPE_Y;
            case Z -> SHAPE_Z;
        };
    }
}
