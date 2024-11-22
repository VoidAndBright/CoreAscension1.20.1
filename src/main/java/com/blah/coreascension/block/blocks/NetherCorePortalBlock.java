package com.blah.coreascension.block.blocks;

import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class NetherCorePortalBlock extends CustomPortalBlock {
    public NetherCorePortalBlock(Settings settings)
    {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random)
    {
        for (int i = 0; i < 4; ++i)
        {
            double d = pos.getX() + random.nextDouble();
            double e = pos.getY() + random.nextDouble();
            double f = pos.getZ() + random.nextDouble();
            double g = (random.nextFloat() - 0.5) * 0.5;
            double h = (random.nextFloat() - 0.5) * 0.5;
            double j = (random.nextFloat() - 0.5) * 0.5;
            int k = random.nextInt(2) * 2 - 1;
            if (state.get(AXIS) == Direction.Axis.Y)
            {
                h = random.nextFloat() * 2.0F * k;
            } else if (!world.getBlockState(pos.west()).isOf(this) && !world.getBlockState(pos.east()).isOf(this))
            {
                d = pos.getX() + 0.5 + 0.25 * k;
                g = random.nextFloat() * 2.0F * k;
            } else
            {
                f = pos.getZ() + 0.5 + 0.25 * k;
                j = random.nextFloat() * 2.0F * k;
            }

            world.addParticle(ParticleTypes.DRIPPING_WATER, d, e, f, g, h, j);
        }
    }
}
