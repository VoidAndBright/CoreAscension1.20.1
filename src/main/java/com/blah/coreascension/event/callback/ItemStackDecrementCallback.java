package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;

public interface ItemStackDecrementCallback
{
    Event<ItemStackDecrementCallback> EVENT = EventFactory.createArrayBacked(ItemStackDecrementCallback.class,
            (listeners) -> (amt, stack) ->
            {
                for (ItemStackDecrementCallback listener : listeners)
                {
                    ActionResult result = listener.onDecrement(amt, stack);
                    if (result != ActionResult.PASS)
                    {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult onDecrement(int amt, ItemStack stack);
}
