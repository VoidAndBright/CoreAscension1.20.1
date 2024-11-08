package com.blah.coreascension.world;

import com.blah.coreascension.world.biome.CoreAscensionBiomes;
import com.blah.coreascension.world.ore.CoreAscensionOres;

public class CoreAscensionWorldGeneration {
    public static void GenerateWorldGeneration(){
        CoreAscensionBiomes.GenerateBiomes();
        CoreAscensionOres.GenerateOres();
    }
}
