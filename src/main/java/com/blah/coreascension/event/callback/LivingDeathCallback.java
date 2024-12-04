package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public interface LivingDeathCallback
{
    Event<LivingDeathCallback> EVENT = EventFactory.createArrayBacked(LivingDeathCallback.class,
            (listeners) -> (source, entity) ->
            {
                for (LivingDeathCallback listener : listeners)
                {
                    ActionResult result = listener.onDeath(source, entity);
                    if (result != ActionResult.PASS)
                    {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult onDeath(DamageSource source, LivingEntity entity);
}
