package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.utils.CoreAscensionTags;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ScytheItem extends MiningToolItem
{
    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings)
    {
        super(attackDamage, attackSpeed, material, CoreAscensionTags.SCYTHE_MINEABLE, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,"tooltip.scythe"))).formatted(Formatting.GRAY));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        // check if the currently targeted/mined block is scythe mineable
        if (miner.isSneaking())
        {
            // check in a 10x10x10 area
            for (int x = -5; x < 5; x++)
            {
                for (int y = -5; y < 5; y++)
                {
                    for (int z = -5; z < 5; z++)
                    {
                        // check the position modified by the nested for loops above
                        if (world.getBlockState(pos.add(x, y, z)).isIn(BlockTags.SMALL_FLOWERS) ||
                            world.getBlockState(pos.add(x, y, z)).isIn(BlockTags.TALL_FLOWERS) ||
                            world.getBlockState(pos.add(x, y, z)).isIn(CoreAscensionTags.SCYTHE_MINEABLE) ||
                            world.getBlockState(pos.add(x, y, z)).isIn(BlockTags.LEAVES) ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof SeagrassBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof TallPlantBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof TallFlowerBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof LeavesBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof DeadBushBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof FernBlock)
                        {
                            // set the block to air instead of breaking it with no
                            // drop so it doesn't play a sound and break your ears
                            world.setBlockState(pos.add(x, y, z), Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        }
        else
        {
            // check in a 10x10x10 area
            for (int x = -5; x < 5; x++)
            {
                for (int y = -5; y < 5; y++)
                {
                    for (int z = -5; z < 5; z++)
                    {
                        // check the position modified by the nested for loops above
                        if (world.getBlockState(pos.add(x, y, z)).getBlock() instanceof SeagrassBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof TallPlantBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof TallFlowerBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof LeavesBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof DeadBushBlock ||
                            world.getBlockState(pos.add(x, y, z)).getBlock() instanceof FernBlock)
                        {
                            // set the block to air instead of breaking it with no
                            // drop so it doesn't play a sound and break your ears
                            world.setBlockState(pos.add(x, y, z), Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
