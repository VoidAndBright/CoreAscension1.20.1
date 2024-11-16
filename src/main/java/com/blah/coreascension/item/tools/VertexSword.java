package com.blah.coreascension.item.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Formatting;

public class VertexSword extends SwordTooltipItem {
    public VertexSword(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, String... tooltip)
    {
        super(material, attackDamage, attackSpeed, settings, Formatting.GRAY, tooltip);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        double random = Math.random();
        if (random < 0.16) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
        } else if (random < 0.33) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1));
        } else if (random < 0.5) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 60, 1));
        } else if (random < 0.67) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
        } else if (random < 0.83) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1));
        } else {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }
}
