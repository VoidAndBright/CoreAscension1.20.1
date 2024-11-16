package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;

public interface EntityAttackCallback {
    Event<EntityAttackCallback> EVENT = EventFactory.createArrayBacked(EntityAttackCallback.class,
            (listeners) -> (target) ->
            {
                for (EntityAttackCallback listener : listeners)
                {
                    ActionResult result = listener.interact(target);
                    if (result != ActionResult.PASS)
                    {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult interact(Entity target);
}
