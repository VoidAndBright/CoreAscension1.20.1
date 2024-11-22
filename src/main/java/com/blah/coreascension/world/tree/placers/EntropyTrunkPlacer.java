package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.world.tree.CoreAscensionTrunkPlacerTypes;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class EntropyTrunkPlacer extends TrunkPlacer
{
    public static final Codec<EntropyTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, EntropyTrunkPlacer::new));

    public EntropyTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return CoreAscensionTrunkPlacerTypes.ENTROPY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config)
    {
        float randomHeight = random.nextFloat();
        if (randomHeight < 0.33f)
        {
            randomHeight = 9;
        }
        else if (randomHeight < 0.67f)
        {
            randomHeight = 12;
        }
        else randomHeight = 15;

        for (int i = 0; i < randomHeight; i++)
        {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up((int)randomHeight), 0, false));
    }
}
