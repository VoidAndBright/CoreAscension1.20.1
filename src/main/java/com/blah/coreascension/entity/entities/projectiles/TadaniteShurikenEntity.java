package com.blah.coreascension.entity.entities.projectiles;

import com.blah.coreascension.entity.CoreAscensionEntities;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

public class TadaniteShurikenEntity extends ThrownItemEntity
{
    public TadaniteShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public TadaniteShurikenEntity(LivingEntity livingEntity, World world) {
        super(CoreAscensionEntities.TADANITE_SHURIKEN, livingEntity, world);
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }


    protected Item getDefaultItem()
    {
        return CoreAscensionItems.TADANITE_SHURIKEN_PROJ;
    }
}
