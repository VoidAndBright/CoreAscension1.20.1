package com.blah.coreascension.block.blocks;


import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.block.entities.PrismaeroFurnaceBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class PrismaeroFurnaceBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public PrismaeroFurnaceBlock(Settings settings)
    {
        super(settings);
    }

    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return new PrismaeroFurnaceBlockEntity(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return checkType(type, CoreAscensionBlockEntities.PRISMAERO_FURNACE_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext)
    {
        Direction direction = itemPlacementContext.getHorizontalPlayerFacing();
        return this.getDefaultState().with(FACING, direction.getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder.add(FACING));
    }

    public void onStateReplaced(BlockState blockState, World world, BlockPos blockPos, BlockState newBlockState, boolean moved)
    {
        if (!blockState.isOf(newBlockState.getBlock()))
        {
            BlockEntity blockEntity = world.getBlockEntity(blockPos);
            if (blockEntity instanceof Inventory)
            {
                ItemScatterer.spawn(world, blockPos, (Inventory) blockEntity);
                world.updateComparators(blockPos, this);
            }
            super.onStateReplaced(blockState, world, blockPos, newBlockState, moved);
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if (world.isClient)
        {
            return ActionResult.SUCCESS;
        } else
        {
            NamedScreenHandlerFactory namedScreenHandlerFactory = this.createScreenHandlerFactory(state, world, pos);
            if (namedScreenHandlerFactory != null) player.openHandledScreen(namedScreenHandlerFactory);
            return ActionResult.CONSUME;
        }
    }
}
