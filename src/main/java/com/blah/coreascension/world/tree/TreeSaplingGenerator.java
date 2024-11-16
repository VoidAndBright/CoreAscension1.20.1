package com.blah.coreascension.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class TreeSaplingGenerator extends SaplingGenerator {
    RegistryKey<ConfiguredFeature<?, ?>> TREE;

    public TreeSaplingGenerator(RegistryKey<ConfiguredFeature<?, ?>> tree)
    {
        this.TREE = tree;
    }

    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees)
    {
        return TREE;
    }
}
