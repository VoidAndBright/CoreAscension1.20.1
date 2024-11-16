package com.blah.coreascension.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.world.World;

public interface EntityItemDropCallback {
    Event<EntityItemDropCallback> EVENT = EventFactory.createArrayBacked(
            EntityItemDropCallback.class,
            (listeners) -> (source, causedByPlayer, lootTable, lootContext, world, dropStack) ->
            {
                for (EntityItemDropCallback callback : listeners)
                {
                    boolean result = callback.onEntityItemDrop(source, causedByPlayer, lootTable, lootContext, world, dropStack);

                    if (!result)
                    {
                        return false;
                    }
                }
                return true;
            }
    );

    boolean onEntityItemDrop(DamageSource source, boolean causedByPlayer, LootTable lootTable, LootContextParameterSet.Builder builder, World world, EntityDropStackCallback dropStack);
}
