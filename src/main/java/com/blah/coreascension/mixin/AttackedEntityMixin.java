package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.EntityAttackCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class AttackedEntityMixin
{
    @Inject(at = @At(value = "TAIL"), method = "onAttacking", cancellable = true)
    private void onAttacking(Entity target, CallbackInfo ci)
    {
        ActionResult result = EntityAttackCallback.EVENT.invoker().interact(target);
        if (result == ActionResult.FAIL)
            ci.cancel();
    }
}
