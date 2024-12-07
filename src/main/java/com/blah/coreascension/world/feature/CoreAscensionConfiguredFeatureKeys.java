package com.blah.coreascension.world.feature;

import com.blah.coreascension.CoreAscension;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CoreAscensionConfiguredFeatureKeys {
    public static final RegistryKey<ConfiguredFeature<?, ?>> UNIQUE_FEATURE_KEY = RegisterConfiguredKey("unique");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TROPICS_TREE_KEY = RegisterConfiguredKey("tropics_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CEDAR_TREE_KEY = RegisterConfiguredKey("cedar_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POPSICLE_TREE_KEY = RegisterConfiguredKey("popsicle_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ETHEREAL_TREE_KEY = RegisterConfiguredKey("ethereal_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DARK_MATTER_TREE_KEY = RegisterConfiguredKey("dark_matter_tree");

    public static RegistryKey<ConfiguredFeature<?, ?>> RegisterConfiguredKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
    }
}
