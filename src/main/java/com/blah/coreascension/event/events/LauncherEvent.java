package com.blah.coreascension.event.events;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LauncherEvent implements ServerTickEvents.EndTick
{
    @Override
    public void onEndTick(MinecraftServer minecraftServer)
    {
        for (ServerWorld world : minecraftServer.getWorlds())
        {
            for (Entity entity : world.iterateEntities())
            {
                if (entity instanceof LivingEntity living)
                {
                    World eWorld = living.getWorld();
                    BlockPos pos = living.getBlockPos();

                    if (eWorld.getReceivedRedstonePower(pos.down()) > 0 &&
                            eWorld.getBlockState(pos.down()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                            getDirection(eWorld, pos.down()) == Direction.UP)
                    {
                        Vec3d v3 = living.getVelocity();
                        living.setVelocity(v3.getX(), eWorld.getReceivedRedstonePower(pos.down()) / 7d, v3.getZ());
                    }

                    // above the player
                    if (eWorld.getReceivedRedstonePower(pos.up(2)) > 0 &&
                            eWorld.getBlockState(pos.up(2)).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                            getDirection(eWorld, pos.up(2)) == Direction.DOWN)
                    {
                        Vec3d v3 = living.getVelocity();
                        living.setVelocity(v3.getX(), -eWorld.getReceivedRedstonePower(pos.up(2)) / 7d, v3.getZ());
                    }

                    // west
                    if (eWorld.getReceivedRedstonePower(pos.east()) > 0 &&
                            eWorld.getBlockState(pos.east()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                            getDirection(eWorld, pos.east()) == Direction.WEST)
                    {
                        Vec3d v3 = living.getVelocity();
                        living.setVelocity(-eWorld.getReceivedRedstonePower(pos.east()) / 7d, v3.getY(), v3.getZ());
                    }

                    // east
                    if (eWorld.getReceivedRedstonePower(pos.west()) > 0 &&
                            eWorld.getBlockState(pos.west()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                            getDirection(eWorld, pos.west()) == Direction.EAST)
                    {
                        Vec3d v3 = living.getVelocity();
                        living.setVelocity(eWorld.getReceivedRedstonePower(pos.west()) / 7d, v3.getY(), v3.getZ());
                    }

                    // north
                    if (eWorld.getReceivedRedstonePower(pos.south()) > 0 &&
                            eWorld.getBlockState(pos.south()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                            getDirection(eWorld, pos.south()) == Direction.NORTH)
                    {
                        Vec3d v3 = living.getVelocity();
                        living.setVelocity(v3.getX(), v3.getY(), -eWorld.getReceivedRedstonePower(pos.south()) / 7d);
                    }

                    // south
                    if (eWorld.getReceivedRedstonePower(pos.north()) > 0 &&
                            eWorld.getBlockState(pos.north()).getBlock() == CoreAscensionBlocks.PLAYER_LAUNCHER &&
                            getDirection(eWorld, pos.north()) == Direction.SOUTH)
                    {
                        Vec3d v3 = living.getVelocity();
                        living.setVelocity(v3.getX(), v3.getY(), eWorld.getReceivedRedstonePower(pos.north()) / 7d);
                    }
                }
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
