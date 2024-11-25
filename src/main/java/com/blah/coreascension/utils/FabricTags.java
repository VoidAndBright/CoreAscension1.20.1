package com.blah.coreascension.utils;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class FabricTags {
    public static final TagKey<Block> NEEDS_TOOL_LEVEL_8 = RegisterBlockTag("needs_tool_level_8");
    public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 = RegisterBlockTag("needs_tool_level_4");

    private static TagKey<Block> RegisterBlockTag(String name)
    {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", name));
    }
}
