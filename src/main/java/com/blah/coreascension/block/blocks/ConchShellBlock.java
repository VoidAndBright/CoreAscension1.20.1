package com.blah.coreascension.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ConchShellBlock extends SeashellBlock {
    public ConchShellBlock(Settings settings)
    {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return switch (state.get(FACING))
        {
            case NORTH -> Block.createCuboidShape(5, 0, 1, 13, 9, 13);
            case EAST -> Block.createCuboidShape(3, 0, 5, 15, 9, 13);
            case WEST -> Block.createCuboidShape(1, 0, 3, 13, 9, 11);
            default -> Block.createCuboidShape(3, 0, 3, 11, 9, 15);
        };
    }
}