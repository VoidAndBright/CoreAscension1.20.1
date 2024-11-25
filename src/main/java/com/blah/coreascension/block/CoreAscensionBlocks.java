package com.blah.coreascension.block;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.blocks.Anodizable.AnodizationLevel;
import com.blah.coreascension.block.blocks.*;
import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import com.blah.coreascension.effects.CoreAscensionStatusEffects;
import com.blah.coreascension.fluid.CoreAscensionFluids;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.sound.CoreAscensionSounds;
import com.blah.coreascension.world.feature.CoreAscensionConfiguredFeatureKeys;
import com.blah.coreascension.world.tree.MegaTreeSaplingGenerator;
import com.blah.coreascension.world.tree.TreeSaplingGenerator;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CoreAscensionBlocks
{
    public static final Block END_GAS = RegisterBlock("end_gas", new FluidBlock(CoreAscensionFluids.STILL_END_GAS, FabricBlockSettings.copy(Blocks.WATER)));
    public static final Block MOLTEN_ICE = RegisterBlock("molten_ice", new FluidBlock(CoreAscensionFluids.STILL_MOLTEN_ICE, FabricBlockSettings.copy(Blocks.WATER).ticksRandomly().luminance((state) -> 15))
    {
        @Override
        public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)
        {
            super.onEntityCollision(state, world, pos, entity);
            if (entity instanceof LivingEntity living)
            {
                if (living.hasStatusEffect(CoreAscensionStatusEffects.WARMTH))
                    return;
                if (!(living instanceof GhastEntity))
                {
                    living.addStatusEffect(new StatusEffectInstance(CoreAscensionStatusEffects.FREEZING, 120, 2));
                    living.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 4));
                }
            }
        }
    });
    public static final Block ACACIA_POST = RegisterBlockItem("acacia_post", new PostBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_FENCE).mapColor(MapColor.STONE_GRAY)));
    public static final Block SKYLANDS_PORTAL_BLOCK = RegisterBlock("skylands_portal", new SkylandsPortalBlock(FabricBlockSettings.copyOf(Blocks.NETHER_PORTAL).mapColor(MapColor.YELLOW)));
    public static final Block NETHER_CORE_PORTAL_BLOCK = RegisterBlock("nether_core_portal", new NetherCorePortalBlock(FabricBlockSettings.copyOf(Blocks.NETHER_PORTAL).mapColor(MapColor.CYAN)));
    public static final Block ACACIA_SECRET_DOOR = RegisterBlockItem("acacia_secret_door", new Block(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS).mapColor(MapColor.ORANGE).noCollision()));
    public static final Block AERO_LANTERN = RegisterBlockItem("aero_lantern", new Block(FabricBlockSettings.copyOf(Blocks.SEA_LANTERN).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PIGNEOUS_ROCK = RegisterBlockItem("pigneous_rock", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.PINK))
    {
        public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
        {
            super.onSteppedOn(world, pos, state, entity);
        }
    });


    public static final Block AMANITA_CAP = RegisterBlockItem("amanita_cap", new Block(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM_BLOCK).mapColor(MapColor.BRIGHT_RED)));
    public static final Block AMANITA_STEM = RegisterBlockItem("amanita_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.MUSHROOM_STEM).mapColor(MapColor.PALE_YELLOW)));
    public static final Block RUBY_GEM_LOG = RegisterBlockItem("ruby_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.RED)));
    public static final Block RUBY_GEM_LEAVES = RegisterBlockItem("ruby_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block CITRINE_GEM_LOG = RegisterBlockItem("citrine_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.ORANGE)));
    public static final Block CITRINE_GEM_LEAVES = RegisterBlockItem("citrine_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block TOPAZ_GEM_LOG = RegisterBlockItem("topaz_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.YELLOW)));
    public static final Block TOPAZ_GEM_LEAVES = RegisterBlockItem("topaz_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block EMERALD_GEM_LOG = RegisterBlockItem("emerald_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block EMERALD_GEM_LEAVES = RegisterBlockItem("emerald_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block DIAMOND_GEM_LOG = RegisterBlockItem("diamond_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block DIAMOND_GEM_LEAVES = RegisterBlockItem("diamond_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block SAPPHIRE_GEM_LOG = RegisterBlockItem("sapphire_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.BLUE)));
    public static final Block SAPPHIRE_GEM_LEAVES = RegisterBlockItem("sapphire_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block AMETHYST_GEM_LOG = RegisterBlockItem("amethyst_gem_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_GEM_LEAVES = RegisterBlockItem("amethyst_gem_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.STONE_GRAY)));
    public static final Block AMETHYST_SLAB = RegisterBlockItem("amethyst_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_STAIRS = RegisterBlockItem("amethyst_stairs", new StairsBlock(Blocks.AMETHYST_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_WALL = RegisterBlockItem("amethyst_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_TILES = RegisterBlockItem("amethyst_tiles", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block ANDESITE_TILE = RegisterBlockItem("andesite_tile", new Block(FabricBlockSettings.copyOf(Blocks.ANDESITE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DIORITE_TILE = RegisterBlockItem("diorite_tile", new Block(FabricBlockSettings.copyOf(Blocks.DIORITE).mapColor(MapColor.OFF_WHITE)));
    public static final Block GRANITE_TILE = RegisterBlockItem("granite_tile", new Block(FabricBlockSettings.copyOf(Blocks.GRANITE).mapColor(MapColor.DIRT_BROWN)));
    public static final Block ARGON_CRYSTAL_BLOCK = RegisterBlockItem("argon_crystal_block", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block ARGON_CRYSTAL_CLUSTER = RegisterBlockItem("argon_crystal_cluster", new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block ARGON_CRYSTAL_ORE = RegisterBlockItem("argon_crystal_ore", new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block SAPPHIRE_ORE = RegisterBlockItem("sapphire_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE), UniformIntProvider.create(4, 8)));
    public static final Block SAPPHIRE_BLOCK = RegisterBlockItem("sapphire_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.BLUE)));
    public static final Block SULPHUR_ORE = RegisterBlockItem("sulphur_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW), UniformIntProvider.create(17, 23)));
    public static final Block SULPHUR_BLOCK = RegisterBlockItem("sulphur_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.YELLOW)));
    // titanium blocks
    public static final Block TITANIUM_ORE = RegisterBlockItem("titanium_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block RAW_TITANIUM_BLOCK = RegisterBlockItem("raw_titanium_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block TITANIUM_BLOCK = RegisterBlockItem("titanium_block", new AnodizableBlock(AnodizationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHERITE).ticksRandomly()));
    public static final Block TITANIUM_SLAB = RegisterBlockItem("titanium_slab", new AnodizableSlabBlock(AnodizationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHERITE).ticksRandomly()));
    public static final Block TITANIUM_STAIRS = RegisterBlockItem("titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.UNAFFECTED, TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHERITE).ticksRandomly()));
    public static final Block SEARED_TITANIUM_STAIRS = RegisterBlockItem("seared_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.SEARED, TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(TITANIUM_STAIRS).mapColor(MapColor.ORANGE)));
    public static final Block SCORCHED_TITANIUM_STAIRS = RegisterBlockItem("scorched_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.SCORCHED, TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(TITANIUM_STAIRS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block BURNT_TITANIUM_STAIRS = RegisterBlockItem("burnt_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.BURNT, TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(TITANIUM_STAIRS).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block SEARED_TITANIUM_BLOCK = RegisterBlockItem("seared_titanium_block", new AnodizableBlock(AnodizationLevel.SEARED, FabricBlockSettings.copyOf(TITANIUM_BLOCK).mapColor(MapColor.ORANGE)));
    public static final Block SEARED_TITANIUM_SLAB = RegisterBlockItem("seared_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.SEARED, FabricBlockSettings.copyOf(TITANIUM_SLAB).mapColor(MapColor.ORANGE)));
    public static final Block SINGED_TITANIUM_BLOCK = RegisterBlockItem("singed_titanium_block", new AnodizableBlock(AnodizationLevel.SINGED, FabricBlockSettings.copyOf(TITANIUM_BLOCK).mapColor(MapColor.DIRT_BROWN)));
    public static final Block SINGED_TITANIUM_SLAB = RegisterBlockItem("singed_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.SINGED, FabricBlockSettings.copyOf(TITANIUM_SLAB).mapColor(MapColor.DIRT_BROWN)));
    public static final Block SINGED_TITANIUM_STAIRS = RegisterBlockItem("singed_titanium_stairs", new AnodizableStairsBlock(AnodizationLevel.SINGED, TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(TITANIUM_BLOCK).mapColor(MapColor.DIRT_BROWN)));
    public static final Block SCORCHED_TITANIUM_BLOCK = RegisterBlockItem("scorched_titanium_block", new AnodizableBlock(AnodizationLevel.SCORCHED, FabricBlockSettings.copyOf(TITANIUM_BLOCK).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block SCORCHED_TITANIUM_SLAB = RegisterBlockItem("scorched_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.SCORCHED, FabricBlockSettings.copyOf(TITANIUM_SLAB).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block BURNT_TITANIUM_BLOCK = RegisterBlockItem("burnt_titanium_block", new AnodizableBlock(AnodizationLevel.BURNT, FabricBlockSettings.copyOf(TITANIUM_BLOCK).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block BURNT_TITANIUM_SLAB = RegisterBlockItem("burnt_titanium_slab", new AnodizableSlabBlock(AnodizationLevel.BURNT, FabricBlockSettings.copyOf(TITANIUM_SLAB).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block FROZEN_TITANIUM_BLOCK = RegisterBlockItem("frozen_titanium_block", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.NETHERITE).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block FROZEN_SEARED_TITANIUM_BLOCK = RegisterBlockItem("frozen_seared_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK).mapColor(MapColor.ORANGE)));
    public static final Block FROZEN_SINGED_TITANIUM_BLOCK = RegisterBlockItem("frozen_singed_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK).mapColor(MapColor.DIRT_BROWN)));
    public static final Block FROZEN_SCORCHED_TITANIUM_BLOCK = RegisterBlockItem("frozen_scorched_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block FROZEN_BURNT_TITANIUM_BLOCK = RegisterBlockItem("frozen_burnt_titanium_block", new Block(FabricBlockSettings.copyOf(FROZEN_TITANIUM_BLOCK).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block FROZEN_TITANIUM_SLAB = RegisterBlockItem("frozen_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.CUT_COPPER_SLAB).sounds(BlockSoundGroup.NETHERITE).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block FROZEN_SEARED_TITANIUM_SLAB = RegisterBlockItem("frozen_seared_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB).mapColor(MapColor.ORANGE)));
    public static final Block FROZEN_SINGED_TITANIUM_SLAB = RegisterBlockItem("frozen_singed_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB).mapColor(MapColor.DIRT_BROWN)));
    public static final Block FROZEN_SCORCHED_TITANIUM_SLAB = RegisterBlockItem("frozen_scorched_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block FROZEN_BURNT_TITANIUM_SLAB = RegisterBlockItem("frozen_burnt_titanium_slab", new SlabBlock(FabricBlockSettings.copyOf(FROZEN_TITANIUM_SLAB).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block FROZEN_TITANIUM_STAIRS = RegisterBlockItem("frozen_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CUT_COPPER_STAIRS).mapColor(MapColor.LIGHT_GRAY).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block FROZEN_SEARED_TITANIUM_STAIRS = RegisterBlockItem("frozen_seared_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS).mapColor(MapColor.ORANGE)));
    public static final Block FROZEN_SINGED_TITANIUM_STAIRS = RegisterBlockItem("frozen_singed_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS).mapColor(MapColor.DIRT_BROWN)));
    public static final Block FROZEN_SCORCHED_TITANIUM_STAIRS = RegisterBlockItem("frozen_scorched_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block FROZEN_BURNT_TITANIUM_STAIRS = RegisterBlockItem("frozen_burnt_titanium_stairs", new StairsBlock(FROZEN_TITANIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(FROZEN_TITANIUM_STAIRS).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block BLAZE_BRICK = RegisterBlockItem("blaze_brick", new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(15).mapColor(MapColor.ORANGE)));
    // end titanium
    public static final Block REINFORCED_CHEST = RegisterBlockItem("reinforced_chest", new ReinforcedChestBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.BROWN)));
    public static final Block CATALYZER_TABLE = RegisterBlockItem("catalyzer", new CatalyzerTableBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    // uranium
    public static final Block URANIUM_ORE = RegisterBlockItem("uranium_ore", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.LIME)), new FabricItemSettings().fireproof());
    public static final Block RAW_URANIUM_BLOCK = RegisterBlockItem("raw_uranium_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.LIME)), new FabricItemSettings().fireproof());
    public static final Block URANIUM_BLOCK = RegisterBlockItem("uranium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.LIME)), new FabricItemSettings().fireproof());

    public static final Block RAW_LUMITE_BLOCK = RegisterBlockItem("raw_lumite_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.PURPLE)), new FabricItemSettings().fireproof());
    public static final Block LUMITE_BLOCK = RegisterBlockItem("lumite_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.PURPLE).hardness(5).resistance(1000)), new FabricItemSettings().fireproof());

    // cedar grove stuff
    public static final Block CEDAR_LOG = RegisterBlockItem("cedar_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.DULL_RED)));
    // end uranium
    public static final Block CEDAR_SAPLING = RegisterBlockItem("cedar_sapling", new SaplingBlock(new MegaTreeSaplingGenerator(CoreAscensionConfiguredFeatureKeys.CEDAR_TREE_KEY), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block CEDAR_WOOD = RegisterBlockItem("cedar_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.DULL_RED)));
    public static final Block CEDAR_PLANKS = RegisterBlockItem("cedar_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_RED)));
    public static final Block CEDAR_SLAB = RegisterBlockItem("cedar_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_RED)));
    public static final Block CEDAR_STAIRS = RegisterBlockItem("cedar_stairs", new StairsBlock(CEDAR_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(TITANIUM_BLOCK).mapColor(MapColor.TERRACOTTA_RED)));
    public static final Block CEDAR_FENCE = RegisterBlockItem("cedar_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_RED)));
    public static final Block CEDAR_FENCE_GATE = RegisterBlockItem("cedar_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.TERRACOTTA_RED), WoodType.OAK));
    public static final Block CEDAR_BUTTON = RegisterBlockItem("cedar_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.TERRACOTTA_RED), BlockSetType.OAK, 30, true));
    public static final Block CEDAR_LEAVES = RegisterBlockItem("cedar_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.DARK_GREEN)));
    public static final Block STRIPPED_CEDAR_LOG = RegisterBlockItem("stripped_cedar_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.DULL_RED)));
    public static final Block STRIPPED_CEDAR_WOOD = RegisterBlockItem("stripped_cedar_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.DULL_RED)));
    public static final Block CEDAR_DOOR = RegisterBlockItem("cedar_door", new DoorBlock(FabricBlockSettings.copyOf(CEDAR_PLANKS).nonOpaque().mapColor(MapColor.TERRACOTTA_RED), BlockSetType.OAK));
    public static final Block CEDAR_TRAPDOOR = RegisterBlockItem("cedar_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(CEDAR_PLANKS).nonOpaque().mapColor(MapColor.TERRACOTTA_RED), BlockSetType.OAK));
    public static final Identifier CEDAR_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/cedar");
    public static final Identifier CEDAR_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/cedar");
    public static final Identifier CEDAR_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/cedar");
    public static final Block STANDING_CEDAR_SIGN = RegisterBlock("cedar_sign",
            new TerraformSignBlock(CEDAR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_CEDAR_SIGN = RegisterBlock("cedar_wall_sign",
            new TerraformWallSignBlock(CEDAR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_CEDAR_SIGN = RegisterBlock("cedar_hanging_sign",
            new TerraformHangingSignBlock(CEDAR_HANGING_SIGN_TEXTURE, CEDAR_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_CEDAR_SIGN = RegisterBlock("cedar_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CEDAR_HANGING_SIGN_TEXTURE, CEDAR_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    // end cedar grove stuff
    // tropics stuff
    public static final Block TROPICS_LOG = RegisterBlockItem("tropics_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.SPRUCE_BROWN)));
    public static final Block TROPICS_WOOD = RegisterBlockItem("tropics_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.SPRUCE_BROWN)));
    public static final Block TROPICS_PLANKS = RegisterBlockItem("tropics_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block TROPICS_SLAB = RegisterBlockItem("tropics_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block TROPICS_STAIRS = RegisterBlockItem("tropics_stairs", new StairsBlock(TROPICS_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block TROPICS_FENCE = RegisterBlockItem("tropics_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block TROPICS_FENCE_GATE = RegisterBlockItem("tropics_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.TERRACOTTA_ORANGE), WoodType.OAK));
    public static final Block TROPICS_BUTTON = RegisterBlockItem("tropics_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.TERRACOTTA_ORANGE), BlockSetType.OAK, 30, true));
    public static final Block TROPICS_LEAVES = RegisterBlockItem("tropics_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.LIME)));
    public static final Block STRIPPED_TROPICS_LOG = RegisterBlockItem("stripped_tropics_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block STRIPPED_TROPICS_WOOD = RegisterBlockItem("stripped_tropics_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final Block BLACK_SAND = RegisterBlockItem("black_sand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.BLACK)));
    public static final Block BLACK_SANDSTONE = RegisterBlockItem("black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.BLACK)));
    public static final Block REINFORCED_GLASS = RegisterBlockItem("reinforced_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
    public static final Block REINFORCED_GLASS_PANE = RegisterBlockItem("reinforced_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(REINFORCED_GLASS)));
    public static final Block TROPICS_MUD = RegisterBlockItem("tropics_mud", new Block(FabricBlockSettings.copyOf(Blocks.MUD).mapColor(MapColor.ORANGE)));
    public static final Block CHISELED_BLACK_SANDSTONE = RegisterBlockItem("chiseled_black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.BLACK)));
    public static final Block SMOOTH_BLACK_SANDSTONE = RegisterBlockItem("smooth_black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.BLACK)));
    public static final Block CUT_BLACK_SANDSTONE = RegisterBlockItem("cut_black_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE).mapColor(MapColor.BLACK)));
    public static final Block LOAM = RegisterBlockItem("loam", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).mapColor(MapColor.ORANGE)));
    public static final Block CUT_BLACK_SANDSTONE_SLAB = RegisterBlockItem("cut_black_sandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB).mapColor(MapColor.BLACK)));
    public static final Block CUT_BLACK_SANDSTONE_STAIRS = RegisterBlockItem("cut_black_sandstone_stairs", new StairsBlock(BLACK_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.BLACK)));
    public static final Block TROPICS_MUD_BRICKS = RegisterBlockItem("tropics_mud_bricks", new Block(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).mapColor(MapColor.ORANGE)));
    public static final Block TROPICS_MUD_BRICK_SLAB = RegisterBlockItem("tropics_mud_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).mapColor(MapColor.ORANGE)));
    public static final Block TROPICS_MUD_BRICK_STAIRS = RegisterBlockItem("tropics_mud_brick_stairs", new StairsBlock(TROPICS_MUD_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.MUD_BRICKS).mapColor(MapColor.ORANGE)));
    public static final Block TROPICS_DOOR = RegisterBlockItem("tropics_door", new DoorBlock(FabricBlockSettings.copyOf(TROPICS_PLANKS).nonOpaque().mapColor(MapColor.TERRACOTTA_ORANGE), BlockSetType.OAK));
    public static final Block TROPICS_TRAPDOOR = RegisterBlockItem("tropics_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(TROPICS_PLANKS).nonOpaque().mapColor(MapColor.TERRACOTTA_ORANGE), BlockSetType.OAK));
    public static final Block TROPICS_SAPLING = RegisterBlockItem("tropics_sapling", new SaplingBlock(new TreeSaplingGenerator(CoreAscensionConfiguredFeatureKeys.TROPICS_TREE_KEY), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)) {
        protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {return floor.isIn(BlockTags.SAND);}
    });
    public static final Block TROPICAL_GRASS = RegisterBlockItem("tropical_grass", new AnySpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).mapColor(MapColor.LIME).ticksRandomly(), LOAM));
    public static final Identifier TROPICS_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/tropics");
    public static final Identifier TROPICS_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/tropics");
    public static final Identifier TROPICS_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/tropics");
    public static final Block STANDING_TROPICS_SIGN = RegisterBlock("tropics_sign",
            new TerraformSignBlock(TROPICS_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_TROPICS_SIGN = RegisterBlock("tropics_wall_sign",
            new TerraformWallSignBlock(TROPICS_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_TROPICS_SIGN = RegisterBlock("tropics_hanging_sign",
            new TerraformHangingSignBlock(TROPICS_HANGING_SIGN_TEXTURE, TROPICS_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_TROPICS_SIGN = RegisterBlock("tropics_wall_hanging_sign",
            new TerraformWallHangingSignBlock(TROPICS_HANGING_SIGN_TEXTURE, TROPICS_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    // whitewood
    public static final Block WHITEWOOD_LOG = RegisterBlockItem("whitewood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_WOOD = RegisterBlockItem("whitewood_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_PLANKS = RegisterBlockItem("whitewood_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_SLAB = RegisterBlockItem("whitewood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_STAIRS = RegisterBlockItem("whitewood_stairs", new StairsBlock(WHITEWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_FENCE = RegisterBlockItem("whitewood_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_FENCE_GATE = RegisterBlockItem("whitewood_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.OFF_WHITE), WoodType.OAK));
    public static final Block WHITEWOOD_BUTTON = RegisterBlockItem("whitewood_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.OFF_WHITE), BlockSetType.OAK, 30, true));
    public static final Block WHITEWOOD_LEAVES = RegisterBlockItem("whitewood_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.OFF_WHITE)));
    public static final Block STRIPPED_WHITEWOOD_LOG = RegisterBlockItem("stripped_whitewood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block STRIPPED_WHITEWOOD_WOOD = RegisterBlockItem("stripped_whitewood_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block WHITEWOOD_DOOR = RegisterBlockItem("whitewood_door", new DoorBlock(FabricBlockSettings.copyOf(WHITEWOOD_PLANKS).nonOpaque().mapColor(MapColor.OFF_WHITE), BlockSetType.OAK));
    public static final Block WHITEWOOD_TRAPDOOR = RegisterBlockItem("whitewood_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(WHITEWOOD_PLANKS).nonOpaque().mapColor(MapColor.OFF_WHITE), BlockSetType.OAK));
    public static final Identifier WHITEWOOD_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/whitewood");
    public static final Identifier WHITEWOOD_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/whitewood");
    public static final Identifier WHITEWOOD_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/whitewood");
    public static final Block STANDING_WHITEWOOD_SIGN = RegisterBlock("whitewood_sign",
            new TerraformSignBlock(WHITEWOOD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_WHITEWOOD_SIGN = RegisterBlock("whitewood_wall_sign",
            new TerraformWallSignBlock(WHITEWOOD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_WHITEWOOD_SIGN = RegisterBlock("whitewood_hanging_sign",
            new TerraformHangingSignBlock(WHITEWOOD_HANGING_SIGN_TEXTURE, WHITEWOOD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_WHITEWOOD_SIGN = RegisterBlock("whitewood_wall_hanging_sign",
            new TerraformWallHangingSignBlock(WHITEWOOD_HANGING_SIGN_TEXTURE, WHITEWOOD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final Block SEASHELL = RegisterBlockItem("seashell", new SeashellBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK).nonOpaque().mapColor(MapColor.PALE_YELLOW)));
    // end whitewood
    public static final Block CONCH_SHELL = RegisterBlockItem("conch_shell", new ConchShellBlock(FabricBlockSettings.copyOf(Blocks.DRIPSTONE_BLOCK).nonOpaque().mapColor(MapColor.PALE_YELLOW)));
    // cactus wood
    public static final Block CACTUS_PLANKS = RegisterBlockItem("cactus_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS)));
    // end tropics stuff
    public static final Block CACTUS_SLAB = RegisterBlockItem("cactus_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS)));
    public static final Block CACTUS_STAIRS = RegisterBlockItem("cactus_stairs", new StairsBlock(CACTUS_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS)));
    public static final Block CACTUS_FENCE = RegisterBlockItem("cactus_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS)));
    public static final Block CACTUS_FENCE_GATE = RegisterBlockItem("cactus_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS), WoodType.OAK));
    public static final Block CACTUS_BUTTON = RegisterBlockItem("cactus_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS), BlockSetType.OAK, 30, true));
    public static final Block CACTUS_DOOR = RegisterBlockItem("cactus_door", new DoorBlock(FabricBlockSettings.copyOf(CACTUS_PLANKS).nonOpaque().mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS), BlockSetType.OAK));
    public static final Block CACTUS_TRAPDOOR = RegisterBlockItem("cactus_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(CACTUS_PLANKS).nonOpaque().mapColor(MapColor.PALE_GREEN).sounds(CoreAscensionSounds.CACTUS_PLANKS_SOUNDS), BlockSetType.OAK));
    public static final Identifier CACTUS_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/cactus");
    public static final Identifier CACTUS_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/cactus");
    public static final Identifier CACTUS_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/cactus");
    public static final Block STANDING_CACTUS_SIGN = RegisterBlock("cactus_sign",
            new TerraformSignBlock(CACTUS_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_CACTUS_SIGN = RegisterBlock("cactus_wall_sign",
            new TerraformWallSignBlock(CACTUS_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_CACTUS_SIGN = RegisterBlock("cactus_hanging_sign",
            new TerraformHangingSignBlock(CACTUS_HANGING_SIGN_TEXTURE, CACTUS_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_CACTUS_SIGN = RegisterBlock("cactus_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CACTUS_HANGING_SIGN_TEXTURE, CACTUS_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    // dread stuff
    public static final Block DREAD_LOG = RegisterBlockItem("dread_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.LICHEN_GREEN)));
    // end cactus
    public static final Block DREAD_WOOD = RegisterBlockItem("dread_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_PLANKS = RegisterBlockItem("dread_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_SLAB = RegisterBlockItem("dread_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_STAIRS = RegisterBlockItem("dread_stairs", new StairsBlock(DREAD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_FENCE = RegisterBlockItem("dread_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_FENCE_GATE = RegisterBlockItem("dread_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.LICHEN_GREEN), WoodType.OAK));
    public static final Block DREAD_BUTTON = RegisterBlockItem("dread_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.LICHEN_GREEN), BlockSetType.OAK, 30, true));
    public static final Block STRIPPED_DREAD_LOG = RegisterBlockItem("stripped_dread_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block STRIPPED_DREAD_WOOD = RegisterBlockItem("stripped_dread_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_SAND = RegisterBlockItem("dread_sand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_SANDSTONE = RegisterBlockItem("dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block BORDERLESS_GLASS = RegisterBlockItem("borderless_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
    public static final Block BORDERLESS_GLASS_PANE = RegisterBlockItem("borderless_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(BORDERLESS_GLASS)));
    public static final Block DREAD_ROCK = RegisterBlockItem("dread_rock", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DARK_GREEN)));
    public static final Block CHISELED_DREAD_SANDSTONE = RegisterBlockItem("chiseled_dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block SMOOTH_DREAD_SANDSTONE = RegisterBlockItem("smooth_dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block CUT_DREAD_SANDSTONE = RegisterBlockItem("cut_dread_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block CUT_DREAD_SANDSTONE_SLAB = RegisterBlockItem("cut_dread_sandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block CUT_DREAD_SANDSTONE_STAIRS = RegisterBlockItem("cut_dread_sandstone_stairs", new StairsBlock(DREAD_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.LICHEN_GREEN)));
    public static final Block DREAD_ROCK_BRICKS = RegisterBlockItem("dread_rock_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).mapColor(MapColor.DARK_GREEN)));
    public static final Block DREAD_DOOR = RegisterBlockItem("dread_door", new DoorBlock(FabricBlockSettings.copyOf(DREAD_PLANKS).nonOpaque().mapColor(MapColor.LICHEN_GREEN), BlockSetType.OAK));
    public static final Block DREAD_TRAPDOOR = RegisterBlockItem("dread_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(DREAD_PLANKS).nonOpaque().mapColor(MapColor.LICHEN_GREEN), BlockSetType.OAK));
    public static final Block DREAD_POST = RegisterBlockItem("dread_post", new PostBlock(FabricBlockSettings.copyOf(DREAD_FENCE).mapColor(MapColor.LICHEN_GREEN)));// end dread
    public static final Identifier DREAD_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/dread");
    public static final Identifier DREAD_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/dread");
    public static final Identifier DREAD_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/dread");
    public static final Block STANDING_DREAD_SIGN = RegisterBlock("dread_sign",
            new TerraformSignBlock(DREAD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_DREAD_SIGN = RegisterBlock("dread_wall_sign",
            new TerraformWallSignBlock(DREAD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_DREAD_SIGN = RegisterBlock("dread_hanging_sign",
            new TerraformHangingSignBlock(DREAD_HANGING_SIGN_TEXTURE, DREAD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_DREAD_SIGN = RegisterBlock("dread_wall_hanging_sign",
            new TerraformWallHangingSignBlock(DREAD_HANGING_SIGN_TEXTURE, DREAD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    // skylands
    // ancient biome
    public static final Block BONESAND = RegisterBlockItem("bonesand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.PALE_YELLOW)));
    public static final Block BONESANDSTONE = RegisterBlockItem("bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CHISELED_BONESANDSTONE = RegisterBlockItem("chiseled_bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block SMOOTH_BONESANDSTONE = RegisterBlockItem("smooth_bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CUT_BONESANDSTONE = RegisterBlockItem("cut_bonesandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CUT_BONESANDSTONE_SLAB = RegisterBlockItem("cut_bonesandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CUT_BONESANDSTONE_STAIRS = RegisterBlockItem("cut_bonesandstone_stairs", new StairsBlock(BONESANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.PALE_YELLOW)));
    // ethereal glade
    public static final Block ETHEREAL_TORCH = RegisterBlock("ethereal_torch", new UnderwaterTorchBlock(FabricBlockSettings.copyOf(Blocks.TORCH), CoreAscensionParticles.ETHEREAL_FLAME));
    // end ancient
    public static final Block ETHEREAL_WALL_TORCH = RegisterBlock("ethereal_wall_torch", new UnderwaterWallTorchBlock(FabricBlockSettings.copyOf(ETHEREAL_TORCH), CoreAscensionParticles.ETHEREAL_FLAME));
    public static final Block ETHEREAL_DIRT = RegisterBlockItem("ethereal_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_LOG = RegisterBlockItem("ethereal_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.STONE_GRAY)));
    public static final Block ETHEREAL_WOOD = RegisterBlockItem("ethereal_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.STONE_GRAY)));
    public static final Block ETHEREAL_PLANKS = RegisterBlockItem("ethereal_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_SLAB = RegisterBlockItem("ethereal_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_STAIRS = RegisterBlockItem("ethereal_stairs", new StairsBlock(ETHEREAL_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_FENCE = RegisterBlockItem("ethereal_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_FENCE_GATE = RegisterBlockItem("ethereal_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.BLUE), WoodType.OAK));
    public static final Block ETHEREAL_BUTTON = RegisterBlockItem("ethereal_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).mapColor(MapColor.BLUE), BlockSetType.OAK, 30, true));
    public static final Block ETHEREAL_LEAVES = RegisterBlockItem("ethereal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.CYAN)));
    public static final Block STRIPPED_ETHEREAL_LOG = RegisterBlockItem("stripped_ethereal_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block STRIPPED_ETHEREAL_WOOD = RegisterBlockItem("stripped_ethereal_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_DOOR = RegisterBlockItem("ethereal_door", new DoorBlock(FabricBlockSettings.copyOf(ETHEREAL_PLANKS).nonOpaque().mapColor(MapColor.BLUE), BlockSetType.OAK));
    public static final Block ETHEREAL_TRAPDOOR = RegisterBlockItem("ethereal_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(ETHEREAL_PLANKS).nonOpaque().mapColor(MapColor.BLUE), BlockSetType.OAK));
    public static final Block ETHEREAL_MEMBRANE = RegisterBlockItem("ethereal_membrane", new SlimeBlock(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK).mapColor(MapColor.BLUE)));
    public static final Block ETHEREAL_GRASS = RegisterBlockItem("ethereal_grass", new AnySpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).mapColor(MapColor.CYAN).ticksRandomly(), ETHEREAL_DIRT));
    public static final Identifier ETHEREAL_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/ethereal");
    public static final Identifier ETHEREAL_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/ethereal");
    public static final Identifier ETHEREAL_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/ethereal");
    public static final Block STANDING_ETHEREAL_SIGN = RegisterBlock("ethereal_sign",
            new TerraformSignBlock(ETHEREAL_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_ETHEREAL_SIGN = RegisterBlock("ethereal_wall_sign",
            new TerraformWallSignBlock(ETHEREAL_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_ETHEREAL_SIGN = RegisterBlock("ethereal_hanging_sign",
            new TerraformHangingSignBlock(ETHEREAL_HANGING_SIGN_TEXTURE, ETHEREAL_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_ETHEREAL_SIGN = RegisterBlock("ethereal_wall_hanging_sign",
            new TerraformWallHangingSignBlock(ETHEREAL_HANGING_SIGN_TEXTURE, ETHEREAL_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final Block RAINBOW_MUSHROOM = RegisterBlockItem("rainbow_mushroom", new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).mapColor(MapColor.WHITE), null));
    // end ethereal glade

    // cakewood
    public static final Block CAKESOIL = RegisterBlockItem("cakesoil", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).mapColor(MapColor.ORANGE)));
    public static final Block CAKEWOOD_LOG = RegisterBlockItem("cakewood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.WHITE)));
    public static final Block CAKEWOOD_WOOD = RegisterBlockItem("cakewood_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.WHITE)));
    public static final Block CAKEWOOD_PLANKS = RegisterBlockItem("cakewood_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.ORANGE)));
    public static final Block CAKEWOOD_SLAB = RegisterBlockItem("cakewood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.ORANGE)));
    public static final Block CAKEWOOD_STAIRS = RegisterBlockItem("cakewood_stairs", new StairsBlock(CAKEWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.ORANGE)));
    public static final Block CAKEWOOD_FENCE = RegisterBlockItem("cakewood_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.ORANGE)));
    public static final Block CAKEWOOD_FENCE_GATE = RegisterBlockItem("cakewood_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.ORANGE), WoodType.OAK));
    public static final Block CAKEWOOD_BUTTON = RegisterBlockItem("cakewood_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
    public static final Block RED_POPSICLE_LEAVES = RegisterBlockItem("red_popsicle_leaves", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(MapColor.RED)));
    public static final Block BLUE_POPSICLE_LEAVES = RegisterBlockItem("blue_popsicle_leaves", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(MapColor.BLUE)));
    public static final Block WHITE_POPSICLE_LEAVES = RegisterBlockItem("white_popsicle_leaves", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).mapColor(MapColor.WHITE)));
    public static final Block STRIPPED_CAKEWOOD_LOG = RegisterBlockItem("stripped_cakewood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.ORANGE)));
    public static final Block STRIPPED_CAKEWOOD_WOOD = RegisterBlockItem("stripped_cakewood_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.ORANGE)));
    public static final Block CAKEWOOD_DOOR = RegisterBlockItem("cakewood_door", new DoorBlock(FabricBlockSettings.copyOf(CAKEWOOD_PLANKS).nonOpaque().mapColor(MapColor.ORANGE), BlockSetType.OAK));
    public static final Block CAKEWOOD_TRAPDOOR = RegisterBlockItem("cakewood_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(CAKEWOOD_PLANKS).nonOpaque().mapColor(MapColor.ORANGE), BlockSetType.OAK));
    public static final Block FROSTING_GRASS = RegisterBlockItem("frosting_grass", new AnySpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).ticksRandomly().mapColor(MapColor.TERRACOTTA_PINK), CAKESOIL));
    public static final Identifier CAKEWOOD_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/cakewood");
    public static final Identifier CAKEWOOD_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/cakewood");
    public static final Identifier CAKEWOOD_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/cakewood");
    public static final Block STANDING_CAKEWOOD_SIGN = RegisterBlock("cakewood_sign",
            new TerraformSignBlock(CAKEWOOD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_CAKEWOOD_SIGN = RegisterBlock("cakewood_wall_sign",
            new TerraformWallSignBlock(CAKEWOOD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_CAKEWOOD_SIGN = RegisterBlock("cakewood_hanging_sign",
            new TerraformHangingSignBlock(CAKEWOOD_HANGING_SIGN_TEXTURE, CAKEWOOD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_CAKEWOOD_SIGN = RegisterBlock("cakewood_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CAKEWOOD_HANGING_SIGN_TEXTURE, CAKEWOOD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    public static final Block RED_GUMDROP = RegisterBlockItem("red_gumdrop", new GlassBlock(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK).mapColor(MapColor.RED)));
    public static final Block YELLOW_GUMDROP = RegisterBlockItem("yellow_gumdrop", new GlassBlock(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block GREEN_GUMDROP = RegisterBlockItem("green_gumdrop", new GlassBlock(FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK).mapColor(MapColor.GREEN)));
    // end cakewood

    // dark matter
    public static final Block DARK_MATTER_STONE = RegisterBlockItem("dark_matter_stone", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).mapColor(MapColor.BLACK).sounds(CoreAscensionSounds.DARK_MATTER_STONE_SOUNDS)));
    public static final Block DARK_MATTER_LOG = RegisterBlockItem("dark_matter_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_PURPLE).sounds(CoreAscensionSounds.DARK_MATTER_WOOD_SOUNDS)));
    public static final Block DARK_MATTER_WOOD = RegisterBlockItem("dark_matter_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_PURPLE).sounds(CoreAscensionSounds.DARK_MATTER_WOOD_SOUNDS)));
    public static final Block DARK_MATTER_PLANKS = RegisterBlockItem("dark_matter_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PURPLE)));
    public static final Block DARK_MATTER_SLAB = RegisterBlockItem("dark_matter_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.PURPLE)));
    public static final Block DARK_MATTER_STAIRS = RegisterBlockItem("dark_matter_stairs", new StairsBlock(DARK_MATTER_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PURPLE)));
    public static final Block DARK_MATTER_FENCE = RegisterBlockItem("dark_matter_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.PURPLE)));
    public static final Block DARK_MATTER_FENCE_GATE = RegisterBlockItem("dark_matter_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.PURPLE), WoodType.OAK));
    public static final Block DARK_MATTER_BUTTON = RegisterBlockItem("dark_matter_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
    public static final Block DARK_MATTER_LEAVES = RegisterBlockItem("dark_matter_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.PALE_PURPLE)));
    public static final Block STRIPPED_DARK_MATTER_LOG = RegisterBlockItem("stripped_dark_matter_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_PURPLE).sounds(CoreAscensionSounds.DARK_MATTER_WOOD_SOUNDS)));
    public static final Block STRIPPED_DARK_MATTER_WOOD = RegisterBlockItem("stripped_dark_matter_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_PURPLE).sounds(CoreAscensionSounds.DARK_MATTER_WOOD_SOUNDS)));
    public static final Block DARK_MATTER_DOOR = RegisterBlockItem("dark_matter_door", new DoorBlock(FabricBlockSettings.copyOf(DARK_MATTER_PLANKS).nonOpaque().mapColor(MapColor.PURPLE), BlockSetType.OAK));
    public static final Block DARK_MATTER_TRAPDOOR = RegisterBlockItem("dark_matter_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(DARK_MATTER_PLANKS).nonOpaque().mapColor(MapColor.PURPLE), BlockSetType.OAK));
    public static final Block MOSSY_DARK_MATTER_STONE = RegisterBlockItem("mossy_dark_matter_stone", new AnySpreadableBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).mapColor(MapColor.TERRACOTTA_PURPLE).ticksRandomly().sounds(BlockSoundGroup.HONEY), DARK_MATTER_STONE));
    public static final Identifier DARK_MATTER_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/dark_matter");
    public static final Identifier DARK_MATTER_HANGING_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "entity/signs/hanging/dark_matter");
    public static final Identifier DARK_MATTER_HANGING_GUI_SIGN_TEXTURE = new Identifier(CoreAscension.MOD_ID, "textures/gui/hanging_signs/dark_matter");
    public static final Block STANDING_DARK_MATTER_SIGN = RegisterBlock("dark_matter_sign",
            new TerraformSignBlock(DARK_MATTER_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_DARK_MATTER_SIGN = RegisterBlock("dark_matter_wall_sign",
            new TerraformWallSignBlock(DARK_MATTER_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_DARK_MATTER_SIGN = RegisterBlock("dark_matter_hanging_sign",
            new TerraformHangingSignBlock(DARK_MATTER_HANGING_SIGN_TEXTURE, DARK_MATTER_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_DARK_MATTER_SIGN = RegisterBlock("dark_matter_wall_hanging_sign",
            new TerraformWallHangingSignBlock(DARK_MATTER_HANGING_SIGN_TEXTURE, DARK_MATTER_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));
    // end dark matter

    // ores and stone
    public static final Block CLOUD_STONE = RegisterBlockItem("cloud_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block CLOUD_COAL_ORE = RegisterBlockItem("cloud_coal_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).mapColor(MapColor.BLACK), UniformIntProvider.create(0, 2)));
    public static final Block CLOUD_IRON_ORE = RegisterBlockItem("cloud_iron_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).mapColor(MapColor.RAW_IRON_PINK)));
    public static final Block CLOUD_GOLD_ORE = RegisterBlockItem("cloud_gold_ore", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).mapColor(MapColor.YELLOW)));
    public static final Block CLOUD_DIAMOND_ORE = RegisterBlockItem("cloud_diamond_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.DIAMOND_BLUE), UniformIntProvider.create(3, 7)));
    public static final Block CLOUD_EMERALD_ORE = RegisterBlockItem("cloud_emerald_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE).mapColor(MapColor.EMERALD_GREEN), UniformIntProvider.create(3, 7)));
    public static final Block MOONSTONE = RegisterBlockItem("moonstone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.LIGHT_GRAY)));
    // end ores and stone

    // prismaero
    public static final Block PRISMAERO = RegisterBlockItem("prismaero", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_PRISMAERO = RegisterBlockItem("polished_prismaero", new Block(FabricBlockSettings.copyOf(PRISMAERO).mapColor(MapColor.PALE_YELLOW)));
    public static final Block GOLD_PRISMAERO = RegisterBlockItem("gold_prismaero", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).mapColor(MapColor.YELLOW)));
    public static final Block PRISMAERO_BRICKS = RegisterBlockItem("prismaero_bricks", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PRISMAERO_PILLAR = RegisterBlockItem("prismaero_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PRISMAERO_SLAB = RegisterBlockItem("prismaero_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB).mapColor(MapColor.PALE_YELLOW)));
    public static final Block GOLDEN_PRISMAERO_SLAB = RegisterBlockItem("golden_prismaero_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB).mapColor(MapColor.YELLOW)));
    public static final Block PRISMAERO_BRICKS_SLAB = RegisterBlockItem("prismaero_bricks_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_PRISMAERO_SLAB = RegisterBlockItem("polished_prismaero_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_SLAB).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PRISMAERO_STAIRS = RegisterBlockItem("prismaero_stairs", new StairsBlock(PRISMAERO.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS).mapColor(MapColor.PALE_YELLOW)));
    public static final Block GOLDEN_PRISMAERO_STAIRS = RegisterBlockItem("golden_prismaero_stairs", new StairsBlock(PRISMAERO.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS).mapColor(MapColor.YELLOW)));
    public static final Block PRISMAERO_BRICKS_STAIRS = RegisterBlockItem("prismaero_bricks_stairs", new StairsBlock(PRISMAERO.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_PRISMAERO_STAIRS = RegisterBlockItem("polished_prismaero_stairs", new StairsBlock(PRISMAERO.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PRISMARINE_STAIRS).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PRISMAERO_WALL = RegisterBlockItem("prismaero_wall", new WallBlock(FabricBlockSettings.copyOf(PRISMAERO).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CHISELED_PRISMAERO = RegisterBlockItem("chiseled_prismaero", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PRISMAERO_SPAWNER = RegisterBlockItem("prismaero_spawner", new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE).mapColor(MapColor.PALE_YELLOW)) {
        public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
        {
            // ADD PROTECTOR SPAWNING (for later)
            super.onSteppedOn(world, pos, state, entity);
        }
    });
    // end prismaero
    // end skylands

    // misc blocks
    public static final Block HARDENED_LAVA = RegisterBlockItem("hardened_lava", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE).luminance(6)));
    public static final Block PLAYER_LAUNCHER = RegisterBlockItem("player_launcher", new PlayerLauncherBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.STONE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block DARK_MATTER_GEL_BLOCK = RegisterBlockItem("dark_matter_gel_block", new Block(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block DIAMOND_DOOR = RegisterBlockItem("diamond_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).nonOpaque().mapColor(MapColor.CYAN), BlockSetType.STONE));
    public static final Block DIAMOND_TRAPDOOR = RegisterBlockItem("diamond_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).nonOpaque().mapColor(MapColor.CYAN), BlockSetType.STONE));

    public static final Block CEMENT = RegisterBlockItem("cement", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block IMPERVIOUS_BRICK = RegisterBlockItem("impervious_brick", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.BLACK)));
    public static final Block COCONUT = RegisterBlockItem("coconut", new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_BROWN).nonOpaque())
    {
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
        {
            return Block.createCuboidShape(3, 3, 3, 13, 13, 13);
        }
    });

    public static final Block ENCHANTMENT_RELOCATOR = RegisterBlockItem("enchantment_relocator", new EnchantmentRelocatorBlock(FabricBlockSettings.copyOf(Blocks.ENCHANTING_TABLE).nonOpaque().mapColor(MapColor.BRIGHT_RED)));

    public static final Block MOSSY_END_STONE_BRICKS = RegisterBlockItem("mossy_end_stone_bricks", new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(MapColor.PALE_PURPLE)));
    public static final Block MAGMA_ROCK_BRICKS = RegisterBlockItem("magma_rock_bricks", new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(MapColor.PALE_PURPLE)));
    public static final Block SUS_BRAIN_CORAL_BLOCK = RegisterBlockItem("sus_brain_coral_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F).mapColor(MapColor.TERRACOTTA_PINK)));
    public static final Block SUS_BUBBLE_CORAL_BLOCK = RegisterBlockItem("sus_bubble_coral_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F).mapColor(MapColor.PINK)));
    public static final Block SUS_FIRE_CORAL_BLOCK = RegisterBlockItem("sus_fire_coral_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F).mapColor(MapColor.BRIGHT_RED)));
    public static final Block SUS_HORN_CORAL_BLOCK = RegisterBlockItem("sus_horn_coral_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F).mapColor(MapColor.YELLOW)));
    public static final Block SUS_TUBE_CORAL_BLOCK = RegisterBlockItem("sus_tube_coral_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F).mapColor(MapColor.BLUE)));
    public static final Block COMPACT_STONE = RegisterBlockItem("compact_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.STONE_GRAY).resistance(5)));
    public static final Block POLISHED_PRISMARINE = RegisterBlockItem("polished_prismarine", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block CHISELED_BRICKS = RegisterBlockItem("chiseled_brick", new Block(FabricBlockSettings.copyOf(Blocks.BRICKS)));
    public static final Block GLASS_DOOR = RegisterBlockItem("glass_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque().mapColor(MapColor.CLEAR), BlockSetType.STONE));
    public static final Block GLASS_TRAPDOOR = RegisterBlockItem("glass_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque().mapColor(MapColor.CLEAR), BlockSetType.STONE));



    public static final Block PRISMAERO_FURNACE = RegisterBlockItem("prismaero_furnace", new PrismaeroFurnaceBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block PETRIFIED_WOOD = RegisterBlockItem("petrified_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block PETRIFIED_WOOD_WALL = RegisterBlockItem("petrified_wood_wall", new WallBlock(FabricBlockSettings.copyOf(PETRIFIED_WOOD).mapColor(MapColor.STONE_GRAY)));
    public static final Block PETRIFIED_PLANKS = RegisterBlockItem("petrified_planks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block PETRIFIED_PLANKS_WALL = RegisterBlockItem("petrified_planks_wall", new WallBlock(FabricBlockSettings.copyOf(PETRIFIED_WOOD).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block PETRIFIED_PLANKS_SLAB = RegisterBlockItem("petrified_planks_slab", new SlabBlock(FabricBlockSettings.copyOf(PETRIFIED_PLANKS).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block PETRIFIED_PLANKS_STAIRS = RegisterBlockItem("petrified_planks_stairs", new StairsBlock(PETRIFIED_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(PETRIFIED_PLANKS).mapColor(MapColor.LIGHT_GRAY)));

    public static final Block ENDER_PEARL_BRICKS = RegisterBlockItem("ender_pearl_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DARK_AQUA)));
    // end misc blocks

    // stone variants
    public static final Block IGNEOUS_ROCK = RegisterBlockItem("igneous_rock", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block SALTROCK = RegisterBlockItem("saltrock", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.PALE_YELLOW)));
    public static final Block MAGNETITE = RegisterBlockItem("magnetite", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIMESTONE = RegisterBlockItem("limestone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block POLISHED_IGNEOUS_ROCK = RegisterBlockItem("polished_igneous_rock", new Block(FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block POLISHED_SALTROCK = RegisterBlockItem("polished_saltrock", new Block(FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_MAGNETITE = RegisterBlockItem("polished_magnetite", new Block(FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block POLISHED_LIMESTONE = RegisterBlockItem("polished_limestone", new Block(FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block IGNEOUS_ROCK_TILES = RegisterBlockItem("igneous_rock_tiles", new Block(FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block SALTROCK_TILES = RegisterBlockItem("saltrock_tiles", new Block(FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block MAGNETITE_TILES = RegisterBlockItem("magnetite_tiles", new Block(FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIMESTONE_TILES = RegisterBlockItem("limestone_tiles", new Block(FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block IGNEOUS_ROCK_SLAB = RegisterBlockItem("igneous_rock_slab", new SlabBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block SALTROCK_SLAB = RegisterBlockItem("saltrock_slab", new SlabBlock(FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block MAGNETITE_SLAB = RegisterBlockItem("magnetite_slab", new SlabBlock(FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIMESTONE_SLAB = RegisterBlockItem("limestone_slab", new SlabBlock(FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block IGNEOUS_ROCK_STAIRS = RegisterBlockItem("igneous_rock_stairs", new StairsBlock(IGNEOUS_ROCK.getDefaultState(), FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block SALTROCK_STAIRS = RegisterBlockItem("saltrock_stairs", new StairsBlock(SALTROCK.getDefaultState(), FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block MAGNETITE_STAIRS = RegisterBlockItem("magnetite_stairs", new StairsBlock(MAGNETITE.getDefaultState(), FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIMESTONE_STAIRS = RegisterBlockItem("limestone_stairs", new StairsBlock(LIMESTONE.getDefaultState(), FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block IGNEOUS_ROCK_WALL = RegisterBlockItem("igneous_rock_wall", new WallBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block SALTROCK_WALL = RegisterBlockItem("saltrock_wall", new WallBlock(FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block MAGNETITE_WALL = RegisterBlockItem("magnetite_wall", new WallBlock(FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block LIMESTONE_WALL = RegisterBlockItem("limestone_wall", new WallBlock(FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block POLISHED_IGNEOUS_ROCK_SLAB = RegisterBlockItem("polished_igneous_rock_slab", new SlabBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block POLISHED_SALTROCK_SLAB = RegisterBlockItem("polished_saltrock_slab", new SlabBlock(FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_MAGNETITE_SLAB = RegisterBlockItem("polished_magnetite_slab", new SlabBlock(FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block POLISHED_LIMESTONE_SLAB = RegisterBlockItem("polished_limestone_slab", new SlabBlock(FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block POLISHED_IGNEOUS_ROCK_STAIRS = RegisterBlockItem("polished_igneous_rock_stairs", new StairsBlock(IGNEOUS_ROCK.getDefaultState(), FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block POLISHED_SALTROCK_STAIRS = RegisterBlockItem("polished_saltrock_stairs", new StairsBlock(SALTROCK.getDefaultState(), FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_MAGNETITE_STAIRS = RegisterBlockItem("polished_magnetite_stairs", new StairsBlock(MAGNETITE.getDefaultState(), FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block POLISHED_LIMESTONE_STAIRS = RegisterBlockItem("polished_limestone_stairs", new StairsBlock(LIMESTONE.getDefaultState(), FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    public static final Block POLISHED_IGNEOUS_ROCK_WALL = RegisterBlockItem("polished_igneous_rock_wall", new WallBlock(FabricBlockSettings.copyOf(IGNEOUS_ROCK).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block POLISHED_SALTROCK_WALL = RegisterBlockItem("polished_saltrock_wall", new WallBlock(FabricBlockSettings.copyOf(SALTROCK).mapColor(MapColor.PALE_YELLOW)));
    public static final Block POLISHED_MAGNETITE_WALL = RegisterBlockItem("polished_magnetite_wall", new WallBlock(FabricBlockSettings.copyOf(MAGNETITE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block POLISHED_LIMESTONE_WALL = RegisterBlockItem("polished_limestone_wall", new WallBlock(FabricBlockSettings.copyOf(LIMESTONE).mapColor(MapColor.PALE_GREEN)));
    // end stone variants

    // nether core
    public static final Block NETHERFROST = RegisterBlockItem("netherfrost", new Block(FabricBlockSettings.copyOf(Blocks.NETHERRACK).mapColor(MapColor.CYAN)));
    public static final Block NETHERFROST_BRICKS = RegisterBlockItem("netherfrost_bricks", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS).mapColor(MapColor.DARK_AQUA)));
    public static final Block NETHERFROST_BRICK_SLAB = RegisterBlockItem("netherfrost_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_SLAB).mapColor(MapColor.DARK_AQUA)));
    public static final Block NETHERFROST_BRICK_STAIRS = RegisterBlockItem("netherfrost_brick_stairs", new StairsBlock(NETHERFROST_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_STAIRS).mapColor(MapColor.DARK_AQUA)));
    public static final Block NETHERFROST_BRICK_WALL = RegisterBlockItem("netherfrost_brick_wall", new WallBlock(FabricBlockSettings.copyOf(NETHERFROST_BRICKS).mapColor(MapColor.DARK_AQUA)));


    public static final Block CORELIGHT = RegisterBlockItem("corelight", new Block(FabricBlockSettings.copyOf(Blocks.SHROOMLIGHT).mapColor(MapColor.BLUE)));
    public static final Block PERMA_ICE = RegisterBlockItem("perma_ice", new Block(FabricBlockSettings.copyOf(Blocks.BLUE_ICE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block NETHER_ICE = RegisterBlockItem("nether_ice", new Block(FabricBlockSettings.copyOf(Blocks.BLUE_ICE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block SOUL_SNOW = RegisterBlockItem("soul_snow", new SoulSandBlock(FabricBlockSettings.copyOf(Blocks.SAND).sounds(BlockSoundGroup.SOUL_SAND).mapColor(MapColor.LIGHT_BLUE).velocityMultiplier(1.3f)));

    public static final Block CORE_SULPHUR_ORE = RegisterBlockItem("core_sulphur_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW), UniformIntProvider.create(17, 23)));
    public static final Block TADANITE_ORE = RegisterBlockItem("tadanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.PALE_GREEN), UniformIntProvider.create(8, 10)));
    public static final Block TADANITE_BLOCK = RegisterBlockItem("tadanite", new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).sounds(BlockSoundGroup.STONE).mapColor(MapColor.PALE_GREEN).hardness(20).resistance(2000)));
    public static final Block LUMITE_ORE = RegisterBlockItem("lumite_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.LIGHT_BLUE)));

    // core grove
    public static final Block FROST_STEM = RegisterBlockItem("frost_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_STEM).mapColor(MapColor.PALE_PURPLE)));
    public static final Block FROST_HYPHAE = RegisterBlockItem("frost_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.PALE_PURPLE)));
    public static final Block FROST_PLANKS = RegisterBlockItem("frost_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.CYAN)));
    public static final Block FROST_SLAB = RegisterBlockItem("frost_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.CYAN)));
    public static final Block FROST_STAIRS = RegisterBlockItem("frost_stairs", new StairsBlock(FROST_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.CYAN)));
    public static final Block FROST_FENCE = RegisterBlockItem("frost_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.CYAN)));
    public static final Block FROST_FENCE_GATE = RegisterBlockItem("frost_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.CYAN), WoodType.OAK));
    public static final Block FROST_BUTTON = RegisterBlockItem("frost_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
    public static final Block STRIPPED_FROST_STEM = RegisterBlockItem("stripped_frost_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CRIMSON_STEM).mapColor(MapColor.PALE_PURPLE)));
    public static final Block STRIPPED_FROST_HYPHAE = RegisterBlockItem("stripped_frost_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CRIMSON_HYPHAE).mapColor(MapColor.PALE_PURPLE)));
    public static final Block FROST_DOOR = RegisterBlockItem("frost_door", new DoorBlock(FabricBlockSettings.copyOf(FROST_PLANKS).nonOpaque().mapColor(MapColor.CYAN), BlockSetType.OAK));
    public static final Block FROST_TRAPDOOR = RegisterBlockItem("frost_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(FROST_PLANKS).nonOpaque().mapColor(MapColor.CYAN), BlockSetType.OAK));
    public static final Block CORE_NYLIUM = RegisterBlockItem("core_nylium", new Block(FabricBlockSettings.copyOf(Blocks.CRIMSON_NYLIUM).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CORE_WART_BLOCK = RegisterBlockItem("core_wart_block", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CORE_VINES = RegisterBlockItem("core_vines", new WeepingVinesBlock(FabricBlockSettings.copyOf(Blocks.WEEPING_VINES).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CORE_ROOTS = RegisterBlockItem("core_roots", new RootsBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).mapColor(MapColor.PALE_PURPLE))
    {
        protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
        {
            return floor.isOf(CORE_NYLIUM);
        }
    });
    public static final Block CORE_FUNGUS = RegisterBlockItem("core_fungus", new PlantBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS).mapColor(MapColor.WHITE))
    {
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
        {
            return Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
        }
        protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
        {
            return floor.isOf(CORE_NYLIUM);
        }
    });
    // end core grove

    public static final Block CORE_TANK_SKULL = RegisterBlockItem("core_tank_skull", new CoreTankSkullBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.CYAN)));

    // entropy
    public static final Block ENTROPY_STEM = RegisterBlockItem("entropy_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_STEM).mapColor(MapColor.WHITE)));
    public static final Block ENTROPY_HYPHAE = RegisterBlockItem("entropy_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.WHITE)));
    public static final Block ENTROPY_PLANKS = RegisterBlockItem("entropy_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.BLACK)));
    public static final Block ENTROPY_SLAB = RegisterBlockItem("entropy_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).mapColor(MapColor.BLACK)));
    public static final Block ENTROPY_STAIRS = RegisterBlockItem("entropy_stairs", new StairsBlock(ENTROPY_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.BLACK)));
    public static final Block ENTROPY_FENCE = RegisterBlockItem("entropy_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).mapColor(MapColor.BLACK)));
    public static final Block ENTROPY_FENCE_GATE = RegisterBlockItem("entropy_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).mapColor(MapColor.BLACK), WoodType.OAK));
    public static final Block ENTROPY_BUTTON = RegisterBlockItem("entropy_button", Blocks.createWoodenButtonBlock(BlockSetType.OAK));
    public static final Block STRIPPED_ENTROPY_STEM = RegisterBlockItem("stripped_entropy_stem", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CRIMSON_STEM).mapColor(MapColor.WHITE)));
	public static final Block STRIPPED_ENTROPY_HYPHAE = RegisterBlockItem("stripped_entropy_hyphae", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CRIMSON_HYPHAE).mapColor(MapColor.WHITE)));
	public static final Block ENTROPY_DOOR = RegisterBlockItem("entropy_door", new DoorBlock(FabricBlockSettings.copyOf(ENTROPY_PLANKS).nonOpaque().mapColor(MapColor.BLACK), BlockSetType.OAK));
	public static final Block ENTROPY_TRAPDOOR = RegisterBlockItem("entropy_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(ENTROPY_PLANKS).nonOpaque().mapColor(MapColor.BLACK), BlockSetType.OAK));
    public static final Block ENTROPIC_CORE_NYLIUM = RegisterBlockItem("entropic_core_nylium", new Block(FabricBlockSettings.copyOf(Blocks.CRIMSON_NYLIUM).mapColor(MapColor.WHITE)));
    public static final Block ENTROPIC_WART_BLOCK = RegisterBlockItem("entropic_wart_block", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).mapColor(MapColor.WHITE)));
    public static final Block ENTROPIC_VINES = RegisterBlockItem("entropic_vines", new EntropicVinesBlock(FabricBlockSettings.copyOf(Blocks.WEEPING_VINES).mapColor(MapColor.WHITE)));
    public static final Block ENTROPIC_VINES_PLANT = RegisterBlockItem("entropic_vines_plant", new EntropicVinesPlantBlock(FabricBlockSettings.copyOf(Blocks.WEEPING_VINES).mapColor(MapColor.WHITE)));
    public static final Block ENTROPY_WEEDS = RegisterBlockItem("entropy_weeds", new PlantBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).mapColor(MapColor.WHITE))
    {
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
        {
            return Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
        }

        protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
        {
            return floor.isOf(ENTROPIC_CORE_NYLIUM);
        }
    });
    public static final Block ENTROPIC_ICE = RegisterBlockItem("entropic_ice", new Block(FabricBlockSettings.copyOf(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.WHITE))
    {
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
        {
            return Block.createCuboidShape(4, 0, 4, 12, 9, 12);
        }
    });
    // salt terraces
    public static final Block ROCK_SALT = RegisterBlockItem("rock_salt", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BASALT).mapColor(MapColor.TERRACOTTA_PINK)));
    // end entropy
    // desert
    public static final Block FROST_SAND = RegisterBlockItem("frost_sand", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).mapColor(MapColor.LIGHT_BLUE)));
    // end salt terraces
    public static final Block FROST_SANDSTONE = RegisterBlockItem("frost_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block CHISELED_FROST_SANDSTONE = RegisterBlockItem("chiseled_frost_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block SMOOTH_FROST_SANDSTONE = RegisterBlockItem("smooth_frost_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block CUT_FROST_SANDSTONE = RegisterBlockItem("cut_frost_sandstone", new Block(FabricBlockSettings.copyOf(Blocks.CUT_SANDSTONE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block CUT_FROST_SANDSTONE_SLAB = RegisterBlockItem("cut_frost_sandstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block CUT_FROST_SANDSTONE_STAIRS = RegisterBlockItem("cut_frost_sandstone_stairs", new StairsBlock(FROST_SANDSTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.SANDSTONE).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block FROSTED_GLASS = RegisterBlockItem("frosted_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
    public static final Block FROSTED_GLASS_PANE = RegisterBlockItem("frosted_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(FROSTED_GLASS)));
    // end desert
    // end nether core

    public static final Block BEDROCK = RegisterBlockItem("bedrock", new Block(FabricBlockSettings.copyOf(Blocks.STONE).hardness(15).resistance(3600000).mapColor(MapColor.STONE_GRAY)));
    public static final Block BEDROCK_SLAB = RegisterBlockItem("bedrock_slab", new SlabBlock(FabricBlockSettings.copyOf(BEDROCK).mapColor(MapColor.STONE_GRAY)));
    public static final Block BEDROCK_STAIRS = RegisterBlockItem("bedrock_stairs", new StairsBlock(BEDROCK.getDefaultState(), FabricBlockSettings.copyOf(BEDROCK).mapColor(MapColor.STONE_GRAY)));
    public static final Block BEDROCK_WALL = RegisterBlockItem("bedrock_wall", new WallBlock(FabricBlockSettings.copyOf(BEDROCK).mapColor(MapColor.STONE_GRAY)));
    public static final Block CHISELED_BEDROCK = RegisterBlockItem("chiseled_bedrock", new Block(FabricBlockSettings.copyOf(BEDROCK).mapColor(MapColor.STONE_GRAY)));
    public static final Block BEDROCK_BRICKS = RegisterBlockItem("bedrock_bricks", new Block(FabricBlockSettings.copyOf(BEDROCK).mapColor(MapColor.STONE_GRAY)));

    public static final Block FLINT_BLOCK = RegisterBlockItem("flint_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.GRAY)));

    public static final Block ZIRCON_ORE = RegisterBlockItem("zircon_ore", new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final Block ZIRCON_BLOCK = RegisterBlockItem("zircon_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final Block ICE_CREAM_BLOCK = RegisterBlockItem("ice_cream_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).luminance(3).strength(0.5f).postProcess(Blocks::always).emissiveLighting(Blocks::always).mapColor(MapColor.CYAN))
    {
        @Override
        public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
        {
            //if (!(entity instanceof GhastEntity)) // add later the mobs that shouldn't be affected by this
            {
                if (entity instanceof PlayerEntity player)
                {
                    if (!player.isSneaking())
                        player.damage(CoreAscensionDamageTypes.of(entity.getWorld(), CoreAscensionDamageTypes.ICE_CREAM_BLOCK), 1);
                }
                else
                {
                    entity.damage(CoreAscensionDamageTypes.of(entity.getWorld(), CoreAscensionDamageTypes.ICE_CREAM_BLOCK), 1);
                }
            }
        }
    });

    private static Block RegisterBlockItem(String name, Block block)
    {
        RegisterItem(name, block);
        return RegisterBlock(name, block);
    }

    private static void RegisterItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block RegisterBlock(String name, Block block)
    {
        return Registry.register(Registries.BLOCK, new Identifier(CoreAscension.MOD_ID, name), block);
    }

    private static Block RegisterBlockItem(String name, Block block, FabricItemSettings settings)
    {
        RegisterItem(name, block, settings);
        return RegisterBlock(name, block);
    }

    private static void RegisterItem(String name, Block block, FabricItemSettings settings)
    {
        Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), new BlockItem(block, settings));
    }

    public static void RegisterBlocks()
    {
        RegisterFlammableBlocks();
        RegisterStrippableBlocks();
        CoreAscension.LOGGER.info("Registering Blocks for " + CoreAscension.MOD_ID);
    }

    private static void RegisterFlammableBlocks()
    {
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_DOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_TRAPDOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CEDAR_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CEDAR_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CEDAR_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_DOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_TRAPDOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TROPICS_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_TROPICS_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_TROPICS_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(DREAD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_DOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DREAD_TRAPDOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_DREAD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_DREAD_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_DOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CAKEWOOD_TRAPDOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(RED_POPSICLE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(BLUE_POPSICLE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WHITE_POPSICLE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CAKEWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CAKEWOOD_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_DOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_TRAPDOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WHITEWOOD_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WHITEWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WHITEWOOD_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_DOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_TRAPDOOR, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ETHEREAL_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_ETHEREAL_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_ETHEREAL_WOOD, 5, 5);
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
        StrippableBlockRegistry.register(CoreAscensionBlocks.CAKEWOOD_LOG, CoreAscensionBlocks.STRIPPED_CAKEWOOD_LOG);
        StrippableBlockRegistry.register(CoreAscensionBlocks.CAKEWOOD_WOOD, CoreAscensionBlocks.STRIPPED_CAKEWOOD_WOOD);
        StrippableBlockRegistry.register(CoreAscensionBlocks.ETHEREAL_LOG, CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG);
        StrippableBlockRegistry.register(CoreAscensionBlocks.ETHEREAL_WOOD, CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD);
        StrippableBlockRegistry.register(CoreAscensionBlocks.FROST_STEM, CoreAscensionBlocks.STRIPPED_FROST_STEM);
        StrippableBlockRegistry.register(CoreAscensionBlocks.FROST_HYPHAE, CoreAscensionBlocks.STRIPPED_FROST_HYPHAE);
    }


    public static void ClientRegisterBlocks()
    {
        ClientRegisterRenderLayeredBlocks();
        ClientRegisterColouredBlocks();

        FluidRenderHandlerRegistry.INSTANCE.register(CoreAscensionFluids.STILL_END_GAS, CoreAscensionFluids.FLOWING_END_GAS, new SimpleFluidRenderHandler(
                new Identifier("coreascension:block/end_gas_still"),
                new Identifier("coreascension:block/end_gas_flowing"),
                0xFFFFFF
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(CoreAscensionFluids.STILL_MOLTEN_ICE, CoreAscensionFluids.FLOWING_MOLTEN_ICE, new SimpleFluidRenderHandler(
                new Identifier("coreascension:block/molten_ice_still"),
                new Identifier("coreascension:block/molten_ice_flowing"),
                0xFFFFFF
        ));
    }

    public static void ClientRegisterRenderLayeredBlocks()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ARGON_CRYSTAL_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.AMETHYST_GEM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.REINFORCED_GLASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.BORDERLESS_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.RED_GUMDROP, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.YELLOW_GUMDROP, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.GREEN_GUMDROP, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.REINFORCED_CHEST, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.COCONUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.DREAD_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ETHEREAL_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.GLASS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.GLASS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ETHEREAL_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.DREAD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CEDAR_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.WHITEWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.WHITEWOOD_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ETHEREAL_GRASS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICAL_GRASS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.FROSTING_GRASS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.MOSSY_DARK_MATTER_STONE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.TROPICS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CORE_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CORE_FUNGUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CORE_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ENTROPY_WEEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ENTROPIC_ICE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ENTROPIC_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.RAINBOW_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.DIAMOND_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.DIAMOND_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ENTROPIC_VINES_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.CORE_TANK_SKULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.ENCHANTMENT_RELOCATOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.FROSTED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.FROSTED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CoreAscensionBlocks.SKYLANDS_PORTAL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), CoreAscensionFluids.STILL_END_GAS, CoreAscensionFluids.FLOWING_END_GAS);
    }

    public static void ClientRegisterColouredBlocks()
    {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), TROPICAL_GRASS);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> 8126208, TROPICAL_GRASS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), TROPICS_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 8126208, TROPICS_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), CEDAR_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 3368448, CEDAR_LEAVES);
    }
}
