package com.blah.coreascension.fluid.fluids;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionFluids;
import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import com.blah.coreascension.fluid.CoreAscensionFluids;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public abstract class MoltenIceFluid extends CoreAscensionFluid
{

    @Override
    public Fluid getFlowing()
    {
        return CoreAscensionFluids.FLOWING_MOLTEN_ICE;
    }

    @Override
    public Fluid getStill()
    {
        return CoreAscensionFluids.STILL_MOLTEN_ICE;
    }

    @Override
    public Item getBucketItem()
    {
        return CoreAscensionItems.MOLTEN_ICE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state)
    {
        return CoreAscensionBlocks.MOLTEN_ICE.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public int getLevel(FluidState state)
    {
        return 0;
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(1501, pos, 0);
    }


    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState)
    {
        if (direction == Direction.DOWN)
        {
            FluidState fluidState2 = world.getFluidState(pos);
            if (fluidState2.isIn(FluidTags.LAVA))
            {
                if (state.getBlock() instanceof FluidBlock)
                {
                    world.setBlockState(pos, Blocks.STONE.getDefaultState(), 3);
                }
                playExtinguishEvent(world, pos);
                return;
            }
        }
        super.flow(world, pos, state, direction, fluidState);
    }

    public static class Flowing extends MoltenIceFluid
    {
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder)
        {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState fluidState)
        {
            return fluidState.get(LEVEL);
        }


        public boolean isStill(FluidState fluidState)
        {
            return false;
        }
    }

    public static class Still extends MoltenIceFluid
    {
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }

        public boolean isStill(FluidState fluidState)
        {
            return true;
        }
    }
}
