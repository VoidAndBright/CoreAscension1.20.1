package com.blah.coreascension.world.biome;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public class CoreAscensionBiomes {
    public static void RegisterBiomes(){
        BiomePlacement.addOverworld(CoreAscensionBiomeKeys.TROPICS,
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(-1.0f, -0.15f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f, -0.35f),
                        MultiNoiseUtil.ParameterRange.of(0.3f, 1.0f),
                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.05f),
                        MultiNoiseUtil.ParameterRange.of(0.0f),
                        MultiNoiseUtil.ParameterRange.of(0.0f, 1.0f),
                        0L));
    }
}
