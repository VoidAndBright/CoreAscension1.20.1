package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class AnySpreadableBlock extends SpreadableBlock {
    private final Block dirt;

    public AnySpreadableBlock(Settings settings, Block dirt)
    {
        super(settings);
        this.dirt = dirt;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        if (!canSurvive(state, world, pos))
        {
            world.setBlockState(pos, dirt.getDefaultState());
        } else
        {
            if (world.getLightLevel(pos.up()) >= 9)
            {
                BlockState blockState = this.getDefaultState();

                for (int i = 0; i < 4; ++i)
                {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(blockPos).isOf(dirt) && canSpread(blockState, world, blockPos))
                    {
                        world.setBlockState(blockPos, blockState.with(SNOWY, world.getBlockState(blockPos.up()).isOf(Blocks.SNOW)));
                    }
                }
            }

        }
    }

    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos)
    {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.SNOW) && blockState.get(SnowBlock.LAYERS) == 1)
        {
            return true;
        }
        else if (blockState.isOf(CoreAscensionBlocks.FROSTING))
        {
            return true;
        }
        else if (blockState.getFluidState().getLevel() == 8)
        {
            return false;
        }
        else
        {
            int light = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
            return light < world.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos)
    {
        BlockPos blockPos = pos.up();
        return canSurvive(state, world, pos) && !world.getFluidState(blockPos).isIn(FluidTags.WATER);
    }
}
