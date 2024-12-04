package com.blah.coreascension.event.events;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.event.callback.LivingDeathCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class PigneousEvent implements LivingDeathCallback
{
    @Override
    public ActionResult onDeath(DamageSource source, LivingEntity entity)
    {
        if (entity instanceof PigEntity || entity instanceof PiglinEntity ||
            entity instanceof PiglinBruteEntity || entity instanceof ZombifiedPiglinEntity)
        {
            CoreAscension.LOGGER.info("step 1");
            if (entity.getHealth() > 0) return ActionResult.PASS;
            CoreAscension.LOGGER.info("step 2");
            BlockPos pos = entity.getBlockPos().down();
            if (entity.getWorld().getBlockState(pos).getBlock() == CoreAscensionBlocks.IGNEOUS_ROCK)
            {
                CoreAscension.LOGGER.info("step 3");
                for (int x = -4; x <= 4; x++)
                {
                    for (int z = -4; z <= 4; z++)
                    {
                        if (entity.getWorld().getBlockState(pos.add(x, 0, z)).getBlock() == CoreAscensionBlocks.IGNEOUS_ROCK)
                        {
                            entity.getWorld().setBlockState(pos.add(x, 0, z), CoreAscensionBlocks.PIGNEOUS_ROCK.getDefaultState());
                        }
                    }
                }
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
