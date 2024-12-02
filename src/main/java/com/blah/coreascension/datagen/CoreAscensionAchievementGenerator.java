package com.blah.coreascension.datagen;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.criterion.UsedVoidTotemCriterion;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.utils.CoreAscensionTags;
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
                        Text.translatable("advancements.need_for_speed.title"), // The title
                        Text.translatable("advancements.need_for_speed.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
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
                .build(consumer, CoreAscension.MOD_ID + "/the_tool");

        Advancement.Builder.create()
                .display(
                        CoreAscensionBlocks.PIGNEOUS_ROCK.asItem(), // The display icon
                        Text.translatable("advancements.pigneous_rock.title"), // The title
                        Text.translatable("advancements.pigneous_rock.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .parent(needForSpeed)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("pigneous", InventoryChangedCriterion.Conditions.items(CoreAscensionBlocks.PIGNEOUS_ROCK.asItem()))
                .build(consumer, CoreAscension.MOD_ID + "/pigneous");

        Advancement catalyzer = Advancement.Builder.create()
                .display(
                        CoreAscensionBlocks.CATALYZER_TABLE.asItem(), // The display icon
                        Text.translatable("advancements.catalyzer.title"), // The title
                        Text.translatable("advancements.catalyzer.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
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
                .build(consumer, CoreAscension.MOD_ID + "/catalyzer");

        Advancement tasteTheRainbow = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.CRYSTALLINE_ARTIFACT, // The display icon
                        Text.translatable("advancements.taste_the_rainbow.title"), // The title
                        Text.translatable("advancements.taste_the_rainbow.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(15))
                .parent(needForSpeed)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("taste_the_rainbow", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.RUBY, CoreAscensionItems.CITRINE, CoreAscensionItems.TOPAZ, CoreAscensionItems.SAPPHIRE, CoreAscensionItems.AMETHYST, CoreAscensionItems.ZIRCON, Items.EMERALD, Items.DIAMOND))
                .build(consumer, CoreAscension.MOD_ID + "/taste_the_rainbow");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.MAGIC_MIRROR, // The display icon
                        Text.translatable("advancements.gaze_in_the_mirror.title"), // The title
                        Text.translatable("advancements.gaze_in_the_mirror.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(10))
                .parent(tasteTheRainbow)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("magic_mirror", usingItem(EntityType.PLAYER, CoreAscensionItems.MAGIC_MIRROR))
                .build(consumer, CoreAscension.MOD_ID + "/magic_mirror");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.IRON_HAMMER, // The display icon
                        Text.translatable("advancements.stop_hammer_time.title"), // The title
                        Text.translatable("advancements.stop_hammer_time.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .parent(needForSpeed)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("hammer_time", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(CoreAscensionTags.MINING_HAMMERS).build()))
                .build(consumer, CoreAscension.MOD_ID + "/hammer_time");

        Advancement gettingADowngrade = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.POTATO_PICKAXE, // The display icon
                        Text.translatable("advancements.getting_a_downgrade.title"), // The title
                        Text.translatable("advancements.getting_a_downgrade.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
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
                .build(consumer, CoreAscension.MOD_ID + "/getting_a_downgrade");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.POTATO_HAMMER, // The display icon
                        Text.translatable("advancements.why.title"), // The title
                        Text.translatable("advancements.why.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(75))
                .parent(gettingADowngrade)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("why", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.POTATO_PICKAXE, CoreAscensionItems.POTATO_SWORD, CoreAscensionItems.POTATO_AXE, CoreAscensionItems.POTATO_SHOVEL, CoreAscensionItems.POTATO_HOE, CoreAscensionItems.POTATO_HAMMER, CoreAscensionItems.POTATO_EXCAVATOR, CoreAscensionItems.POTATO_SCYTHE))
                .build(consumer, CoreAscension.MOD_ID + "/why");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.BEDROCK_PICKAXE, // The display icon
                        Text.translatable("advancements.bedrock_pick.title"), // The title
                        Text.translatable("advancements.bedrock_pick.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
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
                .build(consumer, CoreAscension.MOD_ID + "/i_can_mine_that");

        Advancement notTheAether = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.SKYLANDS_WAYNODE, // The display icon
                        Text.translatable("advancements.enter_skylands.title"), // The title
                        Text.translatable("advancements.enter_skylands.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(10))
                .parent(catalyzer)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("not_the_aether", ChangedDimensionCriterion.Conditions.to(RegistryKey.of(RegistryKeys.WORLD, new Identifier(CoreAscension.MOD_ID, "skylands"))))
                .build(consumer, CoreAscension.MOD_ID + "/not_the_aether");

        Advancement chilly = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.NETHER_CORE_KEY, // The display icon
                        Text.translatable("advancements.nether_core.title"), // The title
                        Text.translatable("advancements.nether_core.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(30))
                .parent(catalyzer)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("chilly", ChangedDimensionCriterion.Conditions.to(RegistryKey.of(RegistryKeys.WORLD, new Identifier(CoreAscension.MOD_ID, "nether_core"))))
                .build(consumer, CoreAscension.MOD_ID + "/chilly");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.TADANITE_HELMET, // The display icon
                        Text.translatable("advancements.tadanite_armor.title"), // The title
                        Text.translatable("advancements.tadanite_armor.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(20))
                .parent(chilly)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("cover_me_with_tadanite", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.TADANITE_HELMET, CoreAscensionItems.TADANITE_CHESTPLATE, CoreAscensionItems.TADANITE_LEGGINGS, CoreAscensionItems.TADANITE_BOOTS))
                .build(consumer, CoreAscension.MOD_ID + "/cover_me_with_tadanite");

        Advancement catalyticInverter = Advancement.Builder.create()
                .display(
                        CoreAscensionItems.CATALYTIC_INVERTER, // The display icon
                        Text.translatable("advancements.catalytic_inverter.title"), // The title
                        Text.translatable("advancements.catalytic_inverter.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(15))
                .parent(catalyzer)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("inverter_factor_nine", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.CATALYTIC_INVERTER))
                .build(consumer, CoreAscension.MOD_ID + "/inverter_factor_nine");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.LUMITE_HELMET, // The display icon
                        Text.translatable("advancements.lumite_armor.title"), // The title
                        Text.translatable("advancements.lumite_armor.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(25))
                .parent(catalyticInverter)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("cover_me_with_lumite", InventoryChangedCriterion.Conditions.items(CoreAscensionItems.LUMITE_HELMET, CoreAscensionItems.LUMITE_CHESTPLATE, CoreAscensionItems.LUMITE_LEGGINGS, CoreAscensionItems.LUMITE_BOOTS))
                .build(consumer, CoreAscension.MOD_ID + "/cover_me_with_lumite");

        Advancement.Builder.create()
                .display(
                        CoreAscensionItems.VOID_TOTEM, // The display icon
                        Text.translatable("advancements.void_totem.title"), // The title
                        Text.translatable("advancements.void_totem.desc"), // The description
                        new Identifier(CoreAscension.MOD_ID, "textures/gui/ethereal_dirt.png"), // Background image used
                        AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                .rewards(AdvancementRewards.Builder.experience(100))
                .parent(notTheAether)
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("cheat_the_void", UsedTotemCriterion.Conditions.create(CoreAscensionItems.VOID_TOTEM))
                .build(consumer, CoreAscension.MOD_ID + "/cheat_the_void");
    }
}
