package com.blah.coreascension.block.blocks;

import com.blah.coreascension.effect.CoreAscensionStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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
            if (living.hasStatusEffect(CoreAscensionStatusEffects.ICE_RESISTANCE))
                return;
            if (!(living instanceof GhastEntity))
            {
                living.addStatusEffect(new StatusEffectInstance(CoreAscensionStatusEffects.FREEZING.addAttributeModifier(
                        EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                ), 120, 2));
            }
        }
    }
}

