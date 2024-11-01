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

	public static final Block AMETHYST_BLOCK = RegisterBlockItem("amethyst_block", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

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
	}
}
