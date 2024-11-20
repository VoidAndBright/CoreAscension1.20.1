package com.blah.coreascension.enchantment.effect;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class RepellingEnchantment extends Enchantment {
    public RepellingEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    
    public int getMaxLevel()
    {
        return 2;
    }

    
    public int getMinPower(int level)
    {
        return 1;
    }
}
