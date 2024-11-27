package com.blah.coreascension.item.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ExcavatorItem extends ShovelToolTipItem {
    public ExcavatorItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, Formatting color, String... tooltip)
    {
        super(material, attackDamage, attackSpeed, settings, color, tooltip);
    }

    public ExcavatorItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, String... tooltip)
    {
        super(material, attackDamage, attackSpeed, settings, Formatting.WHITE, tooltip);
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entity)
    {
        if (entity instanceof PlayerEntity player)
        {
            for (int xy = -1; xy <= 1; xy++)
                for (int yz = -1; yz <= 1; yz++)
                    switch (getLookDirection(player))
                    {
                        case X -> BreakCorrectBlock(pos.add(0, xy, yz), player, world);
                        case Y -> BreakCorrectBlock(pos.add(xy, 0, yz), player, world);
                        case Z -> BreakCorrectBlock(pos.add(xy, yz, 0), player, world);
                    }
        }
        return super.postMine(stack, world, state, pos, entity);
    }

    public Direction.Axis getLookDirection(PlayerEntity player)
    {
        if (player.getPitch() > 40 || player.getPitch() < -40)
            return Direction.Axis.Y;
        return player.getHorizontalFacing().getAxis();
    }

    public void BreakCorrectBlock(BlockPos blockPos, PlayerEntity player, World world)
    {
        BlockState Block = world.getBlockState(blockPos);
        if (Block.isIn(BlockTags.SHOVEL_MINEABLE) && this.canMine(Block, world, blockPos, player))
        {
            world.breakBlock(blockPos, true);
            player.getMainHandStack().damage(1, player, targetEntity -> player.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
    }
}
