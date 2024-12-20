package com.blah.coreascension.block.fluids;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionFluids;
import com.blah.coreascension.item.CoreAscensionItems;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;
import it.unimi.dsi.fastutil.shorts.*;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Map;
import java.util.Optional;

public abstract class EndGasFluid extends CoreAscensionFluid
{
    private static final ThreadLocal<Object2ByteLinkedOpenHashMap<Block.NeighborGroup>> threadLocal = ThreadLocal.withInitial(() ->
    {
        Object2ByteLinkedOpenHashMap<Block.NeighborGroup> object2ByteLinkedOpenHashMap = new Object2ByteLinkedOpenHashMap<>(200) {
            protected void rehash(int i) {}
        };
        object2ByteLinkedOpenHashMap.defaultReturnValue((byte)127);
        return object2ByteLinkedOpenHashMap;
    });
    
    public Fluid getStill()
    {
        return CoreAscensionFluids.STILL_END_GAS;
    }

    
    public Fluid getFlowing()
    {
        return CoreAscensionFluids.FLOWING_END_GAS;
    }

    private boolean isEmptyOrThis(FluidState state)
    {
        return state.isEmpty() || state.getFluid().matchesType(this);
    }
    private void flowToSides(World world, BlockPos pos, FluidState fluidState, BlockState blockState)
    {
        int i = fluidState.getLevel() - this.getLevelDecreasePerBlock(world);
        if (fluidState.get(FALLING))
        {
            i = 7;
        }
        if (i > 0)
        {
            Map<Direction, FluidState> map = this.getSpread(world, pos, blockState);

            for (Map.Entry<Direction, FluidState> entry : map.entrySet())
            {
                Direction direction = entry.getKey();
                FluidState fluidState2 = entry.getValue();
                BlockPos blockPos = pos.offset(direction);
                BlockState blockState2 = world.getBlockState(blockPos);
                if (this.canFlow(world, pos, blockState, direction, blockPos, blockState2, world.getFluidState(blockPos), fluidState2.getFluid()))
                {
                    this.flow(world, blockPos, blockState2, direction, fluidState2);
                }
            }
        }
    }
    protected static int getBlockStateLevel(FluidState state) {
        return state.isStill() ? 0 : 8 - Math.min(state.getLevel(), 8) + (state.get(FALLING) ? 8 : 0);
    }
    private boolean canFlowUpTo(BlockView world, Fluid fluid, BlockPos pos, BlockState state, BlockPos fromPos, BlockState fromState)
    {
        if (!this.receivesFlow(Direction.UP, world, pos, state, fromPos, fromState))
        {
            return false;
        }
        else
        {
            return fromState.getFluidState().getFluid().matchesType(this) || this.canFill(world, fromPos, fromState, fluid);
        }
    }
    private boolean canFill(BlockView world, BlockPos pos, BlockState state, Fluid fluid)
    {
        Block block = state.getBlock();
        if (block instanceof FluidFillable)
        {
            return ((FluidFillable)block).canFillWithFluid(world, pos, state, fluid);
        } else if (block instanceof DoorBlock
                || state.isIn(BlockTags.SIGNS)
                || state.isOf(Blocks.LADDER)
                || state.isOf(Blocks.SUGAR_CANE)
                || state.isOf(Blocks.BUBBLE_COLUMN))
        {
            return false;
        }
        else
        {
            return !state.isOf(Blocks.NETHER_PORTAL) && !state.isOf(Blocks.END_PORTAL) && !state.isOf(Blocks.END_GATEWAY) && !state.isOf(Blocks.STRUCTURE_VOID) && !state.blocksMovement();
        }
    }
    private boolean receivesFlow(Direction face, BlockView world, BlockPos pos, BlockState state, BlockPos fromPos, BlockState fromState) {
        Object2ByteLinkedOpenHashMap<Block.NeighborGroup> object2ByteLinkedOpenHashMap;
        if (!state.getBlock().hasDynamicBounds() && !fromState.getBlock().hasDynamicBounds()) {
            object2ByteLinkedOpenHashMap = threadLocal.get();
        } else {
            object2ByteLinkedOpenHashMap = null;
        }

        Block.NeighborGroup neighborGroup;
        if (object2ByteLinkedOpenHashMap != null) {
            neighborGroup = new Block.NeighborGroup(state, fromState, face);
            byte b = object2ByteLinkedOpenHashMap.getAndMoveToFirst(neighborGroup);
            if (b != 127) {
                return b != 0;
            }
        } else {
            neighborGroup = null;
        }

        VoxelShape voxelShape = state.getCollisionShape(world, pos);
        VoxelShape voxelShape2 = fromState.getCollisionShape(world, fromPos);
        boolean bl = !VoxelShapes.adjacentSidesCoverSquare(voxelShape, voxelShape2, face);
        if (object2ByteLinkedOpenHashMap != null) {
            if (object2ByteLinkedOpenHashMap.size() == 200) {
                object2ByteLinkedOpenHashMap.removeLastByte();
            }

            object2ByteLinkedOpenHashMap.putAndMoveToFirst(neighborGroup, (byte)(bl ? 1 : 0));
        }

        return bl;
    }
    private static short packXZOffset(BlockPos from, BlockPos to)
    {
        int i = to.getX() - from.getX();
        int j = to.getZ() - from.getZ();
        return (short)((i + 128 & 0xFF) << 8 | j + 128 & 0xFF);
    }
    private boolean canFlowThrough(BlockView world, Fluid fluid, BlockPos pos, BlockState state, Direction face, BlockPos fromPos, BlockState fromState, FluidState fluidState)
    {
        return !this.isMatchingAndStill(fluidState)
                && this.receivesFlow(face, world, pos, state, fromPos, fromState)
                && this.canFill(world, fromPos, fromState, fluid);
    }
    
