package com.blah.coreascension.block.blocks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.function.Function;

public class PlayerLauncherBlock extends Block
{
    public static final DirectionProperty FACING = Properties.FACING;

    public PlayerLauncherBlock(Settings settings)
    {
        super(settings);
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext)
    {
        Direction direction = itemPlacementContext.getPlayerLookDirection();
        return this.getDefaultState().with(FACING, direction.getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder.add(FACING));
    }

}
