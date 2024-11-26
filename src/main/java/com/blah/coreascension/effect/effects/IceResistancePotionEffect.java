package com.blah.coreascension.effect.effects;

import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import com.blah.coreascension.effect.CoreAscensionStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class IceResistancePotionEffect extends StatusEffect {
    public IceResistancePotionEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0xFF6600); // color in RGB
    }

    public StatusEffect getEffect()
    {
        return this;
    }
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        entity.inPowderSnow = false;
        entity.removeStatusEffect(CoreAscensionStatusEffects.FREEZING);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }
}
