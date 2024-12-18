package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.*;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class CoreTankSkullBlock extends Block
{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static BlockPattern coreBossPatternX;
    private static BlockPattern coreBossPatternZ;
    public CoreTankSkullBlock(Settings settings)
    {
        super(settings);
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext)
    {
        return this.getDefaultState().with(FACING, itemPlacementContext.getHorizontalPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder.add(FACING));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return Block.createCuboidShape(2, 0, 2, 14, 12, 14);
    }

    // more code to make it do the spawning of the boss with block patterns


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient)
        {
            if (pos.getY() >= world.getBottomY() && world.getDifficulty() != Difficulty.PEACEFUL)
            {
                BlockPattern.Result resultX = getCoreBossPatternX().searchAround(world, pos);
                BlockPattern.Result resultZ = getCoreBossPatternZ().searchAround(world, pos);
                if (resultX != null)
                {
                    breakPatternBlocks(world, resultX);
                }
                if (resultZ != null)
                {
                    breakPatternBlocks(world, resultZ);
                }
            }
        }
    }

    private static BlockPattern getCoreBossPatternX()
    {
        if (coreBossPatternX == null)
        {
            Predicate<CachedBlockPosition> thing =
                    CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.NORTH).getBlock())
                            .or(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.EAST).getBlock())
                            .or(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.WEST).getBlock())
                            .or(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.SOUTH).getBlock())))));


            coreBossPatternX = BlockPatternBuilder.start()
                    .aisle("~~~", "~~~", "#~#").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('~', (pos) -> pos.getBlockState() == Blocks.AIR.getDefaultState())
                    .aisle("~^~", "~#~", "###").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('^', thing).where('~', (pos) -> pos.getBlockState().isAir())
                    .aisle("~~~", "~~~", "#~#").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('~', (pos) -> pos.getBlockState() == Blocks.AIR.getDefaultState())
                    .build();
        }

        return coreBossPatternX;
    }

    private static BlockPattern getCoreBossPatternZ()
    {
        if (coreBossPatternZ == null)
        {
            Predicate<CachedBlockPosition> thing =
                    CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.NORTH).getBlock())
                            .or(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.EAST).getBlock())
                            .or(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.WEST).getBlock())
                            .or(BlockStatePredicate.forBlock(CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState().with(FACING, Direction.SOUTH).getBlock())))));


            coreBossPatternZ = BlockPatternBuilder.start()
                    .aisle("~~~", "~~~", "###").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('~', (pos) -> pos.getBlockState() == Blocks.AIR.getDefaultState())
                    .aisle("~^~", "~#~", "~#~").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('^', thing).where('~', (pos) -> pos.getBlockState().isAir())
                    .aisle("~~~", "~~~", "###").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('~', (pos) -> pos.getBlockState() == Blocks.AIR.getDefaultState())
                    .build();
        }

        return coreBossPatternZ;
    }

    public static void breakPatternBlocks(World world, BlockPattern.Result patternResult)
    {
        for (int i = 0; i < patternResult.getWidth(); ++i)
        {
            for (int j = 0; j < patternResult.getHeight(); ++j)
            {
                for (int k = 0; k < patternResult.getDepth(); ++k)
                {
                    CachedBlockPosition cachedBlockPosition = patternResult.translate(i, j, k);
                    world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                    world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
                }
            }
        }
    }
}
