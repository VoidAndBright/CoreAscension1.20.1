package com.blah.coreascension.enchantment.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class LavaStriderEnchantment extends Enchantment {
    public LavaStriderEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }


    public int getMaxLevel()
    {
        return 3;
    }


    public int getMinPower(int level)
    {
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other)
    {
        return super.canAccept(other) && other != Enchantments.FROST_WALKER;
    }
}
