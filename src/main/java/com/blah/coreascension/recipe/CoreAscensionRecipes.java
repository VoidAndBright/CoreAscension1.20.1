package com.blah.coreascension.recipe;

import com.blah.coreascension.CoreAscension;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class CoreAscensionRecipes {
    public static void RegisterRecipe(String name, RecipeType<?> Type, RecipeSerializer<?> Serializer)
    {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(CoreAscension.MOD_ID, name), Serializer);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(CoreAscension.MOD_ID, name), Type);
    }
    public static void RegisterRecipes() {
        CoreAscension.LOGGER.info("Registering Recipes for " + CoreAscension.MOD_ID);
        RegisterRecipe("catalyzer", CatalyzerRecipe.Type.INSTANCE, CatalyzerRecipe.Serializer.INSTANCE);
    }
}
