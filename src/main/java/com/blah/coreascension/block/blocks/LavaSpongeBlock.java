package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LavaSpongeBlock extends Block
{
    public LavaSpongeBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {
        for (int x = -5; x <= 5; x++)
        {
            for (int y = -5; y <= 5; y++)
            {
                for (int z = -5; z <= 5; z++)
                {
                    if (world.getBlockState(pos.add(x, y, z)).getBlock() == Blocks.LAVA)
                    {
                        world.setBlockState(pos.add(x, y, z), Blocks.AIR.getDefaultState());
                        world.setBlockState(pos, CoreAscensionBlocks.LAVAD_OBSIDIAN_SPONGE.getDefaultState());
                    }
                }
            }
        }
    }
}
