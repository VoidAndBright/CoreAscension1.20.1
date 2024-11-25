package com.blah.coreascension.item.food;

import net.minecraft.item.FoodComponent;

public class CoreAscensionFoodComponents {
    public static final FoodComponent CALAMARI = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build();
    public static final FoodComponent COOKED_CALAMARI = new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build();
    public static final FoodComponent COCONUT = new FoodComponent.Builder().hunger(4).saturationModifier(0.7f).build();
    public static final FoodComponent MEGA_BERRY = new FoodComponent.Builder().hunger(18).saturationModifier(0.4f).build();
    public static final FoodComponent NETHER_MUSHROOM_STEW = new FoodComponent.Builder().hunger(4).saturationModifier(5f).build();
    public static final FoodComponent DARK_MATTER_JELLY = new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).build();
}
