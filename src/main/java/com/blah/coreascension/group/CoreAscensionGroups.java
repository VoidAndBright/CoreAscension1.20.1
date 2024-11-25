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

public class CoreAscensionGroups
{
    public static void RegisterGroups()
    {
        registerItemGroup("block_item", CoreAscensionBlocks.BLAZE_BRICK.asItem(), (displayContext, entries) ->
        {
            entries.add(CoreAscensionBlocks.DARK_MATTER_STONE);
            entries.add(CoreAscensionBlocks.MOSSY_DARK_MATTER_STONE);
            entries.add(CoreAscensionBlocks.HARDENED_LAVA);
            entries.add(CoreAscensionBlocks.DREAD_ROCK);
            entries.add(CoreAscensionBlocks.NETHERFROST);
            entries.add(CoreAscensionBlocks.ANDESITE_TILE);
            entries.add(CoreAscensionBlocks.DIORITE_TILE);
            entries.add(CoreAscensionBlocks.GRANITE_TILE);
            entries.add(CoreAscensionBlocks.SALTROCK);
            entries.add(CoreAscensionBlocks.POLISHED_SALTROCK);
            entries.add(CoreAscensionBlocks.SALTROCK_TILES);
            entries.add(CoreAscensionBlocks.MAGNETITE);
            entries.add(CoreAscensionBlocks.POLISHED_MAGNETITE);
            entries.add(CoreAscensionBlocks.MAGNETITE_TILES);
            entries.add(CoreAscensionBlocks.IGNEOUS_ROCK);
            entries.add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK);
            entries.add(CoreAscensionBlocks.IGNEOUS_ROCK_TILES);
            entries.add(CoreAscensionBlocks.SMOOTH_NETHERRACK);
            entries.add(CoreAscensionBlocks.POLISHED_NETHERRACK);
            entries.add(CoreAscensionBlocks.CLOUD_STONE);
            entries.add(CoreAscensionBlocks.CLOUD_COBBLESTONE);
            entries.add(CoreAscensionBlocks.BLACK_SAND);
            entries.add(CoreAscensionBlocks.BLACK_SANDSTONE);
            entries.add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE);
            entries.add(CoreAscensionBlocks.CHISELED_BLACK_SANDSTONE);
            entries.add(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE);
            entries.add(CoreAscensionBlocks.DREAD_SAND);
            entries.add(CoreAscensionBlocks.DREAD_SANDSTONE);
            entries.add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE);
            entries.add(CoreAscensionBlocks.CHISELED_DREAD_SANDSTONE);
            entries.add(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE);
            entries.add(CoreAscensionBlocks.FROST_SAND);
            entries.add(CoreAscensionBlocks.FROST_SANDSTONE);
            entries.add(CoreAscensionBlocks.CUT_FROST_SANDSTONE);
            entries.add(CoreAscensionBlocks.CHISELED_FROST_SANDSTONE);
            entries.add(CoreAscensionBlocks.SMOOTH_FROST_SANDSTONE);
            entries.add(CoreAscensionBlocks.BONESAND);
            entries.add(CoreAscensionBlocks.BONESANDSTONE);
            entries.add(CoreAscensionBlocks.CUT_BONESANDSTONE);
            entries.add(CoreAscensionBlocks.CHISELED_BONESANDSTONE);
            entries.add(CoreAscensionBlocks.SMOOTH_BONESANDSTONE);
            entries.add(CoreAscensionBlocks.LIMESTONE);
            entries.add(CoreAscensionBlocks.POLISHED_LIMESTONE);
            entries.add(CoreAscensionBlocks.LIMESTONE_TILES);
            entries.add(CoreAscensionBlocks.RUBY_ORE);
            entries.add(CoreAscensionBlocks.CITRINE_ORE);
            entries.add(CoreAscensionBlocks.TOPAZ_ORE);
            entries.add(CoreAscensionBlocks.SULPHUR_ORE);
            entries.add(CoreAscensionBlocks.CLOUD_COAL_ORE);
            entries.add(CoreAscensionBlocks.CLOUD_IRON_ORE);
            entries.add(CoreAscensionBlocks.CLOUD_GOLD_ORE);
            entries.add(CoreAscensionBlocks.SAPPHIRE_ORE);
            entries.add(CoreAscensionBlocks.CLOUD_EMERALD_ORE);
            entries.add(CoreAscensionBlocks.CLOUD_DIAMOND_ORE);
            entries.add(CoreAscensionBlocks.DARK_MATTER_JELLY_ORE);
            entries.add(CoreAscensionBlocks.ZIRCON_ORE);
            entries.add(CoreAscensionBlocks.CORE_SULPHUR_ORE);
            entries.add(CoreAscensionBlocks.TADANITE_ORE);
            entries.add(CoreAscensionBlocks.LUMITE_ORE);
            entries.add(CoreAscensionBlocks.DREAD_LOG);
            entries.add(CoreAscensionBlocks.DREAD_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_DREAD_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_DREAD_WOOD);
            entries.add(CoreAscensionBlocks.DREAD_PLANKS);
            entries.add(CoreAscensionBlocks.DREAD_STAIRS);
            entries.add(CoreAscensionBlocks.DREAD_SLAB);
            entries.add(CoreAscensionBlocks.DREAD_FENCE);
            entries.add(CoreAscensionBlocks.DREAD_FENCE_GATE);
            entries.add(CoreAscensionBlocks.DREAD_DOOR);
            entries.add(CoreAscensionBlocks.DREAD_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.DREAD_BUTTON);
            entries.add(CoreAscensionBlocks.TROPICS_LOG);
            entries.add(CoreAscensionBlocks.TROPICS_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_TROPICS_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD);
            entries.add(CoreAscensionBlocks.TROPICS_PLANKS);
            entries.add(CoreAscensionBlocks.TROPICS_STAIRS);
            entries.add(CoreAscensionBlocks.TROPICS_SLAB);
            entries.add(CoreAscensionBlocks.TROPICS_FENCE);
            entries.add(CoreAscensionBlocks.TROPICS_FENCE_GATE);
            entries.add(CoreAscensionBlocks.TROPICS_DOOR);
            entries.add(CoreAscensionBlocks.TROPICS_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.TROPICS_BUTTON);
            entries.add(CoreAscensionBlocks.WHITEWOOD_LOG);
            entries.add(CoreAscensionBlocks.WHITEWOOD_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_WOOD);
            entries.add(CoreAscensionBlocks.WHITEWOOD_PLANKS);
            entries.add(CoreAscensionBlocks.WHITEWOOD_STAIRS);
            entries.add(CoreAscensionBlocks.WHITEWOOD_SLAB);
            entries.add(CoreAscensionBlocks.WHITEWOOD_FENCE);
            entries.add(CoreAscensionBlocks.WHITEWOOD_FENCE_GATE);
            entries.add(CoreAscensionBlocks.WHITEWOOD_DOOR);
            entries.add(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.WHITEWOOD_BUTTON);
            entries.add(CoreAscensionBlocks.CEDAR_LOG);
            entries.add(CoreAscensionBlocks.CEDAR_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_CEDAR_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD);
            entries.add(CoreAscensionBlocks.CEDAR_PLANKS);
            entries.add(CoreAscensionBlocks.CEDAR_STAIRS);
            entries.add(CoreAscensionBlocks.CEDAR_SLAB);
            entries.add(CoreAscensionBlocks.CEDAR_FENCE);
            entries.add(CoreAscensionBlocks.CEDAR_FENCE_GATE);
            entries.add(CoreAscensionBlocks.CEDAR_DOOR);
            entries.add(CoreAscensionBlocks.CEDAR_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.CEDAR_BUTTON);
            entries.add(CoreAscensionBlocks.FROST_STEM);
            entries.add(CoreAscensionBlocks.FROST_HYPHAE);
            entries.add(CoreAscensionBlocks.STRIPPED_FROST_STEM);
            entries.add(CoreAscensionBlocks.STRIPPED_FROST_HYPHAE);
            entries.add(CoreAscensionBlocks.FROST_PLANKS);
            entries.add(CoreAscensionBlocks.FROST_STAIRS);
            entries.add(CoreAscensionBlocks.FROST_SLAB);
            entries.add(CoreAscensionBlocks.FROST_FENCE);
            entries.add(CoreAscensionBlocks.FROST_FENCE_GATE);
            entries.add(CoreAscensionBlocks.FROST_DOOR);
            entries.add(CoreAscensionBlocks.FROST_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.FROST_BUTTON);
            entries.add(CoreAscensionBlocks.DARK_MATTER_LOG);
            entries.add(CoreAscensionBlocks.DARK_MATTER_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_WOOD);
            entries.add(CoreAscensionBlocks.DARK_MATTER_PLANKS);
            entries.add(CoreAscensionBlocks.DARK_MATTER_STAIRS);
            entries.add(CoreAscensionBlocks.DARK_MATTER_SLAB);
            entries.add(CoreAscensionBlocks.DARK_MATTER_FENCE);
            entries.add(CoreAscensionBlocks.DARK_MATTER_FENCE_GATE);
            entries.add(CoreAscensionBlocks.DARK_MATTER_DOOR);
            entries.add(CoreAscensionBlocks.DARK_MATTER_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.DARK_MATTER_BUTTON);
            entries.add(CoreAscensionBlocks.CAKEWOOD_LOG);
            entries.add(CoreAscensionBlocks.CAKEWOOD_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_WOOD);
            entries.add(CoreAscensionBlocks.CAKEWOOD_PLANKS);
            entries.add(CoreAscensionBlocks.CAKEWOOD_STAIRS);
            entries.add(CoreAscensionBlocks.CAKEWOOD_SLAB);
            entries.add(CoreAscensionBlocks.CAKEWOOD_FENCE);
            entries.add(CoreAscensionBlocks.CAKEWOOD_FENCE_GATE);
            entries.add(CoreAscensionBlocks.CAKEWOOD_DOOR);
            entries.add(CoreAscensionBlocks.CAKEWOOD_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.CAKEWOOD_BUTTON);
            entries.add(CoreAscensionBlocks.ETHEREAL_LOG);
            entries.add(CoreAscensionBlocks.ETHEREAL_WOOD);
            entries.add(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG);
            entries.add(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD);
            entries.add(CoreAscensionBlocks.ETHEREAL_PLANKS);
            entries.add(CoreAscensionBlocks.ETHEREAL_STAIRS);
            entries.add(CoreAscensionBlocks.ETHEREAL_SLAB);
            entries.add(CoreAscensionBlocks.ETHEREAL_FENCE);
            entries.add(CoreAscensionBlocks.ETHEREAL_FENCE_GATE);
            entries.add(CoreAscensionBlocks.ETHEREAL_DOOR);
            entries.add(CoreAscensionBlocks.ETHEREAL_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.ETHEREAL_BUTTON);
            entries.add(CoreAscensionBlocks.ENTROPY_STEM);
            entries.add(CoreAscensionBlocks.ENTROPY_HYPHAE);
            entries.add(CoreAscensionBlocks.STRIPPED_ENTROPY_STEM);
            entries.add(CoreAscensionBlocks.STRIPPED_ENTROPY_HYPHAE);
            entries.add(CoreAscensionBlocks.ENTROPY_PLANKS);
            entries.add(CoreAscensionBlocks.ENTROPY_STAIRS);
            entries.add(CoreAscensionBlocks.ENTROPY_SLAB);
            entries.add(CoreAscensionBlocks.ENTROPY_FENCE);
            entries.add(CoreAscensionBlocks.ENTROPY_FENCE_GATE);
            entries.add(CoreAscensionBlocks.ENTROPY_DOOR);
            entries.add(CoreAscensionBlocks.ENTROPY_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.ENTROPY_BUTTON);
            entries.add(CoreAscensionBlocks.CACTUS_PLANKS);
            entries.add(CoreAscensionBlocks.CACTUS_STAIRS);
            entries.add(CoreAscensionBlocks.CACTUS_SLAB);
            entries.add(CoreAscensionBlocks.CACTUS_FENCE);
            entries.add(CoreAscensionBlocks.CACTUS_FENCE_GATE);
            entries.add(CoreAscensionBlocks.CACTUS_DOOR);
            entries.add(CoreAscensionBlocks.CACTUS_TRAPDOOR);
            // pressure plate
            entries.add(CoreAscensionBlocks.CACTUS_BUTTON);
            entries.add(CoreAscensionBlocks.GLASS_DOOR);
            entries.add(CoreAscensionBlocks.COBBLESTONE_DOOR);
            entries.add(CoreAscensionBlocks.GOLD_DOOR);
            entries.add(CoreAscensionBlocks.DIAMOND_DOOR);
            entries.add(CoreAscensionBlocks.LUMITE_DOOR);
            entries.add(CoreAscensionBlocks.GLASS_TRAPDOOR);
            entries.add(CoreAscensionBlocks.COBBLESTONE_TRAPDOOR);
            entries.add(CoreAscensionBlocks.GOLD_TRAPDOOR);
            entries.add(CoreAscensionBlocks.DIAMOND_TRAPDOOR);
            entries.add(CoreAscensionBlocks.LUMITE_TRAPDOOR);
            entries.add(CoreAscensionBlocks.CARROT_BLOCK);
            entries.add(CoreAscensionBlocks.MASHED_POTATO_BLOCK);
            entries.add(CoreAscensionBlocks.TADANITE_BLOCK);
            entries.add(CoreAscensionBlocks.SULPHUR_BLOCK);
            entries.add(CoreAscensionBlocks.FLINT_BLOCK);
            entries.add(CoreAscensionBlocks.LUMITE_BLOCK);
            entries.add(CoreAscensionBlocks.ZIRCON_BLOCK);
            entries.add(CoreAscensionBlocks.BLAZE_BRICK);
            entries.add(CoreAscensionBlocks.COMPRESSED_OBSIDIAN);
            entries.add(CoreAscensionBlocks.RUBY_BLOCK);
            entries.add(CoreAscensionBlocks.CITRINE_BLOCK);
            entries.add(CoreAscensionBlocks.TOPAZ_BLOCK);
            entries.add(CoreAscensionBlocks.SAPPHIRE_BLOCK);
            entries.add(CoreAscensionBlocks.AMETHYST_TILES);
            entries.add(CoreAscensionBlocks.LEATHER_BLOCK);
            entries.add(CoreAscensionBlocks.OBSIDIAN_BRICKS);
            entries.add(CoreAscensionBlocks.TROPICS_MUD);
            entries.add(CoreAscensionBlocks.DREAD_ROCK_BRICKS);
            entries.add(CoreAscensionBlocks.MAGMA_ROCK_BRICKS);
            entries.add(CoreAscensionBlocks.CLOUD_STONE_BRICKS);
            entries.add(CoreAscensionBlocks.NETHER_ICE_BRICKS);
            entries.add(CoreAscensionBlocks.IMPERVIOUS_BRICK);
            entries.add(CoreAscensionBlocks.TROPICS_MUD_BRICKS);
            entries.add(CoreAscensionBlocks.NETHER_ICE);
            entries.add(CoreAscensionBlocks.REINFORCED_GLASS);
            entries.add(CoreAscensionBlocks.BORDERLESS_GLASS);
            entries.add(CoreAscensionBlocks.FROSTED_GLASS);
            entries.add(CoreAscensionBlocks.PETRIFIED_WOOD);
            entries.add(CoreAscensionBlocks.PETRIFIED_PLANKS);
            entries.add(CoreAscensionBlocks.CEMENT);
            entries.add(CoreAscensionBlocks.NETHERFROST_BRICKS);
            entries.add(CoreAscensionBlocks.SOUL_SNOW);
            entries.add(CoreAscensionBlocks.SEASHELL);
            entries.add(CoreAscensionBlocks.CONCH_SHELL);
            entries.add(CoreAscensionBlocks.COCONUT);
            entries.add(CoreAscensionBlocks.MOSSY_END_STONE_BRICKS);
            entries.add(CoreAscensionBlocks.REINFORCED_CHEST);

