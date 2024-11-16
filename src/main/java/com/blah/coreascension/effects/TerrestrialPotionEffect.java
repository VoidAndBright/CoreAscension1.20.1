package com.blah.coreascension.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class TerrestrialPotionEffect extends StatusEffect {
    public TerrestrialPotionEffect()
    {
        super(StatusEffectCategory.NEUTRAL, // whether beneficial or harmful for entities
                0xCCCCCC); // color in RGB
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }
}
