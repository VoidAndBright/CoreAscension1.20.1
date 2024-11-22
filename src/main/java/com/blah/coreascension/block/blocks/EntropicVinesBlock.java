package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldView;

public class EntropicVinesBlock extends AbstractPlantStemBlock
{
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos)
    {
        return world.getBlockState(pos.up()) != Blocks.AIR.getDefaultState();
    }

    public EntropicVinesBlock(Settings settings)
    {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
    }

    protected int getGrowthLength(Random random)
    {
        return VineLogic.getGrowthLength(random);
    }

    protected Block getPlant()
    {
        return CoreAscensionBlocks.ENTROPIC_VINES_PLANT;
    }

    protected boolean chooseStemState(BlockState state)
    {
        return VineLogic.isValidForWeepingStem(state);
    }
}
