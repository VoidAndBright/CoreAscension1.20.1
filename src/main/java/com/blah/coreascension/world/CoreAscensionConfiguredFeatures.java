package com.blah.coreascension.world;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;

import java.util.List;

public class CoreAscensionConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registerKey("uranium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUD_DISK = registerKey("mud_disk");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        ConfiguredFeatures.register(context, MUD_DISK, Feature.DISK, new DiskFeatureConfig(PredicatedStateProvider.of(CoreAscensionBlocks.TROPICS_MUD), BlockPredicate.matchingBlocks(List.of(Blocks.DIRT, CoreAscensionBlocks.TROPICS_MUD)), UniformIntProvider.create(2, 3), 1));

        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new BlockMatchRuleTest(Blocks.BASALT);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

//        List<OreFeatureConfig.Target> overworldRubyOres =
//                List.of(OreFeatureConfig.createTarget(stoneReplacables, CoreAscensionBlocks.URANIUM_ORE.getDefaultState()),
//                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> uraniumOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, CoreAscensionBlocks.URANIUM_ORE.getDefaultState()));

//        List<OreFeatureConfig.Target> endRubyOres =
//                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.END_STONE_RUBY_ORE.getDefaultState()));

       // register(context, URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 12));
        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(uraniumOres, 12));
        //register(context, END_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRubyOres, 12));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CoreAscension.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