    protected Map<Direction, FluidState> getSpread(World world, BlockPos pos, BlockState state) {
        int i = 1000;
        Map<Direction, FluidState> map = Maps.newEnumMap(Direction.class);
        Short2ObjectMap<Pair<BlockState, FluidState>> short2ObjectMap = new Short2ObjectOpenHashMap<>();
        Short2BooleanMap short2BooleanMap = new Short2BooleanOpenHashMap();

        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos blockPos = pos.offset(direction);
            short s = packXZOffset(pos, blockPos);
            Pair<BlockState, FluidState> pair = short2ObjectMap.computeIfAbsent(s, (Short2ObjectFunction<? extends Pair<BlockState, FluidState>>)(sx -> {
                BlockState blockState = world.getBlockState(blockPos);
                return Pair.of(blockState, blockState.getFluidState());
            }));
            BlockState blockState = pair.getFirst();
            FluidState fluidState = pair.getSecond();
            FluidState fluidState2 = this.getUpdatedState(world, blockPos, blockState);
            if (this.canFlowThrough(world, fluidState2.getFluid(), pos, state, direction, blockPos, blockState, fluidState)) {
                BlockPos blockPos2 = blockPos.up();
                boolean bl = short2BooleanMap.computeIfAbsent(s, sx -> {
                    BlockState blockState2 = world.getBlockState(blockPos2);
                    return this.canFlowUpTo(world, this.getFlowing(), blockPos, blockState, blockPos2, blockState2);
                });
                int j;
                if (bl) {
                    j = 0;
                } else {
                    j = this.getFlowSpeedBetween(world, blockPos, 1, direction.getOpposite(), blockState, pos, short2ObjectMap, short2BooleanMap);
                }

                if (j < i) {
                    map.clear();
                }

                if (j <= i) {
                    map.put(direction, fluidState2);
                    i = j;
                }
            }
        }

