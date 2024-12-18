package com.blah.coreascension.enchantment.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;

public class MoltenTouchEnchantment extends Enchantment {
    public MoltenTouchEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    
    public int getMaxLevel()
    {
        return 1;
    }

    
    public int getMinPower(int level)
    {
        return 1;
    }

    
    protected boolean canAccept(Enchantment other)
    {
        return other == Enchantments.EFFICIENCY ||
                other == Enchantments.FORTUNE ||
                other == Enchantments.UNBREAKING;
    }

    
    public boolean isAcceptableItem(ItemStack stack)
    {
        return stack.getItem() instanceof PickaxeItem ||
                stack.getItem() instanceof ShovelItem ||
                stack.getItem() instanceof AxeItem;
    }
}
