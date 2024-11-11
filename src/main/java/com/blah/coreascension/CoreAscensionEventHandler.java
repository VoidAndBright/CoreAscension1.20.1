package com.blah.coreascension;

import com.blah.coreascension.event.ItemEntityTickCallback;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CoreAscensionEventHandler
{
    public static void RegisterEvents()
    {
        ItemEntityTickCallback.EVENT.register((item) ->
        {
            if (item.getStack().getItem() == CoreAscensionItems.AERO_FUEL)
            {
                World w = item.getWorld();
                Vec3d pos = item.getPos();
                if (w.isClient())
                {
                    if (w.random.nextFloat() < getParticleChance(item))
                    {
                        Vec3d ppos = randomOffset(pos, w.random, .5f);
                        w.addParticle(ParticleTypes.ELECTRIC_SPARK, ppos.x, pos.y, ppos.z, 0, -0.1f, 0);
                    }
                }
                item.setVelocity(item.getVelocity().add(0, .1f, 0).multiply(0.92f, 0.4f, 0.92f));
                return ActionResult.SUCCESS;
            }
            return ActionResult.SUCCESS;
        });
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
