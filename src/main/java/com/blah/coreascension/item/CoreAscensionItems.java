package com.blah.coreascension.item;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.armormaterials.ModArmorMaterials;
import com.blah.coreascension.item.toolmaterials.ModToolMaterial;
import com.blah.coreascension.item.toolmaterials.TheToolToolMaterial;
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
    public static final Item THE_TOOL = registerItem("the_tool", new TheToolItem(4, 1.2F, TheToolToolMaterial.INSTANCE, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_FABRIC = registerItem("obsidian_fabric",new Item(new FabricItemSettings()));

    public static final Item GILDED_OBSIDIAN_HELMET = registerItem("gilded_obsidian_helmet",
            new GildedObsidianArmorItem(ModArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GILDED_OBSIDIAN_CHESTPLATE = registerItem("gilded_obsidian_chestplate",
            new GildedObsidianArmorItem(ModArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GILDED_OBSIDIAN_LEGGINGS = registerItem("gilded_obsidian_leggings",
            new GildedObsidianArmorItem(ModArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GILDED_OBSIDIAN_BOOTS = registerItem("gilded_obsidian_boots",
            new GildedObsidianArmorItem(ModArmorMaterials.GILDED_OBSIDIAN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item TADANITE_HELMET = registerItem("tadanite_helmet",
            new TadaniteArmorItem(ModArmorMaterials.TADANITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_CHESTPLATE = registerItem("tadanite_chestplate",
            new TadaniteArmorItem(ModArmorMaterials.TADANITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_LEGGINGS = registerItem("tadanite_leggings",
            new TadaniteArmorItem(ModArmorMaterials.TADANITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_BOOTS = registerItem("tadanite_boots",
            new TadaniteArmorItem(ModArmorMaterials.TADANITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_PICKAXE = registerItem("tadanite_pickaxe",
            new TadanitePickaxeItem(ModToolMaterial.TADANITE, 6, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_SWORD = registerItem("tadanite_sword",
            new SwordItem(ModToolMaterial.TADANITE, 8, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_AXE = registerItem("tadanite_axe",
            new TadaniteAxeItem(ModToolMaterial.TADANITE, 11, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_SHOVEL = registerItem("tadanite_shovel",
            new TadaniteShovelItem(ModToolMaterial.TADANITE, 4, -3f, new FabricItemSettings().fireproof()));
    public static final Item TADANITE_HOE = registerItem("tadanite_hoe",
            new TadaniteHoeItem(ModToolMaterial.TADANITE, 2, -3f, new FabricItemSettings().fireproof()));




    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe",
            new PickaxeItem(ModToolMaterial.SAPPHIRE, 2, -2.8f, new FabricItemSettings()));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword",
            new SwordItem(ModToolMaterial.SAPPHIRE, 4, -2.4f, new FabricItemSettings()));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe",
            new AxeItem(ModToolMaterial.SAPPHIRE, 8, -3.1f, new FabricItemSettings()));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel",
            new ShovelItem(ModToolMaterial.SAPPHIRE, 1, -3f, new FabricItemSettings()));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe",
            new HoeItem(ModToolMaterial.SAPPHIRE, 0, -3f, new FabricItemSettings()));


    public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(CoreAscension.MOD_ID, name), item);
	}

    public static void RegisterItems() {
		CoreAscension.LOGGER.info("Registering Items for "+CoreAscension.MOD_ID);
    }
}
