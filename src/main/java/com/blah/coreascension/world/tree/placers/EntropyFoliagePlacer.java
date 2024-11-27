package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class EntropyFoliagePlacer extends FoliagePlacer
{
    public static final Codec<EntropyFoliagePlacer> CODEC = RecordCodecBuilder.create(entropyFoliagePlacerInstance ->
            fillFoliagePlacerFields(entropyFoliagePlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(entropyFoliagePlacerInstance, EntropyFoliagePlacer::new));

    private final int height;

    public EntropyFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return CoreAscensionFoliagePlacerTypes.ENTROPY_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        //whether the 3x3 area of wart blocks has placed a corelight or not yet
        boolean placeCorelight = false;
        // the number of stacks of entropic wart blocks to place
        int leafStacks;
        // the height to offset the leaf placement down by
        int subtractFromHeight = 16;
        if (trunkHeight == 12 || trunkHeight == 13)
        {
            leafStacks = 3;
            subtractFromHeight = 10;
        }
        else if (trunkHeight == 14 || trunkHeight == 15)
        {
            leafStacks = 4;
            subtractFromHeight = 13;
        }
        else
        {
            leafStacks = 5;
        }

        int leafPlacement = 3 - subtractFromHeight;

        // place 5x5 entropic wart block things
        for (int i = 0; i < leafStacks; i++)
        {
            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (x == 0 && z == 0 && i < leafStacks - 1) continue;
                    placer.placeBlock(treeNode.getCenter().add(x, leafPlacement, z), CoreAscensionBlocks.ENTROPIC_WART_BLOCK.getDefaultState());
                    if (x == -2 || x == 2 || z == -2 || z == 2)
                    {
                        if (random.nextFloat() < 0.18f)
                        {
                            generateVines(placer, random, treeNode.getCenter().add(x, leafPlacement - 1, z));
                        }
                        else if (random.nextFloat() < 0.15f)
                        {
                            if (!((x == -2 && z == -2) || (x == -2 && z == 2) ||
                                    (x == 2 && z == -2) || (x == 2 && z == 2)))
                            {
                                placer.placeBlock(treeNode.getCenter().add(x, leafPlacement, z), Blocks.AIR.getDefaultState());
                            }
                        }
                    }
                }
            }
            leafPlacement += 3;
        }

        leafPlacement = 2 - subtractFromHeight;

        // place 3x3 entropic wart block things
        for (int i = 0; i < leafStacks; i++)
        {
            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    if (x == 0 && z == 0) continue;
                    placer.placeBlock(treeNode.getCenter().add(x, leafPlacement, z), CoreAscensionBlocks.ENTROPIC_WART_BLOCK.getDefaultState());
                    if (!placeCorelight && random.nextFloat() < 0.45f)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, leafPlacement, z), CoreAscensionBlocks.CORELIGHT.getDefaultState());
                        placeCorelight = true;
                    }
                }
            }
            leafPlacement += 3;
            placeCorelight = false;
        }
    }

    private void generateVines(BlockPlacer placer, Random random, BlockPos pos)
    {
        int h = 0;
        int maxHeight = (int)(random.nextFloat() * 5);

        for (int i = 0; i < maxHeight; i++)
        {
            if (maxHeight == 1)
            {
                placer.placeBlock(pos.add(0, -h, 0), CoreAscensionBlocks.ENTROPIC_VINES.getDefaultState());
            }
            else
            {
                if (i < maxHeight - 1)
                {
                    placer.placeBlock(pos.add(0, -h, 0), CoreAscensionBlocks.ENTROPIC_VINES_PLANT.getDefaultState());
                }
                else
                    placer.placeBlock(pos.add(0, -h, 0), CoreAscensionBlocks.ENTROPIC_VINES.getDefaultState());
            }
            h++;
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
