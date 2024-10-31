package com.blah.coreascension.item;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CoreAscensionItemGroups {
    public static final ItemGroup BLOCK_ITEM_GROUP = registerItemGroup("block",CoreAscensionBlocks.BLAZE_BRICK.asItem(),(displayContext, entries) -> {
        entries.add(CoreAscensionBlocks.ACACIA_POST);
        entries.add(CoreAscensionBlocks.ACACIA_SECRET_DOOR);
        entries.add(CoreAscensionBlocks.AERO_LANTERN);
        entries.add(CoreAscensionBlocks.AMANITA_CAP);
        entries.add(CoreAscensionBlocks.AMANITA_STEM);
        entries.add(CoreAscensionBlocks.AMETHYST_GEM_LEAVES);
        entries.add(CoreAscensionBlocks.AMETHYST_GEM_LOG);
        entries.add(CoreAscensionBlocks.AMETHYST_SLAB);
        entries.add(CoreAscensionBlocks.AMETHYST_STAIR);
        entries.add(CoreAscensionBlocks.AMETHYST_TILE);
        entries.add(CoreAscensionBlocks.AMETHYST_WALL);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_BLOCK);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_CLUSTER);
        entries.add(CoreAscensionBlocks.BURNT_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.BURNT_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.BURNT_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.SEARED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.SEARED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.SEARED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.SINGED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.SINGED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.SINGED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.BLAZE_BRICK);
    });
    public static final ItemGroup ITEM_GROUP = registerItemGroup("item",CoreAscensionItems.RUBY,(displayContext, entries) -> {
        entries.add(CoreAscensionItems.RUBY);
        entries.add(CoreAscensionItems.ETHEREAL_TORCH);
    });
    public static ItemGroup registerItemGroup(String name, Item item, ItemGroup.EntryCollector entries){
        return Registry.register(Registries.ITEM_GROUP, new Identifier(CoreAscension.MOD_ID, name), FabricItemGroup.builder().
                displayName(Text.translatable("itemgroup."+name)).
                icon(()->new ItemStack(item)).
                entries(entries).build());
    }
    public static void registerItemGroups() {
        CoreAscension.LOGGER.info("Registering Item Groups for " + CoreAscension.MOD_ID);
    }
}