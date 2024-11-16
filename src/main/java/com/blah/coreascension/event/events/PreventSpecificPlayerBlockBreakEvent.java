package com.blah.coreascension.event.events;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PreventSpecificPlayerBlockBreakEvent implements PlayerBlockBreakEvents.Before {
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity)
    {
        return blockState != CoreAscensionBlocks.LUMITE_ORE.getDefaultState() ||
                playerEntity.getMainHandStack().getItem() == CoreAscensionItems.BEDROCK_PICKAXE;
        //&&
        //  playerEntity.getMainHandStack().getItem() != CoreAscensionItems.LUMITE_PICKAXE)
    }
}
