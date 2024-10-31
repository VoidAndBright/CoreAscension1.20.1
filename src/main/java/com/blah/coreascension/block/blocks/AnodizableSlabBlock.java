package com.blah.coreascension.block.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class AnodizableSlabBlock extends SlabBlock implements Anodizable{
    private final AnodizationLevel anodationLevel;

    public AnodizableSlabBlock(AnodizationLevel anodationLevel, Settings settings) {
        super(settings);
        this.anodationLevel = anodationLevel;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickAnodization(state, world, pos, random);
    }
    public boolean hasRandomTicks(BlockState state) {
        return Anodizable.getIncreasedAnodizationBlock(state.getBlock()).isPresent();
    }

    public AnodizationLevel getDegradationLevel() {
        return this.anodationLevel;
    }
}
