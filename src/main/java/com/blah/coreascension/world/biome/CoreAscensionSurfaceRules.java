package com.blah.coreascension.world.biome;

import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

import static net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class CoreAscensionSurfaceRules {
    static MaterialRules.MaterialRule birchForest = condition(MaterialRules.biome(BiomeKeys.BIRCH_FOREST),
            block(Blocks.CALCITE.getDefaultState()));

    static MaterialRules.MaterialRule crimsonForest = condition(MaterialRules.biome(BiomeKeys.CRIMSON_FOREST), sequence(
            condition(STONE_DEPTH_FLOOR,
                    MaterialRules.sequence(
                            condition(
                                    MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17),
                                    block(Blocks.NETHER_WART_BLOCK.getDefaultState())),
                            block(Blocks.CRIMSON_NYLIUM.getDefaultState()))),
            block(Blocks.NETHERRACK.getDefaultState())));

    static MaterialRules.MaterialRule warpedForest = condition(MaterialRules.biome(BiomeKeys.WARPED_FOREST), sequence(
            condition(STONE_DEPTH_FLOOR,
                    MaterialRules.sequence(
                            condition(
                                    MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17),
                                    block(Blocks.WARPED_WART_BLOCK.getDefaultState())),
                            block(Blocks.WARPED_NYLIUM.getDefaultState()))),
            block(Blocks.NETHERRACK.getDefaultState())));

    public static void GenerateSurfaceRules(){
        SurfaceGeneration.addOverworldSurfaceRules(
                Identifier.of("minecraft", "rules/overworld"),
                condition(surface(), sequence(birchForest, crimsonForest, warpedForest)));
    }
}
