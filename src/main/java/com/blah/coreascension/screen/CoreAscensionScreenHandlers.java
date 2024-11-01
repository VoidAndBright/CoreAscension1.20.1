package com.blah.coreascension.screen;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.screen.screens.GemPolishingScreen;
import com.blah.coreascension.screen.screens.GemPolishingScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CoreAscensionScreenHandlers {
    public static final ScreenHandlerType<GemPolishingScreenHandler> GEM_POLISHING_SCREEN_HANDLER = RegisterScreenHandler("gem_polishing",GemPolishingScreenHandler::new);

    public static ScreenHandlerType RegisterScreenHandler(String name, ExtendedScreenHandlerType.ExtendedFactory extendedScreenHandlerType){
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(CoreAscension.MOD_ID, name),new ExtendedScreenHandlerType<>(extendedScreenHandlerType));
    }
    public static void RegisterScreenHandlers() {
        CoreAscension.LOGGER.info("Registering Screen Handlers for " + CoreAscension.MOD_ID);
    }
    public static void ClientRegisterScreens(){
        HandledScreens.register(GEM_POLISHING_SCREEN_HANDLER, GemPolishingScreen::new);
    }
}
