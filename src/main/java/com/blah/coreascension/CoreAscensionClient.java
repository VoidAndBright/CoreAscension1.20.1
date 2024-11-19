package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.entity.CoreAscensionBoats;
import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.event.CoreAscensionEvents;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class CoreAscensionClient implements ClientModInitializer
{
    public void onInitializeClient()
    {
        CoreAscensionParticles.ClientRegisterParticles();
        CoreAscensionBlocks.ClientRegisterBlocks();
        CoreAscensionScreenHandlers.ClientRegisterScreens();
        CoreAscensionBlockEntities.ClientRegisterBlockEntitiesRenderer();
        CoreAscensionEvents.RegisterClientEvents();
        CoreAscensionBoats.ClientRegisterBoats();
        CoreAscensionEntities.ClientRegisterEntities();
    }
}