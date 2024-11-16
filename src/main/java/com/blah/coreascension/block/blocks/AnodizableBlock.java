package com.blah.coreascension.block.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class AnodizableBlock extends Block implements Anodizable {
    private final AnodizationLevel anodationLevel;

    public AnodizableBlock(AnodizationLevel anodationLevel, AbstractBlock.Settings settings)
    {
        super(settings);
        this.anodationLevel = anodationLevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        this.tickAnodization(state, world, pos, random);
    }

    public AnodizationLevel getDegradationLevel()
    {
        return this.anodationLevel;
    }
}
