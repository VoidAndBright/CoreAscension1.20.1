package com.blah.coreascension.block.blocks;

import com.blah.coreascension.effects.CoreAscensionStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoltenIceFluidBlock extends FluidBlock {
    public MoltenIceFluidBlock(FlowableFluid fluid, Settings settings)
    {
        super(fluid, settings);
    }
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)
    {
        super.onEntityCollision(state, world, pos, entity);
        if (entity instanceof LivingEntity living)
        {
            if (living.hasStatusEffect(CoreAscensionStatusEffects.WARMTH))
                return;
            if (!(living instanceof GhastEntity))
            {
                living.addStatusEffect(new StatusEffectInstance(CoreAscensionStatusEffects.FREEZING, 120, 2));
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 4));
            }
        }
    }
}

