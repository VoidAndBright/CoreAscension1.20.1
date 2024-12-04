package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.LivingDeathCallback;
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
public class LivingDeathMixin
{
    @Inject(at = @At(value = "HEAD"), method = "onDeath")
    private void onDeath(DamageSource damageSource, CallbackInfo ci)
    {
        LivingDeathCallback.EVENT.invoker().onDeath(damageSource, (LivingEntity)(Object)this);
    }
}
