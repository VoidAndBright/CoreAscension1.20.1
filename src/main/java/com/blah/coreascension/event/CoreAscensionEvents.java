package com.blah.coreascension.event;

import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.event.events.AerofuelFloatEvent;

public class CoreAscensionEvents
{
    public static void RegisterEvents()
    {
        ItemEntityTickCallback.EVENT.register(new AerofuelFloatEvent());
    }

}
