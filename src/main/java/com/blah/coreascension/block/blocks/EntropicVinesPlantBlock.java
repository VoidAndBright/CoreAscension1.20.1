package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldView;

public class EntropicVinesPlantBlock extends AbstractPlantBlock
{
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos)
    {
        return world.getBlockState(pos.up()) != Blocks.AIR.getDefaultState();
    }

    public EntropicVinesPlantBlock(AbstractBlock.Settings settings)
    {
        super(settings, Direction.DOWN, SHAPE, false);
    }
    protected AbstractPlantStemBlock getStem()
    {
        return (AbstractPlantStemBlock) CoreAscensionBlocks.ENTROPIC_VINES;
    }
}
