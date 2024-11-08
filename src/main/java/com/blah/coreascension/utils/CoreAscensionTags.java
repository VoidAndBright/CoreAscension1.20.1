package com.blah.coreascension.utils;

import com.blah.coreascension.CoreAscension;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CoreAscensionTags {
    public static final TagKey<Block> HEAT_SOURCES = RegisterBlockTag("heat_sources");
    public static final TagKey<Block> COOL_SOURCES = RegisterBlockTag("cool_sources");
    public static final TagKey<Block> TOOL_MINEABLE = RegisterBlockTag("tool_mineable");

    private static TagKey<Block> RegisterBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(CoreAscension.MOD_ID, name));
    }

    private static TagKey<Item> RegisterItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(CoreAscension.MOD_ID, name));
    }
}
