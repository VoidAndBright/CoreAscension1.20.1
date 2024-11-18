package com.blah.coreascension.item;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.effects.CoreAscensionStatusEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum CoreAscensionArmorMaterials implements ArmorMaterial {
    GILDED_OBSIDIAN("gilded_obsidian", 25, new int[] { 2, 5, 4, 2 }, new StatusEffect[] { StatusEffects.FIRE_RESISTANCE }, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0f, 0f, () -> Ingredient.ofItems(CoreAscensionItems.OBSIDIAN_FABRIC)),
    TADANITE("tadanite", 200, new int[] { 6, 11, 10, 6 }, new StatusEffect[] { StatusEffects.FIRE_RESISTANCE, StatusEffects.SPEED, StatusEffects.RESISTANCE, StatusEffects.JUMP_BOOST, CoreAscensionStatusEffects.WARMTH }, 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.2f, 0.115f, () -> Ingredient.ofItems(CoreAscensionItems.TADANITE_DIAMOND)),
    LUMITE("lumite", 350, new int[] { 11, 16, 15, 13 }, new StatusEffect[] { StatusEffects.FIRE_RESISTANCE, StatusEffects.SPEED, StatusEffects.RESISTANCE, StatusEffects.JUMP_BOOST, CoreAscensionStatusEffects.WARMTH, StatusEffects.SATURATION }, 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2f, 0.13f, () -> Ingredient.ofItems(CoreAscensionItems.LUMITE_INGOT)),
    SAPPHIRE("sapphire", 25, new int[] { 2, 4, 4, 3 }, null, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f, 0f, () -> Ingredient.ofItems(CoreAscensionItems.SAPPHIRE)),
    CRYSTAL("crystal", 30, new int[] { 3, 5, 5, 4 }, new StatusEffect[] { StatusEffects.HASTE }, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3f, 0.1f, () -> Ingredient.ofItems(CoreAscensionItems.SAPPHIRE)),
    URANIUM("uranium", 25, new int[] { 2, 4, 4, 3 }, null, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3f, 0f, () -> Ingredient.ofItems(CoreAscensionItems.URANIUM_INGOT));

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final StatusEffect[] statusEffects;
    private final Supplier<Ingredient> repairIngredient;

    CoreAscensionArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, StatusEffect[] statusEffects, int enchantability, SoundEvent equipSound,
                                float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient)
    {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.statusEffects = statusEffects;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type)
    {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type)
    {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }

    @Override
    public String getName()
    {
        return CoreAscension.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return this.knockbackResistance;
    }

    public StatusEffect[] getStatusEffects()
    {
        return this.statusEffects;
    }
}
