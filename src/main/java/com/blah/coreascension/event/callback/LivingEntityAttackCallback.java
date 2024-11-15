package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;

public interface LivingEntityAttackCallback
{
    Event<LivingEntityAttackCallback> EVENT = EventFactory.createArrayBacked(LivingEntityAttackCallback.class,
            (listeners) -> (target, attacker) ->
            {
                for (LivingEntityAttackCallback listener : listeners)
                {
                    ActionResult result = listener.interact(target, attacker);
                    if(result != ActionResult.PASS)
                    {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult interact(LivingEntity entity, Entity entity2);
}
