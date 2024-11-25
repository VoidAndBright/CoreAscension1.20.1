package com.blah.coreascension.block.blocks;

import com.blah.coreascension.damage.CoreAscensionDamageTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IceCreamBlock extends Block {
    public IceCreamBlock(Settings settings)
    {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
    {
        //if (!(entity instanceof GhastEntity)) // add later the mobs that shouldn't be affected by this
        {
            if (entity instanceof PlayerEntity player)
            {
                if (!player.isSneaking())
                    player.damage(CoreAscensionDamageTypes.of(entity.getWorld(), CoreAscensionDamageTypes.ICE_CREAM_BLOCK), 1);
            } else
            {
                entity.damage(CoreAscensionDamageTypes.of(entity.getWorld(), CoreAscensionDamageTypes.ICE_CREAM_BLOCK), 1);
            }
        }
    }
}
