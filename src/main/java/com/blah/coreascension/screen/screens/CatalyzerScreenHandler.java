package com.blah.coreascension.screen.screens;


import com.blah.coreascension.block.entities.CatalyzerTableBlockEntity;
import com.blah.coreascension.block.entities.PrismaeroFurnaceBlockEntity;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CatalyzerScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public final CatalyzerTableBlockEntity blockEntity;
    public CatalyzerScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf PacketByteBuf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(PacketByteBuf.readBlockPos()));
    }

    public CatalyzerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(CoreAscensionScreenHandlers.CATALYZER_SCREEN_HANDLER,syncId);
        this.blockEntity = ((CatalyzerTableBlockEntity) blockEntity);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.addSlot(new Slot(inventory, 0, 30, 18));
        this.addSlot(new Slot(inventory, 1, 66, 18));
        this.addSlot(new Slot(inventory, 2, 48, 52));
        this.addSlot(new Slot(inventory, 3, 124, 35));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.dropInventory(player, this.inventory);
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