package com.blah.coreascension.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.BedPart;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

public class CoreAscensionBedBlock extends BedBlock
{
    public CoreAscensionBedBlock(DyeColor color, Settings settings)
    {
        super(color, settings);
    }

    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }
}
