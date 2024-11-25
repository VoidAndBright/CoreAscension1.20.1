package com.blah.coreascension.entity.entities.projectiles.bolt;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

class BlastEntity extends ThrownItemEntity
{
    int dng;
    Item item;
    BlastEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world,int dng) {
        super(entityType, livingEntity, world);
        this.dng=dng;

    }
    BlastEntity(EntityType<? extends ThrownItemEntity> entityType, World world,Item item)
    {
        super(entityType, world);
        this.item = item;
    }
    
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        if (entityHitResult.getEntity().canBeHitByProjectile())
        {
            Entity hitEntity = entityHitResult.getEntity();

            hitEntity.damage(this.getDamageSources().magic(), dng);
            if (hitEntity instanceof LivingEntity entity)
                onEntityHit(entity);
        }
    }
    void onEntityHit(LivingEntity entity){
    }
    
    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }

    
    protected Item getDefaultItem()
    {
        return item;
    }
}
