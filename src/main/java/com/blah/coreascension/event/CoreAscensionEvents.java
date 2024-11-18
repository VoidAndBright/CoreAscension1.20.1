package com.blah.coreascension.event;

import com.blah.coreascension.event.callback.EntityItemDropCallback;
import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;

public class CoreAscensionEvents
{
    public static void RegisterClientEvents()
    {
        ClientTickEvents.END_CLIENT_TICK.register(new StepUpEvent());
        ClientTickEvents.END_CLIENT_TICK.register(new PlayerLauncherEvent());
    }

    public static void RegisterEvents()
    {
        ServerTickEvents.END_SERVER_TICK.register(new LauncherEvent());
        FlingPuncherEvent.EVENT.register(new FlingPuncherEvent());
        ItemEntityTickCallback.EVENT.register(new AerofuelFloatEvent());
        EntityItemDropCallback.EVENT.register(new TeleportDroppedItemsEvent());
        AttackBlockCallback.EVENT.register(new PreventBlockBreakingEvent());
        FlingShooterEvent.EVENT.register(new FlingShooterEvent());
    }
}
