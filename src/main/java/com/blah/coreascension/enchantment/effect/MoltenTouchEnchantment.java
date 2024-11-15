package com.blah.coreascension.enchantment.effect;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class MoltenTouchEnchantment extends Enchantment
{
    public MoltenTouchEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack)
    {
        return stack.getItem() instanceof PickaxeItem ||
                stack.getItem() instanceof ShovelItem ||
                stack.getItem() instanceof AxeItem;
    }

    @Override
    protected boolean canAccept(Enchantment other)
    {
        return other == Enchantments.EFFICIENCY ||
                other == Enchantments.FORTUNE ||
                other == Enchantments.UNBREAKING;
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
