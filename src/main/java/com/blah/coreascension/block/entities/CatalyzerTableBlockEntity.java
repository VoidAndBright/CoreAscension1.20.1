package com.blah.coreascension.block.entities;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
<<<<<<< Updated upstream
import com.blah.coreascension.screen.screens.CatalyzerScreenHandler;
import com.blah.coreascension.screen.screens.PrismaeroFurnaceScreenHandler;
=======
import com.blah.coreascension.screen.screens.CatalyzerTableScreenHandler;
>>>>>>> Stashed changes
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;


public class CatalyzerTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public CatalyzerTableBlockEntity(BlockPos pos, BlockState state) {
        super(CoreAscensionBlockEntities.CATALYZER_TABLE_BLOCK_ENTITY, pos, state);
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    public Text getDisplayName() {
        return Text.translatable("container.catalyzer");
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
<<<<<<< Updated upstream
        return new CatalyzerScreenHandler(syncId, playerInventory, this);
=======
        return new CatalyzerTableScreenHandler(syncId, playerInventory, this);
>>>>>>> Stashed changes
    }
}