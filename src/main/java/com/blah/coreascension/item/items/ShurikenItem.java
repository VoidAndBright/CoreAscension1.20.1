package com.blah.coreascension.item.items;

import com.blah.coreascension.entity.entities.projectiles.shuriken.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ShurikenItem extends Item
{
    public enum Type
    {
        IRON, GOLD, DIAMOND, URANIUM, TADANITE, LUMITE, FROST
    }
    private final Type toShoot;
    public ShurikenItem(Settings settings, Type toShoot)
    {
        super(settings);
        this.toShoot = toShoot;
    }


    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BOW;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (!world.isClient())
        {
            ThrownItemEntity proj = getThrownItemEntity(world, user);
            proj.setVelocity(user, user.getPitch(), user.getYaw(), 0, 2.5f, 1.0f);
            world.spawnEntity(proj);
        }
        world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 0.4f, 1f);
        if (!user.getAbilities().creativeMode) {
            user.getStackInHand(hand).decrement(1);
        }
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }

    private ThrownItemEntity getThrownItemEntity(World world, PlayerEntity user)
    {
        ThrownItemEntity proj;
        switch (this.toShoot)
        {
            case IRON -> proj = new IronShurikenEntity(user, world);
            case GOLD -> proj = new GoldShurikenEntity(user, world);
            case FROST -> proj = new FrostShurikenEntity(user, world);
            case TADANITE -> proj = new TadaniteShurikenEntity(user, world);
            case URANIUM -> proj = new UraniumShurikenEntity(user, world);
            case DIAMOND -> proj = new DiamondShurikenEntity(user, world);
            default -> proj = new LumiteShurikenEntity(user, world);
        }
        return proj;
    }
}
