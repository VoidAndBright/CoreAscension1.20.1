package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class CoreAscensionLootTableProvider extends FabricBlockLootTableProvider {
    public CoreAscensionLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    @Override
    public void generate()
    {
        addDrop(CoreAscensionBlocks.AMETHYST_SLAB, slabDrops(CoreAscensionBlocks.TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.ACACIA_POST);
        addDrop(CoreAscensionBlocks.ACACIA_SECRET_DOOR);
        addDrop(CoreAscensionBlocks.AERO_LANTERN);
        addDrop(CoreAscensionBlocks.AMANITA_STEM);
        addDrop(CoreAscensionBlocks.AMANITA_CAP);
        addDrop(CoreAscensionBlocks.ANDESITE_TILE);
        addDrop(CoreAscensionBlocks.DIORITE_TILE);
        addDrop(CoreAscensionBlocks.GRANITE_TILE);
        addDropWithSilkTouch(CoreAscensionBlocks.AMETHYST_GEM_LEAVES);
        addDrop(CoreAscensionBlocks.BORDERLESS_GLASS);
        addDropWithSilkTouch(CoreAscensionBlocks.ETHEREAL_GRASS, CoreAscensionBlocks.ETHEREAL_DIRT);
        addDropWithSilkTouch(CoreAscensionBlocks.TROPICAL_GRASS, CoreAscensionBlocks.LOAM);
        addDrop(CoreAscensionBlocks.TITANIUM_ORE, oreDrops(CoreAscensionBlocks.TITANIUM_ORE, CoreAscensionItems.RAW_TITANIUM));
        addDrop(CoreAscensionBlocks.TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.SEARED_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.SEARED_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.SEARED_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.SEARED_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.SINGED_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.SINGED_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.SINGED_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.SINGED_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.BURNT_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.BURNT_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.BURNT_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.BURNT_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.FROZEN_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.FROZEN_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.FROZEN_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.FROZEN_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_STAIRS);
        addDrop(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_SLAB, slabDrops(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_SLAB));
        addDrop(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_BLOCK);
        //addDrop(CoreAscensionBlocks.ETHEREAL_TORCH);
        addDrop(CoreAscensionBlocks.BLAZE_BRICK);
        addDrop(CoreAscensionBlocks.REINFORCED_CHEST);
        addDrop(CoreAscensionBlocks.REINFORCED_GLASS);
        addDrop(CoreAscensionBlocks.URANIUM_BLOCK);
        addDrop(CoreAscensionBlocks.URANIUM_ORE, oreDrops(CoreAscensionBlocks.URANIUM_ORE, CoreAscensionItems.RAW_URANIUM));
        addDrop(CoreAscensionBlocks.CEDAR_LOG);
        addDrop(CoreAscensionBlocks.CEDAR_WOOD);
        addDrop(CoreAscensionBlocks.CEDAR_PLANKS);
        addDrop(CoreAscensionBlocks.CEDAR_SLAB, slabDrops(CoreAscensionBlocks.CEDAR_SLAB));
        addDrop(CoreAscensionBlocks.CEDAR_STAIRS);
        addDrop(CoreAscensionBlocks.CEDAR_FENCE);
        addDrop(CoreAscensionBlocks.CEDAR_FENCE_GATE);
        addDrop(CoreAscensionBlocks.CEDAR_BUTTON);
        addDrop(CoreAscensionBlocks.STRIPPED_CEDAR_LOG);
        addDrop(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD);
        addDrop(CoreAscensionBlocks.CEDAR_DOOR, doorDrops(CoreAscensionBlocks.CEDAR_DOOR));
        addDrop(CoreAscensionBlocks.CEDAR_TRAPDOOR);
        //addDrop(CoreAscensionBlocks.CEDAR_LEAVES, leavesDrops(CoreAscensionBlocks.CEDAR_LEAVES, CoreAscensionBlocks.CEDAR_SAPLING, 0.0025f));
        addDrop(CoreAscensionBlocks.TROPICS_LOG);
        addDrop(CoreAscensionBlocks.TROPICS_WOOD);
        addDrop(CoreAscensionBlocks.TROPICS_PLANKS);
        addDrop(CoreAscensionBlocks.TROPICS_SLAB, slabDrops(CoreAscensionBlocks.TROPICS_SLAB));
        addDrop(CoreAscensionBlocks.TROPICS_STAIRS);
        addDrop(CoreAscensionBlocks.TROPICS_FENCE);
        addDrop(CoreAscensionBlocks.TROPICS_FENCE_GATE);
        addDrop(CoreAscensionBlocks.TROPICS_BUTTON);
        addDrop(CoreAscensionBlocks.STRIPPED_TROPICS_LOG);
        addDrop(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD);
        addDrop(CoreAscensionBlocks.TROPICS_DOOR, doorDrops(CoreAscensionBlocks.TROPICS_DOOR));
        addDrop(CoreAscensionBlocks.TROPICS_TRAPDOOR);
        //addDrop(CoreAscensionBlocks.TROPICS_LEAVES, leavesDrops(CoreAscensionBlocks.TROPICS_LEAVES, CoreAscensionBlocks.TROPICS_SAPLING, 0.0025f));
        addDrop(CoreAscensionBlocks.DREAD_LOG);
        addDrop(CoreAscensionBlocks.DREAD_WOOD);
        addDrop(CoreAscensionBlocks.DREAD_PLANKS);
        addDrop(CoreAscensionBlocks.DREAD_SLAB, slabDrops(CoreAscensionBlocks.DREAD_SLAB));
        addDrop(CoreAscensionBlocks.DREAD_STAIRS);
        addDrop(CoreAscensionBlocks.DREAD_FENCE);
        addDrop(CoreAscensionBlocks.DREAD_FENCE_GATE);
        addDrop(CoreAscensionBlocks.DREAD_BUTTON);
        addDrop(CoreAscensionBlocks.STRIPPED_DREAD_LOG);
        addDrop(CoreAscensionBlocks.STRIPPED_DREAD_WOOD);
        addDrop(CoreAscensionBlocks.DREAD_DOOR, doorDrops(CoreAscensionBlocks.DREAD_DOOR));
        addDrop(CoreAscensionBlocks.DREAD_TRAPDOOR);

        addDrop(CoreAscensionBlocks.BLACK_SAND);
        addDrop(CoreAscensionBlocks.BLACK_SANDSTONE);
        addDrop(CoreAscensionBlocks.CHISELED_BLACK_SANDSTONE);
        addDrop(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE);
        addDrop(CoreAscensionBlocks.CUT_BLACK_SANDSTONE);
        addDrop(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_STAIRS);
        addDrop(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_SLAB, slabDrops(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_SLAB));
        addDrop(CoreAscensionBlocks.LOAM);
        addDrop(CoreAscensionBlocks.TROPICS_MUD);
        addDrop(CoreAscensionBlocks.TROPICS_MUD_BRICKS);
        addDrop(CoreAscensionBlocks.TROPICS_MUD_BRICK_STAIRS);
        addDrop(CoreAscensionBlocks.TROPICS_MUD_BRICK_SLAB, slabDrops(CoreAscensionBlocks.TROPICS_MUD_BRICK_SLAB));
        addDrop(CoreAscensionBlocks.DREAD_ROCK);
        addDrop(CoreAscensionBlocks.DREAD_SANDSTONE);
        addDrop(CoreAscensionBlocks.CHISELED_DREAD_SANDSTONE);
        addDrop(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE);
        addDrop(CoreAscensionBlocks.CUT_DREAD_SANDSTONE);
        addDrop(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_SLAB, slabDrops(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_SLAB));
        addDrop(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_STAIRS);
        addDrop(CoreAscensionBlocks.DREAD_ROCK_BRICKS);
        addDrop(CoreAscensionBlocks.HARDENED_LAVA);
        addDrop(CoreAscensionBlocks.CEMENT);
        addDrop(CoreAscensionBlocks.IMPERVIOUS_BRICK);
        addDrop(CoreAscensionBlocks.COCONUT);
        addDrop(CoreAscensionBlocks.PRISMAERO_FURNACE);
        addDrop(CoreAscensionBlocks.CATALYZER_TABLE);
        addDrop(CoreAscensionBlocks.IGNEOUS_ROCK_WALL);
        addDrop(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_WALL);
        addDrop(CoreAscensionBlocks.SALTROCK_WALL);
        addDrop(CoreAscensionBlocks.POLISHED_SALTROCK_WALL);
        addDrop(CoreAscensionBlocks.MAGNETITE_WALL);
        addDrop(CoreAscensionBlocks.POLISHED_MAGNETITE_WALL);
        addDrop(CoreAscensionBlocks.LIMESTONE_WALL);
        addDrop(CoreAscensionBlocks.POLISHED_LIMESTONE_WALL);
        addDrop(CoreAscensionBlocks.IGNEOUS_ROCK);
        addDrop(CoreAscensionBlocks.IGNEOUS_ROCK_STAIRS);
        addDrop(CoreAscensionBlocks.IGNEOUS_ROCK_SLAB, slabDrops(CoreAscensionBlocks.IGNEOUS_ROCK_SLAB));
        addDrop(CoreAscensionBlocks.IGNEOUS_ROCK_TILES);
        addDrop(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK);
        addDrop(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_STAIRS);
        addDrop(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_SLAB, slabDrops(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_SLAB));
        addDrop(CoreAscensionBlocks.SALTROCK);
        addDrop(CoreAscensionBlocks.SALTROCK_STAIRS);
        addDrop(CoreAscensionBlocks.SALTROCK_SLAB, slabDrops(CoreAscensionBlocks.SALTROCK_SLAB));
        addDrop(CoreAscensionBlocks.SALTROCK_TILES);
        addDrop(CoreAscensionBlocks.POLISHED_SALTROCK);
        addDrop(CoreAscensionBlocks.POLISHED_SALTROCK_STAIRS);
        addDrop(CoreAscensionBlocks.POLISHED_SALTROCK_SLAB, slabDrops(CoreAscensionBlocks.POLISHED_SALTROCK_SLAB));
        addDrop(CoreAscensionBlocks.MAGNETITE);
        addDrop(CoreAscensionBlocks.MAGNETITE_STAIRS);
        addDrop(CoreAscensionBlocks.MAGNETITE_SLAB, slabDrops(CoreAscensionBlocks.MAGNETITE_SLAB));
        addDrop(CoreAscensionBlocks.MAGNETITE_TILES);
        addDrop(CoreAscensionBlocks.POLISHED_MAGNETITE);
        addDrop(CoreAscensionBlocks.POLISHED_MAGNETITE_STAIRS);
        addDrop(CoreAscensionBlocks.POLISHED_MAGNETITE_SLAB, slabDrops(CoreAscensionBlocks.POLISHED_MAGNETITE_SLAB));
        addDrop(CoreAscensionBlocks.LIMESTONE);
        addDrop(CoreAscensionBlocks.LIMESTONE_STAIRS);
        addDrop(CoreAscensionBlocks.LIMESTONE_SLAB, slabDrops(CoreAscensionBlocks.LIMESTONE_SLAB));
        addDrop(CoreAscensionBlocks.LIMESTONE_TILES);
        addDrop(CoreAscensionBlocks.POLISHED_LIMESTONE);
        addDrop(CoreAscensionBlocks.POLISHED_LIMESTONE_STAIRS);
        addDrop(CoreAscensionBlocks.POLISHED_LIMESTONE_SLAB, slabDrops(CoreAscensionBlocks.POLISHED_LIMESTONE_SLAB));
        addDrop(CoreAscensionBlocks.BONESAND);
        addDrop(CoreAscensionBlocks.BONESANDSTONE);
        addDrop(CoreAscensionBlocks.CHISELED_BONESANDSTONE);
        addDrop(CoreAscensionBlocks.SMOOTH_BONESANDSTONE);
        addDrop(CoreAscensionBlocks.CUT_BONESANDSTONE);
        addDrop(CoreAscensionBlocks.CUT_BONESANDSTONE_STAIRS);
        addDrop(CoreAscensionBlocks.CUT_BONESANDSTONE_SLAB, slabDrops(CoreAscensionBlocks.CUT_BONESANDSTONE_SLAB));
        addDrop(CoreAscensionBlocks.ETHEREAL_LOG);
        addDrop(CoreAscensionBlocks.ETHEREAL_WOOD);
        addDrop(CoreAscensionBlocks.ETHEREAL_PLANKS);
        addDrop(CoreAscensionBlocks.ETHEREAL_SLAB, slabDrops(CoreAscensionBlocks.ETHEREAL_SLAB));
        addDrop(CoreAscensionBlocks.ETHEREAL_STAIRS);
        addDrop(CoreAscensionBlocks.ETHEREAL_FENCE);
        addDrop(CoreAscensionBlocks.ETHEREAL_FENCE_GATE);
        addDrop(CoreAscensionBlocks.ETHEREAL_BUTTON);
        addDrop(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG);
        addDrop(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD);
        addDrop(CoreAscensionBlocks.ETHEREAL_DOOR, doorDrops(CoreAscensionBlocks.ETHEREAL_DOOR));
        addDrop(CoreAscensionBlocks.ETHEREAL_TRAPDOOR);
        addDrop(CoreAscensionBlocks.ETHEREAL_MEMBRANE);
        //addDrop(CoreAscensionBlocks.ETHEREAL_LEAVES, leavesDrops(CoreAscensionBlocks.ETHEREAL_LEAVES, CoreAscensionBlocks.ETHEREAL_SAPLING, 0.0025f));
        addDrop(CoreAscensionBlocks.WHITEWOOD_LOG);
        addDrop(CoreAscensionBlocks.WHITEWOOD_WOOD);
        addDrop(CoreAscensionBlocks.WHITEWOOD_PLANKS);
        addDrop(CoreAscensionBlocks.WHITEWOOD_SLAB, slabDrops(CoreAscensionBlocks.WHITEWOOD_SLAB));
        addDrop(CoreAscensionBlocks.WHITEWOOD_STAIRS);
        addDrop(CoreAscensionBlocks.WHITEWOOD_FENCE);
        addDrop(CoreAscensionBlocks.WHITEWOOD_FENCE_GATE);
        addDrop(CoreAscensionBlocks.WHITEWOOD_BUTTON);
        addDrop(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG);
        addDrop(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD);
        addDrop(CoreAscensionBlocks.WHITEWOOD_DOOR, doorDrops(CoreAscensionBlocks.WHITEWOOD_DOOR));
        addDrop(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR);
        //addDrop(CoreAscensionBlocks.WHITEWOOD_LEAVES, leavesDrops(CoreAscensionBlocks.WHITEWOOD_LEAVES, CoreAscensionBlocks.WHITEWOOD_SAPLING, 0.0025f));
        addDrop(CoreAscensionBlocks.SEASHELL);
        addDrop(CoreAscensionBlocks.CONCH_SHELL);
    }
}
