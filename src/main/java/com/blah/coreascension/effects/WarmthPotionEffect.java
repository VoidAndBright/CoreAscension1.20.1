package com.blah.coreascension.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class WarmthPotionEffect extends StatusEffect {
    public WarmthPotionEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0xFF6600); // color in RGB
    }

    public StatusEffect getEffect()
    {
        return this;
    }

    // This method is called every tick to check whether it should apply the status effect or not
    
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
//    
//    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
//        if (entity instanceof PlayerEntity) {
//            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you EXP faster
//        }
//    }
}
