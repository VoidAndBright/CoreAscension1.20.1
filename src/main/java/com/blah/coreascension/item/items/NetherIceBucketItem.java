package com.blah.coreascension.item.items;

import com.blah.coreascension.CoreAscension;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import com.blah.coreascension.item.CoreAscensionItems;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetherIceBucketItem extends Item implements FluidModificationItem
{
    private final Fluid fluid;

    public NetherIceBucketItem(Settings settings, Fluid fluid)
    {
        super(settings);
        this.fluid = fluid;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(Text.translatable(Util.createTranslationKey("item", new Identifier(CoreAscension.MOD_ID, "tooltip.nether_ice_bucket"))).formatted(Formatting.GRAY));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, this.fluid == Fluids.EMPTY ? RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE);
        if (blockHitResult.getType() == HitResult.Type.MISS)
        {
            return TypedActionResult.pass(itemStack);
        }
        else if (blockHitResult.getType() != HitResult.Type.BLOCK)
        {
            return TypedActionResult.pass(itemStack);
        }
        else
        {
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos2 = blockPos.offset(direction);
            if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos2, direction, itemStack))
            {
                BlockState blockState;
                if (this.fluid == Fluids.EMPTY)
                {
                    blockState = world.getBlockState(blockPos);
                    if (blockState.getBlock() instanceof FluidDrainable && blockState.getBlock() == Blocks.WATER)
                    {
                        FluidDrainable fluidDrainable = (FluidDrainable)blockState.getBlock();
                        fluidDrainable.tryDrainFluid(world, blockPos, blockState);
                        ItemStack itemStack2 = new ItemStack(CoreAscensionItems.FILLED_NETHER_ICE_BUCKET);
                        if (!itemStack2.isEmpty())
                        {
                            user.incrementStat(Stats.USED.getOrCreateStat(this));
                            fluidDrainable.getBucketFillSound().ifPresent((sound) ->
                                    user.playSound(sound, 1.0F, 1.0F));
                            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, user, itemStack2);
                            if (!world.isClient)
                            {
                                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)user, itemStack2);
                            }

                            return TypedActionResult.success(itemStack3, world.isClient());
                        }
                    }

                    return TypedActionResult.fail(itemStack);
                }
                else
                {
                    blockState = world.getBlockState(blockPos);
                    BlockPos blockPos3 = blockState.getBlock() instanceof FluidFillable && this.fluid == Fluids.WATER ? blockPos : blockPos2;
                    if (this.placeFluid(user, world, blockPos3, blockHitResult))
                    {
                        this.onEmptied(user, world, itemStack, blockPos3);
                        if (user instanceof ServerPlayerEntity)
                        {
                            Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)user, blockPos3, itemStack);
                        }

                        user.incrementStat(Stats.USED.getOrCreateStat(this));
                        return TypedActionResult.success(getEmptiedStack(itemStack, user), world.isClient());
                    }
                    else
                    {
                        return TypedActionResult.fail(itemStack);
                    }
                }
            }
            else
            {
                return TypedActionResult.fail(itemStack);
            }
        }
    }

    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player)
    {
        return !player.getAbilities().creativeMode ? new ItemStack(CoreAscensionItems.NETHER_ICE_BUCKET) : stack;
    }

    public void onEmptied(@Nullable PlayerEntity player, World world, ItemStack stack, BlockPos pos)
    {
    }

    public boolean placeFluid(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockHitResult hitResult)
    {
        if (!(Fluids.WATER instanceof FlowableFluid))
        {
            return false;
        }
        else
        {
            BlockState blockState = world.getBlockState(pos);
            Block block = blockState.getBlock();
            boolean bl = blockState.canBucketPlace(this.fluid);
            boolean bl2 = blockState.isAir() || bl || block instanceof FluidFillable && ((FluidFillable)block).canFillWithFluid(world, pos, blockState, this.fluid);
            if (!bl2)
            {
                return hitResult != null && this.placeFluid(player, world, hitResult.getBlockPos().offset(hitResult.getSide()), (BlockHitResult)null);
            }
            else if (block instanceof FluidFillable && this.fluid == Fluids.WATER)
            {
                ((FluidFillable)block).tryFillWithFluid(world, pos, blockState, ((FlowableFluid)Fluids.WATER).getStill(false));
                this.playEmptyingSound(player, world, pos);
                return true;
            }
            else
            {
                if (!world.isClient && bl && !blockState.isLiquid())
                {
                    world.breakBlock(pos, true);
                }

                if (!world.setBlockState(pos, this.fluid.getDefaultState().getBlockState(), 11) && !blockState.getFluidState().isStill())
                {
                    return false;
                }
                else
                {
                    this.playEmptyingSound(player, world, pos);
                    return true;
                }
            }
        }
    }

    protected void playEmptyingSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos)
    {
        SoundEvent soundEvent = SoundEvents.ITEM_BUCKET_EMPTY;
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
    }
}
