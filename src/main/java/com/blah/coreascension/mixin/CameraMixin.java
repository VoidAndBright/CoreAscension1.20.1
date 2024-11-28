package com.blah.coreascension.mixin;

import com.blah.coreascension.utils.CoreAscensionTags;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.CameraSubmersionType;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public class CameraMixin
{
    @Shadow private BlockView area;
    @Final @Shadow private BlockPos.Mutable blockPos;

    @Inject(method = "getSubmersionType", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"), cancellable = true)
    private void replace(CallbackInfoReturnable<CameraSubmersionType> cir)
    {
        FluidState fluidState = area.getFluidState(blockPos);
        if (fluidState.isIn(CoreAscensionTags.END_GAS))
        {
            cir.setReturnValue(CameraSubmersionType.WATER);
        }
    }
}
