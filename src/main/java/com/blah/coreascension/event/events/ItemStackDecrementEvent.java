package com.blah.coreascension.event.events;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.event.callback.ItemStackDecrementCallback;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

public class ItemStackDecrementEvent implements ItemStackDecrementCallback
{
    @Override
    public ActionResult onDecrement(int amt, ItemStack stack)
    {
        if (stack.getItem() == CoreAscensionItems.VOID_TOTEM)
        {
            ServerPlayerEntity player = (ServerPlayerEntity)stack.getHolder();
            if (player != null)
            {
                CoreAscension.USED_VOID_TOTEM_CRITERION.trigger(player, stack);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
