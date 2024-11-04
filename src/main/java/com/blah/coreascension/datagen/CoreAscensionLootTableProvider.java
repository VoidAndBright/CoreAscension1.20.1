package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class CoreAscensionLootTableProvider extends FabricBlockLootTableProvider {
    public CoreAscensionLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    public void generate() {
        addDrop(CoreAscensionBlocks.AMETHYST_SLAB,slabDrops(CoreAscensionBlocks.TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.ACACIA_POST);
        addDrop(CoreAscensionBlocks.ACACIA_SECRET_DOOR);
        addDrop(CoreAscensionBlocks.AERO_LANTERN);
        addDrop(CoreAscensionBlocks.AMANITA_STEM);
        addDrop(CoreAscensionBlocks.AMANITA_CAP);
        addDropWithSilkTouch(CoreAscensionBlocks.AMETHYST_GEM_LEAVES);
        addDrop(CoreAscensionBlocks.BORDERLESS_GLASS);
        addDrop(CoreAscensionBlocks.TITANIUM_ORE,oreDrops(CoreAscensionBlocks.TITANIUM_ORE,CoreAscensionItems.RAW_TITANIUM));
        addDrop(CoreAscensionBlocks.TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.TITANIUM_BLOCK);
    }

}
