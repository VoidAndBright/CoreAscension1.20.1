package com.blah.coreascension.world.feature;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
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
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHESTNUT_KEY = RegisterConfiguredKey("chestnut");
    public static RegistryKey<ConfiguredFeature<?, ?>> RegisterConfiguredKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
    }
}
