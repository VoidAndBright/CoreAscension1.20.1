package com.blah.coreascension.world.tree.nontreeplacers;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.blocks.FrostingBlock;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class BoneFossilPlacer extends FoliagePlacer
{
    public static final Codec<BoneFossilPlacer> CODEC = RecordCodecBuilder.create(frostingPlacerInstance ->
            fillFoliagePlacerFields(frostingPlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(frostingPlacerInstance, BoneFossilPlacer::new));

    private final int height;

    public BoneFossilPlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return CoreAscensionFoliagePlacerTypes.BONE_FOSSIL_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        int randDir = random.nextBetween(0, 3);

        if (randDir == 0)
        {
            // the spine
            for (int x = -5; x <= 5; x++)
            {
                placer.placeBlock(treeNode.getCenter().add(x, 0, 0), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
            }
            // back of the ribcage
            for (int x = -4; x <= 4; x += 2)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (z == 0) continue;
                    if (x == 4 && (z == -2 || z == 2)) continue;
                    placer.placeBlock(treeNode.getCenter().add(x, 0, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
                }
            }
            // side of the ribcage
            for (int x = -4; x <= 2; x += 2)
            {
                if (x == 2)
                {
                    for (int y = 1; y <= 2; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, y, -3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(x, y, 3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
                else
                {
                    for (int y = 1; y <= 3; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, y, -3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(x, y, 3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
            }
            for (int y = 1; y <= 2; y++)
            {
                placer.placeBlock(treeNode.getCenter().add(4, y, -2), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                placer.placeBlock(treeNode.getCenter().add(4, y, 2), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));

            }
            // front of the ribcage
            for (int x = -4; x <= 2; x += 2)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (z == 0) continue;;
                    if (x == 2)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 3, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
                    }
                    else
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 4, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
                    }
                }
            }
            placer.placeBlock(treeNode.getCenter().add(4, 3, -1), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
            placer.placeBlock(treeNode.getCenter().add(4, 3, 1), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
        }
        if (randDir == 1)
        {
            // the spine
            for (int z = -5; z <= 5; z++)
            {
                placer.placeBlock(treeNode.getCenter().add(0, 0, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
            }
            // back of the ribcage
            for (int z = -4; z <= 4; z += 2)
            {
                for (int x = -2; x <= 2; x++)
                {
                    if (x == 0) continue;
                    if (z == 4 && (x == -2 || x == 2)) continue;
                    placer.placeBlock(treeNode.getCenter().add(x, 0, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
                }
            }
            // side of the ribcage
            for (int z = -4; z <= 2; z += 2)
            {
                if (z == 2)
                {
                    for (int y = 1; y <= 2; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(-3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
                else
                {
                    for (int y = 1; y <= 3; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(-3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
            }
            for (int y = 1; y <= 2; y++)
            {
                placer.placeBlock(treeNode.getCenter().add(-2, y, 4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                placer.placeBlock(treeNode.getCenter().add(2, y, 4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));

            }
            // front of the ribcage
            for (int z = -4; z <= 2; z += 2)
            {
                for (int x = -2; x <= 2; x++)
                {
                    if (x == 0) continue;;
                    if (z == 2)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 3, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
                    }
                    else
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 4, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
                    }
                }
            }
            placer.placeBlock(treeNode.getCenter().add(-1, 3, 4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
            placer.placeBlock(treeNode.getCenter().add(1, 3, 4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
        }
        if (randDir == 2)
        {
            // the spine
            for (int x = -5; x <= 5; x++)
            {
                placer.placeBlock(treeNode.getCenter().add(x, 0, 0), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
            }
            // back of the ribcage
            for (int x = -4; x <= 4; x += 2)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (z == 0) continue;
                    if (x == -4 && (z == -2 || z == 2)) continue;
                    placer.placeBlock(treeNode.getCenter().add(x, 0, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
                }
            }
            // side of the ribcage
            for (int x = 4; x >= -2; x -= 2)
            {
                if (x == -2)
                {
                    for (int y = 1; y <= 2; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, y, -3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(x, y, 3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
                else
                {
                    for (int y = 1; y <= 3; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, y, -3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(x, y, 3), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
            }
            for (int y = 1; y <= 2; y++)
            {
                placer.placeBlock(treeNode.getCenter().add(-4, y, -2), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                placer.placeBlock(treeNode.getCenter().add(-4, y, 2), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));

            }
            // front of the ribcage
            for (int x = 4; x >= -2; x -= 2)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (z == 0) continue;;
                    if (x == -2)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 3, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
                    }
                    else
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 4, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
                    }
                }
            }
            placer.placeBlock(treeNode.getCenter().add(-4, 3, -1), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
            placer.placeBlock(treeNode.getCenter().add(-4, 3, 1), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
        }
        if (randDir == 3)
        {
            // the spine
            for (int z = -5; z <= 5; z++)
            {
                placer.placeBlock(treeNode.getCenter().add(0, 0, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z));
            }
            // back of the ribcage
            for (int z = -4; z <= 4; z += 2)
            {
                for (int x = -2; x <= 2; x++)
                {
                    if (x == 0) continue;
                    if (z == -4 && (x == -2 || x == 2)) continue;
                    placer.placeBlock(treeNode.getCenter().add(x, 0, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
                }
            }
            // side of the ribcage
            for (int z = 4; z >= -2; z -= 2)
            {
                if (z == -2)
                {
                    for (int y = 1; y <= 2; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(-3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
                else
                {
                    for (int y = 1; y <= 3; y++)
                    {
                        placer.placeBlock(treeNode.getCenter().add(-3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                        placer.placeBlock(treeNode.getCenter().add(3, y, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                    }
                }
            }
            for (int y = 1; y <= 2; y++)
            {
                placer.placeBlock(treeNode.getCenter().add(-2, y, -4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));
                placer.placeBlock(treeNode.getCenter().add(2, y, -4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y));

            }
            // front of the ribcage
            for (int z = 4; z >= -2; z -= 2)
            {
                for (int x = -2; x <= 2; x++)
                {
                    if (x == 0) continue;;
                    if (z == -2)
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 3, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
                    }
                    else
                    {
                        placer.placeBlock(treeNode.getCenter().add(x, 4, z), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
                    }
                }
            }
            placer.placeBlock(treeNode.getCenter().add(-1, 3, -4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
            placer.placeBlock(treeNode.getCenter().add(1, 3, -4), Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X));
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
