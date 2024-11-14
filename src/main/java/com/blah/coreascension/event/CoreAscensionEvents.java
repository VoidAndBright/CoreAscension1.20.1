package com.blah.coreascension.event;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.AerofuelFloatEvent;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class CoreAscensionEvents
{
    static int timer = 0;
    public static void RegisterEvents()
    {
        ItemEntityTickCallback.EVENT.register(new AerofuelFloatEvent());
        PlayerBlockBreakEvents.BEFORE.register((world, playerEntity, blockPos, blockState, blockEntity) ->
        {
            return blockState != CoreAscensionBlocks.LUMITE_ORE.getDefaultState() ||
                    playerEntity.getMainHandStack().getItem() == CoreAscensionItems.BEDROCK_PICKAXE;
            //&&
                  //  playerEntity.getMainHandStack().getItem() != CoreAscensionItems.LUMITE_PICKAXE)
        });
        AttackBlockCallback.EVENT.register((playerEntity, world, hand, blockPos, direction) ->
        {
           if (playerEntity.getMainHandStack().getItem() == CoreAscensionItems.BEDROCK_PICKAXE &&
                   world.getBlockState(blockPos).getBlock() == Blocks.BEDROCK)
           {
               timer += 5;
               if (timer < 200)
               {
                   if (timer % 20 == 0)
                       world.playSoundAtBlockCenter(blockPos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 0.25f, world.getRandom().nextFloat() * 0.1f + 0.5f, false);
               }
               else
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
        });
    }
}
