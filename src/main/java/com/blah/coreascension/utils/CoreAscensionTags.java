package com.blah.coreascension.utils;

import com.blah.coreascension.CoreAscension;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CoreAscensionTags {
    public static final TagKey<Block> HEAT_SOURCES = RegisterBlockTag("heat_sources");
    public static final TagKey<Block> COOL_SOURCES = RegisterBlockTag("cool_sources");
    public static final TagKey<Block> TOOL_MINEABLE = RegisterBlockTag("tool_mineable");
    public static final TagKey<Block> SCYTHE_MINEABLE = RegisterBlockTag("scythe_mineable");
    public static final TagKey<Item> GILDED_ARMOR = RegisterItemTag("gilded_armor");
    public static final TagKey<Item> MINES_BEDROCK = RegisterItemTag("mines_bedrock");
    public static final TagKey<Item> MINING_HAMMERS = RegisterItemTag("mining_hammers");
    public static final TagKey<Fluid> END_GAS = RegisterFluidTag("end_gas");

    private static TagKey<Block> RegisterBlockTag(String name)
    {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(CoreAscension.MOD_ID, name));
    }

    private static TagKey<Fluid> RegisterFluidTag(String name)
    {
        return TagKey.of(RegistryKeys.FLUID, new Identifier(CoreAscension.MOD_ID, name));
    }

    private static TagKey<Item> RegisterItemTag(String name)
    {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(CoreAscension.MOD_ID, name));
    }
}
