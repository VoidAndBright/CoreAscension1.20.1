package com.blah.coreascension.screen;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.screen.screens.*;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CoreAscensionScreenHandlers {
<<<<<<< Updated upstream
    public static final ScreenHandlerType<ReinforcedChestScreenHandler> REINFORCED_CHEST_SCREEN_HANDLER = RegisterExtendedScreenHandler("reinforced_chest", ReinforcedChestScreenHandler::new);
    public static final ScreenHandlerType<PrismaeroFurnaceScreenHandler> PRISMAERION_FURNACE_SCREEN_HANDLER = RegisterExtendedScreenHandler("prismaerion_furnace", PrismaeroFurnaceScreenHandler::new);
    public static final ScreenHandlerType<CatalyzerScreenHandler> CATALYZER_SCREEN_HANDLER = RegisterExtendedScreenHandler("catalyzer", CatalyzerScreenHandler::new);
    //public static final ScreenHandlerType<CatalyzerScreenHandler> NORMAL_CATALYZER_SCREEN_HANDLER = RegisterExtendedScreenHandler("catalyzer", CatalyzerScreenHandler::new);
=======
    public static final ScreenHandlerType<ReinforcedChestScreenHandler> REINFORCED_CHEST_SCREEN_HANDLER = RegisterScreenHandler("reinforced_chest", ReinforcedChestScreenHandler::new);
    public static final ScreenHandlerType<PrismaeroFurnaceScreenHandler> PRISMAERION_FURNACE_SCREEN_HANDLER = RegisterScreenHandler("prismaerion_furnace", PrismaeroFurnaceScreenHandler::new);
    public static final ScreenHandlerType<CatalyzerTableScreenHandler> CATALYZER_TABLE_SCREEN_HANDLER = RegisterScreenHandler("catalyzer", CatalyzerTableScreenHandler::new);
>>>>>>> Stashed changes

    public static <T extends ScreenHandler> ScreenHandlerType<T> RegisterScreenHandler(String name, ExtendedScreenHandlerType.ExtendedFactory<T> extendedScreenHandlerType){
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(CoreAscension.MOD_ID, name),new ExtendedScreenHandlerType<>(extendedScreenHandlerType));
    }
    public static void RegisterScreenHandlers() {
        CoreAscension.LOGGER.info("Registering Screen Handlers for " + CoreAscension.MOD_ID);
    }
    public static void ClientRegisterScreens(){
        HandledScreens.register(REINFORCED_CHEST_SCREEN_HANDLER, ReinforcedChestScreen::new);
        HandledScreens.register(PRISMAERION_FURNACE_SCREEN_HANDLER, PrismaeroFurnaceScreen::new);
        HandledScreens.register(CATALYZER_TABLE_SCREEN_HANDLER, CatalyzerTableScreen::new);
    }
}
