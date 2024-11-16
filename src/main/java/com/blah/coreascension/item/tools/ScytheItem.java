package com.blah.coreascension.item.tools;

import com.blah.coreascension.utils.CoreAscensionTags;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScytheItem extends MiningToolTipItem {
    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings, CoreAscensionTags.SCYTHE_MINEABLE);
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos blockPos, LivingEntity miner)
    {
        // check if the currently targeted/mined block is scythe mineable
        if (miner.isSneaking()) {
            // check in a 10x10x10 area
            for (int x = -5; x < 5; x++) {
                for (int y = -5; y < 5; y++) {
                    for (int z = -5; z < 5; z++) {
                        // check the position modified by the nested for loops above
                        BlockState block = world.getBlockState(blockPos.add(x, y, z));
                        if (block.isIn(BlockTags.SMALL_FLOWERS) ||
                                block.isIn(BlockTags.TALL_FLOWERS) ||
                                block.isIn(CoreAscensionTags.SCYTHE_MINEABLE) ||
                                block.isIn(BlockTags.LEAVES) ||
                                block.getBlock() instanceof SeagrassBlock ||
                                block.getBlock() instanceof TallPlantBlock ||
                                block.getBlock() instanceof TallFlowerBlock ||
                                block.getBlock() instanceof LeavesBlock ||
                                block.getBlock() instanceof DeadBushBlock ||
                                block.getBlock() instanceof FernBlock) {
                            // set the block to air instead of breaking it with no
                            // drop so it doesn't play a sound and break your ears
                            world.setBlockState(blockPos.add(x, y, z), Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        } else {
            // check in a 10x10x10 area
            for (int x = -5; x < 5; x++) {
                for (int y = -5; y < 5; y++) {
                    for (int z = -5; z < 5; z++) {
                        // check the position modified by the nested for loops above
                        if (world.getBlockState(blockPos.add(x, y, z)).getBlock() instanceof SeagrassBlock ||
                                world.getBlockState(blockPos.add(x, y, z)).getBlock() instanceof TallPlantBlock ||
                                world.getBlockState(blockPos.add(x, y, z)).getBlock() instanceof TallFlowerBlock ||
                                world.getBlockState(blockPos.add(x, y, z)).getBlock() instanceof LeavesBlock ||
                                world.getBlockState(blockPos.add(x, y, z)).getBlock() instanceof DeadBushBlock ||
                                world.getBlockState(blockPos.add(x, y, z)).getBlock() instanceof FernBlock) {
                            // set the block to air instead of breaking it with no
                            // drop so it doesn't play a sound and break your ears
                            world.setBlockState(blockPos.add(x, y, z), Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        }
        return super.postMine(stack, world, state, blockPos, miner);
    }
}
