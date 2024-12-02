package com.blah.coreascension;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.criterion.UsedVoidTotemCriterion;
import com.blah.coreascension.effect.CoreAscensionStatusEffects;
import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import com.blah.coreascension.entity.CoreAscensionBoats;
import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.event.CoreAscensionEvents;
import com.blah.coreascension.group.CoreAscensionGroups;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.particles.CoreAscensionParticles;
import com.blah.coreascension.recipe.CoreAscensionRecipes;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import com.blah.coreascension.world.CoreAscensionWorldGeneration;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.blah.coreascension.world.tree.CoreAscensionTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoreAscension implements ModInitializer {
    public static final String MOD_ID = "coreascension";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public void onInitialize()
    {
        LOGGER.info("Hello Fabric world!");
        CoreAscensionBlocks.RegisterBlocks();
        CoreAscensionItems.RegisterItems();
        CoreAscensionParticles.RegisterParticles();
        CoreAscensionBlockEntities.RegisterBlockEntities();
        CoreAscensionGroups.RegisterGroups();
        CoreAscensionScreenHandlers.RegisterScreenHandlers();
        CoreAscensionRecipes.RegisterRecipes();
        CoreAscensionEntities.RegisterEntities();
        CoreAscensionWorldGeneration.GenerateWorldAdditions();
        CoreAscensionTrunkPlacerTypes.RegisterTrunkPlacers();
        CoreAscensionFoliagePlacerTypes.RegisterFoliagePlacers();
        CoreAscensionEvents.RegisterEvents();
        CoreAscensionEnchantments.RegisterEnchantments();
        CoreAscensionStatusEffects.RegisterStatusEffects();
        CoreAscensionBoats.RegisterBoats();

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.GLOWSTONE)
                .lightWithItem(CoreAscensionItems.SKYLANDS_WAYNODE)
                .customPortalBlock((CustomPortalBlock) CoreAscensionBlocks.SKYLANDS_PORTAL_BLOCK)
                .destDimID(Identifier.of(CoreAscension.MOD_ID, "skylands"))
                //.tintColor(192, 224, 60)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(CoreAscensionBlocks.NETHER_ICE)
                .lightWithItem(CoreAscensionItems.NETHER_CORE_KEY)
                .customPortalBlock((CustomPortalBlock) CoreAscensionBlocks.NETHER_CORE_PORTAL_BLOCK)
                .destDimID(Identifier.of(CoreAscension.MOD_ID, "nether_core"))
                .registerPortal();
    }
}