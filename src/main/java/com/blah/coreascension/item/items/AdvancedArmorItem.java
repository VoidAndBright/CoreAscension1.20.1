package com.blah.coreascension.item.items;

import com.blah.coreascension.effects.CoreAscensionStatusEffects;
import com.blah.coreascension.effects.WarmthPotionEffect;
import com.blah.coreascension.item.CoreAscensionArmorMaterials;
import com.blah.coreascension.recipe.CoreAscensionPotionRecipes;
import com.blah.coreascension.recipe.CoreAscensionRecipes;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class AdvancedArmorItem extends ArmorItem
{
    private final Multimap<ArmorMaterial, StatusEffectInstance> ArmorSetEffects;

    public AdvancedArmorItem(ArmorMaterial material, Type type, Settings settings)
    {
        super(material, type, settings);
        ImmutableMultimap.Builder<ArmorMaterial, StatusEffectInstance> builder = ImmutableMultimap.builder();
        builder.put(CoreAscensionArmorMaterials.TADANITE, new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 0, false, false));
        builder.put(CoreAscensionArmorMaterials.TADANITE, new StatusEffectInstance(StatusEffects.SPEED, 60, 1, false, false));
        builder.put(CoreAscensionArmorMaterials.TADANITE, new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60, 1, false, false));
        builder.put(CoreAscensionArmorMaterials.TADANITE, new StatusEffectInstance(StatusEffects.RESISTANCE, 60, 1, false, false));
        builder.put(CoreAscensionArmorMaterials.TADANITE, new StatusEffectInstance(CoreAscensionStatusEffects.WARMTH, 60, 1, false, false));
        builder.put(CoreAscensionArmorMaterials.GILDED_OBSIDIAN, new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 1,false,false));
                this.ArmorSetEffects = builder.build();
    }
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient())
        {
            if(entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player))
            {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player)
    {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : ArmorSetEffects.entries())
        {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player))
            {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect)
    {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect)
        {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player)
    {
        for (ItemStack armorStack: player.getInventory().armor)
        {
            if(!(armorStack.getItem() instanceof ArmorItem))
            {
                return false;
            }
        }

        return true;
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player)
    {
        if (!hasFullSuitOfArmorOn(player))
        {
            return false;
        }
        for (int iterate = 0; iterate < 4; iterate++)
        {
            if(((ArmorItem)player.getInventory().getArmorStack(iterate).getItem()).getMaterial() != material)
            {
                return false;
            }
        }
        return true;
    }
}
