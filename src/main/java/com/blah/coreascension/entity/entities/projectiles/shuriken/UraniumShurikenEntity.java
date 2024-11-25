package com.blah.coreascension.entity.entities.projectiles.shuriken;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class UraniumShurikenEntity extends ShurikenEntity
{
    public UraniumShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world,5,CoreAscensionItems.URANIUM_SHURIKEN_PROJ);
    }

    public UraniumShurikenEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.URANIUM_SHURIKEN, livingEntity, world);
    }
}
