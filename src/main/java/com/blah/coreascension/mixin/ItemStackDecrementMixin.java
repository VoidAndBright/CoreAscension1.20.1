package com.blah.coreascension.mixin;

import com.blah.coreascension.event.callback.ItemStackDecrementCallback;
import com.blah.coreascension.event.callback.LivingHurtCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public class ItemStackDecrementMixin
{
    @Inject(at = @At(value = "HEAD"), method = "decrement")
    private void onDecrement(int amount, CallbackInfo ci)
    {
        ItemStackDecrementCallback.EVENT.invoker().onDecrement(amount, (ItemStack)(Object)this);
    }
}
