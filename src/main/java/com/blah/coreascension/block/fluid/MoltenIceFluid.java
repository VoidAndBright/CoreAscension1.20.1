package com.blah.coreascension.block.fluid;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

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
/*
    public int getTickRate(WorldView world) {
        return 1;
    }
    protected boolean hasRandomTicks() {
        return true;
    }
    @Override
    protected void onRandomTick(World world, BlockPos pos, FluidState state, Random random)
    {
        super.onRandomTick(world, pos, state, random);
        for (Entity entity : world.getOtherEntities(null, new Box(pos)))
        {
            if (entity instanceof LivingEntity living)
            {
                if (!(living instanceof GhastEntity))
                {
                    // figure out how to increase the tick rate of randomly ticking blocks
                    living.damage(CoreAscensionDamageTypes.of(living.getWorld(), CoreAscensionDamageTypes.FREEZING), 6);
                }
            }
        }
    }

    @Override
    public void onScheduledTick(World world, BlockPos pos, FluidState state)
    {
        super.onScheduledTick(world, pos, state);
        for (Entity entity : world.getOtherEntities(null, new Box(pos)))
        {
            if (entity instanceof LivingEntity living)
            {
                if (!(living instanceof GhastEntity))
                {
                    living.damage(CoreAscensionDamageTypes.of(living.getWorld(), CoreAscensionDamageTypes.FREEZING), 2);
                }
            }
        }
    }*/
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
