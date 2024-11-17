package com.blah.coreascension.entity.entities;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class RubyBoltEntity extends ThrownItemEntity
{
    public RubyBoltEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world);
    }
    public RubyBoltEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.RUBY_BOLT, livingEntity, world);
    }
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        if (entityHitResult.getEntity() instanceof LivingEntity entity)
        {
            entity.damage(entity.getDamageSources().magic(), 5);
            entity.setOnFireFor(8);
        }
        super.onEntityHit(entityHitResult);
    }
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }
    @Override
    protected Item getDefaultItem()
    {
        return CoreAscensionItems.RUBY_BOLT;
    }
}
