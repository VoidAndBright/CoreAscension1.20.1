package com.blah.coreascension.effects;

import com.blah.coreascension.damagetype.CoreAscensionDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IcyEffect extends StatusEffect
{
    public IcyEffect()
    {
        super(StatusEffectCategory.NEUTRAL, // whether beneficial or harmful for entities
                0x00FFFF); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
}
