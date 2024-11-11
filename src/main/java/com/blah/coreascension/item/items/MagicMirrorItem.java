package com.blah.coreascension.item.items;

import com.blah.coreascension.CoreAscension;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class MagicMirrorItem extends Item
{
    public MagicMirrorItem(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID,"tooltip.magic_mirror"))).formatted(Formatting.GRAY));
    }

    public int getMaxUseTime(ItemStack stack)
    {
        return 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BOW;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user)
    {
        PlayerEntity player = (PlayerEntity)user;
        if (!world.isClient())
        {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
            ServerWorld serverWorld = serverPlayer.server.getWorld(serverPlayer.getSpawnPointDimension());
            if (serverWorld != null)
            {
                BlockPos spawnpoint = serverPlayer.getSpawnPointPosition();
                if (spawnpoint != null)
                {
                    Optional<Vec3d> optionalSpawnVec = PlayerEntity.findRespawnPosition(serverWorld, spawnpoint, serverPlayer.getSpawnAngle(), false, false);

                    //Player spawn
                    BlockPos finalSpawnpoint = spawnpoint;
                    optionalSpawnVec.ifPresent(spawnVec ->
                    {
                        serverPlayer.teleport(serverWorld, spawnVec.getX(), spawnVec.getY(), spawnVec.getZ(), serverPlayer.getSpawnAngle(), serverPlayer.getPitch());
                        serverPlayer.fallDistance = 0F;
                        serverWorld.playSound(null, finalSpawnpoint, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.4f, 1f);
                    });
                }

                // World Spawn
                else
                {
                    RegistryKey<World> destinationType = World.OVERWORLD;
                    ServerWorld nextWorld = serverPlayer.getServer().getWorld(destinationType);
                    //if (nextWorld != null)
                    {
                        world.playSound(null, new BlockPos((int)player.getPos().getX(), (int)player.getPos().getY(), (int)player.getPos().getZ()), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 1, 1);
                        serverPlayer.teleport(nextWorld, nextWorld.getSpawnPos().getX(), nextWorld.getSpawnPos().getY() + 1, nextWorld.getSpawnPos().getZ(), player.getYaw(), player.getPitch());
                        serverPlayer.fallDistance = 0F;
                    }
//                    RegistryKey<World> destinationType = World.OVERWORLD;
//                    ServerWorld nextWorld = player.getServer().getWorld(destinationType);
//                    assert nextWorld != null;
//                    spawnpoint = nextWorld.getSpawnPos();
//                    serverPlayer.teleport(nextWorld, spawnpoint.getX(), spawnpoint.getY(), spawnpoint.getZ(), serverPlayer.getSpawnAngle(), serverPlayer.getPitch());
//                    while (!serverWorld.isSpaceEmpty(serverPlayer))
//                    {
//                        serverPlayer.teleport(serverPlayer.getX(), serverPlayer.getY() + 1, serverPlayer.getZ());
//                        player.fallDistance = 0F;
//                    }
//                    serverWorld.playSound(null, spawnpoint, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.4f, 1f);
                }
            }
            else
            {
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_SHULKER_BULLET_HURT, SoundCategory.BLOCKS, 1f, 1f);
            }
        }
        else
        {

            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_SHULKER_BULLET_HURT, SoundCategory.BLOCKS, 1f, 1f);
        }
        player.getItemCooldownManager().set(this, 60);
        return stack;
        /*if (user.getWorld().isClient())
        {
            ItemStack magicMirror = new ItemStack(this, 1);
            if (user.getMainHandStack().getItem() == magicMirror.getItem())// && user instanceof ServerPlayerEntity player)
            {
                ServerPlayerEntity player = (ServerPlayerEntity)user;
                ServerWorld respawnWorld = player.server.getWorld(player.getSpawnPointDimension());
                BlockPos spawn = player.getSpawnPointPosition();
                float spawnAngle = player.getSpawnAngle();
                boolean forcedSpawn = false;
                boolean preserveAnchorCharges = true;
                try
                {
                    Optional<Vec3d> maybeSpawn = PlayerEntity.findRespawnPosition(respawnWorld, spawn, spawnAngle,
                            forcedSpawn, preserveAnchorCharges);
                    if (maybeSpawn.isPresent())
                    {
                        world.playSound(null, new BlockPos((int)player.getPos().getX(), (int)player.getPos().getY(), (int)player.getPos().getZ()), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 1, 1);
                        player.teleport(respawnWorld, maybeSpawn.get().getX(), maybeSpawn.get().getY(), maybeSpawn.get().getZ(), player.getYaw(), player.getPitch());
                        player.fallDistance = 0F;
                        player.getItemCooldownManager().set(magicMirror.getItem(), 60);
                    }
                }
                catch (Exception e)
                {
                    RegistryKey<World> destinationType = World.OVERWORLD;
                    ServerWorld nextWorld = player.getServer().getWorld(destinationType);
                    if (nextWorld != null)
                    {
                        world.playSound(null, new BlockPos((int)player.getPos().getX(), (int)player.getPos().getY(), (int)player.getPos().getZ()), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 1, 1);
                        player.teleport(nextWorld, nextWorld.getSpawnPos().getX(), nextWorld.getSpawnPos().getY() + 1,
                                nextWorld.getSpawnPos().getZ(), player.getYaw(), player.getPitch());
                    }
                }
            }
        }
        return stack;*/
    }
}
