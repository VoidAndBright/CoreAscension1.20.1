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
	public static final RegistryKey<PlacedFeature> ORE_MAGNETITE_LOWER_PLACED_KEY = RegisterKey("ore_magnetite_lower");
	public static final RegistryKey<PlacedFeature> ORE_MAGNETITE_UPPER_PLACED_KEY = RegisterKey("ore_magnetite_upper");
	public static final RegistryKey<PlacedFeature> ORE_SALTROCK_LOWER_PLACED_KEY = RegisterKey("ore_saltrock_lower");
	public static final RegistryKey<PlacedFeature> ORE_SALTROCK_UPPER_PLACED_KEY = RegisterKey("ore_saltrock_upper");
	public static final RegistryKey<PlacedFeature> ORE_IGNEOUS_ROCK_LOWER_PLACED_KEY = RegisterKey("ore_igneous_rock_lower");
	public static final RegistryKey<PlacedFeature> ORE_IGNEOUS_ROCK_UPPER_PLACED_KEY = RegisterKey("ore_igneous_rock_upper");

	public static RegistryKey<PlacedFeature> RegisterKey(String name)
	{
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
	}
	public static void GenerateOres()
	{
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_MAGNETITE_LOWER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_MAGNETITE_UPPER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_SALTROCK_LOWER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_SALTROCK_UPPER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_IGNEOUS_ROCK_LOWER_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_IGNEOUS_ROCK_UPPER_PLACED_KEY);

	}
}
