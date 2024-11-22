package com.blah.coreascension.world.biome;

import com.blah.coreascension.CoreAscension;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public class CoreAscensionBiomes {
    public static final RegistryKey<Biome> TROPICS = RegisterKey("tropics");
    public static final RegistryKey<Biome> VALLEY_OF_THE_DAMNED = RegisterKey("valley_of_the_damned");
    public static final RegistryKey<Biome> CEDAR_GROVE = RegisterKey("cedar_grove");
    public static final RegistryKey<Biome> ETHEREAL_GLADE = RegisterKey("ethereal_glade");
    public static final RegistryKey<Biome> ANCIENT = RegisterKey("ancient");
    public static final RegistryKey<Biome> DARK_MATTER = RegisterKey("dark_matter");
    public static final RegistryKey<Biome> CANDYLAND = RegisterKey("candyland");
    public static final RegistryKey<Biome> CLOUD_MOUNTAINS = RegisterKey("cloud_mountains");
    public static final RegistryKey<Biome> PSYCHEDELIC_FIELDS = RegisterKey("psychedelic_fields");

    public static RegistryKey<Biome> RegisterKey(String name)
    {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(CoreAscension.MOD_ID, name));
    }

    public static void GenerateBiomes()
    {
        CoreAscensionSurfaceRules.GenerateSurfaceRules();
        BiomePlacement.addOverworld(TROPICS,
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(0.2f, 0.55f),
                        MultiNoiseUtil.ParameterRange.of(0.3f, 1.0f),
                        MultiNoiseUtil.ParameterRange.of(-0.19f, 0.55f),
                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.05f),
                        MultiNoiseUtil.ParameterRange.of(0.0f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f, 1.0f),
                        0L));
//        BiomePlacement.addOverworld(VALLEY_OF_THE_DAMNED,
//                new MultiNoiseUtil.NoiseHypercube(
//                        MultiNoiseUtil.ParameterRange.of(0.2f, 0.55f),
//                        MultiNoiseUtil.ParameterRange.of(0.1f, 0.3f),
//                        MultiNoiseUtil.ParameterRange.of(-0.19f, 0.03f),
//                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.05f),
//                        MultiNoiseUtil.ParameterRange.of(0.0f),
//                        MultiNoiseUtil.ParameterRange.of(-1.0f, 1.0f),
//                        0L));
        BiomePlacement.addOverworld(CEDAR_GROVE,
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(0.2f, 0.55f),
                        MultiNoiseUtil.ParameterRange.of(0.1f, 0.3f),
                        MultiNoiseUtil.ParameterRange.of(-0.19f, 0.03f),
                        MultiNoiseUtil.ParameterRange.of(-0.375f, 0.05f),
                        MultiNoiseUtil.ParameterRange.of(0.0f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f, 1.0f),
                        0L));
    }
}
