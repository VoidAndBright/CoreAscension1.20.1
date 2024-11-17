package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.utils.CoreAscensionTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class CoreAscensionBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public CoreAscensionBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_8")))
                .add(CoreAscensionBlocks.BEDROCK);

        getOrCreateTagBuilder(CoreAscensionTags.SCYTHE_MINEABLE)
                .add(Blocks.ACACIA_LEAVES)
                .add(Blocks.AZALEA_LEAVES)
                .add(Blocks.BIRCH_LEAVES)
                .add(Blocks.CHERRY_LEAVES)
                .add(Blocks.JUNGLE_LEAVES)
                .add(Blocks.DARK_OAK_LEAVES)
                .add(Blocks.FLOWERING_AZALEA_LEAVES)
                .add(Blocks.MANGROVE_LEAVES)
                .add(Blocks.DARK_OAK_LEAVES)
                .add(Blocks.SPRUCE_LEAVES)
                .add(Blocks.FERN)
                .add(Blocks.LARGE_FERN)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.TALL_SEAGRASS)
                .add(Blocks.SEAGRASS)
                .add(Blocks.CORNFLOWER)
                .add(Blocks.SUNFLOWER)
                .add(Blocks.ROSE_BUSH)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.POPPY)
                .add(Blocks.OXEYE_DAISY)
                .add(Blocks.DANDELION)
                .add(Blocks.ALLIUM)
                .add(Blocks.AZURE_BLUET)
                .add(Blocks.ORANGE_TULIP)
                .add(Blocks.PINK_TULIP)
                .add(Blocks.RED_TULIP)
                .add(Blocks.WHITE_TULIP)
                .add(Blocks.BLUE_ORCHID)
                .add(Blocks.LILY_OF_THE_VALLEY)
                .add(Blocks.LILY_PAD)
                .add(Blocks.LILAC)
                .add(Blocks.PEONY)
                .add(Blocks.DEAD_BUSH)
                .add(CoreAscensionBlocks.AMETHYST_GEM_LEAVES)
                .add(CoreAscensionBlocks.CEDAR_LEAVES)
                .add(CoreAscensionBlocks.ETHEREAL_LEAVES)
                .add(CoreAscensionBlocks.TROPICS_LEAVES)
                .add(CoreAscensionBlocks.WHITEWOOD_LEAVES);

        getOrCreateTagBuilder(ConventionalBlockTags.ORES)
                .add(CoreAscensionBlocks.SULPHUR_ORE)
                .add(CoreAscensionBlocks.URANIUM_ORE)
                .add(CoreAscensionBlocks.CLOUD_DIAMOND_ORE)
                .add(CoreAscensionBlocks.CLOUD_EMERALD_ORE)
                .add(CoreAscensionBlocks.CLOUD_GOLD_ORE)
                .add(CoreAscensionBlocks.CLOUD_IRON_ORE)
                .add(CoreAscensionBlocks.CLOUD_COAL_ORE)
                .add(CoreAscensionBlocks.SAPPHIRE_ORE)
                .add(CoreAscensionBlocks.TITANIUM_ORE)
                .add(CoreAscensionBlocks.ZIRCON_ORE)
                .add(CoreAscensionBlocks.ARGON_CRYSTAL_ORE);


        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(CoreAscensionBlocks.TROPICS_LOG)
                .add(CoreAscensionBlocks.TROPICS_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_LOG)
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD)
                .add(CoreAscensionBlocks.ETHEREAL_LOG)
                .add(CoreAscensionBlocks.ETHEREAL_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG)
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD)
                .add(CoreAscensionBlocks.CEDAR_LOG)
                .add(CoreAscensionBlocks.CEDAR_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_LOG)
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD)
                .add(CoreAscensionBlocks.CAKEWOOD_LOG)
                .add(CoreAscensionBlocks.CAKEWOOD_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_LOG)
                .add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_WOOD)
                .add(CoreAscensionBlocks.DREAD_LOG)
                .add(CoreAscensionBlocks.DREAD_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_DREAD_LOG)
                .add(CoreAscensionBlocks.STRIPPED_DREAD_WOOD)
                .add(CoreAscensionBlocks.WHITEWOOD_LOG)
                .add(CoreAscensionBlocks.WHITEWOOD_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_LOG)
                .add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_WOOD)
                .add(CoreAscensionBlocks.DARK_MATTER_LOG)
                .add(CoreAscensionBlocks.DARK_MATTER_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_LOG)
                .add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_WOOD);

        getOrCreateTagBuilder(BlockTags.SAND)
                .add(CoreAscensionBlocks.BLACK_SAND)
                .add(CoreAscensionBlocks.BONESAND)
                .add(CoreAscensionBlocks.DREAD_SAND);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(CoreAscensionBlocks.LOAM);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(CoreAscensionBlocks.HARDENED_LAVA)
                .add(CoreAscensionBlocks.SAPPHIRE_BLOCK)
                .add(CoreAscensionBlocks.TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.TITANIUM_SLAB)
                .add(CoreAscensionBlocks.TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.SEARED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.SEARED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.SEARED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.SINGED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.SINGED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.SINGED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.BURNT_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.BURNT_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.BURNT_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.ZIRCON_BLOCK)
                .add(CoreAscensionBlocks.URANIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(CoreAscensionBlocks.URANIUM_ORE)
                .add(CoreAscensionBlocks.ZIRCON_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(CoreAscensionBlocks.TITANIUM_ORE)
                .add(CoreAscensionBlocks.SAPPHIRE_ORE)
                .add(CoreAscensionBlocks.SULPHUR_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Blocks.BEDROCK)
                .add(CoreAscensionBlocks.AERO_LANTERN)
                .add(CoreAscensionBlocks.BLACK_SANDSTONE)
                .add(CoreAscensionBlocks.DREAD_SANDSTONE)
                .add(CoreAscensionBlocks.AMETHYST_GEM_LOG)
                .add(CoreAscensionBlocks.AMETHYST_SLAB)
                .add(CoreAscensionBlocks.AMETHYST_STAIRS)
                .add(CoreAscensionBlocks.AMETHYST_TILES)
                .add(CoreAscensionBlocks.AMETHYST_WALL)
                .add(CoreAscensionBlocks.ANDESITE_TILE)
                .add(CoreAscensionBlocks.ARGON_CRYSTAL_BLOCK)
                .add(CoreAscensionBlocks.ARGON_CRYSTAL_ORE)
                .add(CoreAscensionBlocks.ARGON_CRYSTAL_ORE)
                .add(CoreAscensionBlocks.TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.TITANIUM_SLAB)
                .add(CoreAscensionBlocks.TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.SEARED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.SEARED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.SEARED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.SINGED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.SINGED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.SINGED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.SCORCHED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.SCORCHED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.SCORCHED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.BURNT_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.BURNT_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.BURNT_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_SEARED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_SINGED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_SCORCHED_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_BLOCK)
                .add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_SLAB)
                .add(CoreAscensionBlocks.FROZEN_BURNT_TITANIUM_STAIRS)
                .add(CoreAscensionBlocks.BLAZE_BRICK)
                .add(CoreAscensionBlocks.CHISELED_BLACK_SANDSTONE)
                .add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE)
                .add(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE)
                .add(CoreAscensionBlocks.CHISELED_DREAD_SANDSTONE)
                .add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE)
                .add(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE)
                .add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_SLAB)
                .add(CoreAscensionBlocks.CUT_BLACK_SANDSTONE_STAIRS)
                .add(CoreAscensionBlocks.TROPICS_MUD_BRICKS)
                .add(CoreAscensionBlocks.TROPICS_MUD_BRICK_SLAB)
                .add(CoreAscensionBlocks.TROPICS_MUD_BRICK_STAIRS)
                .add(CoreAscensionBlocks.DREAD_ROCK)
                .add(CoreAscensionBlocks.DREAD_ROCK_BRICKS)
                .add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_SLAB)
                .add(CoreAscensionBlocks.CUT_DREAD_SANDSTONE_STAIRS)
                .add(CoreAscensionBlocks.HARDENED_LAVA)
                .add(CoreAscensionBlocks.TITANIUM_ORE)
                .add(CoreAscensionBlocks.URANIUM_ORE)
                .add(CoreAscensionBlocks.URANIUM_BLOCK)
                .add(CoreAscensionBlocks.CEMENT)
                .add(CoreAscensionBlocks.IGNEOUS_ROCK)
                .add(CoreAscensionBlocks.IGNEOUS_ROCK_STAIRS)
                .add(CoreAscensionBlocks.IGNEOUS_ROCK_SLAB)
                .add(CoreAscensionBlocks.IGNEOUS_ROCK_TILES)
                .add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK)
                .add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_STAIRS)
                .add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_SLAB)
                .add(CoreAscensionBlocks.SALTROCK)
                .add(CoreAscensionBlocks.SALTROCK_STAIRS)
                .add(CoreAscensionBlocks.SALTROCK_SLAB)
                .add(CoreAscensionBlocks.SALTROCK_TILES)
                .add(CoreAscensionBlocks.POLISHED_SALTROCK)
                .add(CoreAscensionBlocks.POLISHED_SALTROCK_STAIRS)
                .add(CoreAscensionBlocks.POLISHED_SALTROCK_SLAB)
                .add(CoreAscensionBlocks.MAGNETITE)
                .add(CoreAscensionBlocks.MAGNETITE_STAIRS)
                .add(CoreAscensionBlocks.MAGNETITE_SLAB)
                .add(CoreAscensionBlocks.MAGNETITE_TILES)
                .add(CoreAscensionBlocks.POLISHED_MAGNETITE)
                .add(CoreAscensionBlocks.POLISHED_MAGNETITE_STAIRS)
                .add(CoreAscensionBlocks.POLISHED_MAGNETITE_SLAB)
                .add(CoreAscensionBlocks.LIMESTONE)
                .add(CoreAscensionBlocks.LIMESTONE_STAIRS)
                .add(CoreAscensionBlocks.LIMESTONE_SLAB)
                .add(CoreAscensionBlocks.LIMESTONE_TILES)
                .add(CoreAscensionBlocks.POLISHED_LIMESTONE)
                .add(CoreAscensionBlocks.POLISHED_LIMESTONE_STAIRS)
                .add(CoreAscensionBlocks.POLISHED_LIMESTONE_SLAB)
                .add(CoreAscensionBlocks.IGNEOUS_ROCK_WALL)
                .add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_WALL)
                .add(CoreAscensionBlocks.SALTROCK_WALL)
                .add(CoreAscensionBlocks.POLISHED_SALTROCK_WALL)
                .add(CoreAscensionBlocks.MAGNETITE_WALL)
                .add(CoreAscensionBlocks.POLISHED_MAGNETITE_WALL)
                .add(CoreAscensionBlocks.LIMESTONE_WALL)
                .add(CoreAscensionBlocks.POLISHED_LIMESTONE_WALL)
                .add(CoreAscensionBlocks.DIORITE_TILE)
                .add(CoreAscensionBlocks.GRANITE_TILE)
                .add(CoreAscensionBlocks.BONESANDSTONE)
                .add(CoreAscensionBlocks.CHISELED_BONESANDSTONE)
                .add(CoreAscensionBlocks.SMOOTH_BONESANDSTONE)
                .add(CoreAscensionBlocks.CUT_BONESANDSTONE)
                .add(CoreAscensionBlocks.CUT_BONESANDSTONE_STAIRS)
                .add(CoreAscensionBlocks.CUT_BONESANDSTONE_SLAB)
                .add(CoreAscensionBlocks.CATALYZER_TABLE)
                .add(CoreAscensionBlocks.SULPHUR_BLOCK)
                .add(CoreAscensionBlocks.GOLD_PRISMAERO)
                .add(CoreAscensionBlocks.CHISELED_PRISMAERO)
                .add(CoreAscensionBlocks.POLISHED_PRISMAERO)
                .add(CoreAscensionBlocks.PRISMAERO_BRICKS)
                .add(CoreAscensionBlocks.PRISMAERO_PILLAR)
                .add(CoreAscensionBlocks.PRISMAERO_SLAB)
                .add(CoreAscensionBlocks.GOLDEN_PRISMAERO_SLAB)
                .add(CoreAscensionBlocks.PRISMAERO_BRICKS_SLAB)
                .add(CoreAscensionBlocks.POLISHED_PRISMAERO_SLAB)
                .add(CoreAscensionBlocks.PRISMAERO_STAIRS)
                .add(CoreAscensionBlocks.GOLDEN_PRISMAERO_STAIRS)
                .add(CoreAscensionBlocks.POLISHED_PRISMAERO_STAIRS)
                .add(CoreAscensionBlocks.PRISMAERO_BRICKS_STAIRS)
                .add(CoreAscensionBlocks.PRISMAERO_WALL)
                .add(CoreAscensionBlocks.PRISMAERO_SPAWNER)
                .add(CoreAscensionBlocks.PETRIFIED_WOOD)
                .add(CoreAscensionBlocks.PETRIFIED_WOOD_WALL)
                .add(CoreAscensionBlocks.PETRIFIED_PLANKS)
                .add(CoreAscensionBlocks.PETRIFIED_PLANKS_SLAB)
                .add(CoreAscensionBlocks.PETRIFIED_PLANKS_STAIRS)
                .add(CoreAscensionBlocks.PETRIFIED_PLANKS_WALL)
                .add(CoreAscensionBlocks.ENDER_PEARL_BRICKS)
                .add(CoreAscensionBlocks.DARK_MATTER_STONE)
                .add(CoreAscensionBlocks.MOSSY_DARK_MATTER_STONE)
                .add(CoreAscensionBlocks.CLOUD_STONE)
                .add(CoreAscensionBlocks.CLOUD_COAL_ORE)
                .add(CoreAscensionBlocks.CLOUD_IRON_ORE)
                .add(CoreAscensionBlocks.CLOUD_GOLD_ORE)
                .add(CoreAscensionBlocks.CLOUD_DIAMOND_ORE)
                .add(CoreAscensionBlocks.CLOUD_EMERALD_ORE)
                .add(CoreAscensionBlocks.MOONSTONE)
                .add(CoreAscensionBlocks.SULPHUR_ORE)
                .add(CoreAscensionBlocks.NETHERFROST)
                .add(CoreAscensionBlocks.CORE_NYLIUM)
                .add(CoreAscensionBlocks.ENTROPIC_CORE_NYLIUM)
                .add(CoreAscensionBlocks.ENTROPIC_ICE)
                .add(CoreAscensionBlocks.ROCK_SALT)
                .add(CoreAscensionBlocks.FROST_SANDSTONE)
                .add(CoreAscensionBlocks.CHISELED_FROST_SANDSTONE)
                .add(CoreAscensionBlocks.SMOOTH_FROST_SANDSTONE)
                .add(CoreAscensionBlocks.CUT_FROST_SANDSTONE)
                .add(CoreAscensionBlocks.CUT_FROST_SANDSTONE_STAIRS)
                .add(CoreAscensionBlocks.CUT_FROST_SANDSTONE_SLAB)
                .add(CoreAscensionBlocks.FROSTED_GLASS)
                .add(CoreAscensionBlocks.FROSTED_GLASS_PANE)
                .add(CoreAscensionBlocks.PERMA_ICE)
                .add(CoreAscensionBlocks.NETHER_ICE)
                .add(CoreAscensionBlocks.SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(CoreAscensionBlocks.BLACK_SAND)
                .add(CoreAscensionBlocks.DREAD_SAND)
                .add(CoreAscensionBlocks.LOAM)
                .add(CoreAscensionBlocks.TROPICAL_GRASS)
                .add(CoreAscensionBlocks.ETHEREAL_DIRT)
                .add(CoreAscensionBlocks.ETHEREAL_GRASS)
                .add(CoreAscensionBlocks.CAKESOIL)
                .add(CoreAscensionBlocks.FROSTING_GRASS)
                .add(CoreAscensionBlocks.TROPICS_MUD);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(CoreAscensionBlocks.CAKEWOOD_LOG)
                .add(CoreAscensionBlocks.CAKEWOOD_WOOD)
                .add(CoreAscensionBlocks.CAKEWOOD_PLANKS)
                .add(CoreAscensionBlocks.CAKEWOOD_SLAB)
                .add(CoreAscensionBlocks.CAKEWOOD_STAIRS)
                .add(CoreAscensionBlocks.CAKEWOOD_FENCE)
                .add(CoreAscensionBlocks.CAKEWOOD_FENCE_GATE)
                .add(CoreAscensionBlocks.CAKEWOOD_BUTTON)
                .add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_LOG)
                .add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_WOOD)
                .add(CoreAscensionBlocks.CAKEWOOD_DOOR)
                .add(CoreAscensionBlocks.CAKEWOOD_TRAPDOOR)
                .add(CoreAscensionBlocks.TROPICS_LOG)
                .add(CoreAscensionBlocks.CEDAR_LOG)
                .add(CoreAscensionBlocks.DREAD_LOG)
                .add(CoreAscensionBlocks.TROPICS_PLANKS)
                .add(CoreAscensionBlocks.CEDAR_PLANKS)
                .add(CoreAscensionBlocks.DREAD_PLANKS)
                .add(CoreAscensionBlocks.TROPICS_SLAB)
                .add(CoreAscensionBlocks.CEDAR_SLAB)
                .add(CoreAscensionBlocks.DREAD_SLAB)
                .add(CoreAscensionBlocks.TROPICS_STAIRS)
                .add(CoreAscensionBlocks.CEDAR_STAIRS)
                .add(CoreAscensionBlocks.DREAD_STAIRS)
                .add(CoreAscensionBlocks.TROPICS_FENCE)
                .add(CoreAscensionBlocks.CEDAR_FENCE)
                .add(CoreAscensionBlocks.DREAD_FENCE)
                .add(CoreAscensionBlocks.TROPICS_FENCE_GATE)
                .add(CoreAscensionBlocks.CEDAR_FENCE_GATE)
                .add(CoreAscensionBlocks.DREAD_FENCE_GATE)
                .add(CoreAscensionBlocks.TROPICS_BUTTON)
                .add(CoreAscensionBlocks.CEDAR_BUTTON)
                .add(CoreAscensionBlocks.DREAD_BUTTON)
                .add(CoreAscensionBlocks.TROPICS_WOOD)
                .add(CoreAscensionBlocks.CEDAR_WOOD)
                .add(CoreAscensionBlocks.DREAD_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_DREAD_WOOD)
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_LOG)
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_LOG)
                .add(CoreAscensionBlocks.COCONUT)
                .add(CoreAscensionBlocks.ETHEREAL_LOG)
                .add(CoreAscensionBlocks.ETHEREAL_WOOD)
                .add(CoreAscensionBlocks.ETHEREAL_PLANKS)
                .add(CoreAscensionBlocks.ETHEREAL_SLAB)
                .add(CoreAscensionBlocks.ETHEREAL_STAIRS)
                .add(CoreAscensionBlocks.ETHEREAL_FENCE)
                .add(CoreAscensionBlocks.ETHEREAL_FENCE_GATE)
                .add(CoreAscensionBlocks.ETHEREAL_BUTTON)
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG)
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD)
                .add(CoreAscensionBlocks.ETHEREAL_DOOR)
                .add(CoreAscensionBlocks.ETHEREAL_TRAPDOOR)
                .add(CoreAscensionBlocks.STRIPPED_DREAD_LOG)
                .add(CoreAscensionBlocks.WHITEWOOD_LOG)
                .add(CoreAscensionBlocks.WHITEWOOD_WOOD)
                .add(CoreAscensionBlocks.WHITEWOOD_PLANKS)
                .add(CoreAscensionBlocks.WHITEWOOD_SLAB)
                .add(CoreAscensionBlocks.WHITEWOOD_STAIRS)
                .add(CoreAscensionBlocks.WHITEWOOD_FENCE)
                .add(CoreAscensionBlocks.WHITEWOOD_FENCE_GATE)
                .add(CoreAscensionBlocks.WHITEWOOD_BUTTON)
                .add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_LOG)
                .add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_WOOD)
                .add(CoreAscensionBlocks.WHITEWOOD_DOOR)
                .add(CoreAscensionBlocks.CACTUS_PLANKS)
                .add(CoreAscensionBlocks.CACTUS_SLAB)
                .add(CoreAscensionBlocks.CACTUS_STAIRS)
                .add(CoreAscensionBlocks.CACTUS_FENCE)
                .add(CoreAscensionBlocks.CACTUS_FENCE_GATE)
                .add(CoreAscensionBlocks.CACTUS_BUTTON)
                .add(CoreAscensionBlocks.DARK_MATTER_LOG)
                .add(CoreAscensionBlocks.DARK_MATTER_WOOD)
                .add(CoreAscensionBlocks.DARK_MATTER_PLANKS)
                .add(CoreAscensionBlocks.DARK_MATTER_SLAB)
                .add(CoreAscensionBlocks.DARK_MATTER_STAIRS)
                .add(CoreAscensionBlocks.DARK_MATTER_FENCE)
                .add(CoreAscensionBlocks.DARK_MATTER_FENCE_GATE)
                .add(CoreAscensionBlocks.DARK_MATTER_BUTTON)
                .add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_LOG)
                .add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_WOOD)
                .add(CoreAscensionBlocks.DARK_MATTER_DOOR)
                .add(CoreAscensionBlocks.DARK_MATTER_TRAPDOOR)
                .add(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR)
                .add(CoreAscensionBlocks.ENTROPY_STEM)
                .add(CoreAscensionBlocks.ENTROPY_HYPHAE)
                .add(CoreAscensionBlocks.ENTROPY_PLANKS)
                .add(CoreAscensionBlocks.ENTROPY_SLAB)
                .add(CoreAscensionBlocks.ENTROPY_STAIRS)
                .add(CoreAscensionBlocks.ENTROPY_FENCE)
                .add(CoreAscensionBlocks.ENTROPY_FENCE_GATE)
                .add(CoreAscensionBlocks.ENTROPY_BUTTON)
                //.add(CoreAscensionBlocks.STRIPPED_ENTROPY_STEM)
                //.add(CoreAscensionBlocks.STRIPPED_ENTROPY_HYPHAE)
                //.add(CoreAscensionBlocks.ENTROPY_DOOR)
                //.add(CoreAscensionBlocks.ENTROPY_TRAPDOOR)
                .add(CoreAscensionBlocks.FROST_STEM)
                .add(CoreAscensionBlocks.FROST_HYPHAE)
                .add(CoreAscensionBlocks.FROST_PLANKS)
                .add(CoreAscensionBlocks.FROST_SLAB)
                .add(CoreAscensionBlocks.FROST_STAIRS)
                .add(CoreAscensionBlocks.FROST_FENCE)
                .add(CoreAscensionBlocks.FROST_FENCE_GATE)
                .add(CoreAscensionBlocks.FROST_BUTTON)
                .add(CoreAscensionBlocks.STRIPPED_FROST_STEM)
                .add(CoreAscensionBlocks.STRIPPED_FROST_HYPHAE)
                .add(CoreAscensionBlocks.FROST_DOOR)
                .add(CoreAscensionBlocks.FROST_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(CoreAscensionBlocks.ENTROPIC_WART_BLOCK)
                .add(CoreAscensionBlocks.CORELIGHT)
                .add(CoreAscensionBlocks.CORE_WART_BLOCK);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(CoreAscensionBlocks.TROPICS_FENCE)
                .add(CoreAscensionBlocks.DREAD_FENCE)
                .add(CoreAscensionBlocks.CEDAR_FENCE)
                .add(CoreAscensionBlocks.CAKEWOOD_FENCE)
                .add(CoreAscensionBlocks.CACTUS_FENCE)
                .add(CoreAscensionBlocks.ETHEREAL_FENCE)
                .add(CoreAscensionBlocks.DARK_MATTER_FENCE)
                .add(CoreAscensionBlocks.WHITEWOOD_FENCE)
                .add(CoreAscensionBlocks.FROST_FENCE)
                .add(CoreAscensionBlocks.ENTROPY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(CoreAscensionBlocks.TROPICS_FENCE_GATE)
                .add(CoreAscensionBlocks.DREAD_FENCE_GATE)
                .add(CoreAscensionBlocks.CEDAR_FENCE_GATE)
                .add(CoreAscensionBlocks.CAKEWOOD_FENCE_GATE)
                .add(CoreAscensionBlocks.CACTUS_FENCE_GATE)
                .add(CoreAscensionBlocks.ETHEREAL_FENCE_GATE)
                .add(CoreAscensionBlocks.DARK_MATTER_FENCE_GATE)
                .add(CoreAscensionBlocks.WHITEWOOD_FENCE_GATE)
                .add(CoreAscensionBlocks.FROST_FENCE_GATE)
                .add(CoreAscensionBlocks.ENTROPY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(CoreAscensionBlocks.AMETHYST_WALL)
                .add(CoreAscensionBlocks.IGNEOUS_ROCK_WALL)
                .add(CoreAscensionBlocks.LIMESTONE_WALL)
                .add(CoreAscensionBlocks.MAGNETITE_WALL)
                .add(CoreAscensionBlocks.POLISHED_IGNEOUS_ROCK_WALL)
                .add(CoreAscensionBlocks.POLISHED_LIMESTONE_WALL)
                .add(CoreAscensionBlocks.POLISHED_SALTROCK_WALL)
                .add(CoreAscensionBlocks.SALTROCK_WALL)
                .add(CoreAscensionBlocks.PRISMAERO_WALL)
                .add(CoreAscensionBlocks.POLISHED_MAGNETITE_WALL);
    }
}
