package com.blah.coreascension.screen.screens;


import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.entities.CatalyzerTableBlockEntity;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.recipe.CatalyzerRecipe;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class CatalyzerTableScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final World world;

    public final CatalyzerTableBlockEntity blockEntity;
    private static final int INPUT_SLOT = 0;
    private static final int CATALYST_SLOT = 1;
    private static final int SULPHUR_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    public CatalyzerTableScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }

    public CatalyzerTableScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(CoreAscensionScreenHandlers.CATALYZER_TABLE_SCREEN_HANDLER, syncId);
        checkSize((Inventory) blockEntity, 4);
        this.inventory = (Inventory) blockEntity;
        this.world = blockEntity.getWorld();
        inventory.onOpen(playerInventory.player);
        this.blockEntity = (CatalyzerTableBlockEntity) blockEntity;
		this.addSlot(new Slot(inventory, 0, 30, 18));

		this.addSlot(new Slot(inventory, 1, 66, 18));

		this.addSlot(new Slot(inventory, 2, 48, 52)
        {
            public boolean canInsert(ItemStack stack) {return stack.getItem() == CoreAscensionItems.SULPHUR || stack.getItem() == CoreAscensionBlocks.SULPHUR_BLOCK.asItem();}
        });

		this.addSlot(new Slot(inventory, 3, 124, 35)
        {
            public boolean canInsert(ItemStack stack) {return false;}
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        super.onSlotClick(slotIndex, button, actionType, player);
        if (slotIndex==3){
            this.inventory.removeStack(0,1);
            this.inventory.removeStack(1,1);
            this.inventory.removeStack(2,1);
        }
    }
    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) return;
        if(isOutputSlotReceivable())
            if(hasRecipe()) craftItem();
    }
    public boolean hasRecipe() {
        Optional<CatalyzerRecipe> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().getOutput(null)) && canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem());
    }
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.inventory.getStack(OUTPUT_SLOT).getItem() == item || this.inventory.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.inventory.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= this.inventory.getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotReceivable() {
        return this.inventory.getStack(OUTPUT_SLOT).getCount() < this.inventory.getStack(OUTPUT_SLOT).getMaxCount();
    }
    private void craftItem() {
        Optional<CatalyzerRecipe> recipe = getCurrentRecipe();
        //this.removeStack(INPUT_SLOT, 1);
        //this.removeStack(CATALYST_SLOT, 1);
        //this.removeStack(SULPHUR_SLOT, 1);
        this.inventory.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(), this.inventory.getStack(OUTPUT_SLOT).getCount() + recipe.get().getOutput(null).getCount()));
    }
    public Optional<CatalyzerRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(4);
        for(int iterate = 0; iterate < 4; iterate++) inventory.setStack(iterate, this.inventory.getStack(iterate));
        return world.getRecipeManager().getFirstMatch(CatalyzerRecipe.Type.INSTANCE, inventory, world);
    }

    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
