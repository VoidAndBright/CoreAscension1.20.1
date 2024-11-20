package com.blah.coreascension.entity.entities.projectiles;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
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

public class DiamondBoltEntity extends ThrownItemEntity
{
    public DiamondBoltEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public DiamondBoltEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.DIAMOND_BOLT, livingEntity, world);
    }

    
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        Entity hitEntity = entityHitResult.getEntity();
        if (hitEntity instanceof LivingEntity entity && this.getOwner() != hitEntity)
        {
            entity.damage(entity.getDamageSources().magic(), 10);
        }
    }

    
    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }

    
    protected Item getDefaultItem()
    {
        return CoreAscensionItems.DIAMOND_BOLT;
    }
}
