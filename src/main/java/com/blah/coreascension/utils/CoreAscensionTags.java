package com.blah.coreascension.utils;

import com.blah.coreascension.CoreAscension;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CoreAscensionTags {
    public static class Blocks {
        public static final TagKey<Block> HEAT_SOURCES = createTag("heat_sources");
        public static final TagKey<Block> COOL_SOURCES = createTag("cool_sources");
        public static final TagKey<Block> THE_TOOL_MINEABLE = createTag("the_tool_mineable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CoreAscension.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CoreAscension.MOD_ID, name));
        }
    }
}
