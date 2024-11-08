package com.blah.coreascension.recipe;

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

public class DimensionalSurgingRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack result;
    private final DefaultedList<Ingredient> ingredients;

    public DimensionalSurgingRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> inputs) {
        this.id = id;
        this.result = output;
        this.ingredients = inputs;
    }


    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }
        return ingredients.get(0).test(inventory.getStack(1))&&ingredients.get(1).test(inventory.getStack(2))&&ingredients.get(2).test(inventory.getStack(3))&&ingredients.get(3).test(inventory.getStack(4));
    }

	public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
		return result;
	}

    public boolean fits(int width, int height) {
        return true;
    }

    public ItemStack getOutput(DynamicRegistryManager registryManager) {
		return result;
	}

    public Identifier getId() {
        return id;
    }

    public RecipeSerializer<?> getSerializer() {return new Serializer();}

    public RecipeType<?> getType() {return new Type();}

    public static class Type implements RecipeType<DimensionalSurgingRecipe>{}
    public static class Serializer implements RecipeSerializer<DimensionalSurgingRecipe> {
        public DimensionalSurgingRecipe read(Identifier id, JsonObject json)
        {
            ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(4, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new DimensionalSurgingRecipe(id, result, inputs);
        }
        public DimensionalSurgingRecipe read(Identifier id, PacketByteBuf buf)
        {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
			inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));
            ItemStack output = buf.readItemStack();
            return new DimensionalSurgingRecipe(id, output, inputs);
        }
        public void write(PacketByteBuf buf, DimensionalSurgingRecipe recipe)
        {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
				ingredient.write(buf);
            }
			buf.writeItemStack(recipe.getOutput(null));
        }
	}
}
