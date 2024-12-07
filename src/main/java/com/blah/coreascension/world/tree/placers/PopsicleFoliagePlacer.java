package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PopsicleFoliagePlacer extends FoliagePlacer
{
    public static final Codec<PopsicleFoliagePlacer> CODEC = RecordCodecBuilder.create(popsicleFoliagePlacerInstance ->
            fillFoliagePlacerFields(popsicleFoliagePlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(popsicleFoliagePlacerInstance, PopsicleFoliagePlacer::new));

    private final int height;

    public PopsicleFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return CoreAscensionFoliagePlacerTypes.POPSICLE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        int offsetHeight = 4;
        int stack = 2;
        if (trunkHeight == 9) stack = 3;

        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                if (x == 0 && z == 0) continue;

                for (int y = 0; y < stack; y++)
                {
                    // place logs in the middle
                    placer.placeBlock(treeNode.getCenter().add(0, y - offsetHeight, 0), CoreAscensionBlocks.CAKEWOOD_LOG.getDefaultState());
                    placer.placeBlock(treeNode.getCenter().add(0, y + stack - offsetHeight, 0), CoreAscensionBlocks.CAKEWOOD_LOG.getDefaultState());

                    // place popsicle leaves
                    placer.placeBlock(treeNode.getCenter().add(x, y - offsetHeight, z), CoreAscensionBlocks.BLUE_POPSICLE_LEAVES.getDefaultState());
                    placer.placeBlock(treeNode.getCenter().add(x, y + stack - offsetHeight, z), CoreAscensionBlocks.WHITE_POPSICLE_LEAVES.getDefaultState());
                }
                if ((x == 1 && z == 1) || (x == -1 && z == 1) || (x == 1 && z == -1) || (x == -1 && z == -1)) continue;

                int modifier = 0;
                if (stack == 3) modifier = 1;
                for (int y = stack * 2; y <= stack * 2 + modifier; y++)
                {
                    placer.placeBlock(treeNode.getCenter().add(0, y - offsetHeight, 0), CoreAscensionBlocks.CAKEWOOD_LOG.getDefaultState());
                    placer.placeBlock(treeNode.getCenter().add(x, y - offsetHeight, z), CoreAscensionBlocks.WHITE_POPSICLE_LEAVES.getDefaultState());
                }

                for (int y = stack * 2 + 1; y <= stack * 3 + modifier; y++)
                {
                    placer.placeBlock(treeNode.getCenter().add(0, y - offsetHeight, 0), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
                    placer.placeBlock(treeNode.getCenter().add(x, y - offsetHeight, z), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
                }
            }
        }

        if (stack == 2)
        {
            placer.placeBlock(treeNode.getCenter().add(0, 7 - offsetHeight, 0), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
            placer.placeBlock(treeNode.getCenter().add(0, 8 - offsetHeight, 0), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
        }
        if (stack == 3)
        {
            placer.placeBlock(treeNode.getCenter().add(0, 11 - offsetHeight, 0), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
            placer.placeBlock(treeNode.getCenter().add(0, 12 - offsetHeight, 0), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
            placer.placeBlock(treeNode.getCenter().add(0, 13 - offsetHeight, 0), CoreAscensionBlocks.RED_POPSICLE_LEAVES.getDefaultState());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
