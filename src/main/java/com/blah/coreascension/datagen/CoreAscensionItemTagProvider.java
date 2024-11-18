package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CoreAscensionItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public CoreAscensionItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(CoreAscensionBlocks.CEDAR_PLANKS.asItem())
                .add(CoreAscensionBlocks.CACTUS_PLANKS.asItem())
                .add(CoreAscensionBlocks.TROPICS_PLANKS.asItem())
                .add(CoreAscensionBlocks.DREAD_PLANKS.asItem())
                .add(CoreAscensionBlocks.ETHEREAL_PLANKS.asItem())
                .add(CoreAscensionBlocks.DARK_MATTER_PLANKS.asItem())
                .add(CoreAscensionBlocks.CAKEWOOD_PLANKS.asItem())
                .add(CoreAscensionBlocks.ENTROPY_PLANKS.asItem())
                .add(CoreAscensionBlocks.FROST_PLANKS.asItem())
                .add(CoreAscensionBlocks.WHITEWOOD_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(CoreAscensionItems.BEDROCK_PICKAXE)
                .add(CoreAscensionItems.LUMITE_PICKAXE)
                .add(CoreAscensionItems.DUSK_PICKAXE)
                .add(CoreAscensionItems.TADANITE_PICKAXE)
                .add(CoreAscensionItems.POTATO_PICKAXE)
                .add(CoreAscensionItems.SAPPHIRE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(CoreAscensionItems.LUMITE_AXE)
                .add(CoreAscensionItems.TWILIGHT_AXE)
                .add(CoreAscensionItems.POTATO_AXE)
                .add(CoreAscensionItems.SAPPHIRE_AXE)
                .add(CoreAscensionItems.TADANITE_AXE)
                .add(CoreAscensionItems.URANIUM_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(CoreAscensionItems.LUMITE_SHOVEL)
                .add(CoreAscensionItems.POTATO_SHOVEL)
                .add(CoreAscensionItems.SAPPHIRE_SHOVEL)
                .add(CoreAscensionItems.TADANITE_SHOVEL)
                .add(CoreAscensionItems.URANIUM_SHOVEL);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(CoreAscensionBlocks.TROPICS_LOG.asItem())
                .add(CoreAscensionBlocks.TROPICS_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_TROPICS_WOOD.asItem())
                .add(CoreAscensionBlocks.ETHEREAL_LOG.asItem())
                .add(CoreAscensionBlocks.ETHEREAL_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_ETHEREAL_WOOD.asItem())
                .add(CoreAscensionBlocks.CEDAR_LOG.asItem())
                .add(CoreAscensionBlocks.CEDAR_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_CEDAR_WOOD.asItem())
                .add(CoreAscensionBlocks.CAKEWOOD_LOG.asItem())
                .add(CoreAscensionBlocks.CAKEWOOD_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_CAKEWOOD_WOOD.asItem())
                .add(CoreAscensionBlocks.DREAD_LOG.asItem())
                .add(CoreAscensionBlocks.DREAD_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_DREAD_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_DREAD_WOOD.asItem())
                .add(CoreAscensionBlocks.WHITEWOOD_LOG.asItem())
                .add(CoreAscensionBlocks.WHITEWOOD_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_WHITEWOOD_WOOD.asItem())
                .add(CoreAscensionBlocks.DARK_MATTER_LOG.asItem())
                .add(CoreAscensionBlocks.DARK_MATTER_WOOD.asItem())
                .add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_LOG.asItem())
                .add(CoreAscensionBlocks.STRIPPED_DARK_MATTER_WOOD.asItem());
    }
}
