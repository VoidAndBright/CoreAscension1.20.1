package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class GumdropPlacer extends FoliagePlacer
{
    public static final Codec<GumdropPlacer> CODEC = RecordCodecBuilder.create(gumdropPlacerInstance ->
            fillFoliagePlacerFields(gumdropPlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(gumdropPlacerInstance, GumdropPlacer::new));

    private final int height;

    public GumdropPlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return CoreAscensionFoliagePlacerTypes.GUMDROP_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockState gumdropType = CoreAscensionBlocks.RED_GUMDROP.getDefaultState();
        int t = random.nextInt(3);
        if (t == 0) gumdropType = CoreAscensionBlocks.YELLOW_GUMDROP.getDefaultState();
        if (t == 1) gumdropType = CoreAscensionBlocks.GREEN_GUMDROP.getDefaultState();

        int widthMod = random.nextBetween(0, 2);
        for (int y = 0; y <= 4; y++)
        {
            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    placer.placeBlock(treeNode.getCenter().add(x, y, z), gumdropType);
                }
            }
        }

        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                if ((x == -1 && z == -1) || (x == -1 && z == 1) || (x == 1 && z == -1) || (x == 1 && z == 1)) continue;
                placer.placeBlock(treeNode.getCenter().add(x, 5, z), gumdropType);
            }
        }

        for (int x = -2; x <= 2; x++)
        {
            for (int z = -2; z <= 2; z++)
            {
                if ((x == -2 && z == -2) || (x == -2 && z == 2) || (x == 2 && z == -2) || (x == 2 && z == 2)) continue;

                if (x > -2 && z > -2 && x < 2 && z < 2)
                {
                    placer.placeBlock(treeNode.getCenter().add(x, -1, z), gumdropType);
                }

                placer.placeBlock(treeNode.getCenter().add(x, 0, z), gumdropType);
                placer.placeBlock(treeNode.getCenter().add(x, 1, z), gumdropType);
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
