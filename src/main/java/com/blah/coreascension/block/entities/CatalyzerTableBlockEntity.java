package com.blah.coreascension.block.entities;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.recipe.CatalyzerRecipe;
import com.blah.coreascension.screen.screens.CatalyzerTableScreenHandler;
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
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;


public class CatalyzerTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private static final int INPUT_SLOT = 0;
    private static final int CATALYST_SLOT = 1;
    private static final int SULPHUR_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;

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

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) return;
        if(isOutputSlotReceivable())
            if(hasRecipe()) craftItem();
            else markDirty(world, pos, state);
    }
    public boolean hasRecipe() {
        Optional<CatalyzerRecipe> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().getOutput(null)) && canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem());
    }
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return getStack(OUTPUT_SLOT).getItem() == item || getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotReceivable() {
        return getStack(OUTPUT_SLOT).getCount() < getStack(OUTPUT_SLOT).getMaxCount();
    }
    private void craftItem() {
        Optional<CatalyzerRecipe> recipe = getCurrentRecipe();
        //this.removeStack(INPUT_SLOT, 1);
        //this.removeStack(CATALYST_SLOT, 1);
        //this.removeStack(SULPHUR_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(), getStack(OUTPUT_SLOT).getCount() + recipe.get().getOutput(null).getCount()));
    }
    public Optional<CatalyzerRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for(int iterate = 0; iterate < this.size(); iterate++) inventory.setStack(iterate, this.getStack(iterate));
        return getWorld().getRecipeManager().getFirstMatch(CatalyzerRecipe.Type.INSTANCE, inventory, getWorld());
    }
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CatalyzerTableScreenHandler(syncId, playerInventory, this);
    }
}