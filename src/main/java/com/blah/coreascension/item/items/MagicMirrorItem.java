package com.blah.coreascension.item.items;

import com.blah.coreascension.CoreAscension;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class MagicMirrorItem extends Item {
    public MagicMirrorItem(Settings settings)
    {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    public ItemStack finishUsing(ItemStack itemStack, World world, LivingEntity user)
    {
        if (user instanceof PlayerEntity player) {
            if (world instanceof ServerWorld) {
                MinecraftServer server = player.getServer();
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) user;
                ServerWorld TargetDimension = server.getWorld(serverPlayer.getSpawnPointDimension());
                Optional<Vec3d> SpawnVec = PlayerEntity.findRespawnPosition(TargetDimension, serverPlayer.getSpawnPointPosition(), serverPlayer.getSpawnAngle(), false, false);
                serverPlayer.fallDistance = 0F;
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 0.4f, 1f);
                if (SpawnVec.isPresent()) {
                    TeleportTarget teleportTarget = new TeleportTarget(SpawnVec.get(), player.getVelocity(), player.getYaw(), player.getPitch());
                    FabricDimensions.teleport(user, TargetDimension, teleportTarget);
                } else {
                    TargetDimension = server.getWorld(World.OVERWORLD);
                    TeleportTarget teleportTarget = new TeleportTarget(TargetDimension.getSpawnPos().toCenterPos(), player.getVelocity(), player.getYaw(), player.getPitch());
                    FabricDimensions.teleport(user, TargetDimension, teleportTarget);
                }
            }
            player.getItemCooldownManager().set(this, 60);
        }
        return itemStack;
    }

    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack stack)
    {
        return 1;
    }

    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, "tooltip.magic_mirror"))).formatted(Formatting.GRAY));
    }

    public boolean hasGlint(ItemStack stack)
    {
        return true;
    }
}
