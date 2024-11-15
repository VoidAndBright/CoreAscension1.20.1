package com.blah.coreascension.event.events;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class StepUp implements ClientTickEvents.EndTick
{
    @Override
    public void onEndTick(MinecraftClient minecraftClient)
    {
        ClientPlayerEntity player;
        player = minecraftClient.player;

        if (player != null)
        {
            if (player.getInventory().armor.get(0).hasEnchantments() && EnchantmentHelper.getLevel(CoreAscensionEnchantments.STEPPING, player.getInventory().armor.get(0)) > 0)
            {
                if (player.getStepHeight() < 1.0f && player.getMovementSpeed() > 0f)
                {
                    player.setStepHeight(1.0f);
                }
            }
            if (player.getInventory().armor.get(0).hasEnchantments() && EnchantmentHelper.getLevel(CoreAscensionEnchantments.STEPPING, player.getInventory().armor.get(0)) > 1)
            {
                int x = (int) Math.floor(player.getX());
                int y = (int) (player.getY() - player.getHeightOffset());
                int z = (int) Math.floor(player.getZ());

                BlockPos pos = new BlockPos(x, y, z);
                Block blockBelow = player.getWorld().getBlockState(pos.down()).getBlock();

                if (blockBelow == Blocks.LAVA || blockBelow == Blocks.WATER || blockBelow instanceof FluidBlock && player.getWorld().isAir(pos))
                {
                    if (!player.isSneaking())
                    {
                        Vec3d v3d = player.getVelocity();
                        player.setVelocity(new Vec3d(v3d.x, 0, v3d.z));
                        player.fallDistance = 0.0f;
                        player.setOnGround(true);
                    }
                }
            }
        }
    }
}
