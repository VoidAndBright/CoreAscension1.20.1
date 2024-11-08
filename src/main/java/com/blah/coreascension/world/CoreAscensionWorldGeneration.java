package com.blah.coreascension.world;

import com.blah.coreascension.world.biome.CoreAscensionBiomeGeneration;
import com.blah.coreascension.world.ore.CoreAscensionOreGeneration;

public class CoreAscensionWorldGeneration {
    public static void GenerateWorldGeneration(){
        CoreAscensionBiomeGeneration.GenerateBiomes();
        CoreAscensionOreGeneration.GenerateOres();
    }
}
