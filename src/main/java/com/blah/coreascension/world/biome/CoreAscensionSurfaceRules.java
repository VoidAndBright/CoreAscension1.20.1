package com.blah.coreascension.world.biome;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;


public class CoreAscensionSurfaceRules
{
    public static MaterialRules.MaterialRule TROPICS_SURFACE =
        MaterialRules.condition(MaterialRules.biome(CoreAscensionBiomeKeys.TROPICS),
            MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.stoneDepth(2, true, VerticalSurfaceType.FLOOR), block(CoreAscensionBlocks.BLACK_SAND)),
                block(CoreAscensionBlocks.BLACK_SANDSTONE)
            )
        );
    public static MaterialRules.MaterialRule DREAD_SURFACE =
            MaterialRules.condition(MaterialRules.biome(CoreAscensionBiomeKeys.VALLEY_OF_THE_DAMNED),
                    MaterialRules.sequence(
                            MaterialRules.condition(MaterialRules.stoneDepth(2, true, VerticalSurfaceType.FLOOR), block(CoreAscensionBlocks.DREAD_SAND)),
                            block(CoreAscensionBlocks.DREAD_ROCK)
                    )
            );
    private static MaterialRules.MaterialRule block(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
    public static void GenerateSurfaceRules()
    {
        SurfaceGeneration.addOverworldSurfaceRules(new Identifier("coreascension","rules/overworld"),
                MaterialRules.condition(MaterialRules.surface(), MaterialRules.sequence(TROPICS_SURFACE)));
        SurfaceGeneration.addOverworldSurfaceRules(new Identifier("coreascension","rules/overworld"),
                MaterialRules.condition(MaterialRules.surface(), MaterialRules.sequence(DREAD_SURFACE)));
    }
}
