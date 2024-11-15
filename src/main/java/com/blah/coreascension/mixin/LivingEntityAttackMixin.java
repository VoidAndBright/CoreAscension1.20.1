package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.LivingEntityAttackCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityAttackMixin
{
    @Inject(at = @At(value = "TAIL"), method = "onAttacking", cancellable = true)
    private void onAttacking(Entity target, CallbackInfo ci)
    {
        ActionResult result = LivingEntityAttackCallback.EVENT.invoker().interact((LivingEntity)target, ((LivingEntity)target).getAttacker());
        if (result == ActionResult.FAIL)
            ci.cancel();
    }
}
