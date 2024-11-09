package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.utils.CoreAscensionTags;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import java.util.Optional;
public interface Anodizable extends Degradable<Anodizable.AnodizationLevel> {
    Supplier<ImmutableBiMap<Object, Object>> ANODATION_LEVEL_INCREASES = Suppliers.memoize(() -> ImmutableBiMap.builder().
        put(CoreAscensionBlocks.TITANIUM_BLOCK, CoreAscensionBlocks.SEARED_TITANIUM_BLOCK).
        put(CoreAscensionBlocks.SEARED_TITANIUM_BLOCK, CoreAscensionBlocks.SINGED_TITANIUM_BLOCK).
        put(CoreAscensionBlocks.SINGED_TITANIUM_BLOCK, CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK).
        put(CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK,CoreAscensionBlocks.BURNT_TITANIUM_BLOCK).

        put(CoreAscensionBlocks.TITANIUM_SLAB, CoreAscensionBlocks.SEARED_TITANIUM_SLAB).
        put(CoreAscensionBlocks.SEARED_TITANIUM_SLAB, CoreAscensionBlocks.SINGED_TITANIUM_SLAB).
        put(CoreAscensionBlocks.SINGED_TITANIUM_SLAB, CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB).
        put(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB, CoreAscensionBlocks.BURNT_TITANIUM_SLAB).

        put(CoreAscensionBlocks.TITANIUM_STAIRS, CoreAscensionBlocks.SEARED_TITANIUM_STAIRS).
        put(CoreAscensionBlocks.SEARED_TITANIUM_STAIRS, CoreAscensionBlocks.SINGED_TITANIUM_STAIRS).
        put(CoreAscensionBlocks.SINGED_TITANIUM_STAIRS, CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS).
        put(CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS, CoreAscensionBlocks.BURNT_TITANIUM_STAIRS).
    build());
    Supplier<ImmutableBiMap<Object, Object>> ANODATION_LEVEL_DECREASES = Suppliers.memoize(() -> (ANODATION_LEVEL_INCREASES.get()).inverse());

    static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable((Block)(ANODATION_LEVEL_DECREASES.get()).get(block));
    }

    static Block getUnaffectedAnodationBlock(Block block) {
        for(Block block_2 = (Block)ANODATION_LEVEL_DECREASES.get().get(block);
            block_2 != null;
            block_2 = (Block)ANODATION_LEVEL_DECREASES.get().get(block)) {
            block = block_2;
        }
        return block;
    }
    default void tickAnodization(BlockState state,ServerWorld world,BlockPos pos,Random random){
        boolean heated = false;
        for (int x=-3; x<=3; x++) {
            for (int y = -3; y <= 3; y++) {
                for (int z = -3; z <= 3; z++) {
                    if (world.getBlockState(pos.add(x,y,z)).isIn(CoreAscensionTags.HEAT_SOURCES)) heated = true;
                }
            }
        }
        if(heated)this.tickDegradation(state, world, pos, random);
    }
    static Optional<BlockState> getDecreasedAnodizationState(BlockState state) {
        return getDecreasedOxidationBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    static Optional<Block> getIncreasedAnodizationBlock(Block block) {
        return Optional.ofNullable((Block)(ANODATION_LEVEL_INCREASES.get()).get(block));
    }

    static BlockState getUnaffectedAnodizationState(BlockState state) {
        return getUnaffectedAnodationBlock(state.getBlock()).getStateWithProperties(state);
    }

    default Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedAnodizationBlock(state.getBlock()).map(block -> block.getStateWithProperties(state));
    }

    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == Anodizable.AnodizationLevel.UNAFFECTED ? 0.75F : 1.0F;
    }

    enum AnodizationLevel {
        UNAFFECTED,
        SEARED,
        SINGED,
        SCORCHED,
        BURNT
    }
}
