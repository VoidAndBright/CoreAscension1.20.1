package com.blah.coreascension.world.ore;

import com.blah.coreascension.CoreAscension;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;


public class CoreAscensionOreGeneration
{
	public static void GenerateOres()
	{
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_MINERAL_DEBRIS_LARGE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_MINERAL_DEBRIS_SMALL_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_PURPUR_DEBRIS_LARGE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_PURPUR_DEBRIS_SMALL_PLACED_KEY);
	}
	public static final RegistryKey<PlacedFeature> ORE_MINERAL_DEBRIS_LARGE_PLACED_KEY = RegisterKey("ore_mineral_debris_large_placed");
	public static final RegistryKey<PlacedFeature> ORE_MINERAL_DEBRIS_SMALL_PLACED_KEY = RegisterKey("ore_mineral_debris_small_placed");
	public static final RegistryKey<PlacedFeature> ORE_PURPUR_DEBRIS_LARGE_PLACED_KEY = RegisterKey("ore_purpur_debris_large_placed");
	public static final RegistryKey<PlacedFeature> ORE_PURPUR_DEBRIS_SMALL_PLACED_KEY = RegisterKey("ore_purpur_debris_small_placed");

	public static RegistryKey<PlacedFeature> RegisterKey(String name)
	{
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
	}
}
