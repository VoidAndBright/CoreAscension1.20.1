package com.blah.coreascension.item.potion;

import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.item.potion.effects.*;
import com.blah.coreascension.mixin.PotionMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionPotions
{
    public static final Potion WARMTH_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "warmth_potion"),
                    new Potion(new StatusEffectInstance(new WarmthPotionEffect(), 3600, 0)));
    public static final Potion BUILDERS_CURSE_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "builders_curse_potion"),
                    new Potion(new StatusEffectInstance(new BuildersCurseEffect(), 3600, 0)));
    public static final Potion TERRESTRIAL_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "terrestrial_potion"),
                    new Potion(new StatusEffectInstance(new TerrestrialPotionEffect(), 3600, 0)));
    public static final Potion REPAIRING_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "repairing_potion"),
                    new Potion(new StatusEffectInstance(new RepairingPotionEffect(), 3600, 0)));
    public static final Potion LONG_REPAIRING_POTION =
            Registry.register(Registries.POTION, new Identifier("coreascension", "long_repairing_potion"),
                    new Potion(new StatusEffectInstance(new LongRepairingPotionEffect(), 9600, 0)));

    public static void registerPotions()
    {

    }

    public static void registerPotionsRecipes()
    {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, CoreAscensionItems.ICE_CREAM, WARMTH_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, CoreAscensionItems.TERRESTRIAL_CONSTRUCT, TERRESTRIAL_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(TERRESTRIAL_POTION, CoreAscensionItems.CRYSTALLINE_ARTIFACT, REPAIRING_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(REPAIRING_POTION, Items.REDSTONE, LONG_REPAIRING_POTION);
    }
}
