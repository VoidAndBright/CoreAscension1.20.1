package com.blah.coreascension.entity.entities;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class BlahBoltEntity extends ThrownItemEntity
{
    public BlahBoltEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public BlahBoltEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.BLAH_BOLT, livingEntity, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        if (entityHitResult.getEntity() instanceof LivingEntity entity)
        {
            entity.damage(entity.getDamageSources().magic(), 18);
            double random = Math.random();
            if (random < 0.16)
            {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1));
            }
            else if (random < 0.33)
            {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1));
            }
            else if (random < 0.5)
            {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 60, 1));
            }
            else if (random < 0.67)
            {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
            }
            else if (random < 0.83)
            {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1));
            }
            else
            {
                entity.setOnFireFor(5);
            }
        }
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem()
    {
        return CoreAscensionItems.BLAH_BOLT;
    }
}
