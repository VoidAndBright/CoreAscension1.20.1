package com.blah.coreascension.recipe;

import com.blah.coreascension.item.CoreAscensionItems;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class CatalyzerRecipe implements Recipe<SimpleInventory> {
    private static final int size = 3;
    private final Identifier id;
    private final ItemStack result;
    private final DefaultedList<Ingredient> ingredients;

    public CatalyzerRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> inputs)
    {
        this.id = id;
        this.result = output;
        this.ingredients = inputs;
    }


    public boolean matches(SimpleInventory inventory, World world)
    {
        if (world.isClient())
        {
            return false;
        }
        return
              (ingredients.get(0).test(inventory.getStack(0))
            && ingredients.get(1).test(inventory.getStack(1))
            && ingredients.get(2).test(inventory.getStack(1)))
            ||
              (ingredients.get(0).test(inventory.getStack(0))
            && ingredients.get(1).test(inventory.getStack(1))
            && ingredients.get(2).test(inventory.getStack(1)));
    }

    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager)
    {
        return result;
    }

    public boolean fits(int width, int height)
    {
        return true;
    }

    public ItemStack getOutput(DynamicRegistryManager registryManager)
    {
        return result;
    }

    public Identifier getId()
    {
        return id;
    }

    public RecipeSerializer<CatalyzerRecipe> getSerializer()
    {
        return Serializer.INSTANCE;
    }

    public RecipeType<CatalyzerRecipe> getType()
    {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CatalyzerRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<CatalyzerRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public CatalyzerRecipe read(Identifier id, JsonObject json)
        {
            ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(size, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++)
            {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
                if (inputs.get(i).test(new ItemStack(CoreAscensionItems.EMPTY)))
                {
                    inputs.set(i, Ingredient.EMPTY);
                }
            }

            return new CatalyzerRecipe(id, result, inputs);
        }

        public CatalyzerRecipe read(Identifier id, PacketByteBuf buf)
        {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));
            ItemStack output = buf.readItemStack();
            return new CatalyzerRecipe(id, output, inputs);
        }

        public void write(PacketByteBuf buf, CatalyzerRecipe recipe)
        {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients())
            {
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getOutput(null));
        }
    }
}
