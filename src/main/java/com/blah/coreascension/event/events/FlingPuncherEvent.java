package com.blah.coreascension.event.events;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import com.blah.coreascension.event.callback.EntityAttackCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class FlingPuncherEvent implements EntityAttackCallback {
    public ActionResult interact(Entity target)
    {
        if (target instanceof PlayerEntity player)
        {
            Entity attacker = player.getAttacker();
            int enchantLevel = EnchantmentHelper.getLevel(CoreAscensionEnchantments.REPELLING, player.getInventory().getArmorStack(2));
            if (player.getInventory().getArmorStack(2).hasEnchantments() &&
                    enchantLevel > 0)
            {

                if (attacker instanceof LivingEntity)
                {
                    attacker.setVelocity(0, enchantLevel, 0);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.FAIL;
    }
}