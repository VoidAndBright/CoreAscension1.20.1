package com.blah.coreascension.world.tree.custom;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class TropicsFoliagePlacer extends FoliagePlacer {
    public static final Codec<TropicsFoliagePlacer> CODEC = RecordCodecBuilder.create(tropicsFoliagePlacerInstance ->
            fillFoliagePlacerFields(tropicsFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(tropicsFoliagePlacerInstance, TropicsFoliagePlacer::new));
    private final int height;

    public TropicsFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    protected FoliagePlacerType<?> getType() {
        return CoreAscensionFoliagePlacerTypes.TROPICS_FOLIAGE_PLACER;
    }

    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0), 1, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(1), 1, 1, treeNode.isGiantTrunk());

        generateSquare(world, placer, random, config, treeNode.getCenter().west(2), 1, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().east(2), 1, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().north(2), 1, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().south(2), 1, 1, treeNode.isGiantTrunk());

        // second layer of leaves x4
        for (int i = -1; i <= 1; i++)
        {
            placeFoliageBlock(world, placer, random, config, new BlockPos(treeNode.getCenter().getX() + 4, treeNode.getCenter().getY(), treeNode.getCenter().getZ() + i));
        }
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().west(4).up());
        for (int i = -1; i <= 1; i++)
        {
            placeFoliageBlock(world, placer, random, config, new BlockPos(treeNode.getCenter().getX() - 4, treeNode.getCenter().getY(), treeNode.getCenter().getZ() + i));
        }
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().east(4).up());
        for (int i = -1; i <= 1; i++)
        {
            placeFoliageBlock(world, placer, random, config, new BlockPos(treeNode.getCenter().getX() + i, treeNode.getCenter().getY(), treeNode.getCenter().getZ() + 4));
        }
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(4).up());
        for (int i = -1; i <= 1; i++)
        {
            placeFoliageBlock(world, placer, random, config, new BlockPos(treeNode.getCenter().getX() + i, treeNode.getCenter().getY(), treeNode.getCenter().getZ() - 4));
        }
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().south(4).up());

        // final 4 blocks at the end of the leaves
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(5));
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().east(5));
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().west(5));
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().south(5));

        // place coconuts
        // inner coconuts, higher chance
        if (random.nextFloat() < 0.33)
        {
            placer.placeBlock(treeNode.getCenter().north().west(), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
        if (random.nextFloat() < 0.33)
        {
            placer.placeBlock(treeNode.getCenter().south().west(), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
        if (random.nextFloat() < 0.33)
        {
            placer.placeBlock(treeNode.getCenter().north().east(), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
        if (random.nextFloat() < 0.33)
        {
            placer.placeBlock(treeNode.getCenter().south().east(), CoreAscensionBlocks.COCONUT.getDefaultState());
        }

        // outer coconuts, lower chance
        if (random.nextFloat() < 0.2)
        {
            placer.placeBlock(treeNode.getCenter().north(2), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
        if (random.nextFloat() < 0.2)
        {
            placer.placeBlock(treeNode.getCenter().south(2), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
        if (random.nextFloat() < 0.2)
        {
            placer.placeBlock(treeNode.getCenter().east(2), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
        if (random.nextFloat() < 0.2)
        {
            placer.placeBlock(treeNode.getCenter().west(2), CoreAscensionBlocks.COCONUT.getDefaultState());
        }
    }

    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
