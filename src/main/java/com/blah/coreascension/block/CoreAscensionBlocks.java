package com.blah.coreascension.block;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.blocks.*;
import com.blah.coreascension.block.blocks.Anodizable.AnodizationLevel;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.world.tree.ChestnutSaplingGenerator;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.world.World;

public class CoreAscensionBlocks
{
	public static final Block ACACIA_POST = RegisterBlockItem("acacia_post", new PostBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_FENCE)));
	public static final Block ACACIA_SECRET_DOOR = RegisterBlockItem("acacia_secret_door", new Block(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)));
    public static final Block AERO_LANTERN = RegisterBlockItem("aero_lantern", new Block(FabricBlockSettings.copyOf(Blocks.LANTERN)));
	public static final Block AMANITA_CAP = RegisterBlockItem("amanita_cap", new Block(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK)));
	public static final Block AMANITA_STEM = RegisterBlockItem("amanita_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.MUSHROOM_STEM)));
	public static final Block AMETHYST_GEM_LOG = RegisterBlockItem("amethyst_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT)));
	public static final Block AMETHYST_GEM_LEAVES = RegisterBlockItem("amethyst_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block AMETHYST_SLAB = RegisterBlockItem("amethyst_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
	public static final Block AMETHYST_STAIRS = RegisterBlockItem("amethyst_stairs", new StairsBlock(Blocks.AMETHYST_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block AMETHYST_WALL = RegisterBlockItem("amethyst_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block AMETHYST_TILES = RegisterBlockItem("amethyst_tiles", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block ANDESITE_TILE = RegisterBlockItem("andesite_tile", new Block(FabricBlockSettings.copyOf(Blocks.ANDESITE)));
	public static final Block DIORITE_TILE = RegisterBlockItem("diorite_tile", new Block(FabricBlockSettings.copyOf(Blocks.DIORITE)));
	public static final Block GRANITE_TILE = RegisterBlockItem("granite_tile", new Block(FabricBlockSettings.copyOf(Blocks.GRANITE)));

	public static final Block ARGON_CRYSTAL_BLOCK = RegisterBlockItem("argon_crystal_block", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block ARGON_CRYSTAL_CLUSTER = RegisterBlockItem("argon_crystal_cluster", new AmethystClusterBlock(7,3,FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block ARGON_CRYSTAL_ORE = RegisterBlockItem("argon_crystal_ore", new AmethystClusterBlock(7,3,FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block SAPPHIRE_ORE = RegisterBlockItem("sapphire_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
	public static final Block SAPPHIRE_BLOCK = RegisterBlockItem("sapphire_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));

	public static final Block SULPHUR_BLOCK = RegisterBlockItem("sulphur_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

	// titanium blocks
	public static final Block TITANIUM_ORE = RegisterBlockItem("titanium_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE)));
	public static final Block TITANIUM_BLOCK = RegisterBlockItem("titanium_block", new AnodizableBlock(AnodizationLevel.UNAFFECTED,FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.NETHERITE).ticksRandomly()));
	public static final Block TITANIUM_SLAB = RegisterBlockItem("titanium_slab", new AnodizableSlabBlock(AnodizationLevel.UNAFFECTED,FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).sounds(BlockSoundGroup.NETHERITE).ticksRandomly()));
	public static final Block TITANIUM_STAIRS = RegisterBlockItem("titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.UNAFFECTED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).sounds(BlockSoundGroup.NETHERITE).ticksRandomly()));

	public static final Block SEARED_TITANIUM_BLOCK = RegisterBlockItem("seared_titanium_block", new AnodizableBlock(AnodizationLevel.SEARED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));
	public static final Block SEARED_TITANIUM_SLAB = RegisterBlockItem("seared_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.SEARED,FabricBlockSettings.copyOf(TITANIUM_SLAB)));
	public static final Block SEARED_TITANIUM_STAIRS = RegisterBlockItem("seared_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.SEARED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_STAIRS)));
	public static final Block SINGED_TITANIUM_BLOCK = RegisterBlockItem("singed_titanium_block", new AnodizableBlock(AnodizationLevel.SINGED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));
	public static final Block SINGED_TITANIUM_SLAB = RegisterBlockItem("singed_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.SINGED,FabricBlockSettings.copyOf(TITANIUM_SLAB)));
	public static final Block SINGED_TITANIUM_STAIRS = RegisterBlockItem("singed_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.SINGED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));
	public static final Block SCORCHED_TITANIUM_BLOCK = RegisterBlockItem("scorched_titanium_block", new AnodizableBlock(AnodizationLevel.SCORCHED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));
	public static final Block SCORCHED_TITANIUM_SLAB = RegisterBlockItem("scorched_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.SCORCHED,FabricBlockSettings.copyOf(TITANIUM_SLAB)));
	public static final Block SCORCHED_TITANIUM_STAIRS = RegisterBlockItem("scorched_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.SCORCHED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_STAIRS)));
	public static final Block BURNT_TITANIUM_BLOCK = RegisterBlockItem("burnt_titanium_block", new AnodizableBlock(AnodizationLevel.BURNT,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));
	public static final Block BURNT_TITANIUM_SLAB = RegisterBlockItem("burnt_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.BURNT,FabricBlockSettings.copyOf(TITANIUM_SLAB)));
	public static final Block BURNT_TITANIUM_STAIRS = RegisterBlockItem("burnt_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.BURNT,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_STAIRS)));
	public static final Block FROZEN_TITANIUM_BLOCK = RegisterBlockItem("frozen_titanium_block", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
	public static final Block FROZEN_SEARED_TITANIUM_BLOCK = RegisterBlockItem("frozen_seared_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK)));
	public static final Block FROZEN_SINGED_TITANIUM_BLOCK = RegisterBlockItem("frozen_singed_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK)));
	public static final Block FROZEN_SCORCHED_TITANIUM_BLOCK = RegisterBlockItem("frozen_scorched_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK)));
	public static final Block FROZEN_BURNT_TITANIUM_BLOCK = RegisterBlockItem("frozen_burnt_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK)));
	public static final Block FROZEN_TITANIUM_SLAB = RegisterBlockItem("frozen_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).sounds(BlockSoundGroup.NETHERITE)));
	public static final Block FROZEN_SEARED_TITANIUM_SLAB = RegisterBlockItem("frozen_seared_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB)));
	public static final Block FROZEN_SINGED_TITANIUM_SLAB = RegisterBlockItem("frozen_singed_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB)));
	public static final Block FROZEN_SCORCHED_TITANIUM_SLAB = RegisterBlockItem("frozen_scorched_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB)));
	public static final Block FROZEN_BURNT_TITANIUM_SLAB = RegisterBlockItem("frozen_burnt_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB)));
	public static final Block FROZEN_TITANIUM_STAIRS = RegisterBlockItem("frozen_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).sounds(BlockSoundGroup.NETHERITE)));
	public static final Block FROZEN_SEARED_TITANIUM_STAIRS = RegisterBlockItem("frozen_seared_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS)));
	public static final Block FROZEN_SINGED_TITANIUM_STAIRS = RegisterBlockItem("frozen_singed_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS)));
	public static final Block FROZEN_SCORCHED_TITANIUM_STAIRS = RegisterBlockItem("frozen_scorched_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS)));
	public static final Block FROZEN_BURNT_TITANIUM_STAIRS = RegisterBlockItem("frozen_burnt_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS)));
	// end titanium

	public static final Block BLAZE_BRICK = RegisterBlockItem("blaze_brick", new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(15)));
	public static final Block REINFORCED_CHEST = RegisterBlockItem("reinforced_chest", new ReinforcedChestBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
	public static final Block CATALYZER_TABLE = RegisterBlockItem("catalyzer", new CatalyzerTableBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

	// uranium
	public static final Block URANIUM_ORE = RegisterBlockItem("uranium_ore", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT)), new FabricItemSettings().fireproof());
	public static final Block URANIUM_BLOCK = RegisterBlockItem("uranium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)), new FabricItemSettings().fireproof());
	// end uranium

	// cedar grove stuff
	public static final Block CEDAR_LOG = RegisterBlockItem("cedar_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block CEDAR_WOOD = RegisterBlockItem("cedar_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block CEDAR_PLANKS = RegisterBlockItem("cedar_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block CEDAR_SLAB = RegisterBlockItem("cedar_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block CEDAR_STAIRS = RegisterBlockItem("cedar_stairs", new StairsBlock(CEDAR_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));
	public static final Block CEDAR_FENCE = RegisterBlockItem("cedar_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block CEDAR_FENCE_GATE = RegisterBlockItem("cedar_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
	public static final Block CEDAR_BUTTON = RegisterBlockItem("cedar_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
	public static final Block CEDAR_LEAVES = RegisterBlockItem("cedar_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block STRIPPED_CEDAR_LOG = RegisterBlockItem("stripped_cedar_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_CEDAR_WOOD = RegisterBlockItem("stripped_cedar_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block CEDAR_DOOR = RegisterBlockItem("cedar_door", new DoorBlock(FabricBlockSettings.copyOf(CEDAR_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block CEDAR_TRAPDOOR = RegisterBlockItem("cedar_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(CEDAR_PLANKS).nonOpaque(), BlockSetType.OAK));
	// end cedar grove stuff
	// tropics stuff
	public static final Block TROPICS_LOG = RegisterBlockItem("tropics_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block TROPICS_WOOD = RegisterBlockItem("tropics_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block TROPICS_PLANKS = RegisterBlockItem("tropics_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block TROPICS_SLAB = RegisterBlockItem("tropics_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block TROPICS_STAIRS = RegisterBlockItem("tropics_stairs", new StairsBlock(TROPICS_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block TROPICS_FENCE = RegisterBlockItem("tropics_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block TROPICS_FENCE_GATE = RegisterBlockItem("tropics_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
	public static final Block TROPICS_BUTTON = RegisterBlockItem("tropics_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
	public static final Block TROPICS_LEAVES = RegisterBlockItem("tropics_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block STRIPPED_TROPICS_LOG = RegisterBlockItem("stripped_tropics_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_TROPICS_WOOD = RegisterBlockItem("stripped_tropics_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block BLACK_SAND = RegisterBlockItem("black_sand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)));
	public static final Block BLACK_SANDSTONE = RegisterBlockItem("black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	public static final Block REINFORCED_GLASS = RegisterBlockItem("reinforced_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
	public static final Block TROPICS_MUD = RegisterBlockItem("tropics_mud", new Block(FabricBlockSettings.copyOf(Blocks.MUD)));
	public static final Block CHISELED_BLACK_SANDSTONE = RegisterBlockItem("chiseled_black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE)));
	public static final Block SMOOTH_BLACK_SANDSTONE = RegisterBlockItem("smooth_black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE)));
	public static final Block CUT_BLACK_SANDSTONE = RegisterBlockItem("cut_black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE)));
	public static final Block LOAM = RegisterBlockItem("loam", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
	public static final Block CUT_BLACK_SANDSTONE_SLAB = RegisterBlockItem("cut_black_sandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB)));
	public static final Block CUT_BLACK_SANDSTONE_STAIRS = RegisterBlockItem("cut_black_sandstone_stairs", new StairsBlock(BLACK_SANDSTONE.getDefaultState(),FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	public static final Block TROPICS_MUD_BRICKS = RegisterBlockItem("tropics_mud_bricks", new Block(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS)));
	public static final Block TROPICS_MUD_BRICK_SLAB = RegisterBlockItem("tropics_mud_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS)));
	public static final Block TROPICS_MUD_BRICK_STAIRS = RegisterBlockItem("tropics_mud_brick_stairs", new StairsBlock(TROPICS_MUD_BRICKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.MUD_BRICKS)));
	public static final Block TROPICS_DOOR = RegisterBlockItem("tropics_door", new DoorBlock(FabricBlockSettings.copyOf(TROPICS_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block TROPICS_TRAPDOOR = RegisterBlockItem("tropics_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(TROPICS_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block TROPICS_SAPLING = RegisterBlockItem("tropics_sapling", new SaplingBlock(new ChestnutSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)){
		protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {return floor.isIn(BlockTags.SAND);}
	});
	public static final Block TROPICAL_GRASS = RegisterBlockItem("tropical_grass", new AnySpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).ticksRandomly(),LOAM));

	// whitewood
	public static final Block WHITEWOOD_LOG = RegisterBlockItem("whitewood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block WHITEWOOD_WOOD = RegisterBlockItem("whitewood_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block WHITEWOOD_PLANKS = RegisterBlockItem("whitewood_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block WHITEWOOD_SLAB = RegisterBlockItem("whitewood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block WHITEWOOD_STAIRS = RegisterBlockItem("whitewood_stairs", new StairsBlock(WHITEWOOD_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block WHITEWOOD_FENCE = RegisterBlockItem("whitewood_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block WHITEWOOD_FENCE_GATE = RegisterBlockItem("whitewood_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
	public static final Block WHITEWOOD_BUTTON = RegisterBlockItem("whitewood_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
	public static final Block WHITEWOOD_LEAVES = RegisterBlockItem("whitewood_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block STRIPPED_WHITEWOOD_LOG = RegisterBlockItem("stripped_whitewood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_WHITEWOOD_WOOD = RegisterBlockItem("stripped_whitewood_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block WHITEWOOD_DOOR = RegisterBlockItem("whitewood_door", new DoorBlock(FabricBlockSettings.copyOf(WHITEWOOD_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block WHITEWOOD_TRAPDOOR = RegisterBlockItem("whitewood_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(WHITEWOOD_PLANKS).nonOpaque(), BlockSetType.OAK));
	// end whitewood
	public static final Block SEASHELL = RegisterBlockItem("seashell", new SeashellBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK).nonOpaque()));
	public static final Block CONCH_SHELL = RegisterBlockItem("conch_shell", new ConchShellBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK).nonOpaque()));

	// end tropics stuff

	// dread stuff
	public static final Block DREAD_LOG = RegisterBlockItem("dread_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block DREAD_WOOD = RegisterBlockItem("dread_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block DREAD_PLANKS = RegisterBlockItem("dread_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block DREAD_SLAB = RegisterBlockItem("dread_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block DREAD_STAIRS = RegisterBlockItem("dread_stairs", new StairsBlock(DREAD_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block DREAD_FENCE = RegisterBlockItem("dread_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block DREAD_FENCE_GATE = RegisterBlockItem("dread_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
	public static final Block DREAD_BUTTON = RegisterBlockItem("dread_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
	public static final Block STRIPPED_DREAD_LOG = RegisterBlockItem("stripped_dread_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_DREAD_WOOD = RegisterBlockItem("stripped_dread_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block DREAD_SAND = RegisterBlockItem("dread_sand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)));
	public static final Block DREAD_SANDSTONE = RegisterBlockItem("dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	public static final Block BORDERLESS_GLASS = RegisterBlockItem("borderless_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
	public static final Block DREAD_ROCK = RegisterBlockItem("dread_rock", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block CHISELED_DREAD_SANDSTONE = RegisterBlockItem("chiseled_dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE)));
	public static final Block SMOOTH_DREAD_SANDSTONE = RegisterBlockItem("smooth_dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE)));
	public static final Block CUT_DREAD_SANDSTONE = RegisterBlockItem("cut_dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE)));
	public static final Block CUT_DREAD_SANDSTONE_SLAB = RegisterBlockItem("cut_dread_sandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB)));
	public static final Block CUT_DREAD_SANDSTONE_STAIRS = RegisterBlockItem("cut_dread_sandstone_stairs", new StairsBlock(DREAD_SANDSTONE.getDefaultState(),FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	public static final Block DREAD_ROCK_BRICKS = RegisterBlockItem("dread_rock_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
	public static final Block DREAD_DOOR = RegisterBlockItem("dread_door", new DoorBlock(FabricBlockSettings.copyOf(DREAD_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block DREAD_TRAPDOOR = RegisterBlockItem("dread_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(DREAD_PLANKS).nonOpaque(), BlockSetType.OAK));
	// end dread

	// skylands
	// ancient biome
	public static final Block BONESAND = RegisterBlockItem("bonesand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)));
	public static final Block BONESANDSTONE = RegisterBlockItem("bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	public static final Block CHISELED_BONESANDSTONE = RegisterBlockItem("chiseled_bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE)));
	public static final Block SMOOTH_BONESANDSTONE = RegisterBlockItem("smooth_bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE)));
	public static final Block CUT_BONESANDSTONE = RegisterBlockItem("cut_bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE)));
	public static final Block CUT_BONESANDSTONE_SLAB = RegisterBlockItem("cut_bonesandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB)));
	public static final Block CUT_BONESANDSTONE_STAIRS = RegisterBlockItem("cut_bonesandstone_stairs", new StairsBlock(BONESANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	// end ancient

	// ethereal glade
	public static final Block ETHEREAL_TORCH = RegisterBlock("ethereal_torch", new UnderwaterTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH), CoreAscensionParticles.ETHEREAL_FLAME));
	public static final Block ETHEREAL_WALL_TORCH = RegisterBlock("ethereal_wall_torch", new UnderwaterWallTorchBlock(FabricBlockSettings.copyOf(ETHEREAL_TORCH), CoreAscensionParticles.ETHEREAL_FLAME));
	public static final Block ETHEREAL_DIRT = RegisterBlockItem("ethereal_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));
	public static final Block ETHEREAL_LOG = RegisterBlockItem("ethereal_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block ETHEREAL_WOOD = RegisterBlockItem("ethereal_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block ETHEREAL_PLANKS = RegisterBlockItem("ethereal_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block ETHEREAL_SLAB = RegisterBlockItem("ethereal_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block ETHEREAL_STAIRS = RegisterBlockItem("ethereal_stairs", new StairsBlock(ETHEREAL_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block ETHEREAL_FENCE = RegisterBlockItem("ethereal_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block ETHEREAL_FENCE_GATE = RegisterBlockItem("ethereal_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
	public static final Block ETHEREAL_BUTTON = RegisterBlockItem("ethereal_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
	public static final Block ETHEREAL_LEAVES = RegisterBlockItem("ethereal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block STRIPPED_ETHEREAL_LOG = RegisterBlockItem("stripped_ethereal_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_ETHEREAL_WOOD = RegisterBlockItem("stripped_ethereal_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block ETHEREAL_DOOR = RegisterBlockItem("ethereal_door", new DoorBlock(FabricBlockSettings.copyOf(ETHEREAL_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block ETHEREAL_TRAPDOOR = RegisterBlockItem("ethereal_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(ETHEREAL_PLANKS).nonOpaque(), BlockSetType.OAK));
	public static final Block ETHEREAL_MEMBRANE = RegisterBlockItem("ethereal_membrane", new SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK)));
	public static final Block ETHEREAL_GRASS = RegisterBlockItem("ethereal_grass", new AnySpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).ticksRandomly(),ETHEREAL_DIRT));
	// end ethereal glade

	// prismaero
	public static final Block PRISMAERO = RegisterBlockItem("prismaero", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE)));
	public static final Block POLISHED_PRISMAERO = RegisterBlockItem("polished_prismaero", new Block(FabricBlockSettings.copyOf(PRISMAERO)));
	public static final Block GOLD_PRISMAERO = RegisterBlockItem("gold_prismaero", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE)));
	public static final Block PRISMAERO_BRICKS = RegisterBlockItem("prismaero_bricks", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE)));
	public static final Block PRISMAERO_PILLAR = RegisterBlockItem("prismaero_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE)));
	public static final Block PRISMAERO_SLAB = RegisterBlockItem("prismaero_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB)));
	public static final Block GOLDEN_PRISMAERO_SLAB = RegisterBlockItem("golden_prismaero_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB)));
	public static final Block PRISMAERO_BRICKS_SLAB = RegisterBlockItem("prismaero_bricks_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB)));
	public static final Block POLISHED_PRISMAERO_SLAB = RegisterBlockItem("polished_prismaero_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB)));
	public static final Block PRISMAERO_STAIRS = RegisterBlockItem("prismaero_stairs", new StairsBlock(PRISMAERO.getDefaultState(),FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS)));
	public static final Block GOLDEN_PRISMAERO_STAIRS = RegisterBlockItem("golden_prismaero_stairs", new StairsBlock(PRISMAERO.getDefaultState(),FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS)));
	public static final Block PRISMAERO_BRICKS_STAIRS = RegisterBlockItem("prismaero_bricks_stairs", new StairsBlock(PRISMAERO.getDefaultState(),FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS)));
	public static final Block POLISHED_PRISMAERO_STAIRS = RegisterBlockItem("polished_prismaero_stairs", new StairsBlock(PRISMAERO.getDefaultState(),FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS)));
	public static final Block PRISMAERO_WALL = RegisterBlockItem("prismaero_wall", new WallBlock(FabricBlockSettings.copyOf(PRISMAERO)));
	public static final Block CHISELED_PRISMAERO = RegisterBlockItem("chiseled_prismaero", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE)));
	public static final Block PRISMAERO_SPAWNER = RegisterBlockItem("prismaero_spawner", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE))
	{
		@Override
		public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
		{
			// ADD PROTECTOR SPAWNING (for later)
			super.onSteppedOn(world, pos, state, entity);
		}
	});

	// end prismaero
	// end skylands

	// misc blocks
	public static final Block HARDENED_LAVA = RegisterBlockItem("hardened_lava", new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(6)));
	public static final Block CEMENT = RegisterBlockItem("cement", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block IMPERVIOUS_BRICK = RegisterBlockItem("impervious_brick", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block COCONUT = RegisterBlockItem("coconut", new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque())
	{
		@Override
		public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
		{
			return Block.createCuboidShape(3, 3, 3, 13, 13, 13);
		}
	});
	public static final Block PRISMAERO_FURNACE = RegisterBlockItem("prismaero_furnace", new PrismaeroFurnaceBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
	public static final Block PETRIFIED_WOOD = RegisterBlockItem("petrified_wood", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	// end misc blocks

	// stone variants
	public static final Block IGNEOUS_ROCK = RegisterBlockItem("igneous_rock", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block SALTROCK = RegisterBlockItem("saltrock", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block MAGNETITE = RegisterBlockItem("magnetite", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block LIMESTONE = RegisterBlockItem("limestone", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
	public static final Block POLISHED_IGNEOUS_ROCK = RegisterBlockItem("polished_igneous_rock", new Block(FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block POLISHED_SALTROCK = RegisterBlockItem("polished_saltrock", new Block(FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block POLISHED_MAGNETITE = RegisterBlockItem("polished_magnetite", new Block(FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block POLISHED_LIMESTONE = RegisterBlockItem("polished_limestone", new Block(FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block IGNEOUS_ROCK_TILES = RegisterBlockItem("igneous_rock_tiles", new Block(FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block SALTROCK_TILES = RegisterBlockItem("saltrock_tiles", new Block(FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block MAGNETITE_TILES = RegisterBlockItem("magnetite_tiles", new Block(FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block LIMESTONE_TILES = RegisterBlockItem("limestone_tiles", new Block(FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block IGNEOUS_ROCK_SLAB = RegisterBlockItem("igneous_rock_slab", new SlabBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block SALTROCK_SLAB = RegisterBlockItem("saltrock_slab", new SlabBlock(FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block MAGNETITE_SLAB = RegisterBlockItem("magnetite_slab", new SlabBlock(FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block LIMESTONE_SLAB = RegisterBlockItem("limestone_slab", new SlabBlock(FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block IGNEOUS_ROCK_STAIRS = RegisterBlockItem("igneous_rock_stairs", new StairsBlock(IGNEOUS_ROCK.getDefaultState(),FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block SALTROCK_STAIRS = RegisterBlockItem("saltrock_stairs", new StairsBlock(SALTROCK.getDefaultState(),FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block MAGNETITE_STAIRS = RegisterBlockItem("magnetite_stairs", new StairsBlock(MAGNETITE.getDefaultState(),FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block LIMESTONE_STAIRS = RegisterBlockItem("limestone_stairs", new StairsBlock(LIMESTONE.getDefaultState(),FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block IGNEOUS_ROCK_WALL = RegisterBlockItem("igneous_rock_wall", new WallBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block SALTROCK_WALL = RegisterBlockItem("saltrock_wall", new WallBlock(FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block MAGNETITE_WALL = RegisterBlockItem("magnetite_wall", new WallBlock(FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block LIMESTONE_WALL = RegisterBlockItem("limestone_wall", new WallBlock(FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block POLISHED_IGNEOUS_ROCK_SLAB = RegisterBlockItem("polished_igneous_rock_slab", new SlabBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block POLISHED_SALTROCK_SLAB = RegisterBlockItem("polished_saltrock_slab", new SlabBlock(FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block POLISHED_MAGNETITE_SLAB = RegisterBlockItem("polished_magnetite_slab", new SlabBlock(FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block POLISHED_LIMESTONE_SLAB = RegisterBlockItem("polished_limestone_slab", new SlabBlock(FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block POLISHED_IGNEOUS_ROCK_STAIRS = RegisterBlockItem("polished_igneous_rock_stairs", new StairsBlock(IGNEOUS_ROCK.getDefaultState(),FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block POLISHED_SALTROCK_STAIRS = RegisterBlockItem("polished_saltrock_stairs", new StairsBlock(SALTROCK.getDefaultState(),FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block POLISHED_MAGNETITE_STAIRS = RegisterBlockItem("polished_magnetite_stairs", new StairsBlock(MAGNETITE.getDefaultState(),FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block POLISHED_LIMESTONE_STAIRS = RegisterBlockItem("polished_limestone_stairs", new StairsBlock(LIMESTONE.getDefaultState(),FabricBlockSettings.copyOf(LIMESTONE)));
	public static final Block POLISHED_IGNEOUS_ROCK_WALL = RegisterBlockItem("polished_igneous_rock_wall", new WallBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK)));
	public static final Block POLISHED_SALTROCK_WALL = RegisterBlockItem("polished_saltrock_wall", new WallBlock(FabricBlockSettings.copyOf(SALTROCK)));
	public static final Block POLISHED_MAGNETITE_WALL = RegisterBlockItem("polished_magnetite_wall", new WallBlock(FabricBlockSettings.copyOf(MAGNETITE)));
	public static final Block POLISHED_LIMESTONE_WALL = RegisterBlockItem("polished_limestone_wall", new WallBlock(FabricBlockSettings.copyOf(LIMESTONE)));
	// end stone variants

    private static Block RegisterBlockItem(String name, Block block)
	{
        RegisterItem(name, block);
        return RegisterBlock(name, block);
    }

	private static Block RegisterBlockItem(String name, Block block, FabricItemSettings settings)
	{
		RegisterItemWithSettings(name, block, settings);
		return RegisterBlock(name, block);
	}

	private static Block RegisterBlock(String name, Block block)
	{
        return Registry.register(Registries.BLOCK, new Identifier(CoreAscension.MOD_ID, name), block);
    }

    private static void RegisterItem(String name, Block block)
	{
		Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
	}

	private static void RegisterItemWithSettings(String name, Block block,FabricItemSettings settings)
	{
		Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), new BlockItem(block, settings));
	}
	private static void RegisterStrippableBlocks()
	{
		StrippableBlockRegistry.register(CoreAscensionBlocks.CEDAR_LOG, CoreAscensionBlocks.STRIPPED_CEDAR_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.CEDAR_WOOD, CoreAscensionBlocks.STRIPPED_CEDAR_WOOD);
		StrippableBlockRegistry.register(CoreAscensionBlocks.DREAD_LOG, CoreAscensionBlocks.STRIPPED_DREAD_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.DREAD_WOOD, CoreAscensionBlocks.STRIPPED_DREAD_WOOD);
		StrippableBlockRegistry.register(CoreAscensionBlocks.TROPICS_LOG, CoreAscensionBlocks.STRIPPED_TROPICS_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.TROPICS_WOOD, CoreAscensionBlocks.STRIPPED_TROPICS_WOOD);
		StrippableBlockRegistry.register(CoreAscensionBlocks.WHITEWOOD_LOG, CoreAscensionBlocks.STRIPPED_WHITEWOOD_LOG);
		StrippableBlockRegistry.register(CoreAscensionBlocks.WHITEWOOD_WOOD, CoreAscensionBlocks.STRIPPED_WHITEWOOD_WOOD);
	}
	private static void RegisterFlammableBlocks()
	{
		FlammableBlockRegistry.getDefaultInstance().add(CEDAR_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CEDAR_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CEDAR_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(CEDAR_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(CEDAR_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_LOG, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_PLANKS, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(TROPICS_LOG, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_TROPICS_LOG, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_TROPICS_WOOD, 5,5);
		FlammableBlockRegistry.getDefaultInstance().add(TROPICS_PLANKS, 5,20);
		FlammableBlockRegistry.getDefaultInstance().add(TROPICS_LEAVES, 30, 60);

	}
    public static void RegisterBlocks()
	{
		RegisterFlammableBlocks();
		RegisterStrippableBlocks();
		CoreAscension.LOGGER.info("Registering Blocks for " + CoreAscension.MOD_ID);
    }

	public static void ClientRegisterBlocks()
	{
		ClientRegisterRenderLayeredBlocks();
		ClientRegisterColouredBlocks();
	}
	public static void ClientRegisterRenderLayeredBlocks(){
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ARGON_CRYSTAL_CLUSTER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.AMETHYST_GEM_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.REINFORCED_GLASS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.BORDERLESS_GLASS, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.REINFORCED_CHEST, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.COCONUT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.DREAD_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ETHEREAL_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ETHEREAL_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.DREAD_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.WHITEWOOD_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ETHEREAL_GRASS, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICAL_GRASS, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_SAPLING, RenderLayer.getCutout());
	}
	public static void ClientRegisterColouredBlocks() {
		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), TROPICAL_GRASS);
		ColorProviderRegistry.ITEM.register((state,tintIndex) -> 8126208, TROPICAL_GRASS);
		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), TROPICS_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 8126208, TROPICS_LEAVES);
		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), CEDAR_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 3368448, CEDAR_LEAVES);
	}
}
