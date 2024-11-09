package com.blah.coreascension.world.feature;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.TropicsTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class CoreAscensionConfiguredFeatureKeys {
    public static final RegistryKey<ConfiguredFeature<?, ?>> UNIQUE_CONFIGURED_FEATURE_KEY = RegisterConfiguredKey("unique");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TROPICS_SAPLING_KEY = RegisterConfiguredKey("tropics_tree");
    public static RegistryKey<ConfiguredFeature<?, ?>> RegisterConfiguredKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
    }
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        register(context, TROPICS_SAPLING_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(CoreAscensionBlocks.TROPICS_LOG),
                new TropicsTrunkPlacer(5, 4, 3),

                BlockStateProvider.of(CoreAscensionBlocks.TROPICS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

                new TwoLayersFeatureSize(1, 0, 2)).build()
        );
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
