package com.blah.coreascension.event.events;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import com.blah.coreascension.event.callback.LivingEntityAttackCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.ActionResult;

public class LivingAttackEvent implements LivingEntityAttackCallback {
    @Override
    public ActionResult interact(LivingEntity target, Entity attacker)
    {
        if (target instanceof PlayerEntity player)
        {
            int enchantLevel = EnchantmentHelper.getLevel(CoreAscensionEnchantments.REPELLING, player.getInventory().armor.get(2));
            if (player.getInventory().armor.get(2).hasEnchantments() &&
                    enchantLevel > 0)
            {
                assert attacker != null;
                if (attacker instanceof ProjectileEntity proj)
                {
                    if (proj.getOwner() != null && !(proj.getOwner() instanceof PlayerEntity))
                    {
                        proj.getOwner().setVelocity(0, enchantLevel, 0);
                        return ActionResult.SUCCESS;
                    }
                    return ActionResult.FAIL;
                }
                if (attacker instanceof Entity)
                {
                    attacker.setVelocity(0, enchantLevel, 0);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.FAIL;
    }
}
