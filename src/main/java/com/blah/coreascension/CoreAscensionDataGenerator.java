package com.blah.coreascension;

import com.blah.coreascension.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CoreAscensionDataGenerator implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
    {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CoreAscensionBlockTagProvider::new);
        pack.addProvider(CoreAscensionItemTagProvider::new);
        pack.addProvider(CoreAscensionFluidTagProvider::new);
        pack.addProvider(CoreAscensionLootTableProvider::new);
        pack.addProvider(CoreAscensionModelProvider::new);
        pack.addProvider(CoreAscensionAchievementGenerator::new);
    }
}
