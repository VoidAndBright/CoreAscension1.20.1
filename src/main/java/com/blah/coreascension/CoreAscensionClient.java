package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.entity.model.CoreAscensionModelLayers;
import com.blah.coreascension.entity.model.PorcupineModel;
import com.blah.coreascension.entity.renderers.PorcupineRenderer;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;

public class CoreAscensionClient implements ClientModInitializer {
	public void onInitializeClient()
	{
		CoreAscensionParticles.ClientRegisterParticles();
		CoreAscensionBlocks.ClientRegisterBlocks();
		CoreAscensionScreenHandlers.ClientRegisterScreens();
		CoreAscensionBlockEntities.ClientRegisterBlockEntitiesRenderer();
		EntityRendererRegistry.register(CoreAscensionEntities.PORCUPINE, PorcupineRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(CoreAscensionModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);

	}
}