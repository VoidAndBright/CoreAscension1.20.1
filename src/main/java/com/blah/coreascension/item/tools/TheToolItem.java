package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.utils.CoreAscensionTags;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TheToolItem extends MiningToolItem
{
    public TheToolItem(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings)
    {
        super(attackDamage, attackSpeed, material, CoreAscensionTags.Blocks.TOOL_MINEABLE, settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,"tooltip.the_tool"))).formatted(Formatting.GRAY));
    }
}
