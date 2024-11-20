package com.blah.coreascension.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class LongRepairingPotionEffect extends StatusEffect {
    int everySecond = 0;

    public LongRepairingPotionEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0xCC00CC); // color in RGB
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        if (entity instanceof PlayerEntity player)
        {
            everySecond++;
            if (everySecond >= 60)
            {
                for (int i = 0; i < player.getInventory().main.size(); i++)
                {
                    if (player.getInventory().main.get(i).getDamage() > 0)
                    {
                        player.getInventory().main.get(i).setDamage(player.getInventory().main.get(i).getDamage() - 1);
                    }
                }
                for (int i = 0; i < player.getInventory().armor.size(); i++)
                {
                    if (player.getInventory().armor.get(i).getDamage() > 0)
                    {
                        player.getInventory().armor.get(i).setDamage(player.getInventory().armor.get(i).getDamage() - 1);
                    }
                }
                for (int i = 0; i < player.getInventory().offHand.size(); i++)
                {
                    if (player.getInventory().offHand.get(i).getDamage() > 0)
                    {
                        player.getInventory().offHand.get(i).setDamage(player.getInventory().offHand.get(i).getDamage() - 1);
                    }
                }
                everySecond = 0;
            }
        }
    }

    // This method is called every tick to check whether it should apply the status effect or not
    
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
}
