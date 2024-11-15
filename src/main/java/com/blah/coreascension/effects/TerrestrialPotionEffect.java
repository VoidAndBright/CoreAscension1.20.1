package com.blah.coreascension.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TerrestrialPotionEffect extends StatusEffect
{
    public TerrestrialPotionEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0xCCCCCC); // color in RGB
       // Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "terrestrial"), this);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }
}
