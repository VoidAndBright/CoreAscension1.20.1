package com.blah.coreascension.item.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UraniumHoeItem extends HoeTooltipItem {
    int BlocksBroken;

    public UraniumHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, String... tooltip)
    {
        super(material, attackDamage, attackSpeed, settings, Formatting.GRAY, "tooltip.uranium_hoe");
        this.BlocksBroken = 0;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        super.postMine(stack, world, state, pos, miner);
        if (miner.isSneaking())
            if (state.isIn(BlockTags.HOE_MINEABLE))
                BreakNextBlock(state.getBlock(), world, pos, 0);
        this.BlocksBroken = 0;
        return true;
    }

    public void BreakNextBlock(Block block, World world, BlockPos blockPos, int Distance)
    {
        if (this.BlocksBroken <= 100)
            for (int x = -1; x < 3; x++)
                for (int y = -1; y < 3; y++)
                    for (int z = -1; z < 3; z++)
                        if (world.getBlockState(blockPos.add(x, y, z)).getBlock() == block)
                        {
                            world.breakBlock(blockPos.add(x, y, z), true);
                            this.BlocksBroken++;
                            BreakNextBlock(block, world, blockPos.add(x, y, z), Distance + 1);
                        }
    }
}