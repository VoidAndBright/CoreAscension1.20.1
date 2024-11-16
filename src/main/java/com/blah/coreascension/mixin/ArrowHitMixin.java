package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.LivingEntityAttackCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProjectileEntity.class)
public abstract class ArrowHitMixin {
    @Inject(at = @At(value = "HEAD"), method = "onEntityHit", cancellable = true)
    private void onHit(EntityHitResult entityHitResult, CallbackInfo ci)
    {
        ActionResult result = LivingEntityAttackCallback.EVENT.invoker().interact((LivingEntity) entityHitResult.getEntity(), entityHitResult.getEntity());
        if (result == ActionResult.FAIL)
            ci.cancel();
    }
}
