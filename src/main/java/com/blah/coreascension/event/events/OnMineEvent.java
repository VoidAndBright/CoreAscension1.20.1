package com.blah.coreascension.event.events;

import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OnMineEvent implements PlayerBlockBreakEvents.Before
{
    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity)
    {
        return playerEntity.getMainHandStack().getItem() != CoreAscensionItems.BEDROCK_PICKAXE && blockState == Blocks.BEDROCK.getDefaultState();
    }
}
