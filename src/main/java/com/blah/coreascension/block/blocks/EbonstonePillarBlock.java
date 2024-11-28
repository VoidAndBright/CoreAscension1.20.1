package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EbonstonePillarBlock extends PillarBlock
{
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("inactive");

    public EbonstonePillarBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(ACTIVATED);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {
        super.onPlaced(world, pos, state.with(ACTIVATED, true), placer, itemStack);
        world.scheduleBlockTick(pos, this, 1);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        super.scheduledTick(state, world, pos, random);
        if (world.getBlockState(pos.up()).getBlock() == CoreAscensionBlocks.END_GAS ||
                world.getBlockState(pos.down()).getBlock() == CoreAscensionBlocks.END_GAS ||
                world.getBlockState(pos.north()).getBlock() == CoreAscensionBlocks.END_GAS ||
                world.getBlockState(pos.east()).getBlock() == CoreAscensionBlocks.END_GAS ||
                world.getBlockState(pos.west()).getBlock() == CoreAscensionBlocks.END_GAS ||
                world.getBlockState(pos.south()).getBlock() == CoreAscensionBlocks.END_GAS)
        {
            BlockState origState = world.getBlockState(pos);
            world.setBlockState(pos, state.with(ACTIVATED, false).with(AXIS, origState.get(AXIS)));
            world.scheduleBlockTick(pos, this, 1);
        }
        else if (world.getBlockState(pos.up()).getBlock() != CoreAscensionBlocks.END_GAS &&
                world.getBlockState(pos.down()).getBlock() != CoreAscensionBlocks.END_GAS &&
                world.getBlockState(pos.north()).getBlock() != CoreAscensionBlocks.END_GAS &&
                world.getBlockState(pos.east()).getBlock() != CoreAscensionBlocks.END_GAS &&
                world.getBlockState(pos.west()).getBlock() != CoreAscensionBlocks.END_GAS &&
                world.getBlockState(pos.south()).getBlock() != CoreAscensionBlocks.END_GAS)
        {
            BlockState origState = world.getBlockState(pos);
            world.setBlockState(pos, state.with(ACTIVATED, true).with(AXIS, origState.get(AXIS)));
            world.scheduleBlockTick(pos, this, 1);
        }
    }
}
