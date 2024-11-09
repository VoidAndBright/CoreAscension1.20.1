package com.blah.coreascension.world.tree;

import com.blah.coreascension.world.feature.CoreAscensionConfiguredFeatureKeys;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class TropicsSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CoreAscensionConfiguredFeatureKeys.TROPICS_SAPLING_KEY;
    }
}
