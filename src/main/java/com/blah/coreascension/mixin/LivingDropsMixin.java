package com.blah.coreascension.mixin;

import com.blah.coreascension.event.events.EntityItemDropEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LivingEntity.class)
public abstract class LivingDropsMixin extends Entity {
    @Inject(method = "dropLoot", at = @At(value = "INVOKE", target = "Lnet/minecraft/loot/LootTable;generateLoot(Lnet/minecraft/loot/context/LootContextParameterSet;JLjava/util/function/Consumer;)V"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void generateEntityItemDropEvent(DamageSource damageSource, boolean causedByPlayer, CallbackInfo ci, Identifier identifier, LootTable lootTable, LootContextParameterSet.Builder builder, LootContextParameterSet lootContextParameterSet) {
        boolean shouldDrop = EntityItemDropEvent.EVENT.invoker().onEntityItemDrop(damageSource, causedByPlayer, lootTable, builder, super.getWorld(), super::dropStack);
        if (!shouldDrop) {
            ci.cancel();
        }
    }

    public LivingDropsMixin(EntityType<?> type, World world) {
        super(type, world);
    }
}