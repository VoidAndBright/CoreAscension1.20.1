package com.blah.coreascension.screen.screens;

import com.blah.coreascension.block.entities.blockentities.ReinforcedChestBlockEntity;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ReinforcedChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public final ReinforcedChestBlockEntity blockEntity;

    public ReinforcedChestScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }

    public ReinforcedChestScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(CoreAscensionScreenHandlers.REINFORCED_CHEST_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 78);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.blockEntity = ((ReinforcedChestBlockEntity) blockEntity);

        addChestInventory(inventory);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public Inventory getInventory() {
        return inventory;
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


    private void addChestInventory(Inventory Inventory) {
        for (int iterate_x = 0; iterate_x < 13; ++iterate_x) {
            for (int iterate_y = 0; iterate_y < 6; ++iterate_y) {
                this.addSlot(new Slot(Inventory,iterate_y*13+iterate_x, iterate_x*18-28, iterate_y*18-10));
            }
        }
    }
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int iterate_x = 0; iterate_x < 9; ++iterate_x) {
            for (int iterate_y = 0; iterate_y < 3; ++iterate_y) {
                this.addSlot(new Slot(playerInventory, iterate_x+iterate_y*9+9, 8 + iterate_x*18, iterate_y*18+112));
            }
        }
    }
    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int iterate_x = 0; iterate_x < 9; ++iterate_x) {
            this.addSlot(new Slot(playerInventory,iterate_x,8+iterate_x*18,170));
        }
    }
}
