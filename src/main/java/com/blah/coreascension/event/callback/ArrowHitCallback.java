package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;

public interface ArrowHitCallback {
    Event<ArrowHitCallback> EVENT = EventFactory.createArrayBacked(ArrowHitCallback.class,
            (listeners) -> (target,Arrow) ->
            {
                for (ArrowHitCallback listener : listeners)
                {
                    ActionResult result = listener.interact(target,Arrow);
                    if (result != ActionResult.PASS)
                    {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult interact(Entity Arrow, EntityHitResult hit);
}
