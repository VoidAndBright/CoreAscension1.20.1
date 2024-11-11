package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import java.util.concurrent.CompletableFuture;

public class CoreAscensionBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public CoreAscensionBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(CoreAscensionBlocks.TROPICS_LOG)
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_LOG)
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD)
                .add(CoreAscensionBlocks.ETHEREAL_LOG)
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG)
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD)
                .add(CoreAscensionBlocks.CEDAR_LOG)
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_LOG)
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD);
        getOrCreateTagBuilder(BlockTags.SAND)
                .add(CoreAscensionBlocks.BLACK_SAND);

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
                .add(CoreAscensionBlocks.URANIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(CoreAscensionBlocks.URANIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(CoreAscensionBlocks.TITANIUM_ORE)
                .add(CoreAscensionBlocks.SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
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
                .add(CoreAscensionBlocks.SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(CoreAscensionBlocks.CEDAR_FENCE)
                .add(CoreAscensionBlocks.DREAD_FENCE)
                .add(CoreAscensionBlocks.TROPICS_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(CoreAscensionBlocks.CEDAR_FENCE_GATE)
                .add(CoreAscensionBlocks.DREAD_FENCE_GATE)
                .add(CoreAscensionBlocks.TROPICS_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(CoreAscensionBlocks.AMETHYST_WALL);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(CoreAscensionBlocks.BLACK_SAND)
                .add(CoreAscensionBlocks.DREAD_SAND)
                .add(CoreAscensionBlocks.LOAM)
                .add(CoreAscensionBlocks.TROPICAL_GRASS)
                .add(CoreAscensionBlocks.ETHEREAL_DIRT)
                .add(CoreAscensionBlocks.ETHEREAL_GRASS)
                .add(CoreAscensionBlocks.TROPICS_MUD);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
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
                .add(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR);
    }
}
