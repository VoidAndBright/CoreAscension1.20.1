package com.blah.coreascension.mixin;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.world.biome.CoreAscensionBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(VanillaBiomeParameters.class)
public abstract class UndergroundBiomeMixin
{
    @Shadow @Final private MultiNoiseUtil.ParameterRange defaultParameter;
    @Shadow @Final private MultiNoiseUtil.ParameterRange[] erosionParameters;
    @Shadow @Final private MultiNoiseUtil.ParameterRange[] humidityParameters;

    @Shadow protected abstract void writeCaveBiomeParameters(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome);

    @Inject(at = @At("HEAD"), method = "writeCaveBiomes")
    private void addCaveBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, CallbackInfo ci)
    {
        CoreAscension.LOGGER.info("HI");
        writeCaveBiomeParameters(parameters, MultiNoiseUtil.ParameterRange.of(2), MultiNoiseUtil.ParameterRange.of(0.5f, 0.7f), MultiNoiseUtil.ParameterRange.of(0.8F, 1.0F), this.defaultParameter, this.defaultParameter, 0.0F, CoreAscensionBiomes.SCORIA_CAVE);
    }
}
