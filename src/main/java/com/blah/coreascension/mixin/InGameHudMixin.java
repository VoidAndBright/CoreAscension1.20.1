package com.blah.coreascension.mixin;

import com.blah.coreascension.utils.CoreAscensionTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InGameHud.class)
@Environment(EnvType.CLIENT)
public abstract class InGameHudMixin
{
    @WrapOperation(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSubmergedIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean renderAirBubbles(PlayerEntity instance, TagKey<Fluid> tagKey, Operation<Boolean> original)
    {
        if (instance.isSubmergedIn(CoreAscensionTags.END_GAS))
        {
            return true;
        }
        return original.call(instance, tagKey);
    }
}