        return map;
    }

    
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    
    protected FluidState getUpdatedState(World world, BlockPos pos, BlockState state)
    {
        int i = 0;
        int j = 0;

        for (Direction direction : Direction.Type.HORIZONTAL)
        {
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            FluidState fluidState = blockState.getFluidState();
            if (fluidState.getFluid().matchesType(this) && this.receivesFlow(direction, world, pos, state, blockPos, blockState))
            {
                if (fluidState.isStill())
                {
                    j++;
                }

                i = Math.max(i, fluidState.getLevel());
            }
        }

        if (this.isInfinite(world) && j >= 2)
        {
            BlockState blockStateUp = world.getBlockState(pos.up());
            FluidState fluidStateUp = blockStateUp.getFluidState();
            if (blockStateUp.isSolid() || this.isMatchingAndStill(fluidStateUp))
            {
                return this.getStill(false);
            }
        }

        BlockState blockStateDown = world.getBlockState(pos.down());
        FluidState fluidStateDown = blockStateDown.getFluidState();
        if (!fluidStateDown.isEmpty() && fluidStateDown.getFluid().matchesType(this) && this.receivesFlow(Direction.DOWN, world, pos, state, pos.down(), blockStateDown))
        {
            return this.getFlowing(8, true);
        }
        else
        {
            int k = i - this.getLevelDecreasePerBlock(world);
            return k <= 0 ? Fluids.EMPTY.getDefaultState() : this.getFlowing(k, false);
        }
    }

    
    protected void tryFlow(World world, BlockPos fluidPos, FluidState state)
    {
        if (!state.isEmpty())
        {
            BlockState blockState = world.getBlockState(fluidPos);
            BlockPos blockPos = fluidPos.up();
            BlockState blockState2 = world.getBlockState(blockPos);
            FluidState fluidState = this.getUpdatedState(world, blockPos, blockState2);
            if (this.canFlow(world, fluidPos, blockState, Direction.UP, blockPos, blockState2, world.getFluidState(blockPos), fluidState.getFluid()))
            {
                this.flow(world, blockPos, blockState2, Direction.UP, fluidState);
                if (this.countNeighboringSources(world, fluidPos) >= 3)
                {
                    this.flowToSides(world, fluidPos, state, blockState);
                }
            }
            else if (state.isStill() || !this.canFlowUpTo(world, fluidState.getFluid(), fluidPos, blockState, blockPos, blockState2))
            {
                this.flowToSides(world, fluidPos, state, blockState);
            }
        }
    }
    private boolean isMatchingAndStill(FluidState state)
    {
        return state.getFluid().matchesType(this) && state.isStill();
    }
    private int countNeighboringSources(WorldView world, BlockPos pos)
    {
        int i = 0;

        for (Direction direction : Direction.Type.HORIZONTAL)
        {
            BlockPos blockPos = pos.offset(direction);
            FluidState fluidState = world.getFluidState(blockPos);
            if (this.isMatchingAndStill(fluidState))
            {
                i++;
            }
        }

        return i;
    }
    
    public FluidState getStill(boolean falling)
    {
        return this.getStill().getDefaultState().with(FALLING, falling);
    }
    
    public FluidState getFlowing(int level, boolean falling)
    {
        return this.getFlowing().getDefaultState().with(LEVEL, level).with(FALLING, falling);
    }
    
    public Vec3d getVelocity(BlockView world, BlockPos pos, FluidState state)
    {
        double d = 0.0;
        double e = 0.0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (Direction direction : Direction.Type.HORIZONTAL)
        {
            mutable.set(pos, direction);
            FluidState fluidState = world.getFluidState(mutable);
            if (this.isEmptyOrThis(fluidState))
            {
                float f = fluidState.getHeight();
                float g = 0.0F;
                if (f == 0.0F)
                {
                    if (!world.getBlockState(mutable).blocksMovement())
                    {
                        BlockPos blockPos = mutable.up();
                        FluidState fluidState2 = world.getFluidState(blockPos);
                        if (this.isEmptyOrThis(fluidState2))
                        {
                            f = fluidState2.getHeight();
                            if (f > 0.0F)
                            {
                                g = state.getHeight() - (f - 0.8888889F);
                            }
                        }
                    }
                }
                else if (f > 0.0F)
                {
                    g = state.getHeight() - f;
                }

                if (g != 0.0F)
                {
                    d += (float)direction.getOffsetX() * g;
                    e += (float)direction.getOffsetZ() * g;
                }
            }
        }

        Vec3d vec3d = new Vec3d(d, 0, e);
        if (state.get(FALLING))
        {
            for (Direction direction2 : Direction.Type.HORIZONTAL)
            {
                mutable.set(pos, direction2);
                if (isFlowBlocked(world, mutable, direction2) || isFlowBlocked(world, mutable.up(), direction2))
                {
                    vec3d = vec3d.normalize().add(0.0, 12.0, 0.0);
                    break;
                }
            }
        }


        //vec3d = new Vec3d(vec3d.getX(), 1, vec3d.getZ());
        //CoreAscension.LOGGER.info(String.valueOf(vec3d.normalize()));
        return vec3d.normalize();
    }

    
    protected boolean isFlowBlocked(BlockView world, BlockPos pos, Direction direction)
    {
        BlockState blockState = world.getBlockState(pos);
        FluidState fluidState = world.getFluidState(pos);
        if (fluidState.getFluid().matchesType(this))
        {
            return false;
        }
        else if (direction == Direction.DOWN)
        {
            return true;
        }
        else
        {
            return !(blockState.getBlock() instanceof IceBlock) && blockState.isSideSolidFullSquare(world, pos, direction);
        }
    }

    
    public Item getBucketItem()
    {
        return CoreAscensionItems.END_GAS_BUCKET;
    }

    
    protected BlockState toBlockState(FluidState fluidState)
    {
        return CoreAscensionBlocks.END_GAS.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends EndGasFluid
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

    public static class Still extends EndGasFluid
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
