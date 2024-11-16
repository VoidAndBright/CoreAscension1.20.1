package com.blah.coreascension.item.items;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.item.CoreAscensionArmorMaterials;
import com.blah.coreascension.item.CoreAscensionItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class AdvancedArmorItem extends ArmorItem {
    private final Multimap<CoreAscensionArmorMaterials, StatusEffectInstance> ArmorSetEffects;

    public String[] tooltip;

    public AdvancedArmorItem(CoreAscensionArmorMaterials material, Type type, Settings settings, int amplifier, String... tooltips)
    {
        super(material, type, settings);
        this.tooltip = tooltips;
        ImmutableMultimap.Builder<CoreAscensionArmorMaterials, StatusEffectInstance> builder = ImmutableMultimap.builder();
        for (StatusEffect effect : material.getStatusEffects()) {
            builder.put(material, new StatusEffectInstance(effect, 60, amplifier, false, false));
        }
        this.ArmorSetEffects = builder.build();
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
                if (player.getInventory().armor.get(0).getItem() == CoreAscensionItems.CRYSTAL_BOOTS) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60, 0, false, false));
                }
                if (player.getInventory().armor.get(1).getItem() == CoreAscensionItems.CRYSTAL_LEGGINGS) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60, 0, false, false));
                }
                if (player.getInventory().armor.get(2).getItem() == CoreAscensionItems.CRYSTAL_CHESTPLATE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60, 0, false, false));
                }
                if (player.getInventory().armor.get(3).getItem() == CoreAscensionItems.CRYSTAL_HELMET) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, -1, 0, false, false));
                } else {
                    player.removeStatusEffect(StatusEffects.NIGHT_VISION);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        if (this.tooltip != null) {
            tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, "tooltip.setbonus.armor_set"))).formatted(Formatting.GRAY));
            for (String tooltipLine : this.tooltip)
                tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, tooltipLine))).formatted(Formatting.BLUE));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player)
    {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        return true;
    }

    private void evaluateArmorEffects(PlayerEntity player)
    {
        for (Map.Entry<CoreAscensionArmorMaterials, StatusEffectInstance> entry : ArmorSetEffects.entries()) {
            CoreAscensionArmorMaterials mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private boolean hasCorrectArmorOn(CoreAscensionArmorMaterials material, PlayerEntity player)
    {
        if (!hasFullSuitOfArmorOn(player)) {
            return false;
        }
        if (material == CoreAscensionArmorMaterials.TADANITE || material == CoreAscensionArmorMaterials.GILDED_OBSIDIAN) // ||
        //material == CoreAscensionArmorMaterials.LUMITE || material == CoreAscensionArmorMaterials.BLAH)
        {
            player.extinguish();
        }
        for (int iterate = 0; iterate < 4; iterate++) {
            if (((ArmorItem) player.getInventory().getArmorStack(iterate).getItem()).getMaterial() != material) {
                return false;
            }
        }
        return true;
    }

    private void addStatusEffectForMaterial(PlayerEntity player, CoreAscensionArmorMaterials mapArmorMaterial, StatusEffectInstance mapStatusEffect)
    {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }
}
