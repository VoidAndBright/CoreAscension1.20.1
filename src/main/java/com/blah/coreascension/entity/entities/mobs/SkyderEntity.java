package com.blah.coreascension.entity.entities.mobs;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SkyderEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public SkyderEntity(EntityType<? extends HostileEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes()
    {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }

    public static EntityDimensions getDimensions()
    {
        return EntityDimensions.fixed(1f, 1f);
    }

    
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.BEETROOT), false));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    
    public void tick()
    {
        super.tick();
        if (this.getWorld().isClient())
        {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates()
    {
        if (this.idleAnimationTimeout <= 0)
        {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else
        {
            --this.idleAnimationTimeout;
        }
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source)
    {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    
    protected void updateLimbs(float posDelta)
    {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }
}
