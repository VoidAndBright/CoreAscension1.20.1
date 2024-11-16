package com.blah.coreascension.mixin;

import com.blah.coreascension.utils.CoreAscensionTags;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
    @Inject(method = "wearsGoldArmor", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"), cancellable = true)
    private static void wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> info, @Local ItemStack stack)
    {
        if (stack.isIn(CoreAscensionTags.GILDED_ARMOR)) info.setReturnValue(true);
    }
}
