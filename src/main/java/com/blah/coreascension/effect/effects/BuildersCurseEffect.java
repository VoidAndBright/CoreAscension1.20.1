package com.blah.coreascension.effect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

public class BuildersCurseEffect extends StatusEffect {
    public BuildersCurseEffect()
    {
        super(StatusEffectCategory.HARMFUL, // whether beneficial or harmful for entities
                0xCCCC00); // color in RGB
    }

    
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        if (entity instanceof ServerPlayerEntity player)
            if (!player.isCreative() && !player.isSpectator())
                player.interactionManager.changeGameMode(GameMode.ADVENTURE);
    }

    // This method is called every tick to check whether it should apply the status effect or not
    
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier)
    {
        if (entity instanceof ServerPlayerEntity player)
            if (!player.isCreative() && !player.isSpectator())
                player.interactionManager.changeGameMode(GameMode.SURVIVAL);

        super.onRemoved(entity, attributes, amplifier);
    }
}
