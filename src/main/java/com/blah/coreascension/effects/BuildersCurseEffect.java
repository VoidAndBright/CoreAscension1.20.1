package com.blah.coreascension.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

public class BuildersCurseEffect extends StatusEffect
{
    public BuildersCurseEffect()
    {
        super(StatusEffectCategory.HARMFUL, // whether beneficial or harmful for entities
                0xCCCC00); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        if (entity instanceof ServerPlayerEntity player)
            if (!player.isCreative() && !player.isSpectator())
                player.interactionManager.changeGameMode(GameMode.ADVENTURE);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier)
    {
        if (entity instanceof ServerPlayerEntity player)
            if (!player.isCreative() && !player.isSpectator())
                player.interactionManager.changeGameMode(GameMode.SURVIVAL);

        super.onRemoved(entity, attributes, amplifier);
    }
}
