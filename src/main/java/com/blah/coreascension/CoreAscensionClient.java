package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionFluids;
import com.blah.coreascension.entity.CoreAscensionBoats;
import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.event.CoreAscensionEvents;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.util.Identifier;

public class CoreAscensionClient implements ClientModInitializer
{
    public void onInitializeClient()
    {
        CoreAscensionParticles.ClientRegisterParticles();
        CoreAscensionBlocks.ClientRegisterBlocks();
        CoreAscensionScreenHandlers.ClientRegisterScreens();
        CoreAscensionBlockEntities.ClientRegisterBlockEntitiesRenderer();
        CoreAscensionEvents.ClientRegisterEvents();
        CoreAscensionBoats.ClientRegisterBoats();
        CoreAscensionEntities.ClientRegisterEntities();
        FluidRenderHandlerRegistry.INSTANCE.register(CoreAscensionFluids.STILL_END_GAS, CoreAscensionFluids.FLOWING_END_GAS, new SimpleFluidRenderHandler(
                new Identifier("coreascension:block/end_gas_still"),
                new Identifier("coreascension:block/end_gas_flowing"),
                0xFFFFFF
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(CoreAscensionFluids.STILL_MOLTEN_ICE, CoreAscensionFluids.FLOWING_MOLTEN_ICE, new SimpleFluidRenderHandler(
                new Identifier("coreascension:block/molten_ice_still"),
                new Identifier("coreascension:block/molten_ice_flowing"),
                0xFFFFFF
        ));
    }
}