package com.blah.coreascension;

import com.blah.coreascension.datagen.ModBlockTagProvider;
import com.blah.coreascension.world.CoreAscensionConfiguredFeatures;
import com.blah.coreascension.world.CoreAscensionPlacedFeatures;
import com.blah.coreascension.world.biome.CoreAscensionBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CoreAscensionDataGenerator implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
	}
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, CoreAscensionConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, CoreAscensionPlacedFeatures::boostrap);
		//registryBuilder.addRegistry(RegistryKeys.BIOME, CoreAscensionBiomes::bootstrap);
//		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
