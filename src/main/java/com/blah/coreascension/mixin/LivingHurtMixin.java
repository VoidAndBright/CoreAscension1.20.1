package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.LivingHurtCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingHurtMixin
{
    @Inject(at = @At(value = "HEAD"), method = "damage")
    private void onDamaged(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir)
    {
        ActionResult result = LivingHurtCallback.EVENT.invoker().onHurt(source, (LivingEntity)(Object)this);
    }
}
