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


public class CatalyzerTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory
{
    private static final int INPUT_SLOT = 0;
    private static final int CATALYZIST_SLOT = 1;
    private static final int SULPHUR_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public CatalyzerTableBlockEntity(BlockPos pos, BlockState state)
    {
        super(CoreAscensionBlockEntities.CATALYZER_TABLE_BLOCK_ENTITY, pos, state);
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf)
    {
        buf.writeBlockPos(this.pos);
    }

    public Text getDisplayName()
    {
        return Text.translatable("container.catalyzer");
    }

    public DefaultedList<ItemStack> getItems()
    {
        return inventory;
    }

    @Override
    public void markDirty()
    {
        onContentChanged(this.world,this.pos,this.getCachedState());
    }

    public void onContentChanged(World world, BlockPos pos, BlockState state)
    {
        if (world.isClient()) return;
        if (hasRecipe())
        {
            showItem();
            markDirty(world, pos, state);
        }
        else {
            this.removeStack(3);
            markDirty(world, pos, state);
        }
    }
    public boolean hasRecipe()
    {
        Optional<CatalyzerRecipe> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().getOutput(null)) && canInsertItemIntoOutputSlot(recipe.get().getOutput(null).getItem());
    }

    @Override
    public ItemStack removeStack(int slot, int count)
    {
        ItemStack result = Inventories.splitStack(getItems(), slot, count);
        if (!result.isEmpty())
        {
            markDirty();
            if (slot==3)
            {
                onCraftItem();
            }
        }
        return result;
    }

    public void onCraftItem(){
        this.removeStack(INPUT_SLOT,1);
        this.removeStack(CATALYZIST_SLOT,1);
        this.removeStack(SULPHUR_SLOT,1);
    }
    private void showItem()
    {
        Optional<CatalyzerRecipe> recipe = getCurrentRecipe();
        this.inventory.set(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(), recipe.get().getOutput(null).getCount()));
    }

    public Optional<CatalyzerRecipe> getCurrentRecipe()
    {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int iterate = 0; iterate < this.size(); iterate++) inventory.setStack(iterate, this.getStack(iterate));
        return getWorld().getRecipeManager().getFirstMatch(CatalyzerRecipe.Type.INSTANCE, inventory, getWorld());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result)
    {
        return getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(Item item)
    {
        return getStack(OUTPUT_SLOT).getItem() == item || getStack(OUTPUT_SLOT).isEmpty();
    }

    public void readNbt(NbtCompound nbt)
    {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    protected void writeNbt(NbtCompound nbt)
    {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        return new CatalyzerTableScreenHandler(syncId, playerInventory, this);
    }
}