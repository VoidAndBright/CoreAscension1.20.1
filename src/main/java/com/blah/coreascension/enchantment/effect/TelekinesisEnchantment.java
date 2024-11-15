package com.blah.coreascension.enchantment.effect;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

public class TelekinesisEnchantment extends Enchantment
{
    public TelekinesisEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack)
    {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof TridentItem || stack.getItem() instanceof RangedWeaponItem;
    }

    @Override
    public int getMinPower(int level)
    {
        return 1;
    }

    @Override
    public int getMaxLevel()
    {
        return 1;
    }
}
