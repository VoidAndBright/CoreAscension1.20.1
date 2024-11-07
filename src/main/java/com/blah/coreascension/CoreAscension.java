package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.entities.CoreAscensionBlockEntities;
import com.blah.coreascension.group.CoreAscensionGroups;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import com.blah.coreascension.world.CoreAscensionWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoreAscension implements ModInitializer {
	public static final String MOD_ID = "coreascension";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		CoreAscensionBlocks.RegisterBlocks();
		CoreAscensionItems.RegisterItems();
		CoreAscensionParticles.RegisterParticles();
		CoreAscensionBlockEntities.RegisterBlockEntities();
		CoreAscensionGroups.RegisterGroups();
		CoreAscensionScreenHandlers.RegisterScreenHandlers();
		CoreAscensionWorldGeneration.GenerateWorldGeneration();

		StrippableBlockRegistry.register(CoreAscensionBlocks.CEDAR_LOG, CoreAscensionBlocks.STRIPPED_CEDAR_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.CEDAR_WOOD, CoreAscensionBlocks.STRIPPED_CEDAR_WOOD);
		StrippableBlockRegistry.register(CoreAscensionBlocks.DREAD_LOG, CoreAscensionBlocks.STRIPPED_DREAD_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.DREAD_WOOD, CoreAscensionBlocks.STRIPPED_DREAD_WOOD);
		StrippableBlockRegistry.register(CoreAscensionBlocks.TROPICS_LOG, CoreAscensionBlocks.STRIPPED_TROPICS_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.TROPICS_WOOD, CoreAscensionBlocks.STRIPPED_TROPICS_WOOD);
	}
}