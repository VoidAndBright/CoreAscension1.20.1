package com.blah.coreascension.block.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EtherealMembraneBlock extends TransparentBlock
{
    public EtherealMembraneBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance)
    {
        if (entity.bypassesLandingEffects())
        {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        }
        else
        {
            entity.handleFallDamage(fallDistance, 0.0F, world.getDamageSources().fall());
        }
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity)
    {
        if (entity.bypassesLandingEffects())
        {
            super.onEntityLand(world, entity);
        }
        else
        {
            this.bounce(entity);
        }
    }

    private void bounce(Entity entity)
    {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0)
        {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }
    }


}
