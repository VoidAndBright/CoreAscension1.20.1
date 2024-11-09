package com.blah.coreascension.block.blocks;


import com.blah.coreascension.block.entities.CatalyzerTableBlockEntity;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import com.blah.coreascension.screen.screens.CatalyzerScreenHandler;
import com.blah.coreascension.screen.screens.NormalCatalyzerScreenHandler;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class NormalCatalyzerTableBlock extends HorizontalFacingBlock {
    public NormalCatalyzerTableBlock(Settings settings) {super(settings);}

	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			NamedScreenHandlerFactory namedScreenHandlerFactory = this.createScreenHandlerFactory(state,world,pos);
			if (namedScreenHandlerFactory != null) player.openHandledScreen(namedScreenHandlerFactory);
			return ActionResult.CONSUME;
		}
	}
//	public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
//		return (NamedScreenHandlerFactory) CoreAscensionScreenHandlers.NORMAL_CATALYZER_SCREEN_HANDLER;
//	}
	//the reason I made this is to make a block with only a screen and no entity so, I learn more
}
