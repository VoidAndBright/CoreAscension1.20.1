package com.blah.coreascension.block.entities;

import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.screen.screens.ReinforcedChestScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class ReinforcedChestBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory, LidOpenable {
    private DefaultedList<ItemStack> inventory;

    public ReinforcedChestBlockEntity(BlockPos pos, BlockState state)
    {
        this(CoreAscensionBlockEntities.REINFORCED_CHEST_BLOCK_ENTITY, pos, state);
    }

    public ReinforcedChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState)
    {
        super(blockEntityType, blockPos, blockState);
        this.inventory = DefaultedList.ofSize(78, ItemStack.EMPTY);
    }

    @Override
    public DefaultedList<ItemStack> getItems()
    {
        return inventory;
    }

    public int size()
    {
        return inventory.size();
    }

    public void readNbt(NbtCompound nbt)
    {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readNbt(nbt, this.inventory);
    }

    protected void writeNbt(NbtCompound nbt)
    {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    public void onOpen(PlayerEntity player)
    {
        if (!this.removed && !player.isSpectator()) {
            world.playSound(null, pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        }

    }

    public void onClose(PlayerEntity player)
    {
        if (!this.removed && !player.isSpectator()) {
            world.playSound(null, pos, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf)
    {
        buf.writeBlockPos(this.pos);
    }


    public Text getDisplayName()
    {
        return Text.translatable("container.reinforced_chest");
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        return new ReinforcedChestScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public float getAnimationProgress(float tickDelta)
    {
        return 0;
    }
}
