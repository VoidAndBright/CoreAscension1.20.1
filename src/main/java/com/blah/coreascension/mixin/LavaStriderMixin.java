package com.blah.coreascension.mixin;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LavaStriderMixin
{
    @WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;updateVelocity(FLnet/minecraft/util/math/Vec3d;)V"), method = "travel")
    private void lavaStrider(LivingEntity instance, float speed, Vec3d movementInput, Operation<Void> original)
    {
        if (instance instanceof PlayerEntity player)
        {
            if (player.isInLava())
            {
                float baseSpeed = 0.02f;
                float level = EnchantmentHelper.getLevel(CoreAscensionEnchantments.MAGMA_STRIDER, player.getInventory().armor.get(0));
                if (level > 3) level = 3;
                if (!player.isOnGround())
                {
                    level /= 2f;
                }
                if (level > 0.0F)
                {
                    baseSpeed += (player.getMovementSpeed() - baseSpeed) * level / 3.0F;
                }
                original.call(player, baseSpeed, movementInput);
            }
            else
            {
                original.call(player, speed, movementInput);
            }
        }
        else original.call(instance, speed, movementInput);
    }
}
