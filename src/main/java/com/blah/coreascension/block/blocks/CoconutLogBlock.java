package com.blah.coreascension.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CoconutLogBlock extends PillarBlock {

    public CoconutLogBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        super.randomTick(state, world, pos, random);
        for(int x = -1; x<=1;x+=2)
            if (random.nextFloat()<0.25)
                world.setBlockState(pos.east(x), state);
        for(int z = -1; z<=1;z+=2)
            if (random.nextFloat()<0.25)
                world.setBlockState(pos.north(z), state);
    }
}
