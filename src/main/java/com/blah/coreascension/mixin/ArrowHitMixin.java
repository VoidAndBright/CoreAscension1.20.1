package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.ArrowHitCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProjectileEntity.class)
public abstract class ArrowHitMixin {
    @Shadow @Nullable public abstract Entity getOwner();

    @Inject(at = @At(value = "HEAD"), method = "onEntityHit", cancellable = true)
    private void onHit(EntityHitResult entityHitResult, CallbackInfo ci)
    {
        ActionResult result = ArrowHitCallback.EVENT.invoker().interact((ProjectileEntity)(Object)this,entityHitResult);
        if (result == ActionResult.FAIL)
            ci.cancel();

    }
}
