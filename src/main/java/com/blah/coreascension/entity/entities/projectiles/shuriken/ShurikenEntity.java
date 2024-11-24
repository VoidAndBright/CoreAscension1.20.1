package com.blah.coreascension.entity.entities.projectiles.shuriken;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class ShurikenEntity extends ThrownItemEntity
{
    int dng;
    Item item;
    public ShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);

    }
    public ShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world,int dng,Item item)
    {
        super(entityType, world);
        this.dng=dng;
        this.item = item;
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }

    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        if (entityHitResult.getEntity() instanceof LivingEntity entity)
        {
            entity.damage(this.getDamageSources().mobProjectile(entity, (LivingEntity) this.getOwner()), dng);
        }
    }

    protected Item getDefaultItem()
    {
        return item;
    }
}
