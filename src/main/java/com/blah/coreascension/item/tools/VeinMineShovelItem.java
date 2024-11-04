package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class VeinMineShovelItem extends ShovelItem
{
    public VeinMineShovelItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        super.postMine(stack,world,state,pos,miner);
        if(miner.isSneaking())
            if(state.isIn(ConventionalBlockTags.ORES))
                BreakNextBlock(state.getBlock(),world,pos,0);
        return true;
    }
    public static void BreakNextBlock(Block block,World world,BlockPos blockPos,int Distance)
    {
        if (Distance<=6)
            for(int x = -1; x<3;x++)
                for(int y = -1; y<3;y++)
                    for(int z = -1; z<3;z++)
                        if(world.getBlockState(blockPos.add(x,y,z)).getBlock()==block){
                            world.breakBlock(blockPos.add(x,y,z),true);
                            BreakNextBlock(block,world,blockPos.add(x,y,z),Distance+1);
                        }
    }
    public void appendTooltip(ItemStack stack,World world,List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,"tooltip.uranium"))).formatted(Formatting.GRAY));
    }
}