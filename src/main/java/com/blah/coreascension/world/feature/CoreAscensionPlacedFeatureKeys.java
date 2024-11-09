package com.blah.coreascension.world.feature;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.TropicsTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class CoreAscensionPlacedFeatureKeys {
    public static final RegistryKey<PlacedFeature> UNIQUE_PLACED_FEATURE_KEY = RegisterPlacedKey("unique");
    public static final RegistryKey<PlacedFeature> TROPICS_SAPLING_PLACED_KEY = RegisterPlacedKey("tropics_tree");
    public static RegistryKey<PlacedFeature> RegisterPlacedKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
    }
    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, TROPICS_SAPLING_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(CoreAscensionConfiguredFeatureKeys.TROPICS_SAPLING_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        CoreAscensionBlocks.TROPICS_SAPLING));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    // by the way Ores are also placed features just put in their own class that all
}
