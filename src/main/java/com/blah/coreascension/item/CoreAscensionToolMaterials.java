package com.blah.coreascension.item;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;

import java.util.function.Supplier;

public enum CoreAscensionToolMaterials implements ToolMaterial {
    TOOL(1, 0, 13f, 4f, 0, null),
    BLAH(8, 0, 15f, 18f, 50, null),
    VOLCANO(4, 2031, 10f, 7f, 10,
            () -> Ingredient.ofItems(Items.LAVA_BUCKET, Items.BLAZE_ROD)),
    DUSK(4, 2786, 10f, 7f, 10,
            () -> Ingredient.ofItems(CoreAscensionItems.DAWN_ESSENCE)),
    BEDROCK(8, 5500, 15f, 8f, 20,
            () -> Ingredient.ofItems(Blocks.BEDROCK)),
    SAPPHIRE(3, 1203, 10f, 4f, 15,
            () -> Ingredient.ofItems(CoreAscensionItems.SAPPHIRE)),
    TADANITE(5, 4000, 14f, 7f, 20,
            () -> Ingredient.ofItems(CoreAscensionItems.TADANITE_CRYSTAL)),
    SOLARIUM(5, 4220, 14f, 8f, 23,
            () -> Ingredient.ofItems(CoreAscensionItems.SOLARIUM_INGOT)),
    LUMITE(7, 4500, 15f, 9f, 25,
            () -> Ingredient.ofItems(CoreAscensionItems.LUMITE_INGOT)),
    URANIUM(3, 2506, 10f, 4f, 0,
            () -> Ingredient.ofItems(CoreAscensionItems.URANIUM_INGOT)),
    POTATO(1, 77, 4f, 1f, 5,
            () -> Ingredient.ofItems(Items.POTATO, Items.POISONOUS_POTATO, Items.BAKED_POTATO)),
    SKYLANDS_SWORD(1, 1072, 4f, 4f, 10,
            () -> Ingredient.ofItems(CoreAscensionItems.HEAVENLY_FRAGMENT)),
    WOOD_SPECIAL(0, 236, 1f, 4.5f, 2,
            () -> Ingredient.fromTag(ItemTags.PLANKS)),
    STONE_SPECIAL(1, 524, 2f, 4.5f, 5,
            () -> Ingredient.fromTag(ItemTags.STONE_CRAFTING_MATERIALS)),
    IRON_SPECIAL(2, 1000, 3f, 4.5f, 14,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    GOLD_SPECIAL(0, 128, 6f, 4.5f, 22,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND_SPECIAL(3, 6244, 4f, 4.5f, 10,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_SPECIAL(4, 8124, 5f, 4.5f, 15,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    TADANITE_SPECIAL(5, 16000, 7f, 4.5f, 20,
            () -> Ingredient.ofItems(CoreAscensionItems.TADANITE_CRYSTAL)),
    SOLARIUM_SPECIAL(5, 16880, 7f, 5.5f, 23,
            () -> Ingredient.ofItems(CoreAscensionItems.SOLARIUM_INGOT)),
    LUMITE_SPECIAL(6, 18000, 8f, 4.5f, 25,
            () -> Ingredient.ofItems(CoreAscensionItems.LUMITE_INGOT)),
    SAPPHIRE_SPECIAL(3, 4812, 5f, 4.5f, 15,
            () -> Ingredient.ofItems(CoreAscensionItems.SAPPHIRE));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    CoreAscensionToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient)
    {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    
    public int getDurability()
    {
        return this.itemDurability;
    }

    
    public float getMiningSpeedMultiplier()
    {
        return this.miningSpeed;
    }

    
    public float getAttackDamage()
    {
        return this.attackDamage;
    }

    
    public int getMiningLevel()
    {
        return this.miningLevel;
    }

    
    public int getEnchantability()
    {
        return this.enchantability;
    }

    
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }
}
