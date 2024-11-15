package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PickaxeToolTipItem extends PickaxeItem
{
    public String[] tooltip;
    public Formatting tooltipColor;
    public PickaxeToolTipItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, Formatting color, String... tooltip)
    {
        super(material, attackDamage, attackSpeed, settings);
        this.tooltip = tooltip;
        this.tooltipColor = color;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        for (String tooltipLine : this.tooltip)
            tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,tooltipLine))).formatted(this.tooltipColor));
    }
}
