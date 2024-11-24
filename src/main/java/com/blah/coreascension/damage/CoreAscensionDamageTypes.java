package com.blah.coreascension.damage;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CoreAscensionDamageTypes {
    public static final RegistryKey<DamageType> FREEZING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("coreascension", "freezing"));
    public static final RegistryKey<DamageType> ICE_CREAM_BLOCK = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("coreascension", "ice_cream_block"));

    public static DamageSource of(World world, RegistryKey<DamageType> key)
    {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
