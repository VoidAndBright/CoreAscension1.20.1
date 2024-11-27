package com.blah.coreascension.world.biome;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class CoreAscensionSurfaceRules {
    public static MaterialRules.MaterialRule TROPICS_SURFACE =
            MaterialRules.condition(MaterialRules.biome(CoreAscensionBiomes.TROPICS),
                    MaterialRules.sequence(
                            MaterialRules.condition(MaterialRules.stoneDepth(2, true, VerticalSurfaceType.FLOOR), MaterialRules.block(CoreAscensionBlocks.BLACK_SAND.getDefaultState())),
                            MaterialRules.block(CoreAscensionBlocks.BLACK_SANDSTONE.getDefaultState())
                    )
            );
    public static MaterialRules.MaterialRule DREAD_SURFACE =
            MaterialRules.condition(MaterialRules.biome(CoreAscensionBiomes.VALLEY_OF_THE_DAMNED),
                    MaterialRules.sequence(
                            MaterialRules.condition(MaterialRules.stoneDepth(2, true, VerticalSurfaceType.FLOOR), MaterialRules.block(CoreAscensionBlocks.DREAD_SAND.getDefaultState())),
                            MaterialRules.block(CoreAscensionBlocks.DREAD_ROCK.getDefaultState())
                    )
            );

    public static MaterialRules.MaterialRule SCORIA_SURFACE =
            MaterialRules.condition(MaterialRules.biome(CoreAscensionBiomes.SCORIA_CAVE),
                    MaterialRules.sequence(
                            MaterialRules.condition(MaterialRules.stoneDepth(2, true, VerticalSurfaceType.FLOOR), MaterialRules.block(CoreAscensionBlocks.SCORIA.getDefaultState())),
                            MaterialRules.block(CoreAscensionBlocks.SCORIA.getDefaultState())
                    )
            );

    public static void GenerateSurfaceRules()
    {
        SurfaceGeneration.addOverworldSurfaceRules(Identifier.of(CoreAscension.MOD_ID, "rules/overworld"),
                MaterialRules.condition(MaterialRules.surface(), MaterialRules.sequence(TROPICS_SURFACE)));
        SurfaceGeneration.addOverworldSurfaceRules(new Identifier(CoreAscension.MOD_ID, "rules/overworld"),
                MaterialRules.condition(MaterialRules.surface(), MaterialRules.sequence(DREAD_SURFACE)));
    }
}
