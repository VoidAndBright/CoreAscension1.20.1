package com.blah.coreascension.event;

import com.blah.coreascension.event.callback.EntityItemDropCallback;
import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.*;
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

        ClientTickEvents.END_CLIENT_TICK.register(new StepUpEvent());
        EntityItemDropCallback.EVENT.register(new TeleportDroppedItemsEvent());
    }
}
