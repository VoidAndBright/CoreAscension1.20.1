package com.blah.coreascension.event.events;

import com.blah.coreascension.event.callback.ItemEntityTickCallback;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AerofuelFloatEvent implements ItemEntityTickCallback {
    public ActionResult interact(ItemEntity item)
    {
        if (item.getStack().getItem() == CoreAscensionItems.AERO_FUEL)
        {
            World world = item.getWorld();
            Vec3d pos = item.getPos();
            if (world.isClient())
                if (world.random.nextFloat() < getParticleChance(item))
                {
                    Vec3d area = randomOffset(pos, world.random, .5f);
                    world.addParticle(ParticleTypes.ELECTRIC_SPARK, area.x, pos.y, area.z, 0, -0.1f, 0);
                }
            item.setVelocity(item.getVelocity().add(0, .1f, 0).multiply(0.92f, 0.4f, 0.92f));
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    protected static float getParticleChance(ItemEntity entity)
    {
        return MathHelper.clamp(entity.getStack().getCount() - 10, 5, 100) / 64f;
    }

    public static Vec3d randomOffset(Vec3d vec, Random r, float radius)
    {
        return new Vec3d(vec.x + (r.nextFloat() - .5f) * 2 * radius, vec.y + (r.nextFloat() - .5f) * 2 * radius, vec.z + (r.nextFloat() - .5f) * 2 * radius);
    }
}
