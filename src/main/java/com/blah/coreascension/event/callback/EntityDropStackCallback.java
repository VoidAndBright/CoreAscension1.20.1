package com.blah.coreascension.event.callback;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

public interface EntityDropStackCallback {
    ItemEntity dropStack(ItemStack stack);
}