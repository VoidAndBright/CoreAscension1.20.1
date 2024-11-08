package com.blah.coreascension.world.biome;

import com.blah.coreascension.CoreAscension;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public class CoreAscensionBiomeGeneration {
    public static final RegistryKey<Biome> TROPICS = RegisterKey("tropics");
    public static RegistryKey<Biome> RegisterKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(CoreAscension.MOD_ID, name));
    }
    public static void GenerateBiomes(){
        CoreAscensionSurfaceRules.GenerateSurfaceRules();
        BiomePlacement.addOverworld(TROPICS,
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(0.2f,0.55f),
                        MultiNoiseUtil.ParameterRange.of(0.1f,0.3f),
                        MultiNoiseUtil.ParameterRange.of(-0.19f,0.03f),
                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.05f),
                        MultiNoiseUtil.ParameterRange.of(0.0f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f,1.0f),
                        0L));
    }
}
