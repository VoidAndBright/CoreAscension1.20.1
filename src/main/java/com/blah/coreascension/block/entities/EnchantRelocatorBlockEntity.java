package com.blah.coreascension.block.entities;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlockEntities;
import com.blah.coreascension.screen.screens.EnchantmentRelocatorScreen;
import com.blah.coreascension.screen.screens.EnchantmentRelocatorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

import static com.blah.coreascension.screen.screens.EnchantmentRelocatorScreenHandler.*;

public class EnchantRelocatorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private static final int OUTPUT_SLOT = 3;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public EnchantRelocatorBlockEntity(BlockPos pos, BlockState state)
    {
        super(CoreAscensionBlockEntities.ENCHANTMENT_RELOCATOR_BLOCK_ENTITY, pos, state);
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf)
    {
        buf.writeBlockPos(this.pos);
    }

    public Text getDisplayName()
    {
        return Text.translatable("container.enchantment_relocator");
    }

    public DefaultedList<ItemStack> getItems()
    {
        return inventory;
    }

    public void tick(World world, BlockPos pos, BlockState state)
    {
        //if (world.isClient()) return;
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
        return new EnchantmentRelocatorScreenHandler(syncId, playerInventory, this);
    }
}