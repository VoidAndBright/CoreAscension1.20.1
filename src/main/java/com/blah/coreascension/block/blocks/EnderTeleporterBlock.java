package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.entities.EnderTeleporterBlockEntity;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

public class EnderTeleporterBlock extends Block
{
    public static final BooleanProperty LINKED = BooleanProperty.of("linked");
    public EnderTeleporterBlock(Settings settings)
    {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
    {
        BlockState blockstate = world.getBlockState(pos);
        if (blockstate.getBlock() == (CoreAscensionBlocks.ENDER_TELEPORTER) ? blockstate.get(LINKED) : false){
            TeleportTarget location = new TeleportTarget(pos.toCenterPos(),entity.getVelocity(),entity.getYaw(),entity.getPitch());
            RegistryKey<World> dimension = World.OVERWORLD;
            ServerWorld destination = world.getServer().getWorld(dimension);
            FabricDimensions.teleport(entity,destination,location);
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if (!world.isClient)
        {
            NamedScreenHandlerFactory screenHandlerFactory = (EnderTeleporterBlockEntity)world.getBlockEntity(pos);
            if (screenHandlerFactory != null)
            {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }
}
