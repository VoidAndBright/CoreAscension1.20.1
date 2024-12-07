package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class EtherealFoliagePlacer extends FoliagePlacer
{
    public static final Codec<EtherealFoliagePlacer> CODEC = RecordCodecBuilder.create(ethPlacerInstance ->
            fillFoliagePlacerFields(ethPlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(ethPlacerInstance, EtherealFoliagePlacer::new));

    private final int height;

    public EtherealFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return CoreAscensionFoliagePlacerTypes.ETHEREAL_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        int r = random.nextBetween(0, 1);

        if (r == 0)
        {
            int randomSide = random.nextInt(4);
            BlockPos side;
            BlockPos secondLayerSide;

            // determine the side to place the secondary and tertiary parts of the trunk
            if (randomSide == 0)
            {
                side = treeNode.getCenter().north();
                secondLayerSide = treeNode.getCenter().north(2).east();
            }
            else if (randomSide == 1)
            {
                side = treeNode.getCenter().south();
                secondLayerSide = treeNode.getCenter().south(2).west();
            }
            else if (randomSide == 2)
            {
                side = treeNode.getCenter().west();
                secondLayerSide = treeNode.getCenter().west(2).north();
            }
            else
            {
                side = treeNode.getCenter().east();
                secondLayerSide = treeNode.getCenter().east(2).south();
            }

            // place the second part of the trunk
            for (int y = 0; y <= 3; y++)
            {
                placer.placeBlock(side.add(0, y, 0), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
            }

            // place the third part of the trunk
            for (int y = 3; y <= 7; y++)
            {
                placer.placeBlock(secondLayerSide.add(0, y, 0), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
            }

            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    placer.placeBlock(secondLayerSide.add(x, 7, z), CoreAscensionBlocks.ETHEREAL_WOOD.getDefaultState());
                    placeFoliageBlock(world, placer, random, config, secondLayerSide.add(x, 8, z));
                    // exclude corners
                    if ((x == -1 && z == -1) || (x == -1 && z == 1) || (x == 1 && z == -1) || (x == 1 && z == 1)) continue;
                    placeFoliageBlock(world, placer, random, config, secondLayerSide.add(x, 9, z));
                }
            }

            placeFoliageBlock(world, placer, random, config, secondLayerSide.north().up(6));
            placeFoliageBlock(world, placer, random, config, secondLayerSide.east().up(6));
            placeFoliageBlock(world, placer, random, config, secondLayerSide.west().up(6));
            placeFoliageBlock(world, placer, random, config, secondLayerSide.south().up(6));

            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (x == -2 || z == -2 || x == 2 || z == 2)
                    {
                        placeFoliageBlock(world, placer, random, config, secondLayerSide.add(x, 6, z));
                    }
                    // exclude corners for the rest of the leaf placement
                    if ((x == -2 && z == -2) || (x == -2 && z == 2) || (x == 2 && z == -2) || (x == 2 && z == 2)) continue;
                    if (!world.testBlockState(secondLayerSide.add(x, 7, z), (blockState -> blockState == CoreAscensionBlocks.ETHEREAL_WOOD.getDefaultState())))
                    {
                        placeFoliageBlock(world, placer, random, config, secondLayerSide.add(x, 7, z));
                    }
                    if ((x == -2 && z == 0) || (x == 2 && z == 0) || (x == 0 && z == -2) || (x == 0 && z == 2))
                    {
                        placeFoliageBlock(world, placer, random, config, secondLayerSide.add(x, 8, z));
                    }
                }
            }

            int randDroopyNW = random.nextInt(3) + 1;
            int randDroopyNE = random.nextInt(3) + 1;
            int randDroopySW = random.nextInt(3) + 1;
            int randDroopySE = random.nextInt(3) + 1;
            for (int y = 6; y >= 6 - randDroopyNW; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.west(2).north(2).up(y));
            }
            for (int y = 6; y >= 6 - randDroopyNE; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.east(2).north(2).up(y));
            }
            for (int y = 6; y >= 6 - randDroopySW; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.west(2).south(2).up(y));
            }
            for (int y = 6; y >= 6 - randDroopySE; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.east(2).south(2).up(y));
            }

            int randDroopyN = random.nextBetween(1, 3);
            int randDroopyS = random.nextBetween(1, 3);
            int randDroopyE = random.nextBetween(1, 3);
            int randDroopyW = random.nextBetween(1, 3);
            for (int y = 6; y >= 6 - randDroopyN; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.north(3).up(y));
            }
            for (int y = 6; y >= 6 - randDroopyS; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.south(3).up(y));
            }
            for (int y = 6; y >= 6 - randDroopyE; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.east(3).up(y));
            }
            for (int y = 6; y >= 6 - randDroopyW; y--)
            {
                placeFoliageBlock(world, placer, random, config, secondLayerSide.west(3).up(y));
            }
        }
        // second tree type
        else if (r == 1)
        {
            int randomSide = random.nextBetween(0, 3);
            BlockPos side; // going up
            BlockPos sideStraight;

            if (randomSide == 0)
            {
                side = treeNode.getCenter().north().west();
                sideStraight = treeNode.getCenter().west();

                // first branch
                placer.placeBlock(sideStraight.south().west(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                for (int i = -1; i <= 1; i++)
                {
                    placeFoliageBlock(world, placer, random, config, sideStraight.south(3).west(1).up().add(i, 0, 0));
                    placeFoliageBlock(world, placer, random, config, sideStraight.south(2).west(2).up().add(i, 0, 0));
                }
                placeFoliageBlock(world, placer, random, config, sideStraight.south(2).west(2).up(2));
                placer.placeBlock(sideStraight.south(2).west(2).up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                // droopy
                for (int i = 1; i >= -2; i--)
                {
                    placeFoliageBlock(world, placer, random, config, sideStraight.south(3).add(0, i, 0));
                    if (i > -1)
                    {
                        placeFoliageBlock(world, placer, random, config, sideStraight.south(4).west(2).add(0, i, 0));
                    }
                    if (i > -2)
                    {
                        placeFoliageBlock(world, placer, random, config, sideStraight.south(2).west(3).add(0, i, 0));
                    }
                }

                // second branch logs
                placer.placeBlock(treeNode.getCenter().north().up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().east().up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().east(2).up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());

                // second branch's leaves
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().east(2).up(3));
                for (int x = 0; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        if (x == 0 && z == -1) continue;
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(-x + 3, 2, -z));
                    }
                }
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up(1).south().east(2));
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up().east(3).north());
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().east(3).north());
            }
            else if (randomSide == 1)
            {
                side = treeNode.getCenter().north().east();
                sideStraight = treeNode.getCenter().north();
                placer.placeBlock(sideStraight.north().west(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                for (int i = -1; i <= 1; i++)
                {
                    placeFoliageBlock(world, placer, random, config, sideStraight.north(2).west(2).up().add(0, 0, i));
                    placeFoliageBlock(world, placer, random, config, sideStraight.north(1).west(3).up().add(0, 0, i));
                }
                placeFoliageBlock(world, placer, random, config, sideStraight.north(2).west(2).up(2));
                placer.placeBlock(sideStraight.north(2).west(2).up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                // droopy
                for (int i = 1; i >= -2; i--)
                {
                    placeFoliageBlock(world, placer, random, config, treeNode.getCenter().west(3).north().add(0, i, 0));
                    if (i > -1)
                    {
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(3).west(4).add(0, i, 0));
                    }
                    if (i > -2)
                    {
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(4).west(2).add(0, i, 0));
                    }
                }

                // second branch logs
                placer.placeBlock(treeNode.getCenter().east().up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().south().up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().south(2).up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());

                // second branch's leaves
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().south(2).up(3));
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = 0; z <= 1; z++)
                    {
                        if (x == 1 && z == 0) continue;
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(-x, 2, -z + 3));
                    }
                }
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up(1).west().south(2));
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up().south(3).east());
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().south(3).east());
            }
            else if (randomSide == 2)
            {
                side = treeNode.getCenter().south().east();
                sideStraight = treeNode.getCenter().east();
                placer.placeBlock(sideStraight.north().east(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                for (int i = -1; i <= 1; i++)
                {
                    placeFoliageBlock(world, placer, random, config, sideStraight.north(3).east(1).up().add(i, 0, 0));
                    placeFoliageBlock(world, placer, random, config, sideStraight.north(2).east(2).up().add(i, 0, 0));
                }
                placeFoliageBlock(world, placer, random, config, sideStraight.north(2).east(2).up(2));
                placer.placeBlock(sideStraight.north(2).east(2).up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                // droopy
                for (int i = 1; i >= -2; i--)
                {
                    placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(3).east().add(0, i, 0));
                    if (i > -1)
                    {
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(4).east(3).add(0, i, 0));
                    }
                    if (i > -2)
                    {
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(2).east(4).add(0, i, 0));
                    }
                }

                // second branch logs
                placer.placeBlock(treeNode.getCenter().south().up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().west().up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().west(2).up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());

                // second branch's leaves
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().west(2).up(3));
                for (int x = 0; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        if (x == 1 && z == 1) continue;
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(-x - 2, 2, -z));
                    }
                }
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up(1).north().west(2));
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up().west(3).south());
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().west(3).south());
            }
            else
            {
                side = treeNode.getCenter().south().west();
                sideStraight = treeNode.getCenter().south();
                placer.placeBlock(sideStraight.south().east(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                for (int i = -1; i <= 1; i++)
                {
                    placeFoliageBlock(world, placer, random, config, sideStraight.south(2).east(2).up().add(0, 0, i));
                    placeFoliageBlock(world, placer, random, config, sideStraight.south(1).east(3).up().add(0, 0, i));
                }
                placeFoliageBlock(world, placer, random, config, sideStraight.south(2).east(2).up(2));
                placer.placeBlock(sideStraight.south(2).east(2).up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                // droopy
                for (int i = 1; i >= -2; i--)
                {
                    placeFoliageBlock(world, placer, random, config, treeNode.getCenter().east(3).south().add(0, i, 0));
                    if (i > -1)
                    {
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().south(3).east(4).add(0, i, 0));
                    }
                    if (i > -2)
                    {
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().south(4).east(2).add(0, i, 0));
                    }
                }

                // second branch logs
                placer.placeBlock(treeNode.getCenter().west().up(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().north().up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                placer.placeBlock(treeNode.getCenter().north(2).up(2), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());

                // second branch's leaves
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(2).up(3));
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = 0; z <= 1; z++)
                    {
                        if (x == -1 && z == 1) continue;
                        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().add(-x, 2, -z - 2));
                    }
                }
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up(1).east().north(2));
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up().north(3).west());
                placeFoliageBlock(world, placer, random, config, treeNode.getCenter().north(3).west());
            }

            placer.placeBlock(sideStraight.down(), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());

            for (int y = 0; y <= 6; y++)
            {
                if (y < 3)
                {
                    placer.placeBlock(side.add(0, y, 0), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                }
                if (y > 2)
                {
                    placer.placeBlock(sideStraight.add(0, y, 0), CoreAscensionBlocks.ETHEREAL_LOG.getDefaultState());
                }
            }

            placeFoliageBlock(world, placer, random, config, sideStraight.north().up(6));
            placeFoliageBlock(world, placer, random, config, sideStraight.east().up(6));
            placeFoliageBlock(world, placer, random, config, sideStraight.west().up(6));
            placeFoliageBlock(world, placer, random, config, sideStraight.south().up(6));

            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (x > -2 && x < 2 && z > -2 && z < 2)
                    {
                        placer.placeBlock(sideStraight.add(x, 7, z), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if ((x == -2 && z == -2) || (x == -2 && z == 2) || (x == 2 && z == -2) || (x == 2 && z == 2)) continue;
                    if (z == -2 || z == 2 || x == -2 || x == 2)
                    {
                        placer.placeBlock(sideStraight.add(x, 6, z), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                }
            }

            // droopy membranes
            if (randomSide == 0)
            {
                for (int y = 2; y <= 7; y++)
                {
                    if (y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().north(3).west().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().north().east(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 4 && y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().west(4).north().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().south(3).west().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 5 || y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().east(2).south().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().west(4).south(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().south(2).east().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                }
            }
            else if (randomSide == 1)
            {
                for (int y = 2; y <= 7; y++)
                {
                    if (y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().east(3).north().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().east().south(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 4 && y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().north(4).east().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().west(3).north().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 5 || y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().south(2).west().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().north(4).west(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().west(2).south().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                }
            }
            else if (randomSide == 2)
            {
                for (int y = 2; y <= 7; y++)
                {
                    if (y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().south(3).east().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().south().west(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 4 && y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().east(4).south().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().north(3).east().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 5 || y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().west(2).north().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().east(4).north(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().north(2).west().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                }
            }
            else if (randomSide == 3)
            {
                for (int y = 2; y <= 7; y++)
                {
                    if (y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().west(3).south().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().west().north(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y >= 4 && y <= 6)
                    {
                        placer.placeBlock(treeNode.getCenter().south(4).west().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().east(3).south().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 5 || y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().north(2).east().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                        placer.placeBlock(treeNode.getCenter().south(4).east(2).up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
                    if (y == 6)
                    {
                        placer.placeBlock(treeNode.getCenter().east(2).north().up(y - 1), CoreAscensionBlocks.ETHEREAL_MEMBRANE.getDefaultState());
                    }
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
