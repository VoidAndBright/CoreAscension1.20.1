package com.blah.coreascension.item.items;

import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EnderWireItem extends Item
{
    public EnderWireItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        Vec3d thing = context.getHitPos();
        BlockPos pos = new BlockPos((int)thing.getX(), (int)thing.getY(), (int)thing.getZ());
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();


        double portalX = 0;
        double portalY = 0;
        double portalZ = 0;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null)
        {
            if (!blockEntity.createNbt().getBoolean("isBlockLinked"))
            {

            }
        }

        // unused section, might be useful later though
        if (!player.getMainHandStack().getOrCreateNbt().getBoolean("IsBlock"))
        {
            portalX = pos.getX();
            portalY = pos.getY();
            portalZ = pos.getZ();
            player.getMainHandStack().getOrCreateNbt().putDouble("ItemPortalX", portalX);
            player.getMainHandStack().getOrCreateNbt().putDouble("ItemPortalY", portalY);
            player.getMainHandStack().getOrCreateNbt().putDouble("ItemPortalZ", portalZ);


        }
        else
        {

        }

        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        super.use(world, user, hand);

        if (user.getStackInHand(hand).getItem() == CoreAscensionItems.ENDER_WIRE)
        {

        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
