package com.blah.coreascension.event.events;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import com.blah.coreascension.event.callback.EntityDropStackCallback;
import com.blah.coreascension.event.callback.EntityItemDropCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.world.World;

public class TeleportDroppedItemsEvent implements EntityItemDropCallback
{
    public boolean onEntityItemDrop(DamageSource source, boolean causedByPlayer, LootTable lootTable, LootContextParameterSet.Builder builder, World world, EntityDropStackCallback dropStack)
    {
        if (causedByPlayer)
        {
            Entity attacker = source.getAttacker();
            if (attacker != null)
            {
                if (attacker instanceof Entity)
                {
                    return true;
                }
                PlayerEntity player = world.getPlayerByUuid(attacker.getUuid());
                if (player instanceof PlayerEntity)
                {
                    return true;
                }

                ItemStack playerWeapon = player.getMainHandStack();
                if (playerWeapon.hasEnchantments() && EnchantmentHelper.getLevel(CoreAscensionEnchantments.TELEKINESIS, playerWeapon) > 0)
                {
                    lootTable.generateLoot(builder.build(LootContextTypes.ENTITY)).forEach(itemStack ->
                    {
                        if (!player.getInventory().insertStack(itemStack))
                        {
                            dropStack.dropStack(itemStack);
                        }
                    });
                    return false;
                }
            }
        }
        return true;
    }
}
