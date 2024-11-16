package com.blah.coreascension.event;

import com.blah.coreascension.event.callback.EntityItemDropCallback;
import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;

public class CoreAscensionEvents {
    public static void RegisterClientEvents()
    {
        ClientTickEvents.END_CLIENT_TICK.register(new StepUpEvent());
    }

    public static void RegisterEvents()
    {
        FlingPuncherEvent.EVENT.register(new FlingPuncherEvent());
        ItemEntityTickCallback.EVENT.register(new AerofuelFloatEvent());
        EntityItemDropCallback.EVENT.register(new TeleportDroppedItemsEvent());
        AttackBlockCallback.EVENT.register(new PreventBlockBreakingEvent());
        FlingShooterEvent.EVENT.register(new FlingShooterEvent());
    }
}
