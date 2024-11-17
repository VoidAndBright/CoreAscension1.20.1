package com.blah.coreascension.event.events;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PlayerLauncherEvent implements ClientTickEvents.EndTick
{
    @Override
    public void onEndTick(MinecraftClient minecraftClient)
    {
        ClientPlayerEntity player;
        player = minecraftClient.player;

        if (player != null)
        {
            World world = player.getWorld();
            BlockPos playerPos = player.getBlockPos();
            // below the player
            if (world.getReceivedRedstonePower(playerPos.down()) > 0 &&
                world.getBlockState(playerPos.down()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                getDirection(world, playerPos.down()) == Direction.UP)
            {
                Vec3d v3 = player.getVelocity();
                player.setVelocity(v3.getX(), world.getReceivedRedstonePower(playerPos.down()) / 7d, v3.getZ());
            }

            // above the player
            if (world.getReceivedRedstonePower(playerPos.up(2)) > 0 &&
                    world.getBlockState(playerPos.up(2)).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                    getDirection(world, playerPos.up(2)) == Direction.DOWN)
            {
                Vec3d v3 = player.getVelocity();
                player.setVelocity(v3.getX(), -world.getReceivedRedstonePower(playerPos.up(2)) / 7d, v3.getZ());
            }

            // west
            if (world.getReceivedRedstonePower(playerPos.east()) > 0 &&
                    world.getBlockState(playerPos.east()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                    getDirection(world, playerPos.east()) == Direction.WEST)
            {
                Vec3d v3 = player.getVelocity();
                player.setVelocity(-world.getReceivedRedstonePower(playerPos.east()) / 7d, v3.getY(), v3.getZ());
            }

            // east
            if (world.getReceivedRedstonePower(playerPos.west()) > 0 &&
                    world.getBlockState(playerPos.west()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                    getDirection(world, playerPos.west()) == Direction.EAST)
            {
                Vec3d v3 = player.getVelocity();
                player.setVelocity(world.getReceivedRedstonePower(playerPos.west()) / 7d, v3.getY(), v3.getZ());
            }

            // north
            if (world.getReceivedRedstonePower(playerPos.south()) > 0 &&
                    world.getBlockState(playerPos.south()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                    getDirection(world, playerPos.south()) == Direction.NORTH)
            {
                Vec3d v3 = player.getVelocity();
                player.setVelocity(v3.getX(), v3.getY(), -world.getReceivedRedstonePower(playerPos.south()) / 7d);
            }

            // south
            if (world.getReceivedRedstonePower(playerPos.north()) > 0 &&
                    world.getBlockState(playerPos.north()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                    getDirection(world, playerPos.north()) == Direction.SOUTH)
            {
                Vec3d v3 = player.getVelocity();
                player.setVelocity(v3.getX(), v3.getY(), world.getReceivedRedstonePower(playerPos.north()) / 7d);
            }
        }
    }
    public Direction getDirection(World world, BlockPos pos)
    {
        BlockState state = world.getBlockState(pos);
        DirectionProperty property = (DirectionProperty)state.getBlock().getStateManager().getProperty("facing");
        return state.get(property);
    }
}
