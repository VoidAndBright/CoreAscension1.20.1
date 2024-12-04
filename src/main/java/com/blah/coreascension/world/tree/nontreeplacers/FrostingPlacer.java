package com.blah.coreascension.world.tree.nontreeplacers;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.blocks.FrostingBlock;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class FrostingPlacer extends FoliagePlacer
{
    public static final Codec<FrostingPlacer> CODEC = RecordCodecBuilder.create(frostingPlacerInstance ->
            fillFoliagePlacerFields(frostingPlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(frostingPlacerInstance, FrostingPlacer::new));

    private final int height;

    public FrostingPlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return CoreAscensionFoliagePlacerTypes.FROSTING_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockState bs = CoreAscensionBlocks.FROSTING.getDefaultState();

        int distX1 = random.nextBetween(2, 5);
        int distX2 = random.nextBetween(2, 5);
        int distZ1 = random.nextBetween(2, 5);
        int distZ2 = random.nextBetween(2, 5);

        for (int x = -distX1; x <= distX2; x++)
        {
            for (int z = -distZ1; z <= distZ2; z++)
            {
                int subtract = 0;
                while (world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState == Blocks.AIR.getDefaultState())))
                {
                    subtract++;
                }
                if (world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState == Blocks.VOID_AIR.getDefaultState())) ||
                        world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState == CoreAscensionBlocks.CAKEWOOD_LOG.getDefaultState())) ||
                        world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState == CoreAscensionBlocks.RED_GUMDROP.getDefaultState())) ||
                        world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState == CoreAscensionBlocks.YELLOW_GUMDROP.getDefaultState())) ||
                        world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState == CoreAscensionBlocks.GREEN_GUMDROP.getDefaultState())) ||
                        world.testBlockState(treeNode.getCenter().add(x, -subtract, z), (blockState -> blockState.getBlock() == CoreAscensionBlocks.FROSTING)))
                {
                    continue;
                }

                {
                    placer.placeBlock(treeNode.getCenter().add(x, -subtract + 1, z), bs.with(FrostingBlock.LAYERS, random.nextInt(4) + 1));
                }
            }
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
