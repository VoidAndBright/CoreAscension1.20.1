package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public interface LivingHurtCallback
{
    Event<LivingHurtCallback> EVENT = EventFactory.createArrayBacked(LivingHurtCallback.class,
            (listeners) -> (source, entity) ->
            {
                for (LivingHurtCallback listener : listeners)
                {
                    ActionResult result = listener.onHurt(source, entity);
                    if (result != ActionResult.PASS)
                    {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult onHurt(DamageSource source, LivingEntity entity);
}
