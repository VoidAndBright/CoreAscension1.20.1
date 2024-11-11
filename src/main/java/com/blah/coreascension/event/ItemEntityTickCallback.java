package com.blah.coreascension.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.ActionResult;

public interface ItemEntityTickCallback {

    Event<ItemEntityTickCallback> EVENT = EventFactory.createArrayBacked(ItemEntityTickCallback.class,
            (listeners) -> (item) -> {
                for (ItemEntityTickCallback listener : listeners) {
                    ActionResult result = listener.interact(item);

                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    ActionResult interact(ItemEntity item);
}
