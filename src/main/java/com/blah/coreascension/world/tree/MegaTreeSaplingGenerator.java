package com.blah.coreascension.world.tree;

import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MegaTreeSaplingGenerator extends LargeTreeSaplingGenerator {
    RegistryKey<ConfiguredFeature<?, ?>> TREE;
    public MegaTreeSaplingGenerator(RegistryKey<ConfiguredFeature<?, ?>> tree) {
        this.TREE = tree;
    }

    protected @Nullable RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return TREE;
    }

    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return null;
    }
}
