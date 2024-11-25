package com.blah.coreascension.entity.entities.projectiles.shuriken;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class FrostShurikenEntity extends ShurikenEntity
{
    public FrostShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world,5,CoreAscensionItems.FROST_SHURIKEN_PROJ);
    }

    public FrostShurikenEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.FROST_SHURIKEN, livingEntity, world);
    }
}
