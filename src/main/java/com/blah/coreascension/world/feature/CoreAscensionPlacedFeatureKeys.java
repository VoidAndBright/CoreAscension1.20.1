package com.blah.coreascension.world.feature;

import com.blah.coreascension.CoreAscension;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

public class CoreAscensionPlacedFeatureKeys {
    public static final RegistryKey<PlacedFeature> UNIQUE_PLACED_FEATURE_KEY = RegisterPlacedKey("unique");
    public static RegistryKey<PlacedFeature> RegisterPlacedKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
    }
    // by the way Ores are also placed features just put in their own class that all
}
