package com.blah.coreascension.screen.screens;


import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.entities.CatalyzerTableBlockEntity;
import com.blah.coreascension.block.entities.EnchantRelocatorBlockEntity;
import com.blah.coreascension.item.CoreAscensionItems;
import com.blah.coreascension.recipe.CatalyzerRecipe;
import com.blah.coreascension.screen.CoreAscensionScreenHandlers;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Optional;

public class EnchantmentRelocatorScreenHandler extends ScreenHandler
{
    public static final int ENCH_ITEM_INPUT = 0;
    public static final int BOOK_SLOT = 1;
    public static final int OUTPUT_ITEM_SLOT = 2;
    public static final int OUTPUT_ENCH_BOOK_SLOT = 3;

    public final EnchantRelocatorBlockEntity blockEntity;
    public final Inventory inventory;
    private final World world;

    public EnchantmentRelocatorScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf)
    {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }

    public EnchantmentRelocatorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity)
    {
        super(CoreAscensionScreenHandlers.ENCHANTMENT_RELOCATOR_SCREEN_HANDLER, syncId);
        checkSize((Inventory) blockEntity, 4);
        this.inventory = (Inventory) blockEntity;
        this.world = blockEntity.getWorld();
        inventory.onOpen(playerInventory.player);
        this.blockEntity = (EnchantRelocatorBlockEntity) blockEntity;
        this.addSlot(new Slot(inventory, 0, 26, 36));
        this.addSlot(new Slot(inventory, 1, 62, 36)
        {
            public boolean canInsert(ItemStack stack)
            {
                return stack.getItem() == Items.BOOK;
            }
        });
        this.addSlot(new Slot(inventory, 2, 116, 26)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
        });
        this.addSlot(new Slot(inventory, 3, 116, 46)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id)
    {
        if (id == 0)
        {
            EnchantmentRelocatorScreenHandler handler = (EnchantmentRelocatorScreenHandler)player.currentScreenHandler;
            if (player.isCreative() || player.experienceLevel >= 10)
            {
                if (handler.inventory.getStack(OUTPUT_ITEM_SLOT)
                        .getCount() == 0 && handler.inventory.getStack(OUTPUT_ENCH_BOOK_SLOT).getCount() == 0 &&
                        handler.inventory.getStack(ENCH_ITEM_INPUT)
                                .getCount() == 1 && handler.inventory.getStack(BOOK_SLOT).getCount() > 0)
                {
                    if (handler.inventory.getStack(ENCH_ITEM_INPUT).hasEnchantments())
                    {
                        handler.inventory.setStack(OUTPUT_ENCH_BOOK_SLOT, new ItemStack(Items.ENCHANTED_BOOK, 1));

                        ItemStack inSlot0 = handler.inventory.getStack(ENCH_ITEM_INPUT);
                        ItemStack inSlot3 = handler.inventory.getStack(OUTPUT_ENCH_BOOK_SLOT);
                        EnchantmentHelper.set(EnchantmentHelper.get(inSlot0), inSlot3);

                        Map<Enchantment, Integer> ench = EnchantmentHelper.get(handler.inventory.getStack(ENCH_ITEM_INPUT));
                        ench.clear();

                        ItemStack stack = new ItemStack(handler.inventory.getStack(ENCH_ITEM_INPUT).getItem(), 1);

                        stack.setDamage(handler.inventory.getStack(ENCH_ITEM_INPUT).getDamage());
                        handler.inventory.setStack(OUTPUT_ITEM_SLOT, stack);
                        if (!player.isCreative())
                        {
                            player.addExperienceLevels(-10);
                        }
                        handler.inventory.getStack(ENCH_ITEM_INPUT).decrement(1);
                        handler.inventory.getStack(BOOK_SLOT).decrement(1);

                        player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.4f, 1f);
                    }
                }
            }
        }

        return super.onButtonClick(player, id);
    }

    private void addPlayerInventory(PlayerInventory playerInventory)
    {
        for (int i = 0; i < 3; ++i)
        {
            for (int l = 0; l < 9; ++l)
            {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory)
    {
        for (int i = 0; i < 9; ++i)
        {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public ItemStack quickMove(PlayerEntity player, int invSlot)
    {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack())
        {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size())
            {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false))
            {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty())
            {
                slot.setStack(ItemStack.EMPTY);
            } else
            {
                slot.markDirty();
            }
        }

        return newStack;
    }

    public boolean canUse(PlayerEntity player)
    {
        return this.inventory.canPlayerUse(player);
    }
}
