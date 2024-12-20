package com.blah.coreascension.item;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionFluids;
import com.blah.coreascension.entity.CoreAscensionBoats;
import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.entity.entities.projectiles.bolt.BlahBoltEntity;
import com.blah.coreascension.item.food.CoreAscensionFoodComponents;
import com.blah.coreascension.item.items.*;
import com.blah.coreascension.item.tools.*;
import com.blah.coreascension.utils.CoreAscensionTags;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoreAscensionItems {

    public static final Item ETHEREAL_TORCH = registerItem("ethereal_torch",
            new VerticallyAttachableBlockItem(CoreAscensionBlocks.ETHEREAL_TORCH, CoreAscensionBlocks.ETHEREAL_WALL_TORCH, new FabricItemSettings(), Direction.DOWN)
            {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
                {
                    tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, "tooltip.ethereal_torch"))).formatted(Formatting.GRAY));
                }
            });

    public static final Item NETHER_ICE_BUCKET = registerItem("nether_ice_bucket", new NetherIceBucketItem(new FabricItemSettings(), Fluids.EMPTY));
    public static final Item FILLED_NETHER_ICE_BUCKET = registerItem("filled_nether_ice_bucket", new NetherIceBucketItem(new FabricItemSettings(), Fluids.WATER));
    public static final Item ICE_CREAM = registerItem("ice_cream", new Item(new FabricItemSettings()));
    public static final Item SKYLANDS_WAYNODE = registerItem("skylands_waynode", new LighterItem(new FabricItemSettings().maxDamage(5)));
    public static final Item NETHER_CORE_KEY = registerItem("nether_core_key", new LighterItem(new FabricItemSettings().maxDamage(5)));
    public static final Item TERRESTRIAL_CONSTRUCT = registerItem("terrestrial_construct", new Item(new FabricItemSettings()));
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item AERO_FUEL = registerItem("aerofuel", new Item(new FabricItemSettings()));
    public static final Item RUBY_SHARD = registerItem("ruby_shard", new Item(new FabricItemSettings()));
    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item CITRINE_SHARD = registerItem("citrine_shard", new Item(new FabricItemSettings()));
    public static final Item TOPAZ = registerItem("topaz", new Item(new FabricItemSettings()));
    public static final Item TOPAZ_SHARD = registerItem("topaz_shard", new Item(new FabricItemSettings()));
    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_SHARD = registerItem("diamond_shard", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE_SHARD = registerItem("sapphire_shard", new Item(new FabricItemSettings()));
    public static final Item AMETHYST = registerItem("amethyst", new Item(new FabricItemSettings()));
    public static final Item ZIRCON = registerItem("zircon", new Item(new FabricItemSettings()));
    public static final Item TADANITE_DIAMOND = registerItem("tadanite_diamond", new Item(new FabricItemSettings().fireproof()));
    public static final Item TADANITE_CRYSTAL = registerItem("tadanite_crystal", new Item(new FabricItemSettings().fireproof()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item SULPHUR = registerItem("sulphur", new Item(new FabricItemSettings()));
    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new FabricItemSettings().fireproof()));
    public static final Item URANIUM_INGOT = registerItem("uranium_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item SPAWN_EGG = registerItem("poor", new SpawnEggItem(CoreAscensionEntities.PORCUPINE, 894731, 0, new FabricItemSettings()));
    public static final Item THE_TOOL = registerItem("the_tool", new MiningToolTipItem(CoreAscensionToolMaterials.TOOL, -2, -2.8f, new FabricItemSettings().fireproof(), CoreAscensionTags.TOOL_MINEABLE));
    public static final Item OBSIDIAN_FABRIC = registerItem("obsidian_fabric", new Item(new FabricItemSettings()));
    public static final Item OBSIDIFIED_BLAZE_ROD = registerItem("obsidified_blaze_rod", new Item(new FabricItemSettings()));
    public static final Item RAW_LUMITE = registerItem("raw_lumite", new Item(new FabricItemSettings().fireproof()));
    public static final Item LUMITE_INGOT = registerItem("lumite_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item MAGIC_MIRROR = registerItem("magic_mirror", new MagicMirrorItem(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item CRYSTALLINE_ARTIFACT = registerItem("crystalline_artifact", new Item(new FabricItemSettings().fireproof()));

    public static final Item PRISMAERO_SHARD = registerItem("prismaero_shard", new Item(new FabricItemSettings()));
    public static final Item PRISMAERO_CRYSTALS = registerItem("prismaero_crystals", new Item(new FabricItemSettings()));

    public static final Item WOODEN_SCYTHE = registerItem("wood_scythe", new ScytheItem(ToolMaterials.WOOD, 0, -3f, new FabricItemSettings()));
    public static final Item STONE_SCYTHE = registerItem("stone_scythe", new ScytheItem(ToolMaterials.STONE, 0, -3f, new FabricItemSettings()));
    public static final Item GOLDEN_SCYTHE = registerItem("gold_scythe", new ScytheItem(ToolMaterials.GOLD, 0, -3f, new FabricItemSettings()));
    public static final Item IRON_SCYTHE = registerItem("iron_scythe", new ScytheItem(ToolMaterials.IRON, 0, -3f, new FabricItemSettings()));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe", new ScytheItem(ToolMaterials.DIAMOND, 0, -3f, new FabricItemSettings()));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe", new ScytheItem(ToolMaterials.NETHERITE, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_SCYTHE = registerItem("tadanite_scythe", new ScytheItem(CoreAscensionToolMaterials.TADANITE, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item LUMITE_SCYTHE = registerItem("lumite_scythe", new ScytheItem(CoreAscensionToolMaterials.LUMITE, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item SAPPHIRE_SCYTHE = registerItem("sapphire_scythe", new ScytheItem(CoreAscensionToolMaterials.SAPPHIRE, 0, -3f, new FabricItemSettings()));
    public static final Item POTATO_SCYTHE = registerItem("potato_scythe", new ScytheItem(CoreAscensionToolMaterials.POTATO, 0, -3f, new FabricItemSettings()));

    public static final Item FROST_SIGN = registerItem("frost_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_FROST_SIGN, CoreAscensionBlocks.WALL_FROST_SIGN));
    public static final Item HANGING_FROST_SIGN = registerItem("frost_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_FROST_SIGN, CoreAscensionBlocks.WALL_HANGING_FROST_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item ENTROPY_SIGN = registerItem("entropy_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_ENTROPY_SIGN, CoreAscensionBlocks.WALL_ENTROPY_SIGN));
    public static final Item HANGING_ENTROPY_SIGN = registerItem("entropy_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_ENTROPY_SIGN, CoreAscensionBlocks.WALL_HANGING_ENTROPY_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item CEDAR_SIGN = registerItem("cedar_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_CEDAR_SIGN, CoreAscensionBlocks.WALL_CEDAR_SIGN));
    public static final Item HANGING_CEDAR_SIGN = registerItem("cedar_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_CEDAR_SIGN, CoreAscensionBlocks.WALL_HANGING_CEDAR_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item TROPICS_SIGN = registerItem("tropics_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_TROPICS_SIGN, CoreAscensionBlocks.WALL_TROPICS_SIGN));
    public static final Item HANGING_TROPICS_SIGN = registerItem("tropics_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_TROPICS_SIGN, CoreAscensionBlocks.WALL_HANGING_TROPICS_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item WHITEWOOD_SIGN = registerItem("whitewood_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_WHITEWOOD_SIGN, CoreAscensionBlocks.WALL_WHITEWOOD_SIGN));
    public static final Item HANGING_WHITEWOOD_SIGN = registerItem("whitewood_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_WHITEWOOD_SIGN, CoreAscensionBlocks.WALL_HANGING_WHITEWOOD_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item DREAD_SIGN = registerItem("dread_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_DREAD_SIGN, CoreAscensionBlocks.WALL_DREAD_SIGN));
    public static final Item HANGING_DREAD_SIGN = registerItem("dread_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_DREAD_SIGN, CoreAscensionBlocks.WALL_HANGING_DREAD_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item CACTUS_SIGN = registerItem("cactus_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_CACTUS_SIGN, CoreAscensionBlocks.WALL_CACTUS_SIGN));
    public static final Item HANGING_CACTUS_SIGN = registerItem("cactus_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_CACTUS_SIGN, CoreAscensionBlocks.WALL_HANGING_CACTUS_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item ETHEREAL_SIGN = registerItem("ethereal_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_ETHEREAL_SIGN, CoreAscensionBlocks.WALL_ETHEREAL_SIGN));
    public static final Item HANGING_ETHEREAL_SIGN = registerItem("ethereal_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_ETHEREAL_SIGN, CoreAscensionBlocks.WALL_HANGING_ETHEREAL_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item CAKEWOOD_SIGN = registerItem("cakewood_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_CAKEWOOD_SIGN, CoreAscensionBlocks.WALL_CAKEWOOD_SIGN));
    public static final Item HANGING_CAKEWOOD_SIGN = registerItem("cakewood_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_CAKEWOOD_SIGN, CoreAscensionBlocks.WALL_HANGING_CAKEWOOD_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item DARK_MATTER_SIGN = registerItem("dark_matter_sign",
            new SignItem(new FabricItemSettings().maxCount(16), CoreAscensionBlocks.STANDING_DARK_MATTER_SIGN, CoreAscensionBlocks.WALL_DARK_MATTER_SIGN));
    public static final Item HANGING_DARK_MATTER_SIGN = registerItem("dark_matter_hanging_sign",
            new HangingSignItem(CoreAscensionBlocks.HANGING_DARK_MATTER_SIGN, CoreAscensionBlocks.WALL_HANGING_DARK_MATTER_SIGN, new FabricItemSettings().maxCount(16)));


    public static final Item CEDAR_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.CEDAR_BOAT_ID, CoreAscensionBoats.CEDAR_BOAT_KEY, false);
    public static final Item CEDAR_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.CEDAR_CHEST_BOAT_ID, CoreAscensionBoats.CEDAR_BOAT_KEY, true);
    public static final Item TROPICS_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.TROPICS_BOAT_ID, CoreAscensionBoats.TROPICS_BOAT_KEY, false);
    public static final Item TROPICS_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.TROPICS_CHEST_BOAT_ID, CoreAscensionBoats.TROPICS_BOAT_KEY, true);
    public static final Item WHITEWOOD_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.WHITEWOOD_BOAT_ID, CoreAscensionBoats.WHITEWOOD_BOAT_KEY, false);
    public static final Item WHITEWOOD_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.WHITEWOOD_CHEST_BOAT_ID, CoreAscensionBoats.WHITEWOOD_BOAT_KEY, true);
    public static final Item ETHEREAL_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.ETHEREAL_BOAT_ID, CoreAscensionBoats.ETHEREAL_BOAT_KEY, false);
    public static final Item ETHEREAL_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.ETHEREAL_CHEST_BOAT_ID, CoreAscensionBoats.ETHEREAL_BOAT_KEY, true);
    public static final Item DARK_MATTER_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.DARK_MATTER_BOAT_ID, CoreAscensionBoats.DARK_MATTER_BOAT_KEY, false);
    public static final Item DARK_MATTER_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.DARK_MATTER_CHEST_BOAT_ID, CoreAscensionBoats.DARK_MATTER_BOAT_KEY, true);
    public static final Item CACTUS_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.CACTUS_BOAT_ID, CoreAscensionBoats.CACTUS_BOAT_KEY, false);
    public static final Item CACTUS_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.CACTUS_CHEST_BOAT_ID, CoreAscensionBoats.CACTUS_BOAT_KEY, true);
    public static final Item DREAD_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.DREAD_BOAT_ID, CoreAscensionBoats.DREAD_BOAT_KEY, false);
    public static final Item DREAD_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.DREAD_CHEST_BOAT_ID, CoreAscensionBoats.DREAD_BOAT_KEY, true);
    public static final Item CAKEWOOD_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.CAKEWOOD_BOAT_ID, CoreAscensionBoats.CAKEWOOD_BOAT_KEY, false);
    public static final Item CAKEWOOD_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CoreAscensionBoats.CAKEWOOD_CHEST_BOAT_ID, CoreAscensionBoats.CAKEWOOD_BOAT_KEY, true);

    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer", new HammerItem(CoreAscensionToolMaterials.WOOD_SPECIAL, 1, 0.4f, new FabricItemSettings()));
    public static final Item STONE_HAMMER = registerItem("stone_hammer", new HammerItem(CoreAscensionToolMaterials.STONE_SPECIAL, 1, 0.4f, new FabricItemSettings()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(CoreAscensionToolMaterials.IRON_SPECIAL, 5, 0.4f, new FabricItemSettings()));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            new HammerItem(CoreAscensionToolMaterials.GOLD_SPECIAL, 3, 0.4f, new FabricItemSettings()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(CoreAscensionToolMaterials.DIAMOND_SPECIAL, 6, 0.4f, new FabricItemSettings()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(CoreAscensionToolMaterials.NETHERITE_SPECIAL, 7, 0.4f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_HAMMER = registerItem("tadanite_hammer",
            new HammerItem(CoreAscensionToolMaterials.TADANITE_SPECIAL, 11, 0.4f, new FabricItemSettings().fireproof(), Formatting.YELLOW, "tooltip.tadanite"));
    public static final Item LUMITE_HAMMER = registerItem("lumite_hammer",
            new HammerItem(CoreAscensionToolMaterials.LUMITE_SPECIAL, 14, 0.4f, new FabricItemSettings().fireproof()));
    public static final Item SAPPHIRE_HAMMER = registerItem("sapphire_hammer",
            new HammerItem(CoreAscensionToolMaterials.SAPPHIRE_SPECIAL, 7, 0.4f, new FabricItemSettings()));

    public static final Item WOODEN_EXCAVATOR = registerItem("wooden_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.WOOD_SPECIAL, -0.5f, 1f, new FabricItemSettings()));
    public static final Item STONE_EXCAVATOR = registerItem("stone_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.STONE_SPECIAL, 0.5f, 1f, new FabricItemSettings()));
    public static final Item GOLDEN_EXCAVATOR = registerItem("golden_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.GOLD_SPECIAL, -0.5f, 1f, new FabricItemSettings()));
    public static final Item IRON_EXCAVATOR = registerItem("iron_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.IRON_SPECIAL, 1f, 1f, new FabricItemSettings()));
    public static final Item DIAMOND_EXCAVATOR = registerItem("diamond_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.DIAMOND_SPECIAL, 1.5f, 1f, new FabricItemSettings()));
    public static final Item NETHERITE_EXCAVATOR = registerItem("netherite_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.NETHERITE_SPECIAL, 2f, 1f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_EXCAVATOR = registerItem("tadanite_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.TADANITE_SPECIAL, 5f, 1f, new FabricItemSettings().fireproof(), Formatting.YELLOW, "tooltip.tadanite"));
    public static final Item LUMITE_EXCAVATOR = registerItem("lumite_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.LUMITE_SPECIAL, 6f, 1f, new FabricItemSettings().fireproof()));
    public static final Item SAPPHIRE_EXCAVATOR = registerItem("sapphire_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.SAPPHIRE_SPECIAL, 7, 1f, new FabricItemSettings()));

    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));


    public static final Item GILDED_OBSIDIAN_HELMET = registerItem("gilded_obsidian_helmet",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.HELMET, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));
    public static final Item GILDED_OBSIDIAN_CHESTPLATE = registerItem("gilded_obsidian_chestplate",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));
    public static final Item GILDED_OBSIDIAN_LEGGINGS = registerItem("gilded_obsidian_leggings",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.LEGGINGS, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));
    public static final Item GILDED_OBSIDIAN_BOOTS = registerItem("gilded_obsidian_boots",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.BOOTS, new FabricItemSettings(), 0, "tooltip.setbonus.gilded_obsidian"));

    public static final Item VOID_TOTEM = registerItem("void_totem", new Item(new FabricItemSettings().fireproof())
    {
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
        {
            tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, "tooltip.void_totem"))).formatted(Formatting.GRAY));
        }
    });


    public static final Item CRYSTAL_HELMET = registerItem("crystal_helmet",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.CRYSTAL, ArmorItem.Type.HELMET, new FabricItemSettings(), 1, "tooltip.setbonus.crystal"));
    public static final Item CRYSTAL_CHESTPLATE = registerItem("crystal_chestplate",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.CRYSTAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings(), 1, "tooltip.setbonus.crystal"));
    public static final Item CRYSTAL_LEGGINGS = registerItem("crystal_leggings",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.CRYSTAL, ArmorItem.Type.LEGGINGS, new FabricItemSettings(), 1, "tooltip.setbonus.crystal"));
    public static final Item CRYSTAL_BOOTS = registerItem("crystal_boots",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.CRYSTAL, ArmorItem.Type.BOOTS, new FabricItemSettings(), 1, "tooltip.setbonus.crystal"));

    public static final Item DARK_MATTER_JELLY = registerItem("dark_matter_jelly", new Item(new FabricItemSettings().food(CoreAscensionFoodComponents.DARK_MATTER_JELLY)));
    public static final Item HEAVENLY_FRAGMENT = registerItem("heavenly_fragment", new Item(new FabricItemSettings().fireproof()));
    public static final Item CATALYTIC_INVERTER = registerItem("catalytic_inverter", new Item(new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_CONSTRUCT = registerItem("obsidian_construct", new Item(new FabricItemSettings().fireproof()));
    public static final Item BLAHR = registerItem("blahr", new Item(new FabricItemSettings().fireproof()));

    public static final Item CRIMSON_EDGE = registerItem("crimson_edge", new SwordTooltipItem(CoreAscensionToolMaterials.SKYLANDS_SWORD, 4, -2.4f, new FabricItemSettings().fireproof().rarity(Rarity.RARE), Formatting.GRAY, "tooltip.crimson_edge") {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
        {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1));
            return super.postHit(stack, target, attacker);
        }
    });

    public static final Item TITAN_BLADE = registerItem("titan_blade", new SwordTooltipItem(CoreAscensionToolMaterials.SKYLANDS_SWORD, 3, -2.4f, new FabricItemSettings().fireproof().rarity(Rarity.RARE), Formatting.GRAY, "tooltip.titan_blade") {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
        {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 120, 1));
            return super.postHit(stack, target, attacker);
        }
    });

    public static final Item VERTEX = registerItem("vertex", new VertexSword(CoreAscensionToolMaterials.SKYLANDS_SWORD, 2, -2.4f, new FabricItemSettings().fireproof().rarity(Rarity.RARE), "tooltip.vertex"));

    public static final Item BEDROCK_PICKAXE = registerItem("bedrock_pickaxe",
            new PickaxeToolTipItem(CoreAscensionToolMaterials.BEDROCK, -3, -2.8f, new FabricItemSettings().fireproof(), Formatting.RED, "tooltip.bedrock_pickaxe"));

    public static final Item TADANITE_HELMET = registerItem("tadanite_helmet",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item TADANITE_CHESTPLATE = registerItem("tadanite_chestplate",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item TADANITE_LEGGINGS = registerItem("tadanite_leggings",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item TADANITE_BOOTS = registerItem("tadanite_boots",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item TADANITE_PICKAXE = registerItem("tadanite_pickaxe",
            new PickaxeToolTipItem(CoreAscensionToolMaterials.TADANITE, 2, -2.8f, new FabricItemSettings().fireproof(), Formatting.YELLOW, "tooltip.tadanite"));
    public static final Item TADANITE_SWORD = registerItem("tadanite_sword",
            new SwordItem(CoreAscensionToolMaterials.TADANITE, 4, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_AXE = registerItem("tadanite_axe",
            new AxeToolTipItem(CoreAscensionToolMaterials.TADANITE, 7, -3.1f, new FabricItemSettings().fireproof(), Formatting.YELLOW, "tooltip.tadanite"));
    public static final Item TADANITE_SHOVEL = registerItem("tadanite_shovel",
            new ShovelToolTipItem(CoreAscensionToolMaterials.TADANITE, 0, -3f, new FabricItemSettings().fireproof(), Formatting.YELLOW, "tooltip.tadanite"));
    public static final Item TADANITE_HOE = registerItem("tadanite_hoe",
            new HoeTooltipItem(CoreAscensionToolMaterials.TADANITE, -2, -3f, new FabricItemSettings().fireproof(), Formatting.YELLOW, "tooltip.tadanite"));

    public static final Item LUMITE_HELMET = registerItem("lumite_helmet",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.LUMITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof(),
                    1, "tooltip.setbonus.lumite_1", "tooltip.setbonus.lumite_2", "tooltip.setbonus.lumite_3", "tooltip.setbonus.lumite_4", "tooltip.setbonus.lumite_5", "tooltip.setbonus.lumite_6"));
    public static final Item LUMITE_CHESTPLATE = registerItem("lumite_chestplate",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.LUMITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof(),
                    1, "tooltip.setbonus.lumite_1", "tooltip.setbonus.lumite_2", "tooltip.setbonus.lumite_3", "tooltip.setbonus.lumite_4", "tooltip.setbonus.lumite_5", "tooltip.setbonus.lumite_6"));
    public static final Item LUMITE_LEGGINGS = registerItem("lumite_leggings",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.LUMITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof(),
                    1, "tooltip.setbonus.lumite_1", "tooltip.setbonus.lumite_2", "tooltip.setbonus.lumite_3", "tooltip.setbonus.lumite_4", "tooltip.setbonus.lumite_5", "tooltip.setbonus.lumite_6"));
    public static final Item LUMITE_BOOTS = registerItem("lumite_boots",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.LUMITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof(),
                    1, "tooltip.setbonus.lumite_1", "tooltip.setbonus.lumite_2", "tooltip.setbonus.lumite_3", "tooltip.setbonus.lumite_4", "tooltip.setbonus.lumite_5", "tooltip.setbonus.lumite_6"));
    public static final Item LUMITE_PICKAXE = registerItem("lumite_pickaxe",
            new PickaxeToolTipItem(CoreAscensionToolMaterials.LUMITE, 4, -2.8f, new FabricItemSettings().fireproof(), Formatting.RED, "tooltip.lumite_pickaxe_1", "tooltip.lumite_pickaxe_2"));
    public static final Item LUMITE_SWORD = registerItem("lumite_sword",
            new SwordTooltipItem(CoreAscensionToolMaterials.LUMITE, 6, -2.4f, new FabricItemSettings().fireproof(), Formatting.RED, "tooltip.lumite_sword"));
    public static final Item LUMITE_AXE = registerItem("lumite_axe",
            new AxeItem(CoreAscensionToolMaterials.LUMITE, 9, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item LUMITE_SHOVEL = registerItem("lumite_shovel",
            new ShovelItem(CoreAscensionToolMaterials.LUMITE, 3, -3f, new FabricItemSettings().fireproof()));
    public static final Item LUMITE_HOE = registerItem("lumite_hoe",
            new HoeItem(CoreAscensionToolMaterials.LUMITE, -1, -3f, new FabricItemSettings().fireproof()));


    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe",
            new PickaxeItem(CoreAscensionToolMaterials.SAPPHIRE, 2, -2.8f, new FabricItemSettings()));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword",
            new SwordItem(CoreAscensionToolMaterials.SAPPHIRE, 4, -2.4f, new FabricItemSettings()));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe",
            new AxeItem(CoreAscensionToolMaterials.SAPPHIRE, 8, -3.1f, new FabricItemSettings()));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel",
            new ShovelItem(CoreAscensionToolMaterials.SAPPHIRE, 1, -3f, new FabricItemSettings()));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe",
            new HoeItem(CoreAscensionToolMaterials.SAPPHIRE, 0, -3f, new FabricItemSettings()));

    public static final Item URANIUM_HELMET = registerItem("uranium_helmet",
            new ArmorItem(CoreAscensionArmorMaterials.URANIUM, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_CHESTPLATE = registerItem("uranium_chestplate",
            new ArmorItem(CoreAscensionArmorMaterials.URANIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_LEGGINGS = registerItem("uranium_leggings",
            new ArmorItem(CoreAscensionArmorMaterials.URANIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_BOOTS = registerItem("uranium_boots",
            new ArmorItem(CoreAscensionArmorMaterials.URANIUM, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_PICKAXE = registerItem("uranium_pickaxe",
            new UraniumPickaxeItem(CoreAscensionToolMaterials.URANIUM, 0, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_SWORD = registerItem("uranium_sword",
            new UraniumSwordItem(CoreAscensionToolMaterials.URANIUM, 4, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_AXE = registerItem("uranium_axe",
            new UraniumAxeItem(CoreAscensionToolMaterials.URANIUM, 8, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_SHOVEL = registerItem("uranium_shovel",
            new UraniumShovelItem(CoreAscensionToolMaterials.URANIUM, 1, -3f, new FabricItemSettings().fireproof()));
    public static final Item URANIUM_HOE = registerItem("uranium_hoe",
            new UraniumHoeItem(CoreAscensionToolMaterials.URANIUM, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item POTATO_PICKAXE = registerItem("potato_pickaxe",
            new PickaxeToolTipItem(CoreAscensionToolMaterials.POTATO, 1, -2.8f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));
    public static final Item POTATO_SWORD = registerItem("potato_sword",
            new SwordTooltipItem(CoreAscensionToolMaterials.POTATO, 2, -2.4f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));
    public static final Item POTATO_AXE = registerItem("potato_axe",
            new AxeToolTipItem(CoreAscensionToolMaterials.POTATO, 5, -3.1f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));
    public static final Item POTATO_SHOVEL = registerItem("potato_shovel",
            new ShovelToolTipItem(CoreAscensionToolMaterials.POTATO, 0, -3f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));
    public static final Item POTATO_HOE = registerItem("potato_hoe",
            new HoeTooltipItem(CoreAscensionToolMaterials.POTATO, 0, -3f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));
    public static final Item POTATO_HAMMER = registerItem("potato_hammer",
            new HammerItem(CoreAscensionToolMaterials.POTATO, 4, 0.4f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));
    public static final Item POTATO_EXCAVATOR = registerItem("potato_excavator", new ExcavatorItem(CoreAscensionToolMaterials.POTATO, 4, 0.4f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.potato_tools_1", "tooltip.potato_tools_2"));

    public static final Item IRON_ROD = registerItem("iron_rod", new Item(new FabricItemSettings()));
    public static final Item FOUR_LEAF_CLOVER = registerItem("four_leaf_clover", new Item(new FabricItemSettings()));
    public static final Item ULTIMATE_GAUNTLET = registerItem("ultimate_gauntlet", new Item(new FabricItemSettings().fireproof()));
    public static final Item OSBORGNEN_FUEL = registerItem("osborgnen_fuel", new Item(new FabricItemSettings().fireproof()));
    public static final Item FROZEN_ROD = registerItem("frozen_rod", new Item(new FabricItemSettings()));
    public static final Item FROZEN_ARTIFACT = registerItem("frozen_artifact", new Item(new FabricItemSettings()));
    public static final Item DARK_MATTER_GEL = registerItem("dark_matter_gel", new Item(new FabricItemSettings()));

    public static final Item BLAH_BOLT = registerItem("blah_beam_blast", new Item(new FabricItemSettings()));
    public static final Item BLAHS_ENERGY_BLADE = registerItem("blahs_energy_blade", new SwordTooltipItem(CoreAscensionToolMaterials.BLAH, 2, -2.4f, new FabricItemSettings().fireproof(), Formatting.BLUE, "tooltip.unbreakable")
    {
        public UseAction getUseAction(ItemStack stack)
        {
            return UseAction.BOW;
        }
        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
        {
            if (!world.isClient())
            {
                BlahBoltEntity proj = new BlahBoltEntity(user, world);
                proj.setVelocity(user, user.getPitch(), user.getYaw(), 0, 2.5f, 1.0f);
                world.spawnEntity(proj);
            }
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 0.4f, 1f);
            return TypedActionResult.success(new ItemStack(this));
        }
    });

    public static final Item RUBY_BOLT = registerItem("ruby_blast", new Item(new FabricItemSettings()));
    public static final Item CITRINE_BOLT = registerItem("citrine_blast", new Item(new FabricItemSettings()));
    public static final Item TOPAZ_BOLT = registerItem("topaz_blast", new Item(new FabricItemSettings()));
    public static final Item EMERALD_BOLT = registerItem("emerald_blast", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_BOLT = registerItem("diamond_blast", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE_BOLT = registerItem("sapphire_blast", new Item(new FabricItemSettings()));
    public static final Item AMETHYST_BOLT = registerItem("amethyst_blast", new Item(new FabricItemSettings()));
    public static final Item RUBY_STAFF = registerItem("ruby_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.RUBY, "tooltip.staff.ruby"));
    public static final Item CITRINE_STAFF = registerItem("citrine_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.CITRINE, "tooltip.staff.citrine"));
    public static final Item TOPAZ_STAFF = registerItem("topaz_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.TOPAZ, "tooltip.staff.topaz"));
    public static final Item EMERALD_STAFF = registerItem("emerald_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.EMERALD, "tooltip.staff.emerald"));
    public static final Item DIAMOND_STAFF = registerItem("diamond_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.DIAMOND, "tooltip.staff.diamond"));
    public static final Item SAPPHIRE_STAFF = registerItem("sapphire_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.SAPPHIRE, "tooltip.staff.sapphire"));
    public static final Item AMETHYST_STAFF = registerItem("amethyst_staff", new StaffItem(new FabricItemSettings().maxDamage(250), StaffItem.GemType.AMETHYST, "tooltip.staff.amethyst"));

    public static final Item COCONUT_FOOD = registerItem("coconut_food", new Item(new FabricItemSettings().food(CoreAscensionFoodComponents.COCONUT)));
    public static final Item CALAMARI = registerItem("raw_calamari", new Item(new FabricItemSettings().food(CoreAscensionFoodComponents.CALAMARI)));
    public static final Item COOKED_CALAMARI = registerItem("cooked_calamari", new Item(new FabricItemSettings().food(CoreAscensionFoodComponents.COOKED_CALAMARI)));
    public static final Item MEGA_BERRY = registerItem("mega_berry", new Item(new FabricItemSettings().food(CoreAscensionFoodComponents.MEGA_BERRY)));
    public static final Item NETHER_MUSHROOM_STEW = registerItem("nether_mushroom_stew", new Item(new FabricItemSettings().food(CoreAscensionFoodComponents.NETHER_MUSHROOM_STEW)));

    public static final Item DAWN_ESSENCE = registerItem("dawn_essence", new Item(new FabricItemSettings().fireproof()));
    public static final Item VOLCANO = registerItem("volcano",
            new SwordTooltipItem(CoreAscensionToolMaterials.VOLCANO, 2, -2.4f, new FabricItemSettings().rarity(Rarity.EPIC), Formatting.GRAY, "tooltip.volcano"));
    public static final Item NIGHTS_EDGE = registerItem("nights_edge",
            new SwordItem(CoreAscensionToolMaterials.DUSK, 3, -2.4f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item DUSK_PICKAXE = registerItem("dusk_pickaxe",
            new SwordItem(CoreAscensionToolMaterials.DUSK, -2, -2.8f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static final Item TWILIGHT_AXE = registerItem("twilight_axe",
            new AxeItem(CoreAscensionToolMaterials.DUSK, 5, -3.1f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    public static final Item END_GAS_BUCKET = registerItem("end_gas_bucket", new BucketItem(CoreAscensionFluids.STILL_END_GAS, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item MOLTEN_ICE_BUCKET = registerItem("molten_ice_bucket", new BucketItem(CoreAscensionFluids.STILL_MOLTEN_ICE, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item ENDER_WIRE = registerItem("ender_wire", new EnderWireItem(new FabricItemSettings()));

    public static final Item SUNSTONE = registerItem("sunstone", new Item(new FabricItemSettings()));

    public static final Item IRON_SHURIKEN_PROJ = registerItem("iron_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item GOLD_SHURIKEN_PROJ = registerItem("golden_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_SHURIKEN_PROJ = registerItem("diamond_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item URANIUM_SHURIKEN_PROJ = registerItem("uranium_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item TADANITE_SHURIKEN_PROJ = registerItem("tadanite_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item LUMITE_SHURIKEN_PROJ = registerItem("lumite_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item FROST_SHURIKEN_PROJ = registerItem("frost_shuriken_proj", new Item(new FabricItemSettings()));
    public static final Item IRON_SHURIKEN = registerItem("iron_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.IRON));
    public static final Item GOLD_SHURIKEN = registerItem("golden_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.GOLD));
    public static final Item DIAMOND_SHURIKEN = registerItem("diamond_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.DIAMOND));
    public static final Item URANIUM_SHURIKEN = registerItem("uranium_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.URANIUM));
    public static final Item TADANITE_SHURIKEN = registerItem("tadanite_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.TADANITE));
    public static final Item LUMITE_SHURIKEN = registerItem("lumite_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.LUMITE));
    public static final Item FROST_SHURIKEN = registerItem("frost_shuriken", new ShurikenItem(new FabricItemSettings(), ShurikenItem.Type.FROST));

    public static final Item EMPTY = registerItem("empty", new Item(new FabricItemSettings()));

    public static final Item BRIGHT_CYAN_DYE = registerItem("bright_cyan_dye", new Item(new FabricItemSettings()));
    public static final Item BRIGHT_RED_DYE = registerItem("bright_red_dye", new Item(new FabricItemSettings()));
    public static final Item BRIGHT_YELLOW_DYE = registerItem("bright_yellow_dye", new Item(new FabricItemSettings()));
    public static final Item DARK_ORANGE_DYE = registerItem("dark_orange_dye", new Item(new FabricItemSettings()));
    public static final Item DARK_RED_DYE = registerItem("dark_red_dye", new Item(new FabricItemSettings()));
    public static final Item DARK_YELLOW_DYE = registerItem("dark_yellow_dye", new Item(new FabricItemSettings()));
    public static final Item LIGHT_BROWN_DYE = registerItem("light_brown_dye", new Item(new FabricItemSettings()));
    public static final Item PALE_YELLOW_DYE = registerItem("pale_yellow_dye", new Item(new FabricItemSettings()));
    public static final Item TURQUOISE_DYE = registerItem("turquoise_dye", new Item(new FabricItemSettings()));
    public static final Item YELLOW_GREEN_DYE = registerItem("yellow_green_dye", new Item(new FabricItemSettings()));
    public static final Item INDIGO_DYE = registerItem("indigo_dye", new Item(new FabricItemSettings()));
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye", new Item(new FabricItemSettings()));

    public static final Item ONYX = registerItem("onyx", new Item(new FabricItemSettings()));

    public static final Item FYRENDIUM_ROCK = registerItem("fyrendium_rock", new Item(new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_INGOT = registerItem("solarium_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_HELMET = registerItem("solarium_helmet",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.SOLARIUM, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item SOLARIUM_CHESTPLATE = registerItem("solarium_chestplate",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.SOLARIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item SOLARIUM_LEGGINGS = registerItem("solarium_leggings",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.SOLARIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item SOLARIUM_BOOTS = registerItem("solarium_boots",
            new AdvancedArmorItem(CoreAscensionArmorMaterials.SOLARIUM, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof(),
                    0, "tooltip.setbonus.tadanite_1", "tooltip.setbonus.tadanite_2", "tooltip.setbonus.tadanite_3", "tooltip.setbonus.tadanite_4", "tooltip.setbonus.tadanite_5"));
    public static final Item SOLARIUM_PICKAXE = registerItem("solarium_pickaxe",
            new PickaxeToolTipItem(CoreAscensionToolMaterials.SOLARIUM, 2, -2.8f, new FabricItemSettings().fireproof(), Formatting.YELLOW));
    public static final Item SOLARIUM_SWORD = registerItem("solarium_sword",
            new SwordItem(CoreAscensionToolMaterials.SOLARIUM, 4, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item SOLARIUM_AXE = registerItem("solarium_axe",
            new AxeToolTipItem(CoreAscensionToolMaterials.SOLARIUM, 7, -3.1f, new FabricItemSettings().fireproof(), Formatting.YELLOW));
    public static final Item SOLARIUM_SHOVEL = registerItem("solarium_shovel",
            new ShovelToolTipItem(CoreAscensionToolMaterials.SOLARIUM, 0, -3f, new FabricItemSettings().fireproof(), Formatting.YELLOW));
    public static final Item SOLARIUM_HOE = registerItem("solarium_hoe",
            new HoeTooltipItem(CoreAscensionToolMaterials.SOLARIUM, -2, -3f, new FabricItemSettings().fireproof(), Formatting.YELLOW));
    public static final Item SOLARIUM_EXCAVATOR = registerItem("solarium_excavator",
            new ExcavatorItem(CoreAscensionToolMaterials.SOLARIUM_SPECIAL, 5f, 1f, new FabricItemSettings().fireproof(), Formatting.YELLOW));
    public static final Item SOLARIUM_HAMMER = registerItem("solarium_hammer",
            new HammerItem(CoreAscensionToolMaterials.SOLARIUM_SPECIAL, 11, 0.4f, new FabricItemSettings().fireproof(), Formatting.YELLOW));
    public static final Item SOLARIUM_SCYTHE = registerItem("solarium_scythe", new ScytheItem(CoreAscensionToolMaterials.SOLARIUM, 0, -3f, new FabricItemSettings().fireproof()));


    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), item);
    }

    public static void RegisterItems()
    {
        RegisterFuelItems();
        CoreAscension.LOGGER.info("Registering Items for " + CoreAscension.MOD_ID);
    }

    private static void RegisterFuelItems()
    {
        FuelRegistry.INSTANCE.add(CoreAscensionBlocks.ACACIA_SECRET_DOOR.asItem(), 1);
        FuelRegistry.INSTANCE.add(OSBORGNEN_FUEL, 24);
    }
}
