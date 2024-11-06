package com.blah.coreascension.world;

import com.blah.coreascension.world.biome.CoreAscensionBiomeGeneration;
import com.blah.coreascension.world.biome.CoreAscensionSurfaceRules;

public class CoreAscensionWorldGeneration {
    public static void GenerateWorldGeneration(){
        CoreAscensionBiomeGeneration.GenerateBiomes();
        CoreAscensionSurfaceRules.GenerateSurfaceRules();
    }
    // don't remove anything here as it for future features such as ore, trees and geodes
}
