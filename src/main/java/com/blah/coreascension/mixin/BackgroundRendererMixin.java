package com.blah.coreascension.mixin;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.CameraSubmersionType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin
{
    @Shadow private static float red;
    @Shadow private static float green;
    @Shadow private static float blue;
    @Shadow private static long lastWaterFogColorUpdateTime;

    @Inject(method = "render", at = @At(value = "TAIL"))
    private static void render(Camera camera, float tickDelta, ClientWorld world, int viewDistance, float skyDarkness, CallbackInfo ci)
    {
        float f;
        float g;
        float h;

        float r;
        float s;
        float t;
        if (camera.getSubmersionType() == CameraSubmersionType.WATER && world.getBlockState(camera.getBlockPos()).getBlock() == CoreAscensionBlocks.END_GAS)
        {
            long l = Util.getMeasuringTimeMs();
            int j = 16756054 >> 16 & 255;
            int k = 16756054 >> 8 & 255;
            int m = 16756054 & 255;
            int n = 16756054 >> 16 & 255;
            int o = 16756054 >> 8 & 255;
            int p = 16756054 & 255;
            f = MathHelper.clamp((float)(l - lastWaterFogColorUpdateTime) / 5000.0F, 0.0F, 1.0F);
            g = MathHelper.lerp(f, (float)n, (float)j);
            h = MathHelper.lerp(f, (float)o, (float)k);
            float q = MathHelper.lerp(f, (float)p, (float)m);
            red = g / 255.0F;
            green = h / 255.0F;
            blue = q / 255.0F;
        }

        if (camera.getSubmersionType() == CameraSubmersionType.WATER && world.getBlockState(camera.getBlockPos()).getBlock() == CoreAscensionBlocks.END_GAS)
        {
            if (camera.getFocusedEntity() instanceof ClientPlayerEntity)
            {
                s = ((ClientPlayerEntity)camera.getFocusedEntity()).getUnderwaterVisibility();
            }
            else
            {
                s = 1F;
            }
        }
        else
        {
            s = 0f;
        }

        if (red != 0.0F && green != 0.0F && blue != 0.0F)
        {
            t = Math.min(1.0F / red, Math.min(1.0F / green, 1.0F / blue));
            red = red * (1.0F - s) + red * t * s;
            green = green * (1.0F - s) + green * t * s;
            blue = blue * (1.0F - s) + blue * t * s;
        }

        RenderSystem.clearColor(red, green, blue, 0.0F);
    }
}
