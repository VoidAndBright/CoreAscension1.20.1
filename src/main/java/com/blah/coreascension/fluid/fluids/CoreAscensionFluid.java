package com.blah.coreascension.fluid.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class CoreAscensionFluid extends FlowableFluid {
    /**
     @return whether the given fluid an instance of this fluid
     */
    
    public boolean matchesType(Fluid fluid)
    {
        return fluid == getStill() || fluid == getFlowing();
    }

    
    protected boolean isFlowBlocked(BlockView world, BlockPos pos, Direction direction)
    {
        return super.isFlowBlocked(world, pos, direction);
    }

    /**
     @return whether the fluid is infinite (which means can be infinitely created like water). In vanilla, it depends on the game rule.
     */
    
    protected boolean isInfinite(World world)
    {
        return false;
    }

    /**
     Perform actions when the fluid flows into a replaceable block. Water drops
     the block's loot table. Lava plays the "block.lava.extinguish" sound.
     */
    
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    /**
     Lava returns true if it's FluidState is above a certain height and the
     Fluid is Water.

     @return whether the given Fluid can flow into this FluidState
     */
    
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return false;
    }

    /**
     Possibly related to the distance checks for flowing into nearby holes?
     Water returns 4. Lava returns 2 in the Overworld and 4 in the Nether.
     */
    
    protected int getFlowSpeed(WorldView worldView) {
        return 4;
    }

    /**
     Water returns 1. Lava returns 2 in the Overworld and 1 in the Nether.
     */
    
    protected int getLevelDecreasePerBlock(WorldView worldView) {
        return 1;
    }

    /**
     Water returns 5. Lava returns 30 in the Overworld and 10 in the Nether.
     */
    
    public int getTickRate(WorldView worldView) {
        return 5;
    }

    /**
     Water and Lava both return 100.0F.
     */
    
    public float getBlastResistance() {
        return 100.0F;
    }
}