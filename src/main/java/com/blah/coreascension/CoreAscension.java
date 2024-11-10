package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.group.CoreAscensionGroups;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.recipe.CoreAscensionRecipes;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import com.blah.coreascension.world.CoreAscensionWorldGeneration;
import net.fabricmc.api.ModInitializer;
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
		CoreAscensionRecipes.RegisterRecipes();
		CoreAscensionEntities.RegisterEntities();
		CoreAscensionWorldGeneration.GenerateWorldGeneration();
	}
}