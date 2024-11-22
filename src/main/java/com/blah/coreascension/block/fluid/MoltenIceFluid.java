package com.blah.coreascension.block.fluid;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

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
        return null;
    }

    @Override
    protected BlockState toBlockState(FluidState state)
    {
        return CoreAscensionBlocks.MOLTEN_ICE.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
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
