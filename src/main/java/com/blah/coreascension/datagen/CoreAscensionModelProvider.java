package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CoreAscensionModelProvider extends FabricModelProvider
{
    public CoreAscensionModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.UMBRASTONE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.POLISHED_UMBRASTONE);
        BlockStateModelGenerator.BlockTexturePool EBONSTONE_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.EBONSTONE);
        EBONSTONE_POOL.stairs(CoreAscensionBlocks.EBONSTONE_STAIRS);
        EBONSTONE_POOL.slab(CoreAscensionBlocks.EBONSTONE_SLAB);
        EBONSTONE_POOL.wall(CoreAscensionBlocks.EBONSTONE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.RUNIC_OBSIDIAN_M);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.RUNIC_OBSIDIAN_O);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.RUNIC_OBSIDIAN_J);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.RUNIC_OBSIDIAN_A);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.RUNIC_OBSIDIAN_N);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.RUNIC_OBSIDIAN_G);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.FYRENDIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.FYRENDIUM_CRYSTAL);// change to column when the top texture is finished
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.DOOMSTONE);
        blockStateModelGenerator.registerLog(CoreAscensionBlocks.UMBRASTONE_COLUMN);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.DIAMOND_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.BLIZZARACK);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.OBSIDIAN_BRICKS);
        BlockStateModelGenerator.BlockTexturePool BLIZZARACK_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.BLIZZARACK_BRICKS);
        BLIZZARACK_POOL.stairs(CoreAscensionBlocks.BLIZZARACK_BRICK_STAIRS);
        BLIZZARACK_POOL.slab(CoreAscensionBlocks.BLIZZARACK_BRICK_SLAB);
        BLIZZARACK_POOL.wall(CoreAscensionBlocks.BLIZZARACK_BRICK_WALL);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.FROST_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.CAKEWOOD_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.CACTUS_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.DARK_MATTER_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.ENTROPY_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.GLASS_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.LUMITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(CoreAscensionBlocks.ENTROPY_TRAPDOOR);
        blockStateModelGenerator.registerLog(CoreAscensionBlocks.ENTROPY_STEM).log(CoreAscensionBlocks.ENTROPY_STEM).wood(CoreAscensionBlocks.ENTROPY_HYPHAE);
        blockStateModelGenerator.registerLog(CoreAscensionBlocks.STRIPPED_ENTROPY_STEM).log(CoreAscensionBlocks.STRIPPED_ENTROPY_STEM).wood(CoreAscensionBlocks.STRIPPED_ENTROPY_HYPHAE);
    }

    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(CoreAscensionItems.TROPICS_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.TROPICS_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.CEDAR_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.CEDAR_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.DARK_MATTER_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.DARK_MATTER_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.CACTUS_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.CACTUS_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.ETHEREAL_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.ETHEREAL_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.WHITEWOOD_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.WHITEWOOD_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.CAKEWOOD_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.CAKEWOOD_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.DREAD_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.DREAD_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.END_GAS_BUCKET, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.MOLTEN_ICE_BUCKET, Models.GENERATED);
    }
}
