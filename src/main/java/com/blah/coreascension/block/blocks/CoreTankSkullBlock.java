package com.blah.coreascension.block.blocks;

import com.blah.coreascension.block.CoreAscensionBlocks;
import net.minecraft.block.*;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
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

public class CoreTankSkullBlock extends Block
{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static BlockPattern coreBossPattern;

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
        return Block.createCuboidShape(4, 0, 4, 12, 8, 12);
    }

    // more code to make it do the spawning of the boss with block patterns


    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient)
        {
            if (state == CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState() && pos.getY() >= world.getBottomY() && world.getDifficulty() != Difficulty.PEACEFUL)
            {
                BlockPattern.Result result = getCoreBossPattern().searchAround(world, pos);
                if (result != null)
                {
                    CarvedPumpkinBlock.breakPatternBlocks(world, result);
                }
            }
        }
    }

    private static BlockPattern getCoreBossPattern()
    {
        if (coreBossPattern == null)
        {
            coreBossPattern = BlockPatternBuilder.start()
                    //.aisle("~~~", "~~~", "#~#").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('~', (pos) -> pos.getBlockState() == Blocks.AIR.getDefaultState())
                    .aisle("~^~", "~#~", "###").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('^', (pos) -> pos.getBlockState() == CoreAscensionBlocks.CORE_TANK_SKULL.getDefaultState()).where('~', (pos) -> pos.getBlockState().isAir())
                    //.aisle("~~~", "~~~", "#~#").where('#', (pos) -> pos.getBlockState() == CoreAscensionBlocks.SOUL_SNOW.getDefaultState()).where('~', (pos) -> pos.getBlockState() == Blocks.AIR.getDefaultState())
                    .build();
        }

        return coreBossPattern;
    }
}
