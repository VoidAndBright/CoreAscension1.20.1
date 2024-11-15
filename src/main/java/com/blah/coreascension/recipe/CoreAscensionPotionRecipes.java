package com.blah.coreascension.recipe;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.effects.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionPotionRecipes
{
    public static final Potion WARMTH_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "warmth_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.WARMTH, 3600, 0)));
    public static final Potion BUILDERS_CURSE_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "builders_curse_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.BUILDERS_CURSE, 3600, 0)));
    public static final Potion TERRESTRIAL_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "terrestrial_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.TERRESTRIAL, 3600, 0)));
    public static final Potion REPAIRING_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "repairing_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.REPAIRING, 3600, 0)));
    public static final Potion LONG_REPAIRING_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "long_repairing_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.LONG_REPAIRING, 9600, 0)));
    public static final Potion JUMP_BOOST_3_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "jump_boost_3_potion"),
                    new Potion(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 3600, 2)));

    public static final Potion FREEZING_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "freezing_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.FREEZING, 3600, 0)));
    public static final Potion STRONG_FREEZING_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "strong_freezing_potion"),
                    new Potion(new StatusEffectInstance(CoreAscensionStatusEffects.FREEZING, 3600, 2)));


    public static void registerPotionRecipes()
    {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, CoreAscensionItems.ICE_CREAM, WARMTH_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, CoreAscensionItems.TERRESTRIAL_CONSTRUCT, TERRESTRIAL_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(TERRESTRIAL_POTION, CoreAscensionItems.TERRESTRIAL_CONSTRUCT, BUILDERS_CURSE_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(TERRESTRIAL_POTION, CoreAscensionItems.CRYSTALLINE_ARTIFACT, REPAIRING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(REPAIRING_POTION, Items.REDSTONE, LONG_REPAIRING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, CoreAscensionBlocks.ETHEREAL_MEMBRANE.asItem(), JUMP_BOOST_3_POTION);
    }
}
