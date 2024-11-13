package com.blah.coreascension.item.potion.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WarmthPotionEffect extends StatusEffect {
    public WarmthPotionEffect() {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0xFF6600); // color in RGB
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "ice_resistance"), this);

    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
//    @Override
//    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
//        if (entity instanceof PlayerEntity) {
//            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you EXP faster
//        }
//    }
}
