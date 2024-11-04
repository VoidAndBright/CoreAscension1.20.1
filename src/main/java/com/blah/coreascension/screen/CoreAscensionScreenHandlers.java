package com.blah.coreascension.screen;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.screen.screens.PrismaeroFurnaceScreen;
import com.blah.coreascension.screen.screens.PrismaeroFurnaceScreenHandler;
import com.blah.coreascension.screen.screens.ReinforcedChestScreen;
import com.blah.coreascension.screen.screens.ReinforcedChestScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CoreAscensionScreenHandlers {
    public static final ScreenHandlerType<ReinforcedChestScreenHandler> REINFORCED_CHEST_SCREEN_HANDLER = RegisterScreenHandler("reinforced_chest", ReinforcedChestScreenHandler::new);
    public static final ScreenHandlerType<PrismaeroFurnaceScreenHandler> PRISMAERION_FURNACE_SCREEN_HANDLER = RegisterScreenHandler("prismaerion_furnace", PrismaeroFurnaceScreenHandler::new);

    public static ScreenHandlerType RegisterScreenHandler(String name, ExtendedScreenHandlerType.ExtendedFactory extendedScreenHandlerType){
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(CoreAscension.MOD_ID, name),new ExtendedScreenHandlerType<>(extendedScreenHandlerType));
    }
    public static void RegisterScreenHandlers() {
        CoreAscension.LOGGER.info("Registering Screen Handlers for " + CoreAscension.MOD_ID);
    }
    public static void ClientRegisterScreens(){
        HandledScreens.register(REINFORCED_CHEST_SCREEN_HANDLER, ReinforcedChestScreen::new);
        HandledScreens.register(PRISMAERION_FURNACE_SCREEN_HANDLER, PrismaeroFurnaceScreen::new);
    }
}
