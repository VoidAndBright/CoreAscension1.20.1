package com.blah.coreascension.enchantment.effect;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class SteppingEnchantment extends Enchantment {
    public SteppingEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

    @Override
    public int getMinPower(int level)
    {
        return 1;
    }
}
