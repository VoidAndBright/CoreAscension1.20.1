package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
<<<<<<< Updated upstream
import com.blah.coreascension.event.CoreAscensionEvents;
=======
import com.blah.coreascension.block.CoreAscensionBlocks;
>>>>>>> Stashed changes
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.fabricmc.api.ClientModInitializer;

public class CoreAscensionClient implements ClientModInitializer {
<<<<<<< Updated upstream
	public void onInitializeClient()
	{
		CoreAscensionParticles.ClientRegisterParticles();
		CoreAscensionBlocks.ClientRegisterBlocks();
		CoreAscensionScreenHandlers.ClientRegisterScreens();
		CoreAscensionBlockEntities.ClientRegisterBlockEntitiesRenderer();
		CoreAscensionEvents.RegisterClientEvents();
	}
=======
    public void onInitializeClient()
    {
        CoreAscensionParticles.ClientRegisterParticles();
        CoreAscensionBlocks.ClientRegisterBlocks();
        CoreAscensionScreenHandlers.ClientRegisterScreens();
        CoreAscensionBlockEntities.ClientRegisterBlockEntitiesRenderer();


    }
>>>>>>> Stashed changes
}