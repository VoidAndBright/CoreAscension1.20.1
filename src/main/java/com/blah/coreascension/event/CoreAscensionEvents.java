package com.blah.coreascension.event;

import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.AerofuelFloatEvent;
import com.blah.coreascension.item.potion.effects.BuildersCurseEffect;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.server.world.BlockEvent;

public class CoreAscensionEvents
{
    public static void RegisterEvents()
    {
        ItemEntityTickCallback.EVENT.register(new AerofuelFloatEvent());
    }
}
