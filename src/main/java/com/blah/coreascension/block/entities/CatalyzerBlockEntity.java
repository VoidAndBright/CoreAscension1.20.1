package com.blah.coreascension.block.entities;

import com.blah.coreascension.screen.screens.DimensionalSurgingScreenHandler;
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
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.Objects;
import java.util.Optional;


public class CatalyzerBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

	private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int INPUT_SLOT_3 = 3;
    private static final int INPUT_SLOT_4 = 4;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 200;

    public CatalyzerBlockEntity(BlockPos pos, BlockState state) {
        super(CoreAscensionBlockEntities.CATALYZER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> CatalyzerBlockEntity.this.progress;
					case 1 -> CatalyzerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CatalyzerBlockEntity.this.progress = value;
                    case 1 -> CatalyzerBlockEntity.this.maxProgress = value;
                }
            }
            public int size() {
                return 2;
            }
        };
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    public Text getDisplayName() {
        return Text.translatable("container.catalyzer");
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("dimensional_surge_infusing.progress", progress);
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("dimensional_surge_infusing.progress");
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DimensionalSurgingScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    //public void tick(World world, BlockPos pos, BlockState state) {
    //    if(world.isClient()) {
    //        return;
    //    }
//
    //    if(isOutputSlotEmptyOrReceivable()) {
    //        if(this.hasRecipe()) {
    //            this.increaseCraftProgress();
    //            markDirty(world, pos, state);
//
    //            if(hasCraftingFinished()) {
    //                this.craftItem();
    //                this.resetProgress();
    //            }
    //        } else {
    //            this.resetProgress();
    //        }
    //    } else {
    //        this.resetProgress();
    //        markDirty(world, pos, state);
    //    }
    //}

    private void resetProgress() {
        this.progress = 0;
    }



    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

	//private boolean hasRecipe() {
		//Optional<DimensionalSurgingRecipe> recipe = getCurrentRecipe();
		//return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().getResult(null))
		//	&& canInsertItemIntoOutputSlot(recipe.get().getResult(null).getItem());
	//}
	//private void craftItem() {
		//Optional<DimensionalSurgingRecipe> recipe = getCurrentRecipe();
		//this.removeStack(INPUT_SLOT_1, 1);
		//this.removeStack(INPUT_SLOT_2, 1);
		//this.removeStack(INPUT_SLOT_3, 1);
		//this.removeStack(INPUT_SLOT_4, 1);
		//this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getResult(null).getItem(),
		//	getStack(OUTPUT_SLOT).getCount() + recipe.get().getResult(null).getCount()));
	//}
	//private Optional<DimensionalSurgingRecipe> getCurrentRecipe() {
	//	SimpleInventory inv = new SimpleInventory(this.size());
	//	for(int i = 0; i < this.size(); i++) {
	//		inv.setStack(i, this.getStack(i));
	//	}
//
	//	return (Objects.requireNonNull(getWorld())).getRecipeManager().getFirstMatch(DimensionalSurgingRecipe.Type.INSTANCE, inv, getWorld());
	//}
	private boolean canInsertItemIntoOutputSlot(Item item) {
		return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
	}

	private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
		return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
	}

	private boolean isOutputSlotEmptyOrReceivable() {
		return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
	}

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }
}
