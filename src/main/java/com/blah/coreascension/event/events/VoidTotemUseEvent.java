package com.blah.coreascension.event.events;

import com.blah.coreascension.event.callback.LivingHurtCallback;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

import java.util.Optional;

public class VoidTotemUseEvent implements LivingHurtCallback
{
    @Override
    public ActionResult onHurt(DamageSource source, LivingEntity entity)
    {
        if (entity instanceof PlayerEntity player)
        {
            if (source != player.getDamageSources().outOfWorld() || player.getY() > -80 || player.getHealth() > 10)
            {
                return ActionResult.PASS;
            }
            ItemStack totem = null;
            boolean foundStack = false;

            if (player.getStackInHand(Hand.OFF_HAND).getItem() == CoreAscensionItems.VOID_TOTEM)
            {
                totem = copyStackThenShrinkOriginal(player.getStackInHand(Hand.OFF_HAND));
                foundStack = true;
            }
            else if (player.getStackInHand(Hand.MAIN_HAND).getItem() == CoreAscensionItems.VOID_TOTEM)
            {
                totem = copyStackThenShrinkOriginal(player.getStackInHand(Hand.MAIN_HAND));
                foundStack = true;
            }

            if (totem != null && foundStack)
            {
                if (player.getWorld() instanceof ServerWorld)
                {
                    MinecraftServer server = player.getServer();
                    ServerPlayerEntity serverPlayer = (ServerPlayerEntity)entity;
                    ServerWorld TargetDimension = server.getWorld(serverPlayer.getSpawnPointDimension());
                    Optional<Vec3d> SpawnVec = PlayerEntity.findRespawnPosition(TargetDimension, serverPlayer.getSpawnPointPosition(), serverPlayer.getSpawnAngle(), false, false);
                    serverPlayer.fallDistance = 0F;
                    player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.4f, 1f);
                    if (SpawnVec.isPresent())
                    {
                        TeleportTarget teleportTarget = new TeleportTarget(SpawnVec.get(), player.getVelocity(), player.getYaw(), player.getPitch());
                        FabricDimensions.teleport(entity, TargetDimension, teleportTarget);
                    }
                    else
                    {
                        TargetDimension = server.getWorld(World.OVERWORLD);
                        TeleportTarget teleportTarget = new TeleportTarget(TargetDimension.getSpawnPos().toCenterPos(), player.getVelocity(), player.getYaw(), player.getPitch());
                        FabricDimensions.teleport(entity, TargetDimension, teleportTarget);
                    }
                    Criteria.USED_TOTEM.trigger(serverPlayer, totem);
                    return ActionResult.SUCCESS;
                }
            }
        }

        return ActionResult.PASS;
    }

    public static ItemStack copyStackThenShrinkOriginal(ItemStack stack)
    {
        ItemStack itemStackCopy = stack.copy();
        stack.decrement(1);
        return itemStackCopy;
    }
}