            entries.add(CoreAscensionBlocks.BLACK_SANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.DREAD_SANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.FROST_SANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.BONESANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.BLACK_SANDSTONE_WALL);
            entries.add(CoreAscensionBlocks.DREAD_SANDSTONE_WALL);
            entries.add(CoreAscensionBlocks.FROST_SANDSTONE_WALL);
            entries.add(CoreAscensionBlocks.BONESANDSTONE_WALL);

            entries.add(CoreAscensionBlocks.BLACK_SANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.DREAD_SANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.FROST_SANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.BONESANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.CUT_FROST_SANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.CUT_BONESANDSTONE_SLAB);
            entries.add(CoreAscensionBlocks.MAGMA_ROCK_BRICK_SLAB);
            entries.add(CoreAscensionBlocks.NETHERFROST_BRICK_SLAB);
            entries.add(CoreAscensionBlocks.TROPICS_MUD_BRICK_SLAB);
            entries.add(CoreAscensionBlocks.SUS_BRAIN_CORAL_BLOCK);
            entries.add(CoreAscensionBlocks.SUS_BUBBLE_CORAL_BLOCK);
            entries.add(CoreAscensionBlocks.SUS_FIRE_CORAL_BLOCK);
            entries.add(CoreAscensionBlocks.SUS_HORN_CORAL_BLOCK);
            entries.add(CoreAscensionBlocks.SUS_TUBE_CORAL_BLOCK);
            entries.add(CoreAscensionBlocks.COMPACT_STONE);
            entries.add(CoreAscensionBlocks.OSBORGNEN_FUEL_BLOCK);
            //SECRET DOORS
            entries.add(CoreAscensionBlocks.PETRIFIED_PLANKS_STAIRS);
            entries.add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.CUT_FROST_SANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.CUT_BONESANDSTONE_STAIRS);
            entries.add(CoreAscensionBlocks.MAGMA_ROCK_BRICK_STAIRS);
            entries.add(CoreAscensionBlocks.NETHERFROST_BRICK_STAIRS);
            entries.add(CoreAscensionBlocks.CEMENT_STAIRS);
            entries.add(CoreAscensionBlocks.TROPICS_MUD_BRICK_STAIRS);
            entries.add(CoreAscensionBlocks.REINFORCED_GLASS_PANE);
            entries.add(CoreAscensionBlocks.BORDERLESS_GLASS_PANE);
            entries.add(CoreAscensionBlocks.FROSTED_GLASS_PANE);
            entries.add(CoreAscensionBlocks.CORELIGHT);
            entries.add(CoreAscensionBlocks.PETRIFIED_WOOD_WALL);
            entries.add(CoreAscensionBlocks.PETRIFIED_PLANKS_WALL);
            entries.add(CoreAscensionBlocks.NETHERFROST_BRICK_WALL);
            entries.add(CoreAscensionBlocks.CEMENT_WALL);
            entries.add(CoreAscensionBlocks.MOSSY_END_STONE_BRICK_WALL);
            entries.add(CoreAscensionBlocks.PLAYER_LAUNCHER);
            entries.add(CoreAscensionBlocks.CATALYZER_TABLE);
            entries.add(CoreAscensionBlocks.ENCHANTMENT_RELOCATOR);
            // dark matter bushes
            entries.add(CoreAscensionBlocks.RUBY_GEM_LOG);
            entries.add(CoreAscensionBlocks.CITRINE_GEM_LOG);
            entries.add(CoreAscensionBlocks.TOPAZ_GEM_LOG);
            entries.add(CoreAscensionBlocks.EMERALD_GEM_LOG);
            entries.add(CoreAscensionBlocks.DIAMOND_GEM_LOG);
            entries.add(CoreAscensionBlocks.SAPPHIRE_GEM_LOG);
            entries.add(CoreAscensionBlocks.AMETHYST_GEM_LOG);
            entries.add(CoreAscensionBlocks.RUBY_GEM_LEAVES);
            entries.add(CoreAscensionBlocks.CITRINE_GEM_LEAVES);
            entries.add(CoreAscensionBlocks.TOPAZ_GEM_LEAVES);
            entries.add(CoreAscensionBlocks.EMERALD_GEM_LEAVES);
            entries.add(CoreAscensionBlocks.DIAMOND_GEM_LEAVES);
            entries.add(CoreAscensionBlocks.SAPPHIRE_GEM_LEAVES);
            entries.add(CoreAscensionBlocks.AMETHYST_GEM_LEAVES);

            entries.add(CoreAscensionBlocks.CORE_VINES);
            entries.add(CoreAscensionBlocks.CORE_WART_BLOCK);
            entries.add(CoreAscensionBlocks.CORE_NYLIUM);
            entries.add(CoreAscensionBlocks.CORE_ROOTS);
            entries.add(CoreAscensionBlocks.ICE_CREAM_BLOCK);
            // scoria shit goes here
            entries.add(CoreAscensionBlocks.ENDER_PEARL_BRICKS);
            // glowing mushroom biome
            entries.add(CoreAscensionBlocks.URANIUM_ORE);


        });
        registerItemGroup("item", CoreAscensionItems.RUBY, (displayContext, entries) ->
        {

            entries.add(CoreAscensionItems.GILDED_OBSIDIAN_HELMET);
            entries.add(CoreAscensionItems.GILDED_OBSIDIAN_CHESTPLATE);
            entries.add(CoreAscensionItems.GILDED_OBSIDIAN_LEGGINGS);
            entries.add(CoreAscensionItems.GILDED_OBSIDIAN_BOOTS);
            entries.add(CoreAscensionItems.SAPPHIRE_PICKAXE);
            entries.add(CoreAscensionItems.SAPPHIRE_SWORD);
            entries.add(CoreAscensionItems.SAPPHIRE_AXE);
            entries.add(CoreAscensionItems.SAPPHIRE_SHOVEL);
            entries.add(CoreAscensionItems.SAPPHIRE_HOE);
            entries.add(CoreAscensionItems.SAPPHIRE_SCYTHE);
            entries.add(CoreAscensionItems.SAPPHIRE_HAMMER);
            entries.add(CoreAscensionItems.SAPPHIRE_EXCAVATOR);
            entries.add(CoreAscensionItems.SAPPHIRE_HELMET);
            entries.add(CoreAscensionItems.SAPPHIRE_CHESTPLATE);
            entries.add(CoreAscensionItems.SAPPHIRE_LEGGINGS);
            entries.add(CoreAscensionItems.SAPPHIRE_BOOTS);
            entries.add(CoreAscensionItems.TADANITE_PICKAXE);
            entries.add(CoreAscensionItems.TADANITE_SWORD);
            entries.add(CoreAscensionItems.TADANITE_AXE);
            entries.add(CoreAscensionItems.TADANITE_SHOVEL);
            entries.add(CoreAscensionItems.TADANITE_HOE);
            entries.add(CoreAscensionItems.TADANITE_SCYTHE);
            entries.add(CoreAscensionItems.TADANITE_HAMMER);
            entries.add(CoreAscensionItems.TADANITE_EXCAVATOR);
            entries.add(CoreAscensionItems.TADANITE_HELMET);
            entries.add(CoreAscensionItems.TADANITE_CHESTPLATE);
            entries.add(CoreAscensionItems.TADANITE_LEGGINGS);
            entries.add(CoreAscensionItems.TADANITE_BOOTS);
            entries.add(CoreAscensionItems.LUMITE_PICKAXE);
            entries.add(CoreAscensionItems.LUMITE_SWORD);
            entries.add(CoreAscensionItems.LUMITE_AXE);
            entries.add(CoreAscensionItems.LUMITE_SHOVEL);
            entries.add(CoreAscensionItems.LUMITE_HOE);
            entries.add(CoreAscensionItems.LUMITE_SCYTHE);
            entries.add(CoreAscensionItems.LUMITE_HAMMER);
            entries.add(CoreAscensionItems.LUMITE_EXCAVATOR);
            entries.add(CoreAscensionItems.LUMITE_HELMET);
            entries.add(CoreAscensionItems.LUMITE_CHESTPLATE);
            entries.add(CoreAscensionItems.LUMITE_LEGGINGS);
            entries.add(CoreAscensionItems.LUMITE_BOOTS);
            entries.add(CoreAscensionItems.URANIUM_PICKAXE);
            entries.add(CoreAscensionItems.URANIUM_SWORD);
            entries.add(CoreAscensionItems.URANIUM_AXE);
            entries.add(CoreAscensionItems.URANIUM_SHOVEL);
            entries.add(CoreAscensionItems.URANIUM_HOE);
            entries.add(CoreAscensionItems.URANIUM_HELMET);
            entries.add(CoreAscensionItems.URANIUM_CHESTPLATE);
            entries.add(CoreAscensionItems.URANIUM_LEGGINGS);
            entries.add(CoreAscensionItems.URANIUM_BOOTS);

            entries.add(CoreAscensionItems.THE_TOOL);
            entries.add(CoreAscensionItems.BEDROCK_PICKAXE);
            entries.add(CoreAscensionItems.CRIMSON_EDGE);
            entries.add(CoreAscensionItems.TITAN_BLADE);
            entries.add(CoreAscensionItems.VERTEX);
            entries.add(CoreAscensionItems.WOODEN_SCYTHE);
            entries.add(CoreAscensionItems.STONE_SCYTHE);
            entries.add(CoreAscensionItems.GOLDEN_SCYTHE);
            entries.add(CoreAscensionItems.IRON_SCYTHE);
            entries.add(CoreAscensionItems.DIAMOND_SCYTHE);
            entries.add(CoreAscensionItems.NETHERITE_SCYTHE);
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
            entries.add(CoreAscensionItems.RUBY_STAFF);
            entries.add(CoreAscensionItems.CITRINE_STAFF);
            entries.add(CoreAscensionItems.TOPAZ_STAFF);
            entries.add(CoreAscensionItems.EMERALD_STAFF);
            entries.add(CoreAscensionItems.DIAMOND_STAFF);
            entries.add(CoreAscensionItems.SAPPHIRE_STAFF);
            entries.add(CoreAscensionItems.AMETHYST_STAFF);
            entries.add(CoreAscensionItems.TADANITE_CRYSTAL);
            entries.add(CoreAscensionItems.TADANITE_DIAMOND);
            entries.add(CoreAscensionItems.LUMITE_INGOT);
            entries.add(CoreAscensionItems.SUNSTONE);
            entries.add(CoreAscensionItems.URANIUM_INGOT);
            entries.add(CoreAscensionItems.RUBY);
            entries.add(CoreAscensionItems.CITRINE);
            entries.add(CoreAscensionItems.TOPAZ);
            entries.add(CoreAscensionItems.SAPPHIRE);
            entries.add(CoreAscensionItems.AMETHYST);
            entries.add(CoreAscensionItems.ZIRCON);
            entries.add(CoreAscensionItems.SULPHUR);
            entries.add(CoreAscensionItems.RUBY_SHARD);
            entries.add(CoreAscensionItems.CITRINE_SHARD);
            entries.add(CoreAscensionItems.TOPAZ_SHARD);
            entries.add(CoreAscensionItems.EMERALD_SHARD);
            entries.add(CoreAscensionItems.DIAMOND_SHARD);
            entries.add(CoreAscensionItems.SAPPHIRE_SHARD);
            entries.add(CoreAscensionItems.OBSIDIAN_CONSTRUCT);
            entries.add(CoreAscensionItems.OBSIDIFIED_BLAZE_ROD);
            entries.add(CoreAscensionItems.AERO_FUEL);
            entries.add(CoreAscensionItems.OSBORGNEN_FUEL);
            entries.add(CoreAscensionItems.CATALYTIC_INVERTER);
            entries.add(CoreAscensionItems.IRON_ROD);
            entries.add(CoreAscensionItems.FROZEN_ROD);
            entries.add(CoreAscensionItems.NETHER_CORE_KEY);
            entries.add(CoreAscensionItems.SKYLANDS_WAYNODE);
            entries.add(CoreAscensionItems.MOLTEN_ICE_BUCKET);
            entries.add(CoreAscensionItems.ICE_CREAM);
            entries.add(CoreAscensionItems.DARK_MATTER_GEL);

            // more stuff inserted here

            entries.add(CoreAscensionItems.RAW_URANIUM);
            entries.add(CoreAscensionItems.RAW_LUMITE);
            entries.add(CoreAscensionItems.RAW_TITANIUM);
            entries.add(CoreAscensionItems.TITANIUM_INGOT);
            entries.add(CoreAscensionItems.CRYSTAL_HELMET);
            entries.add(CoreAscensionItems.CRYSTAL_CHESTPLATE);
            entries.add(CoreAscensionItems.CRYSTAL_LEGGINGS);
            entries.add(CoreAscensionItems.CRYSTAL_BOOTS);
            entries.add(CoreAscensionItems.CRYSTALLINE_ARTIFACT);
            entries.add(CoreAscensionItems.MAGIC_MIRROR);
            entries.add(CoreAscensionItems.TERRESTRIAL_CONSTRUCT);
            entries.add(CoreAscensionItems.PRISMAERO_SHARD);
            entries.add(CoreAscensionItems.PRISMAERO_CRYSTALS);
            entries.add(CoreAscensionItems.OBSIDIAN_FABRIC);
            entries.add(CoreAscensionItems.FOUR_LEAF_CLOVER);

            entries.add(CoreAscensionItems.POTATO_PICKAXE);
            entries.add(CoreAscensionItems.POTATO_SWORD);
            entries.add(CoreAscensionItems.POTATO_AXE);
            entries.add(CoreAscensionItems.POTATO_SHOVEL);
            entries.add(CoreAscensionItems.POTATO_HOE);
            entries.add(CoreAscensionItems.POTATO_SCYTHE);
            entries.add(CoreAscensionItems.POTATO_HAMMER);
            entries.add(CoreAscensionItems.POTATO_EXCAVATOR);

            entries.add(CoreAscensionItems.BLAHR);
            entries.add(CoreAscensionItems.BLAHS_ENERGY_BLADE);
            entries.add(CoreAscensionItems.COCONUT_FOOD);
            entries.add(CoreAscensionItems.MEGA_BERRY);
            entries.add(CoreAscensionItems.CALAMARI);
            entries.add(CoreAscensionItems.COOKED_CALAMARI);
            entries.add(CoreAscensionItems.NETHER_MUSHROOM_STEW);

            entries.add(CoreAscensionItems.VOID_TOTEM);

            entries.add(CoreAscensionItems.VOLCANO);
            entries.add(CoreAscensionItems.DAWN_ESSENCE);
            entries.add(CoreAscensionItems.DUSK_PICKAXE);
            entries.add(CoreAscensionItems.NIGHTS_EDGE);
            entries.add(CoreAscensionItems.TWILIGHT_AXE);

            entries.add(CoreAscensionItems.IRON_SHURIKEN);
            entries.add(CoreAscensionItems.GOLD_SHURIKEN);
            entries.add(CoreAscensionItems.DIAMOND_SHURIKEN);
            entries.add(CoreAscensionItems.URANIUM_SHURIKEN);
            entries.add(CoreAscensionItems.TADANITE_SHURIKEN);
            entries.add(CoreAscensionItems.LUMITE_SHURIKEN);
            entries.add(CoreAscensionItems.FROST_SHURIKEN);

            entries.add(CoreAscensionItems.ETHEREAL_TORCH);





            entries.add(CoreAscensionItems.SPAWN_EGG);
            entries.add(CoreAscensionItems.ENDER_WIRE);




            // -- END TOOLS --



            entries.add(CoreAscensionItems.END_GAS_BUCKET);
            entries.add(CoreAscensionItems.FROZEN_ARTIFACT);

            // -- FOOD --

            // -- END FOOD --

            // -- BOATS --
            entries.add(CoreAscensionItems.CACTUS_BOAT);
            entries.add(CoreAscensionItems.CAKEWOOD_BOAT);
            entries.add(CoreAscensionItems.CEDAR_BOAT);
            entries.add(CoreAscensionItems.DARK_MATTER_BOAT);
            entries.add(CoreAscensionItems.DREAD_BOAT);
            entries.add(CoreAscensionItems.ETHEREAL_BOAT);
            entries.add(CoreAscensionItems.TROPICS_BOAT);
            entries.add(CoreAscensionItems.WHITEWOOD_BOAT);
            entries.add(CoreAscensionItems.CACTUS_CHEST_BOAT);
            entries.add(CoreAscensionItems.CAKEWOOD_CHEST_BOAT);
            entries.add(CoreAscensionItems.CEDAR_CHEST_BOAT);
            entries.add(CoreAscensionItems.DARK_MATTER_CHEST_BOAT);
            entries.add(CoreAscensionItems.DREAD_CHEST_BOAT);
            entries.add(CoreAscensionItems.ETHEREAL_CHEST_BOAT);
            entries.add(CoreAscensionItems.TROPICS_CHEST_BOAT);
            entries.add(CoreAscensionItems.WHITEWOOD_CHEST_BOAT);
            // -- END BOATS --
        });
        CoreAscension.LOGGER.info("Registering Item Groups for " + CoreAscension.MOD_ID);
    }

    public static void registerItemGroup(String name, Item item, ItemGroup.EntryCollector entries)
    {
        Registry.register(Registries.ITEM_GROUP, new Identifier(CoreAscension.MOD_ID, name), FabricItemGroup.builder().
                displayName(Text.translatable("itemgroup." + name)).
                icon(() -> new ItemStack(item)).
                entries(entries).build());
    }
}