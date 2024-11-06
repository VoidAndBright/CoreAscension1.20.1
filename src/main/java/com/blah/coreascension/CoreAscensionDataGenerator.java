package com.blah.coreascension;

import com.blah.coreascension.datagen.CoreAscensionBlockTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class CoreAscensionDataGenerator implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(CoreAscensionBlockTagProvider::new);
	}
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {

	}
}
