package com.blah.coreascension.entity.entities.projectiles.shuriken;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class LumiteShurikenEntity extends ShurikenEntity
{
    public LumiteShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world,5,CoreAscensionItems.LUMITE_SHURIKEN_PROJ);
    }

    public LumiteShurikenEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.LUMITE_SHURIKEN, livingEntity, world);
    }
}
