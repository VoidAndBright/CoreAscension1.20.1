package com.blah.coreascension.effects;

import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FreezingEffect extends StatusEffect {
    int everySecond = 0;

    public FreezingEffect()
    {
        super(StatusEffectCategory.HARMFUL, // whether beneficial or harmful for entities
                0x00FFFF); // color in RGB
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        everySecond++;
        if (everySecond % 10 == 0)
        {
            entity.damage(CoreAscensionDamageTypes.of(entity.getWorld(), CoreAscensionDamageTypes.FREEZING), 2 * amplifier);
            everySecond = 0;
        }
    }

    // This method is called every tick to check whether it should apply the status effect or not
    
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
}
