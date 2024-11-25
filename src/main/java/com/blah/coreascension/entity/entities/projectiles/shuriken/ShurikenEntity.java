package com.blah.coreascension.entity.entities.projectiles.shuriken;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class ShurikenEntity extends ThrownItemEntity
{
    int dmg;
    Item item;
    public ShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world, int dmg)
    {
        super(entityType, livingEntity, world);
        this.dmg = dmg;

    }
    public ShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world,Item item)
    {
        super(entityType, world);
        this.item = item;
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }

    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        if (entityHitResult.getEntity().canBeHitByProjectile())
        {
            Entity entity = entityHitResult.getEntity();
            entity.damage(this.getDamageSources().mobProjectile(entity, (LivingEntity) this.getOwner()), dmg);
            this.discard();
        }
    }

    protected void onBlockHit(BlockHitResult blockHitResult)
    {
        super.onBlockHit(blockHitResult);
        this.discard();
    }

    protected Item getDefaultItem()
    {
        return item;
    }
}
