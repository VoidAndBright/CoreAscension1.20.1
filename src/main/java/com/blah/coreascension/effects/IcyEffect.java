package com.blah.coreascension.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class IcyEffect extends StatusEffect {
    public IcyEffect()
    {
        super(StatusEffectCategory.NEUTRAL, // whether beneficial or harmful for entities
                0x00FFFF); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
}
