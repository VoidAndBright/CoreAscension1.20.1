package com.blah.coreascension.entity.entities.projectiles.shuriken;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class IronShurikenEntity extends ShurikenEntity
{
    public IronShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world,CoreAscensionItems.IRON_SHURIKEN_PROJ);
    }

    public IronShurikenEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.IRON_SHURIKEN, livingEntity, world,4);
    }
}
