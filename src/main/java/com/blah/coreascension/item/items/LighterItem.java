package com.blah.coreascension.item.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LighterItem extends Item {
    public LighterItem(Settings settings)
    {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context)
    {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos blockPos = context.getBlockPos();
        ItemStack stack = context.getStack();
        world.playSound(player, blockPos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
        context.getStack().damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(context.getHand()));
        return super.useOnBlock(context);
    }
}
