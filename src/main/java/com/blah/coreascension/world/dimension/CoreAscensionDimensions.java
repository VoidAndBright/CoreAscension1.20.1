package com.blah.coreascension.world.dimension;

import com.blah.coreascension.CoreAscension;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class CoreAscensionDimensions
{
    public static final RegistryKey<DimensionOptions> SKYLANDS_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(CoreAscension.MOD_ID, "skylands"));
    public static final RegistryKey<World> SKYLANDS_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(CoreAscension.MOD_ID, "skylands"));
    public static final RegistryKey<DimensionType> SKYLANDS_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(CoreAscension.MOD_ID, "skylands_type"));

    public static void bootstrapType(Registerable<DimensionType> context)
    {
        context.register(SKYLANDS_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
