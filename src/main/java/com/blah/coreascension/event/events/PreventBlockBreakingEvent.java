package com.blah.coreascension.event.events;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.utils.CoreAscensionTags;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PreventBlockBreakingEvent implements AttackBlockCallback {

    public ActionResult interact(PlayerEntity playerEntity, World world, Hand hand, BlockPos blockPos, Direction direction)
    {
        if (!playerEntity.getStackInHand(hand).isIn(CoreAscensionTags.MINES_BEDROCK)
            && world.getBlockState(blockPos).getBlock() == CoreAscensionBlocks.BEDROCK)
            return ActionResult.SUCCESS;
        return ActionResult.PASS;
    }
}
