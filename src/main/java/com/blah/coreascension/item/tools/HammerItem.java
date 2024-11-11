package com.blah.coreascension.item.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class HammerItem extends PickaxeItem
{
    public HammerItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings)
    {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        if (miner instanceof PlayerEntity player)
        {
            if (player.getPitch() > 40 || player.getPitch() < -40)
            {
                if (world.getBlockState(pos.west()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                    player.getMainHandStack().getItem().canMine(world.getBlockState(pos.west()), world, pos.west(), player))
                {
                    //Block.dropStacks(world.getBlockState(pos.west()), world, pos.west());
                    world.breakBlock(pos.west(), true);
                }
                if (world.getBlockState(pos.east()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                    player.getMainHandStack().getItem().canMine(world.getBlockState(pos.east()), world, pos.east(), player))
                {
                    world.breakBlock(pos.east(), true);
                }
                if (world.getBlockState(pos.west().south()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                    player.getMainHandStack().getItem().canMine(world.getBlockState(pos.west().south()), world, pos.west().south(), player))
                {
                    world.breakBlock(pos.west().south(), true);
                }
                if (world.getBlockState(pos.west().north()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                    player.getMainHandStack().getItem().canMine(world.getBlockState(pos.west().north()), world, pos.west().north(), player))
                {
                    world.breakBlock(pos.west().north(), true);
                }
                if (world.getBlockState(pos.east().south()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.east().south()), world, pos.east().south(), player))
                {
                    world.breakBlock(pos.east().south(), true);
                }
                if (world.getBlockState(pos.east().north()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.east().north()), world, pos.east().north(), player))
                {
                    world.breakBlock(pos.east().north(), true);
                }
                if (world.getBlockState(pos.south()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.south()), world, pos.south(), player))
                {
                    world.breakBlock(pos.south(), true);
                }
                if (world.getBlockState(pos.north()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.north()), world, pos.north(), player))
                {
                    world.breakBlock(pos.north(), true);
                }
            }
            else if (player.getHorizontalFacing() == Direction.NORTH || player.getHorizontalFacing() == Direction.SOUTH)
            {
                if (world.getBlockState(pos.east()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.east()), world, pos.east(), player))
                {
                    world.breakBlock(pos.east(), true);
                }
                if (world.getBlockState(pos.west()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.west()), world, pos.west(), player))
                {
                    world.breakBlock(pos.west(), true);
                }
                if (world.getBlockState(pos.west().up()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.west().up()), world, pos.west().up(), player))
                {
                    world.breakBlock(pos.west().up(), true);
                }
                if (world.getBlockState(pos.west().down()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.west().down()), world, pos.west().down(), player))
                {
                    world.breakBlock(pos.west().down(), true);
                }
                if (world.getBlockState(pos.east().up()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.east().up()), world, pos.east().up(), player))
                {
                    world.breakBlock(pos.east().up(), true);
                }
                if (world.getBlockState(pos.east().down()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.east().down()), world, pos.east().down(), player))
                {
                    world.breakBlock(pos.east().down(), true);
                }
                if (world.getBlockState(pos.up()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.up()), world, pos.up(), player))
                {
                    world.breakBlock(pos.up(), true);
                }
                if (world.getBlockState(pos.down()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.down()), world, pos.down(), player))
                {
                    world.breakBlock(pos.down(), true);
                }
            }
            else if (player.getHorizontalFacing() == Direction.EAST || player.getHorizontalFacing() == Direction.WEST)
            {
                if (world.getBlockState(pos.south()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.south()), world, pos.south(), player))
                {
                    world.breakBlock(pos.south(), true);
                }
                if (world.getBlockState(pos.north()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.north()), world, pos.north(), player))
                {
                    world.breakBlock(pos.north(), true);
                }
                if (world.getBlockState(pos.up().south()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.up().south()), world, pos.up().south(), player))
                {
                    world.breakBlock(pos.up().south(), true);
                }
                if (world.getBlockState(pos.down().south()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.down().south()), world, pos.down().south(), player))
                {
                    world.breakBlock(pos.down().south(), true);
                }
                if (world.getBlockState(pos.up().north()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.up().north()), world, pos.up().north(), player))
                {
                    world.breakBlock(pos.up().north(), true);
                }
                if (world.getBlockState(pos.down().north()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.down().north()), world, pos.down().north(), player))
                {
                    world.breakBlock(pos.down().north(), true);
                }
                if (world.getBlockState(pos.up()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.up()), world, pos.up(), player))
                {
                    world.breakBlock(pos.up(), true);
                }
                if (world.getBlockState(pos.down()).isIn(BlockTags.PICKAXE_MINEABLE) &&
                        player.getMainHandStack().getItem().canMine(world.getBlockState(pos.down()), world, pos.down(), player))
                {
                    world.breakBlock(pos.down(), true);
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
