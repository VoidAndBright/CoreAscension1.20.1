package com.blah.coreascension.mixin;

import com.blah.coreascension.event.ItemEntityTickCallback;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityTickMixin
{
    @Inject(at = @At(value = "TAIL"), method = "tick", cancellable = true)
    private void onTick(CallbackInfo ci)
    {
        ActionResult result = ItemEntityTickCallback.EVENT.invoker().interact((ItemEntity) (Object) this);

        if(result == ActionResult.FAIL)
        {
            ci.cancel();
        }
    }
}
