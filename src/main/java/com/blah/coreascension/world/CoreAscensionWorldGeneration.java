package com.blah.coreascension.world;

import com.blah.coreascension.world.biome.CoreAscensionBiomeGeneration;

public class CoreAscensionWorldGeneration {
    public static void GenerateWorldGeneration(){
        CoreAscensionBiomeGeneration.GenerateBiomes();
    }
    // don't remove anything here as it for future features such as ore, trees and geodes
}
