package com.blah.coreascension.block.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class AnodizableBlock extends Block implements Anodizable{
    private final Anodizable.AnodizationLevel anodationLevel;
    public AnodizableBlock(Anodizable.AnodizationLevel anodationLevel, AbstractBlock.Settings settings) {
        super(settings);
        this.anodationLevel = anodationLevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickAnodization(state,world,pos,random);
    }
    public boolean hasRandomTicks(BlockState state) {
        return Anodizable.getIncreasedAnodizationBlock(state.getBlock()).isPresent();
    }
    public Anodizable.AnodizationLevel getDegradationLevel() {
        return this.anodationLevel;
    }
}
