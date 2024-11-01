package com.blah.coreascension.item.toolmaterials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TheToolToolMaterial implements ToolMaterial
{
    public static final TheToolToolMaterial INSTANCE = new TheToolToolMaterial();
    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 13;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
