package com.blah.coreascension.world.biome;

import com.blah.coreascension.CoreAscension;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class CoreAscensionBiomeKeys {
    public static final RegistryKey<Biome> TROPICS = RegisterKey("tropics");
    public static RegistryKey<Biome> RegisterKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(CoreAscension.MOD_ID, name));
    }
}