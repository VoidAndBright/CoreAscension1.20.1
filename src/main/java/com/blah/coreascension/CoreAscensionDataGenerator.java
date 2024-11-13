package com.blah.coreascension;

import com.blah.coreascension.datagen.CoreAscensionBlockTagProvider;
import com.blah.coreascension.datagen.CoreAscensionLootTableProvider;
import com.blah.coreascension.world.dimension.CoreAscensionDimensions;
import com.blah.coreascension.world.feature.CoreAscensionConfiguredFeatureKeys;
import com.blah.coreascension.world.feature.CoreAscensionPlacedFeatureKeys;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CoreAscensionDataGenerator implements DataGeneratorEntrypoint
{
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(CoreAscensionBlockTagProvider::new);
		pack.addProvider(CoreAscensionLootTableProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder)
	{
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, CoreAscensionDimensions::bootstrapType);
	}
}
