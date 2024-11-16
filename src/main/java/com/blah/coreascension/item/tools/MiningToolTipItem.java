package com.blah.coreascension.item.tools;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.utils.CoreAscensionTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;

public class MiningToolTipItem extends MiningToolItem {
    public String[] tooltip;

    public MiningToolTipItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, TagKey<Block> effectiveBlocks, String... tooltip)
    {
        super(attackSpeed, attackDamage, material, effectiveBlocks, settings);
        this.tooltip = tooltip;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        for (String tooltipLine : this.tooltip)
            tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, tooltipLine))).formatted(Formatting.GRAY));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        if (miner instanceof PlayerEntity player) {
            if (player.getInventory().contains(new ItemStack(CoreAscensionItems.ULTIMATE_GAUNTLET))) {
                for (int xy = -1; xy <= 1; xy++)
                    for (int yz = -1; yz <= 1; yz++) {
                        switch (getLookDirection(player)) {
                            case X -> BreakCorrectBlock(pos.add(0, xy, yz), player, world);
                            case Y -> BreakCorrectBlock(pos.add(xy, 0, yz), player, world);
                            case Z -> BreakCorrectBlock(pos.add(xy, yz, 0), player, world);
                        }
                    }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
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
        if (Block.isIn(CoreAscensionTags.TOOL_MINEABLE) && this.canMine(Block, world, blockPos, player))
            world.breakBlock(blockPos, true);
    }
}
