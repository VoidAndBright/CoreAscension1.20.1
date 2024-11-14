package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.utils.CoreAscensionTags;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MiningToolToolTipItem extends MiningToolItem
{
    public String[] tooltip;
    public MiningToolToolTipItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, TagKey<Block> effectiveBlocks, String... tooltip)
    {
        super(attackSpeed, attackDamage, material,effectiveBlocks, settings);
        this.tooltip=tooltip;
    }
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        for(String tooltipLine:this.tooltip)
            tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,tooltipLine))).formatted(Formatting.YELLOW));
    }
}
