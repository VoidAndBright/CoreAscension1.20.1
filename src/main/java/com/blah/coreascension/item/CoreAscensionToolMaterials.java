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
    BEDROCK(8, 5500, 15f, 8f, 20,
            () -> Ingredient.ofItems(Blocks.BEDROCK)),
    SAPPHIRE(3, 1203, 10f, 4f, 15,
            () -> Ingredient.ofItems(CoreAscensionItems.SAPPHIRE)),
    TADANITE(5, 4000, 14f, 3f, 20,
            () -> Ingredient.ofItems(CoreAscensionItems.TADANITE_CRYSTAL)),
    LUMITE(7, 4500, 15f, 8f, 25,
            () -> Ingredient.ofItems(CoreAscensionItems.LUMITE_INGOT)),
    URANIUM(3, 2031, 10f, 4f, 0,
            () -> Ingredient.ofItems(CoreAscensionItems.URANIUM_INGOT)),
    POTATO(1, 77, 4f, 1f, 5,
            () -> Ingredient.ofItems(Items.POTATO, Items.POISONOUS_POTATO, Items.BAKED_POTATO)),
    SKYLANDS_SWORD(1, 1072, 4f, 4f, 10,
            () -> Ingredient.ofItems(CoreAscensionItems.HEAVENLY_FRAGMENT)),
    WOOD_SPECIAL(0, 35, 1f, 4.5f, 2,
            () -> Ingredient.fromTag(ItemTags.PLANKS)),
    STONE_SPECIAL(1, 78, 2f, 4.5f, 5,
            () -> Ingredient.fromTag(ItemTags.STONE_CRAFTING_MATERIALS)),
    IRON_SPECIAL(2, 150, 3f, 4.5f, 14,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    GOLD_SPECIAL(0, 19, 6f, 4.5f, 22,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    DIAMOND_SPECIAL(3, 936, 4f, 4.5f, 10,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE_SPECIAL(4, 1218, 5f, 4.5f, 15,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    TADANITE_SPECIAL(5, 2400, 7f, 4.5f, 20,
            () -> Ingredient.ofItems(CoreAscensionItems.TADANITE_CRYSTAL)),
    LUMITE_SPECIAL(6, 2700, 8f, 4.5f, 25,
            () -> Ingredient.ofItems(CoreAscensionItems.LUMITE_INGOT)),
    SAPPHIRE_SPECIAL(3, 721, 5f, 4.5f, 15,
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

    @Override
    public int getDurability()
    {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage()
    {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel()
    {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }
}
