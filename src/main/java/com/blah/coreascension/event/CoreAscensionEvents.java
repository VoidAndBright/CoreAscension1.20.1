package com.blah.coreascension.event;

import com.blah.coreascension.event.events.TeleportDroppedItemsEvent;
import com.blah.coreascension.event.callback.EntityItemDropCallback;
import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.AerofuelFloatEvent;
import com.blah.coreascension.event.events.LivingAttackEvent;
import com.blah.coreascension.event.events.StepUpEvent;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class CoreAscensionEvents
{
    public static void RegisterClientEvents()
    {
        ClientTickEvents.END_CLIENT_TICK.register(new StepUpEvent());
    }

    public static void RegisterEvents()
    {
        LivingAttackEvent.EVENT.register(new LivingAttackEvent());
        ItemEntityTickCallback.EVENT.register(new AerofuelFloatEvent());
        EntityItemDropCallback.EVENT.register(new TeleportDroppedItemsEvent());
    }
}
