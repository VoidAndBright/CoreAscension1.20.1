package com.blah.coreascension.mixin;

import com.blah.coreascension.enchantment.CoreAscensionEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Block.class)
public class BlockBreakMixin {

    @Inject(
            method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
            at = @At("RETURN"),
            cancellable = true)
    private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> items = new ArrayList<>();
        List<ItemStack> returnValue = cir.getReturnValue();

        if (EnchantmentHelper.getLevel(CoreAscensionEnchantments.MOLTEN_TOUCH, stack) > 0)
        {
            for (ItemStack itemStack : returnValue)
            {
                var recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(itemStack), world);
                if (recipe.isPresent())
                {
                    ItemStack smelted = recipe.get().getOutput(world.getRegistryManager()).copy();
                    smelted.setCount(itemStack.getCount());
                    for (int level = 0; level <= EnchantmentHelper.getLevel(Enchantments.FORTUNE, stack); level++)
                    {
                        items.add(smelted);
                        world.spawnEntity(new ExperienceOrbEntity(world, pos.getX(), pos.getY(), pos.getZ(), 3));
                    }
                }
                else
                {
                    items.add(itemStack);
                }
            }
            cir.setReturnValue(items);
        }
        if (EnchantmentHelper.getLevel(CoreAscensionEnchantments.EXPERIENCE_BOOST_TOOL, stack) > 0)
        {
            for (ItemStack itemStack : returnValue)
            {
                // TODO: make this not drop XP for ALL smeltable blocks
                // TODO: just the ones that smelt into ingots or are things like diamond, emerald, redstone, etc.
                var recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(itemStack), world);
                if (recipe.isPresent())
                {
                    for (int level = 0; level < EnchantmentHelper.getLevel(CoreAscensionEnchantments.EXPERIENCE_BOOST_TOOL, stack); level++)
                    {
                        world.spawnEntity(new ExperienceOrbEntity(world, pos.getX(), pos.getY(), pos.getZ(), 2));
                    }
                }
            }
            cir.setReturnValue(items);
        }
    }
}