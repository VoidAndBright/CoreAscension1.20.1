package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class UraniumShovelItem extends ShovelItem
{
    public UraniumShovelItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        super.postMine(stack, world, state, pos, miner);
        if (miner.isSneaking())
            if (state.isIn(BlockTags.SHOVEL_MINEABLE))
                Block.dropStack(world, pos, state.getBlock().asItem().getDefaultStack());
        return true;
    }
    public void appendTooltip(ItemStack stack,World world,List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,"tooltip.uranium_shovel"))).formatted(Formatting.GRAY));
    }
}