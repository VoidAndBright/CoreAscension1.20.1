package com.blah.coreascension.item;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.armormaterials.CoreAscensionArmorMaterials;
import com.blah.coreascension.item.toolmaterials.CoreascensionToolMaterial;
import com.blah.coreascension.item.tooltypes.TadaniteAxeItem;
import com.blah.coreascension.item.tooltypes.TadaniteHoeItem;
import com.blah.coreascension.item.tooltypes.TadanitePickaxeItem;
import com.blah.coreascension.item.tooltypes.TadaniteShovelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;


public class CoreAscensionItems {

    public static final Item ETHEREAL_TORCH = registerItem("ethereal_torch",new VerticallyAttachableBlockItem(CoreAscensionBlocks.ETHEREAL_TORCH, CoreAscensionBlocks.ETHEREAL_WALL_TORCH, new FabricItemSettings(), Direction.DOWN));
    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings()));
    public static final Item CITRINE = registerItem("citrine",new Item(new FabricItemSettings()));
    public static final Item TOPAZ = registerItem("topaz",new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire",new Item(new FabricItemSettings()));
    public static final Item TADANITE_DIAMOND = registerItem("tadanite_diamond",new Item(new FabricItemSettings().fireproof()));
    public static final Item TADANITE_CRYSTAL = registerItem("tadanite_crystal",new Item(new FabricItemSettings().fireproof()));
    public static final Item THE_TOOL = registerItem("the_tool", new TheToolItem(4, 1.2F, CoreascensionToolMaterial.TOOL, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_FABRIC = registerItem("obsidian_fabric",new Item(new FabricItemSettings()));

    public static final Item GILDED_OBSIDIAN_HELMET = registerItem("gilded_obsidian_helmet",
            new GildedObsidianArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GILDED_OBSIDIAN_CHESTPLATE = registerItem("gilded_obsidian_chestplate",
            new GildedObsidianArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GILDED_OBSIDIAN_LEGGINGS = registerItem("gilded_obsidian_leggings",
            new GildedObsidianArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GILDED_OBSIDIAN_BOOTS = registerItem("gilded_obsidian_boots",
            new GildedObsidianArmorItem(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item TADANITE_HELMET = registerItem("tadanite_helmet",
            new TadaniteArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_CHESTPLATE = registerItem("tadanite_chestplate",
            new TadaniteArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_LEGGINGS = registerItem("tadanite_leggings",
            new TadaniteArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_BOOTS = registerItem("tadanite_boots",
            new TadaniteArmorItem(CoreAscensionArmorMaterials.TADANITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_PICKAXE = registerItem("tadanite_pickaxe",
            new TadanitePickaxeItem(CoreascensionToolMaterial.TADANITE, 6, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_SWORD = registerItem("tadanite_sword",
            new SwordItem(CoreascensionToolMaterial.TADANITE, 8, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_AXE = registerItem("tadanite_axe",
            new TadaniteAxeItem(CoreascensionToolMaterial.TADANITE, 11, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_SHOVEL = registerItem("tadanite_shovel",
            new TadaniteShovelItem(CoreascensionToolMaterial.TADANITE, 4, -3f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_HOE = registerItem("tadanite_hoe",
            new TadaniteHoeItem(CoreascensionToolMaterial.TADANITE, 2, -3f, new FabricItemSettings().fireproof()));




    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots",
            new ArmorItem(CoreAscensionArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe",
            new PickaxeItem(CoreascensionToolMaterial.TOOL, 2, -2.8f, new FabricItemSettings()));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword",
            new SwordItem(CoreascensionToolMaterial.TOOL, 4, -2.4f, new FabricItemSettings()));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe",
            new AxeItem(CoreascensionToolMaterial.TOOL, 8, -3.1f, new FabricItemSettings()));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel",
            new ShovelItem(CoreascensionToolMaterial.TOOL, 1, -3f, new FabricItemSettings()));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe",
            new HoeItem(CoreascensionToolMaterial.TOOL, 0, -3f, new FabricItemSettings()));


    public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), item);
	}

    public static void RegisterItems() {
		CoreAscension.LOGGER.info("Registering Items for "+CoreAscension.MOD_ID);
    }
}
