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
    public static final ItemGroup BLOCK_ITEM_GROUP = registerItemGroup("block_item",CoreAscensionBlocks.BLAZE_BRICK.asItem(),(displayContext, entries) -> {
        entries.add(CoreAscensionBlocks.ACACIA_POST);
        entries.add(CoreAscensionBlocks.DREAD_POST);
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
        entries.add(CoreAscensionBlocks.DIORITE_TILE);
        entries.add(CoreAscensionBlocks.GRANITE_TILE);

        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_BLOCK);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_ORE);
        entries.add(CoreAscensionBlocks.ARGON_CRYSTAL_CLUSTER);

        // -- TITANIUM --
        entries.add(CoreAscensionBlocks.TITANIUM_ORE);
        entries.add(CoreAscensionBlocks.RAW_TITANIUM_BLOCK);
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
        entries.add(CoreAscensionBlocks.CEDAR_DOOR);
        entries.add(CoreAscensionBlocks.CEDAR_TRAPDOOR);
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
        entries.add(CoreAscensionBlocks.TROPICS_DOOR);
        entries.add(CoreAscensionBlocks.TROPICS_TRAPDOOR);
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
        entries.add(CoreAscensionBlocks.TROPICS_SAPLING);
        entries.add(CoreAscensionBlocks.LOAM);
        entries.add(CoreAscensionBlocks.TROPICAL_GRASS);
        entries.add(CoreAscensionBlocks.WHITEWOOD_LOG);
        entries.add(CoreAscensionBlocks.WHITEWOOD_WOOD);
        entries.add(CoreAscensionBlocks.WHITEWOOD_PLANKS);
        entries.add(CoreAscensionBlocks.WHITEWOOD_SLAB);
        entries.add(CoreAscensionBlocks.WHITEWOOD_STAIRS);
        entries.add(CoreAscensionBlocks.WHITEWOOD_FENCE);
        entries.add(CoreAscensionBlocks.WHITEWOOD_FENCE_GATE);
        entries.add(CoreAscensionBlocks.WHITEWOOD_BUTTON);
        entries.add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_LOG);
        entries.add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_WOOD);
        entries.add(CoreAscensionBlocks.WHITEWOOD_DOOR);
        entries.add(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR);
        entries.add(CoreAscensionBlocks.SEASHELL);
        entries.add(CoreAscensionBlocks.CONCH_SHELL);
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
        entries.add(CoreAscensionBlocks.DREAD_DOOR);
        entries.add(CoreAscensionBlocks.DREAD_TRAPDOOR);
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

        // -- ANCIENT BIOME --
        entries.add(CoreAscensionBlocks.BONESAND);
        entries.add(CoreAscensionBlocks.BONESANDSTONE);
        entries.add(CoreAscensionBlocks.CHISELED_BONESANDSTONE);
        entries.add(CoreAscensionBlocks.SMOOTH_BONESANDSTONE);
        entries.add(CoreAscensionBlocks.CUT_BONESANDSTONE);
        entries.add(CoreAscensionBlocks.CUT_BONESANDSTONE_STAIRS);
        entries.add(CoreAscensionBlocks.CUT_BONESANDSTONE_SLAB);
        // -- END ANCIENT --

        // -- ETHEREAL GLADE --
        entries.add(CoreAscensionBlocks.ETHEREAL_LOG);
        entries.add(CoreAscensionBlocks.ETHEREAL_WOOD);
        entries.add(CoreAscensionBlocks.ETHEREAL_PLANKS);
        entries.add(CoreAscensionBlocks.ETHEREAL_SLAB);
        entries.add(CoreAscensionBlocks.ETHEREAL_STAIRS);
        entries.add(CoreAscensionBlocks.ETHEREAL_FENCE);
        entries.add(CoreAscensionBlocks.ETHEREAL_FENCE_GATE);
        entries.add(CoreAscensionBlocks.ETHEREAL_BUTTON);
        entries.add(CoreAscensionBlocks.ETHEREAL_DOOR);
        entries.add(CoreAscensionBlocks.ETHEREAL_TRAPDOOR);
        entries.add(CoreAscensionBlocks.ETHEREAL_LEAVES);
        entries.add(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG);
        entries.add(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD);
        entries.add(CoreAscensionBlocks.ETHEREAL_MEMBRANE);
        entries.add(CoreAscensionBlocks.ETHEREAL_DIRT);
        entries.add(CoreAscensionBlocks.ETHEREAL_GRASS);
        // -- END ETHEREAL --

        entries.add(CoreAscensionBlocks.HARDENED_LAVA);
        entries.add(CoreAscensionBlocks.CEMENT);
        entries.add(CoreAscensionBlocks.IMPERVIOUS_BRICK);
        entries.add(CoreAscensionBlocks.COCONUT);
        entries.add(CoreAscensionBlocks.URANIUM_ORE);
        entries.add(CoreAscensionBlocks.RAW_URANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.URANIUM_BLOCK);
        entries.add(CoreAscensionBlocks.PRISMAERO_FURNACE);
        entries.add(CoreAscensionBlocks.IGNEOUS_ROCK);
        entries.add(CoreAscensionBlocks.IGNEOUS_ROCK_SLAB);
        entries.add(CoreAscensionBlocks.IGNEOUS_ROCK_STAIRS);
        entries.add(CoreAscensionBlocks.IGNEOUS_ROCK_WALL);
        entries.add(CoreAscensionBlocks.IGNEOUS_ROCK_TILES);
        entries.add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK);
        entries.add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_SLAB);
        entries.add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_STAIRS);
        entries.add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_WALL);
        entries.add(CoreAscensionBlocks.SALTROCK);
        entries.add(CoreAscensionBlocks.SALTROCK_SLAB);
        entries.add(CoreAscensionBlocks.SALTROCK_STAIRS);
        entries.add(CoreAscensionBlocks.SALTROCK_WALL);
        entries.add(CoreAscensionBlocks.SALTROCK_TILES);
        entries.add(CoreAscensionBlocks.POLISHED_SALTROCK);
        entries.add(CoreAscensionBlocks.POLISHED_SALTROCK_SLAB);
        entries.add(CoreAscensionBlocks.POLISHED_SALTROCK_STAIRS);
        entries.add(CoreAscensionBlocks.POLISHED_SALTROCK_WALL);
        entries.add(CoreAscensionBlocks.MAGNETITE);
        entries.add(CoreAscensionBlocks.MAGNETITE_SLAB);
        entries.add(CoreAscensionBlocks.MAGNETITE_STAIRS);
        entries.add(CoreAscensionBlocks.MAGNETITE_WALL);
        entries.add(CoreAscensionBlocks.MAGNETITE_TILES);
        entries.add(CoreAscensionBlocks.POLISHED_MAGNETITE);
        entries.add(CoreAscensionBlocks.POLISHED_MAGNETITE_SLAB);
        entries.add(CoreAscensionBlocks.POLISHED_MAGNETITE_STAIRS);
        entries.add(CoreAscensionBlocks.POLISHED_MAGNETITE_WALL);
        entries.add(CoreAscensionBlocks.LIMESTONE);
        entries.add(CoreAscensionBlocks.LIMESTONE_SLAB);
        entries.add(CoreAscensionBlocks.LIMESTONE_STAIRS);
        entries.add(CoreAscensionBlocks.LIMESTONE_WALL);
        entries.add(CoreAscensionBlocks.LIMESTONE_TILES);
        entries.add(CoreAscensionBlocks.POLISHED_LIMESTONE);
        entries.add(CoreAscensionBlocks.POLISHED_LIMESTONE_SLAB);
        entries.add(CoreAscensionBlocks.POLISHED_LIMESTONE_STAIRS);
        entries.add(CoreAscensionBlocks.POLISHED_LIMESTONE_WALL);
        entries.add(CoreAscensionBlocks.CATALYZER_TABLE);
        entries.add(CoreAscensionBlocks.SULPHUR_BLOCK);
        entries.add(CoreAscensionBlocks.GOLD_PRISMAERO);
        entries.add(CoreAscensionBlocks.CHISELED_PRISMAERO);
        entries.add(CoreAscensionBlocks.POLISHED_PRISMAERO);
        entries.add(CoreAscensionBlocks.PRISMAERO_BRICKS);
        entries.add(CoreAscensionBlocks.PRISMAERO_PILLAR);
        entries.add(CoreAscensionBlocks.PRISMAERO_SLAB);
        entries.add(CoreAscensionBlocks.GOLDEN_PRISMAERO_SLAB);
        entries.add(CoreAscensionBlocks.PRISMAERO_BRICKS_SLAB);
        entries.add(CoreAscensionBlocks.POLISHED_PRISMAERO_SLAB);
        entries.add(CoreAscensionBlocks.PRISMAERO_STAIRS);
        entries.add(CoreAscensionBlocks.GOLDEN_PRISMAERO_STAIRS);
        entries.add(CoreAscensionBlocks.POLISHED_PRISMAERO_STAIRS);
        entries.add(CoreAscensionBlocks.PRISMAERO_BRICKS_STAIRS);
        entries.add(CoreAscensionBlocks.PRISMAERO_WALL);
        entries.add(CoreAscensionBlocks.PETRIFIED_WOOD);
        entries.add(CoreAscensionBlocks.CACTUS_PLANKS);
        entries.add(CoreAscensionBlocks.CACTUS_SLAB);
        entries.add(CoreAscensionBlocks.CACTUS_STAIRS);
        entries.add(CoreAscensionBlocks.CACTUS_FENCE);
        entries.add(CoreAscensionBlocks.CACTUS_FENCE_GATE);
        entries.add(CoreAscensionBlocks.CACTUS_BUTTON);
        entries.add(CoreAscensionBlocks.CACTUS_DOOR);
        entries.add(CoreAscensionBlocks.CACTUS_TRAPDOOR);
    });
    public static final ItemGroup ITEM_GROUP = registerItemGroup("item", CoreAscensionItems.RUBY,(displayContext, entries) -> {
        entries.add(CoreAscensionItems.THE_TOOL);
        entries.add(CoreAscensionItems.MAGIC_MIRROR);
        entries.add(CoreAscensionItems.RUBY);
        entries.add(CoreAscensionItems.CITRINE);
        entries.add(CoreAscensionItems.TOPAZ);
        entries.add(CoreAscensionItems.SAPPHIRE);
        entries.add(CoreAscensionItems.AMETHYST);
        entries.add(CoreAscensionItems.CRYSTALLINE_ARTIFACT);
        entries.add(CoreAscensionItems.RUBY_SHARD);
        entries.add(CoreAscensionItems.CITRINE_SHARD);
        entries.add(CoreAscensionItems.TOPAZ_SHARD);
        entries.add(CoreAscensionItems.EMERALD_SHARD);
        entries.add(CoreAscensionItems.DIAMOND_SHARD);
        entries.add(CoreAscensionItems.SAPPHIRE_SHARD);
        entries.add(CoreAscensionItems.TADANITE_CRYSTAL);
        entries.add(CoreAscensionItems.TADANITE_DIAMOND);
        entries.add(CoreAscensionItems.ETHEREAL_TORCH);
        entries.add(CoreAscensionItems.OBSIDIFIED_BLAZE_ROD);
        entries.add(CoreAscensionItems.RAW_TITANIUM);
        entries.add(CoreAscensionItems.TITANIUM_INGOT);
        entries.add(CoreAscensionItems.SPAWN_EGG);

        entries.add(CoreAscensionItems.CRIMSON_EDGE);
        entries.add(CoreAscensionItems.TITAN_BLADE);
        entries.add(CoreAscensionItems.VERTEX);

        entries.add(CoreAscensionItems.WOODEN_HAMMER);
        entries.add(CoreAscensionItems.STONE_HAMMER);
        entries.add(CoreAscensionItems.GOLDEN_HAMMER);
        entries.add(CoreAscensionItems.IRON_HAMMER);
        entries.add(CoreAscensionItems.DIAMOND_HAMMER);
        entries.add(CoreAscensionItems.NETHERITE_HAMMER);
        entries.add(CoreAscensionItems.WOODEN_EXCAVATOR);
        entries.add(CoreAscensionItems.STONE_EXCAVATOR);
        entries.add(CoreAscensionItems.GOLDEN_EXCAVATOR);
        entries.add(CoreAscensionItems.IRON_EXCAVATOR);
        entries.add(CoreAscensionItems.DIAMOND_EXCAVATOR);
        entries.add(CoreAscensionItems.NETHERITE_EXCAVATOR);

        entries.add(CoreAscensionItems.SULPHUR);
        entries.add(CoreAscensionItems.IRON_ROD);

        entries.add(CoreAscensionItems.RAW_URANIUM);
        entries.add(CoreAscensionItems.URANIUM_INGOT);
        entries.add(CoreAscensionItems.LUMITE_INGOT);
        // -- ARMOR --
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_HELMET);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_CHESTPLATE);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_LEGGINGS);
        entries.add(CoreAscensionItems.GILDED_OBSIDIAN_BOOTS);
        entries.add(CoreAscensionItems.SAPPHIRE_HELMET);
        entries.add(CoreAscensionItems.SAPPHIRE_CHESTPLATE);
        entries.add(CoreAscensionItems.SAPPHIRE_LEGGINGS);
        entries.add(CoreAscensionItems.SAPPHIRE_BOOTS);
        entries.add(CoreAscensionItems.TADANITE_HELMET);
        entries.add(CoreAscensionItems.TADANITE_CHESTPLATE);
        entries.add(CoreAscensionItems.TADANITE_LEGGINGS);
        entries.add(CoreAscensionItems.TADANITE_BOOTS);
        entries.add(CoreAscensionItems.URANIUM_HELMET);
        entries.add(CoreAscensionItems.URANIUM_CHESTPLATE);
        entries.add(CoreAscensionItems.URANIUM_LEGGINGS);
        entries.add(CoreAscensionItems.URANIUM_BOOTS);
        // -- END ARMOR --

        // -- TOOLS --
        entries.add(CoreAscensionItems.POTATO_SWORD);
        entries.add(CoreAscensionItems.POTATO_PICKAXE);
        entries.add(CoreAscensionItems.POTATO_AXE);
        entries.add(CoreAscensionItems.POTATO_SHOVEL);
        entries.add(CoreAscensionItems.POTATO_HOE);
        entries.add(CoreAscensionItems.POTATO_HAMMER);
        entries.add(CoreAscensionItems.POTATO_EXCAVATOR);
        entries.add(CoreAscensionItems.SAPPHIRE_SWORD);
        entries.add(CoreAscensionItems.SAPPHIRE_PICKAXE);
        entries.add(CoreAscensionItems.SAPPHIRE_AXE);
        entries.add(CoreAscensionItems.SAPPHIRE_SHOVEL);
        entries.add(CoreAscensionItems.SAPPHIRE_HOE);
        entries.add(CoreAscensionItems.SAPPHIRE_HAMMER);
        entries.add(CoreAscensionItems.SAPPHIRE_EXCAVATOR);
        entries.add(CoreAscensionItems.TADANITE_SWORD);
        entries.add(CoreAscensionItems.TADANITE_PICKAXE);
        entries.add(CoreAscensionItems.TADANITE_AXE);
        entries.add(CoreAscensionItems.TADANITE_SHOVEL);
        entries.add(CoreAscensionItems.TADANITE_HOE);
        entries.add(CoreAscensionItems.TADANITE_HAMMER);
        entries.add(CoreAscensionItems.TADANITE_EXCAVATOR);
        entries.add(CoreAscensionItems.LUMITE_HAMMER);
        entries.add(CoreAscensionItems.LUMITE_EXCAVATOR);
        entries.add(CoreAscensionItems.URANIUM_SWORD);
        entries.add(CoreAscensionItems.URANIUM_PICKAXE);
        entries.add(CoreAscensionItems.URANIUM_AXE);
        entries.add(CoreAscensionItems.URANIUM_SHOVEL);
        entries.add(CoreAscensionItems.URANIUM_HOE);
        // -- END TOOLS --

        entries.add(CoreAscensionItems.PRISMAERO_SHARD);
        entries.add(CoreAscensionItems.PRISMAERO_CRYSTALS);
        entries.add(CoreAscensionItems.AERO_FUEL);

        // -- FOOD --
        entries.add(CoreAscensionItems.CALAMARI);
        entries.add(CoreAscensionItems.COOKED_CALAMARI);
        entries.add(CoreAscensionItems.COCONUT_FOOD);
        entries.add(CoreAscensionItems.MEGA_BERRY);
        entries.add(CoreAscensionItems.NETHER_MUSHROOM_STEW);
        // -- END FOOD --
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