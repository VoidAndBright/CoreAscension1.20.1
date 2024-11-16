package com.blah.coreascension.event.events;

import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class MimicBlockBreakEvent implements AttackBlockCallback {
    static int timer = 0;

    public ActionResult interact(PlayerEntity playerEntity, World world, Hand hand, BlockPos blockPos, Direction direction)
    {
        Blocks.BEDROCK.getHardness();
        if (playerEntity.getMainHandStack().getItem() == CoreAscensionItems.BEDROCK_PICKAXE &&
                world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK)
        {
            timer += 5;
            if (timer < 200)
            {
                if (timer % 20 == 0)
                    world.playSoundAtBlockCenter(blockPos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 0.25f, world.getRandom().nextFloat() * 0.1f + 0.5f, false);
            } else
            {
                playerEntity.getMainHandStack().setDamage(playerEntity.getMainHandStack().getDamage() + 1);
                world.breakBlock(blockPos, true);
                ItemEntity bedrock = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(Blocks.BEDROCK, 1));
                world.spawnEntity(bedrock);
                timer = 0;
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
