package com.blah.coreascension.group;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CoreAscensionGroups {
    public static final ItemGroup BLOCK_ITEM_GROUP = registerItemGroup("block",CoreAscensionBlocks.BLAZE_BRICK.asItem(),(displayContext, entries) -> {
        entries.add(CoreAscensionBlocks.ACACIA_POST);
        entries.add(CoreAscensionBlocks.ACACIA_SECRET_DOOR);
        entries.add(CoreAscensionBlocks.AERO_LANTERN);
        entries.add(CoreAscensionBlocks.AMANITA_CAP);
        entries.add(CoreAscensionBlocks.AMANITA_STEM);
        entries.add(CoreAscensionBlocks.AMETHYST_GEM_LEAVES);
        entries.add(CoreAscensionBlocks.AMETHYST_GEM_LOG);
        entries.add(CoreAscensionBlocks.AMETHYST_SLAB);
        entries.add(CoreAscensionBlocks.AMETHYST_STAIRS);
        entries.add(CoreAscensionBlocks.AMETHYST_TILES);
        entries.add(CoreAscensionBlocks.AMETHYST_WALL);
        entries.add(CoreAscensionBlocks.ANDESITE_TILE);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_BLOCK);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_ORE);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_CLUSTER);
        // -- TITANIUM --
        entries.add(CoreAscensionBlocks.TITANIUM_ORE);
        entries.add(CoreAscensionBlocks.TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.SEARED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.SEARED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.SEARED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.SINGED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.SINGED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.SINGED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.BURNT_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.BURNT_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.BURNT_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_STAIRS);
        entries.add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_SLAB);
        entries.add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_STAIRS);
        // -- END TITANIUM --
        entries.add(CoreAscensionBlocks.SAPPHIRE_ORE);
        entries.add(CoreAscensionBlocks.SAPPHIRE_BLOCK);
        entries.add(CoreAscensionBlocks.BLAZE_BRICK);
        entries.add(CoreAscensionBlocks.REINFORCED_CHEST);
        // -- CEDAR --
        entries.add(CoreAscensionBlocks.CEDAR_LOG);
        entries.add(CoreAscensionBlocks.CEDAR_WOOD);
        entries.add(CoreAscensionBlocks.CEDAR_PLANKS);
        entries.add(CoreAscensionBlocks.CEDAR_SLAB);
        entries.add(CoreAscensionBlocks.CEDAR_STAIRS);
        entries.add(CoreAscensionBlocks.CEDAR_FENCE);
        entries.add(CoreAscensionBlocks.CEDAR_FENCE_GATE);
        entries.add(CoreAscensionBlocks.CEDAR_BUTTON);
        entries.add(CoreAscensionBlocks.CEDAR_LEAVES);
        entries.add(CoreAscensionBlocks.STRIPPED_CEDAR_LOG);
        entries.add(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD);
        // -- END CEDAR --
        // -- TROPICS --
        entries.add(CoreAscensionBlocks.TROPICS_LOG);
        entries.add(CoreAscensionBlocks.TROPICS_WOOD);
        entries.add(CoreAscensionBlocks.TROPICS_PLANKS);
        entries.add(CoreAscensionBlocks.TROPICS_SLAB);
        entries.add(CoreAscensionBlocks.TROPICS_STAIRS);
        entries.add(CoreAscensionBlocks.TROPICS_FENCE);
        entries.add(CoreAscensionBlocks.TROPICS_FENCE_GATE);
        entries.add(CoreAscensionBlocks.TROPICS_BUTTON);
        entries.add(CoreAscensionBlocks.TROPICS_LEAVES);
        entries.add(CoreAscensionBlocks.STRIPPED_TROPICS_LOG);
        entries.add(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD);
        entries.add(CoreAscensionBlocks.BLACK_SAND);
        entries.add(CoreAscensionBlocks.BLACK_SANDSTONE);
        entries.add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE);
        entries.add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_SLAB);
        entries.add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_STAIRS);
        entries.add(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE);
        entries.add(CoreAscensionBlocks.CHISELED_BLACK_SANDSTONE);
        entries.add(CoreAscensionBlocks.REINFORCED_GLASS);
        entries.add(CoreAscensionBlocks.TROPICS_MUD);
        entries.add(CoreAscensionBlocks.TROPICS_MUD_BRICKS);
        entries.add(CoreAscensionBlocks.TROPICS_MUD_BRICK_SLAB);
        entries.add(CoreAscensionBlocks.TROPICS_MUD_BRICK_STAIRS);
        entries.add(CoreAscensionBlocks.LOAM);
        // -- END TROPICS --
        // -- DREAD --
        entries.add(CoreAscensionBlocks.DREAD_LOG);
        entries.add(CoreAscensionBlocks.DREAD_WOOD);
        entries.add(CoreAscensionBlocks.DREAD_PLANKS);
        entries.add(CoreAscensionBlocks.DREAD_SLAB);
        entries.add(CoreAscensionBlocks.DREAD_STAIRS);
        entries.add(CoreAscensionBlocks.DREAD_FENCE);
        entries.add(CoreAscensionBlocks.DREAD_FENCE_GATE);
        entries.add(CoreAscensionBlocks.DREAD_BUTTON);
        entries.add(CoreAscensionBlocks.STRIPPED_DREAD_LOG);
        entries.add(CoreAscensionBlocks.STRIPPED_DREAD_WOOD);
        entries.add(CoreAscensionBlocks.DREAD_SAND);
        entries.add(CoreAscensionBlocks.DREAD_SANDSTONE);
        entries.add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE);
        entries.add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_SLAB);
        entries.add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_STAIRS);
        entries.add(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE);
        entries.add(CoreAscensionBlocks.CHISELED_DREAD_SANDSTONE);
        entries.add(CoreAscensionBlocks.BORDERLESS_GLASS);
        entries.add(CoreAscensionBlocks.DREAD_ROCK);
        entries.add(CoreAscensionBlocks.DREAD_ROCK_BRICKS);
        // -- END DREAD --

        entries.add(CoreAscensionBlocks.HARDENED_LAVA);
        entries.add(CoreAscensionBlocks.CEMENT);
        entries.add(CoreAscensionBlocks.IMPERVIOUS_BRICK);
    });
    public static final ItemGroup ITEM_GROUP = registerItemGroup("item", CoreAscensionItems.RUBY,(displayContext, entries) -> {
        entries.add(CoreAscensionItems.THE_TOOL);
        entries.add(CoreAscensionItems.RUBY);
        entries.add(CoreAscensionItems.CITRINE);
        entries.add(CoreAscensionItems.TOPAZ);
        entries.add(CoreAscensionItems.SAPPHIRE);
        entries.add(CoreAscensionItems.TADANITE_DIAMOND);
        entries.add(CoreAscensionItems.ETHEREAL_TORCH);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_HELMET);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_CHESTPLATE);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_LEGGINGS);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_BOOTS);
        entries.add(CoreAscensionItems.SAPPHIRE_HELMET);
        entries.add(CoreAscensionItems.SAPPHIRE_CHESTPLATE);
        entries.add(CoreAscensionItems.SAPPHIRE_LEGGINGS);
        entries.add(CoreAscensionItems.SAPPHIRE_BOOTS);
        entries.add(CoreAscensionItems.SAPPHIRE_SWORD);
        entries.add(CoreAscensionItems.SAPPHIRE_PICKAXE);
        entries.add(CoreAscensionItems.SAPPHIRE_AXE);
        entries.add(CoreAscensionItems.SAPPHIRE_SHOVEL);
        entries.add(CoreAscensionItems.SAPPHIRE_HOE);
        entries.add(CoreAscensionItems.TADANITE_HELMET);
        entries.add(CoreAscensionItems.TADANITE_CHESTPLATE);
        entries.add(CoreAscensionItems.TADANITE_LEGGINGS);
        entries.add(CoreAscensionItems.TADANITE_BOOTS);
        entries.add(CoreAscensionItems.TADANITE_SWORD);
        entries.add(CoreAscensionItems.TADANITE_PICKAXE);
        entries.add(CoreAscensionItems.TADANITE_AXE);
        entries.add(CoreAscensionItems.TADANITE_SHOVEL);
        entries.add(CoreAscensionItems.TADANITE_HOE);
    });
    public static ItemGroup registerItemGroup(String name, Item item, ItemGroup.EntryCollector entries){
        return Registry.register(Registries.ITEM_GROUP, new Identifier(CoreAscension.MOD_ID, name), FabricItemGroup.builder().
                displayName(Text.translatable("itemgroup."+name)).
                icon(()->new ItemStack(item)).
                entries(entries).build());
    }
    public static void RegisterGroups() {
        CoreAscension.LOGGER.info("Registering Item Groups for " + CoreAscension.MOD_ID);
    }
}