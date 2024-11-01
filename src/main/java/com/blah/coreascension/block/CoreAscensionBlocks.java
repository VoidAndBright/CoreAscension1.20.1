package com.blah.coreascension.block;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.blocks.*;
import com.blah.coreascension.particles.CoreAscensionParticles;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class CoreAscensionBlocks {
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

	public static final Block ARGON_CRYSTAL_BLOCK = RegisterBlockItem("argon_crystal_block", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

	public static final Block ARGON_CRYSTAL_CLUSTER = RegisterBlockItem("argon_crystal_cluster", new AmethystClusterBlock(7,3,FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

	public static final Block ARGON_CRYSTAL_ORE = RegisterBlockItem("argon_crystal_ore", new AmethystClusterBlock(7,3,FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

	public static final Block TITANIUM_BLOCK = RegisterBlockItem("titanium_block", new AnodizableBlock(Anodizable.AnodizationLevel.UNAFFECTED,FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

	public static final Block SEARED_TITANIUM_BLOCK = RegisterBlockItem("seared_titanium_block", new AnodizableBlock(Anodizable.AnodizationLevel.SEARED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block SINGED_TITANIUM_BLOCK = RegisterBlockItem("singed_titanium_block", new AnodizableBlock(Anodizable.AnodizationLevel.SINGED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block SCORCHED_TITANIUM_BLOCK = RegisterBlockItem("scorched_titanium_block", new AnodizableBlock(Anodizable.AnodizationLevel.SCORCHED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block BURNT_TITANIUM_BLOCK = RegisterBlockItem("burnt_titanium_block", new AnodizableBlock(Anodizable.AnodizationLevel.BURNT,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block TITANIUM_SLAB = RegisterBlockItem("titanium_slab", new AnodizableSlabBlock(Anodizable.AnodizationLevel.UNAFFECTED,FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

	public static final Block SEARED_TITANIUM_SLAB = RegisterBlockItem("seared_titanium_slab", new AnodizableSlabBlock(Anodizable.AnodizationLevel.SEARED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block SINGED_TITANIUM_SLAB = RegisterBlockItem("singed_titanium_slab", new AnodizableSlabBlock(Anodizable.AnodizationLevel.SINGED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block SCORCHED_TITANIUM_SLAB = RegisterBlockItem("scorched_titanium_slab", new AnodizableSlabBlock(Anodizable.AnodizationLevel.SCORCHED,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block BURNT_TITANIUM_SLAB = RegisterBlockItem("burnt_titanium_slab", new AnodizableSlabBlock(Anodizable.AnodizationLevel.BURNT,FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block TITANIUM_STAIRS = RegisterBlockItem("titanium_stairs", new AnodizableStairsBlock(Anodizable.AnodizationLevel.UNAFFECTED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

	public static final Block SEARED_TITANIUM_STAIRS = RegisterBlockItem("seared_titanium_stairs", new AnodizableStairsBlock(Anodizable.AnodizationLevel.SEARED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block SINGED_TITANIUM_STAIRS = RegisterBlockItem("singed_titanium_stairs", new AnodizableStairsBlock(Anodizable.AnodizationLevel.SINGED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block SCORCHED_TITANIUM_STAIRS = RegisterBlockItem("scorched_titanium_stairs", new AnodizableStairsBlock(Anodizable.AnodizationLevel.SCORCHED,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block BURNT_TITANIUM_STAIRS = RegisterBlockItem("burnt_titanium_stairs", new AnodizableStairsBlock(Anodizable.AnodizationLevel.BURNT,TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_TITANIUM_BLOCK = RegisterBlockItem("frozen_titanium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

	public static final Block FROZEN_SEARED_TITANIUM_BLOCK = RegisterBlockItem("frozen_seared_titanium_block", new Block(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_SINGED_TITANIUM_BLOCK = RegisterBlockItem("frozen_singed_titanium_block", new Block(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_SCORCHED_TITANIUM_BLOCK = RegisterBlockItem("frozen_scorched_titanium_block", new Block(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_BURNT_TITANIUM_BLOCK = RegisterBlockItem("frozen_burnt_titanium_block", new Block(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_TITANIUM_SLAB = RegisterBlockItem("frozen_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

	public static final Block FROZEN_SEARED_TITANIUM_SLAB = RegisterBlockItem("frozen_seared_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_SINGED_TITANIUM_SLAB = RegisterBlockItem("frozen_singed_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_SCORCHED_TITANIUM_SLAB = RegisterBlockItem("frozen_scorched_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_BURNT_TITANIUM_SLAB = RegisterBlockItem("frozen_burnt_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_TITANIUM_STAIRS = RegisterBlockItem("frozen_titanium_stairs", new StairsBlock(TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)));

	public static final Block FROZEN_SEARED_TITANIUM_STAIRS = RegisterBlockItem("frozen_seared_titanium_stairs", new StairsBlock(TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_SINGED_TITANIUM_STAIRS = RegisterBlockItem("frozen_singed_titanium_stairs", new StairsBlock(TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_SCORCHED_TITANIUM_STAIRS = RegisterBlockItem("frozen_scorched_titanium_stairs", new StairsBlock(TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block FROZEN_BURNT_TITANIUM_STAIRS = RegisterBlockItem("frozen_burnt_titanium_stairs", new StairsBlock(TITANIUM_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(TITANIUM_BLOCK)));

	public static final Block ETHEREAL_TORCH = RegisterBlock("ethereal_torch", new UnderwaterTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH), CoreAscensionParticles.ETHEREAL_FLAME));

	public static final Block ETHEREAL_WALL_TORCH = RegisterBlock("ethereal_wall_torch", new UnderwaterWallTorchBlock(FabricBlockSettings.copyOf(ETHEREAL_TORCH), CoreAscensionParticles.ETHEREAL_FLAME));

	public static final Block BLAZE_BRICK = RegisterBlockItem("blaze_brick",new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(15)));

	public static final Block REINFORCED_CHEST = RegisterBlockItem("reinforced_chest", new GemPolishingStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

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
	// end cedar grove stuff
	// tropics stuff
	public static final Block TROPICS_LOG = RegisterBlockItem("tropics_log.json", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
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
	// end dread stuff

    private static Block RegisterBlockItem(String name, Block block) {
        RegisterItem(name,block);
        return RegisterBlock(name,block);
    }
	private static Block RegisterBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK,new Identifier(CoreAscension.MOD_ID,name),block);
    }
    private static void RegisterItem(String name, Block block){
		Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID,name),new BlockItem(block,new FabricItemSettings()));
	}
    public static void RegisterBlocks(){
		CoreAscension.LOGGER.info("Registering Blocks for " + CoreAscension.MOD_ID);
    }
	public static void ClientRegisterBlocks(){
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ARGON_CRYSTAL_CLUSTER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.AMETHYST_GEM_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.REINFORCED_GLASS, RenderLayer.getCutout());
	}
}
