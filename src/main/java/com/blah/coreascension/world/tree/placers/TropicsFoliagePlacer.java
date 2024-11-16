package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

    public TropicsFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    protected FoliagePlacerType<?> getType()
    {
        return CoreAscensionFoliagePlacerTypes.TROPICS_FOLIAGE_PLACER;
    }

    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        generateSquare(world, placer, random, config, treeNode.getCenter().up(), 1, 1, treeNode.isGiantTrunk());
        // adds leaves
        generateSquare(world, placer, random, config, treeNode.getCenter(), 1 + radius, 1, 1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter(), 1, 1, 1 + radius, treeNode.isGiantTrunk());
        for (int xz = -radius - 2; xz <= radius + 2; xz += radius * 2 + 4)
        {
            // adds tips of first layer of leaves
            placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(xz, 1, 0));
            placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(0, 1, xz));
            // adds second layer of leaves
            for (int pl = -1; pl <= 1; pl++)
            {
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(xz, 0, pl));
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(pl, 0, xz));
            }
        }
        // adds tips of leaves
        for (int xz = -radius - 3; xz <= radius + 3; xz += radius * 2 + 6)
        {
            placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(xz, 0, 0));
            placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(0, 0, xz));
        }
        // place coconuts
        for (int x = -1; x <= 1; x += 2)
        {
            for (int z = -1; z <= 1; z += 2)
            {
                // inner coconuts, higher chance
                if (random.nextFloat() < 0.33)
                {
                    placer.placeBlock(treeNode.getCenter().add(x, 0, z), CoreAscensionBlocks.COCONUT.getDefaultState());
                }
            }
            // outer coconuts, lower chance
            if (random.nextFloat() < 0.2)
            {
                placer.placeBlock(treeNode.getCenter().add(x * 2, 0, 0), CoreAscensionBlocks.COCONUT.getDefaultState());
                placer.placeBlock(treeNode.getCenter().add(0, 0, x * 2), CoreAscensionBlocks.COCONUT.getDefaultState());
            }
        }
    }

    protected void generateSquare(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos centerPos, int x, int y, int z, boolean giantTrunk)
    {
        int giant = giantTrunk ? 1 : 0;
        for (int X = -x; X <= x + giant; ++X)
        {
            for (int Z = -z; Z <= z + giant; ++Z)
            {
                if (!this.isPositionInvalid(random, X, y, Z, (x + z) / 2, giantTrunk))
                {
                    placeFoliageBlock(world, placer, random, config, centerPos.add(X, y, Z));
                }
            }
        }

    }

    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config)
    {
        return this.height;
    }

    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk)
    {
        return false;
    }
}
