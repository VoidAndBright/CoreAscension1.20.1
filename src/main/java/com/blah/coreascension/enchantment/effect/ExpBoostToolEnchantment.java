package com.blah.coreascension.enchantment.effect;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;

public class ExpBoostToolEnchantment extends Enchantment {
    public ExpBoostToolEnchantment()
    {
        super(Rarity.COMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    
    public int getMaxLevel()
    {
        return 3;
    }

    
    public int getMinPower(int level)
    {
        return 1;
    }

    
    protected boolean canAccept(Enchantment other)
    {
        return other == Enchantments.EFFICIENCY ||
                other == Enchantments.FORTUNE ||
                other == Enchantments.UNBREAKING ||
                other == CoreAscensionEnchantments.MOLTEN_TOUCH;
    }

    
    public boolean isAcceptableItem(ItemStack stack)
    {
        return stack.getItem() instanceof PickaxeItem;
    }
}

