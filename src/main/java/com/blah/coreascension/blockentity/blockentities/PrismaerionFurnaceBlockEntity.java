package com.blah.coreascension.blockentity.blockentities;

import com.blah.coreascension.blockentity.CoreAscensionBlockEntities;
import com.blah.coreascension.screen.screens.PrismaerionFurnaceScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;


public class PrismaerionFurnaceBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

	private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private static final int FUEL_SLOT = 2;

    public PrismaerionFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(CoreAscensionBlockEntities.PRISMAERION_FURNACE_ENTITY, pos, state);
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    public Text getDisplayName() {
        return Text.translatable("container.prismaerion_furnace");
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PrismaerionFurnaceScreenHandler(syncId, playerInventory, this);
    }
    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }
        if(isOutputSlotEmptyOrReceivable()) {
            if(this.hasRecipe()) {
                    this.craftItem();
            }
        } else {
            markDirty(world, pos, state);
        }
    }
	private boolean hasRecipe() {
		Optional<SmeltingRecipe> recipe = getCurrentRecipe();

		return recipe.get().matches(,getWorld()) && canInsertAmountIntoOutputSlot(recipe.get().getOutput(null))
			&& canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem());
	}
	private void craftItem() {
		Optional<SmeltingRecipe> recipe = getCurrentRecipe();
		this.removeStack(INPUT_SLOT, 1);
		this.removeStack(FUEL_SLOT, 1);
		this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(), getStack(OUTPUT_SLOT).getCount() + recipe.get().getOutput(null).getCount()));
	}
	private Optional<SmeltingRecipe> getCurrentRecipe() {
		SimpleInventory inventory = new SimpleInventory(this.size());
		for(int iterate = 0; iterate < this.size(); iterate++) {
			inventory.setStack(iterate, this.getStack(iterate));
		}
		return getWorld().getRecipeManager().getFirstMatch(RecipeType.SMELTING, inventory, getWorld());
	}
	private boolean canInsertItemIntoOutputSlot(Item item) {
		return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
	}

	private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
		return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
	}

	private boolean isOutputSlotEmptyOrReceivable() {
		return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
	}
}
