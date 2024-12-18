package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.world.tree.CoreAscensionTrunkPlacerTypes;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class TropicsTrunkPlacer extends TrunkPlacer {
    public static final Codec<TropicsTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, TropicsTrunkPlacer::new));

    public TropicsTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight)
    {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    
    protected TrunkPlacerType<?> getType()
    {
        return CoreAscensionTrunkPlacerTypes.TROPICS_TRUNK_PLACER;
    }

    
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config)
    {
        setToDirt(world, replacer, random, startPos.down(), config);
        int TreeHeight = height + random.nextBetween(firstRandomHeight, firstRandomHeight + 2) + random.nextBetween(secondRandomHeight - 1, secondRandomHeight + 1);

        for (int IterateHeight = 0; IterateHeight <= TreeHeight; IterateHeight++)
        {
            getAndSetState(world, replacer, random, startPos.up(IterateHeight), config);
        }
        replacer.accept(startPos.up(TreeHeight).offset(Direction.NORTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                .get(random, startPos.up(TreeHeight).offset(Direction.NORTH, 1)).with(PillarBlock.AXIS, Direction.Axis.Z)));

        replacer.accept(startPos.up(TreeHeight).offset(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                .get(random, startPos.up(TreeHeight).offset(Direction.SOUTH, 1)).with(PillarBlock.AXIS, Direction.Axis.Z)));

        replacer.accept(startPos.up(TreeHeight).offset(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                .get(random, startPos.up(TreeHeight).offset(Direction.EAST, 1)).with(PillarBlock.AXIS, Direction.Axis.X)));

        replacer.accept(startPos.up(TreeHeight).offset(Direction.WEST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                .get(random, startPos.up(TreeHeight).offset(Direction.WEST, 1)).with(PillarBlock.AXIS, Direction.Axis.X)));
        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(TreeHeight), 0, false));
    }
}
