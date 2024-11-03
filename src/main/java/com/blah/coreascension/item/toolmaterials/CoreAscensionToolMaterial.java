package com.blah.coreascension.item.toolmaterials;

import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum CoreAscensionToolMaterial implements ToolMaterial {
    TOOL(1, 0, 13f, 4f, 0,
            null, ""),
    SAPPHIRE(3, 1203, 10f, 4f, 15,
            () -> Ingredient.ofItems(CoreAscensionItems.SAPPHIRE), ""),
    TADANITE(5, 4000, 14f, 8f, 20,
            () -> Ingredient.ofItems(CoreAscensionItems.TADANITE_CRYSTAL), "Efficient"),
    URANIUM(3, 2031, 10f, 4f, 0,
                     () -> Ingredient.ofItems(CoreAscensionItems.URANIUM_INGOT), "");

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final String tooltip;
    private final Supplier<Ingredient> repairIngredient;

    CoreAscensionToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient, String toolTip) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
        this.tooltip = toolTip;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
