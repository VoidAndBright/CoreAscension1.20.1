package com.blah.coreascension.entity.entities.projectiles.shuriken;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class DiamondShurikenEntity extends ShurikenEntity
{
    public DiamondShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world,5,CoreAscensionItems.DIAMOND_SHURIKEN_PROJ);
    }

    public DiamondShurikenEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.DIAMOND_SHURIKEN, livingEntity, world);
    }
}
