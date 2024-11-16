package com.blah.coreascension.event.events;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import com.blah.coreascension.event.callback.ArrowHitCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;

public class FlingShooterEvent implements ArrowHitCallback {

    public ActionResult interact(Entity Arrow, EntityHitResult hit)
    {
        if (hit.getEntity() instanceof PlayerEntity player)
        {
            if (Arrow instanceof ProjectileEntity arrow && !(arrow.getOwner() instanceof PlayerEntity))
            {
                Entity attacker = arrow.getOwner();
                int enchantLevel = EnchantmentHelper.getLevel(CoreAscensionEnchantments.REPELLING, player.getInventory().getArmorStack(2));
                if (player.getInventory().getArmorStack(2).hasEnchantments() && enchantLevel > 0)
                {
                    if (attacker instanceof LivingEntity)
                    {
                        attacker.setVelocity(0, enchantLevel, 0);
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        return ActionResult.FAIL;
    }
}