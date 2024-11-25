package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;
import java.util.function.Consumer;

public class CoreAscensionAchievementGenerator extends FabricAdvancementProvider
{
    public CoreAscensionAchievementGenerator(FabricDataOutput output)
    {
        super(output);
    }

    public static UsingItemCriterion.Conditions usingItem(EntityType<?> entity, Item item)
    {
        return UsingItemCriterion.Conditions.create(
                EntityPredicate.Builder.create(),
                ItemPredicate.Builder.create().items(item)
        );
    }

    
    public void generateAdvancement(Consumer<Advancement> consumer)
    {
        Advancement needForSpeed = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.THE_TOOL, // The display icon
                        Text.literal("Need For Speed"), // The title
                        Text.literal("Craft The Tool™"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(10))
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("need_for_speed", RecipeCraftedCriterion.Conditions.create(
                                new Identifier("coreascension:the_tool"),
                                List.of(ItemPredicate.Builder.create().items(
                                        Blocks.GOLD_BLOCK.asItem(), Blocks.REDSTONE_BLOCK.asItem(), Blocks.GOLD_BLOCK.asItem(),
                                        Blocks.LAPIS_BLOCK.asItem(), Blocks.LAPIS_BLOCK.asItem()).build())))
                .build(consumer, "coreascension" + "/the_tool");

        Advancement catalyzer = Advancement.Builder.create()
                .display(
                        CoreAscensionBlocks.CATALYZER_TABLE.asItem(), // The display icon
                        Text.literal("Catalyzer"), // The title
                        Text.literal("Craft the Catalyzer"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .parent(needForSpeed)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("catalyzer", RecipeCraftedCriterion.Conditions.create(
                        new Identifier("coreascension:catalyzer"),
                        List.of(ItemPredicate.Builder.create().tag(ItemTags.PLANKS).items(
                                Items.IRON_INGOT,
                                CoreAscensionBlocks.SULPHUR_BLOCK.asItem(),
                                Blocks.CRAFTING_TABLE.asItem()
                            ).build())))
                .build(consumer, "coreascension" + "/catalyzer");

        Advancement tasteTheRainbow = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.CRYSTALLINE_ARTIFACT, // The display icon
                        Text.literal("Taste the Rainbow"), // The title
                        Text.literal("Obtain all gems"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(15))
                .parent(needForSpeed)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("taste_the_rainbow", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.RUBY, CoreAscensionItems.CITRINE, CoreAscensionItems.TOPAZ, CoreAscensionItems.SAPPHIRE, CoreAscensionItems.AMETHYST, CoreAscensionItems.ZIRCON, Items.EMERALD, Items.DIAMOND))
                .build(consumer, "coreascension" + "/taste_the_rainbow");

        Advancement magicMirror = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.MAGIC_MIRROR, // The display icon
                        Text.literal("Gaze In The Mirror"), // The title
                        Text.literal("Use a Magic Mirror"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(10))
                .parent(tasteTheRainbow)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("magic_mirror", usingItem(EntityType.PLAYER, CoreAscensionItems.MAGIC_MIRROR))
                .build(consumer, "coreascension" + "/magic_mirror");

        Advancement hammerTime = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.IRON_HAMMER, // The display icon
                        Text.literal("Stop! Hammer Time"), // The title
                        Text.literal("Obtain a mining hammer"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .parent(needForSpeed)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("hammer_time", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.IRON_HAMMER))
                .build(consumer, "coreascension" + "/hammer_time");

        Advancement gettingADowngrade = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.POTATO_PICKAXE, // The display icon
                        Text.literal("Getting a Downgrade"), // The title
                        Text.literal("Craft a Potato Pickaxe"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .parent(catalyzer)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("catalyzer", RecipeCraftedCriterion.Conditions.create(
                        new Identifier("coreascension:potato_pickaxe"),
                        List.of(ItemPredicate.Builder.create().items(
                                Items.POISONOUS_POTATO,
                                Items.STICK
                        ).build())))
                .build(consumer, "coreascension" + "/getting_a_downgrade");

        Advancement why = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.POTATO_HAMMER, // The display icon
                        Text.literal("Why?"), // The title
                        Text.literal("Obtain all the Potato tools"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(75))
                .parent(gettingADowngrade)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("why", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.POTATO_PICKAXE, CoreAscensionItems.POTATO_SWORD, CoreAscensionItems.POTATO_AXE, CoreAscensionItems.POTATO_SHOVEL, CoreAscensionItems.POTATO_HOE, CoreAscensionItems.POTATO_HAMMER, CoreAscensionItems.POTATO_EXCAVATOR, CoreAscensionItems.POTATO_SCYTHE))
                .build(consumer, "coreascension" + "/why");

        Advancement iCanMineTHAT = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.POTATO_HAMMER, // The display icon
                        Text.literal("I can mine THAT!"), // The title
                        Text.literal("Craft a Bedrock Pickaxe"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(40))
                .parent(catalyzer)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("i_can_mine_that", RecipeCraftedCriterion.Conditions.create(
                        new Identifier("coreascension:bedrock_pickaxe"),
                        List.of(ItemPredicate.Builder.create().items(
                                Blocks.BEDROCK.asItem(),
                                CoreAscensionItems.FROZEN_ARTIFACT
                        ).build())))
                .build(consumer, "coreascension" + "/i_can_mine_that");

        Advancement notTheAether = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.SKYLANDS_WAYNODE, // The display icon
                        Text.literal("Not the Aether!"), // The title
                        Text.literal("Enter the Skylands"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(10))
                .parent(catalyzer)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("not_the_aether", ChangedDimensionCriterion.Conditions.to(RegistryKey.of(RegistryKeys.WORLD, new Identifier("coreascension", "skylands"))))
                .build(consumer, "coreascension" + "/not_the_aether");

        Advancement cheatTheVoid = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.VOID_TOTEM, // The display icon
                        Text.literal("Cheat the Void"), // The title
                        Text.literal("Avoid death by using a Void Totem"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .parent(notTheAether)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("cheat_the_void", UsedTotemCriterion.Conditions.create(CoreAscensionItems.VOID_TOTEM))
                .build(consumer, "coreascension" + "/cheat_the_void");
    }
}
