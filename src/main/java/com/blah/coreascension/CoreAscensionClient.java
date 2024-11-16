package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.entity.CoreAscensionBoats;
import com.blah.coreascension.event.CoreAscensionEvents;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;

public class CoreAscensionClient implements ClientModInitializer
{
    public void onInitializeClient()
    {
        CoreAscensionParticles.ClientRegisterParticles();
        CoreAscensionBlocks.ClientRegisterBlocks();
        CoreAscensionScreenHandlers.ClientRegisterScreens();
        CoreAscensionBlockEntities.ClientRegisterBlockEntitiesRenderer();
        CoreAscensionEvents.RegisterClientEvents();
        CoreAscensionBoats.RegisterClientSideBoats();
    }
}