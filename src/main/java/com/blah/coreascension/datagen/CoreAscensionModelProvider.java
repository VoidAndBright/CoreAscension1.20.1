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
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_REDSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_LAPIS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.SCORIA_SUNSTONE_ORE);
        BlockStateModelGenerator.BlockTexturePool SMOOTH_DREAD_SANDSTONE_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE);
        SMOOTH_DREAD_SANDSTONE_POOL.stairs(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE_STAIRS);
        SMOOTH_DREAD_SANDSTONE_POOL.slab(CoreAscensionBlocks.SMOOTH_DREAD_SANDSTONE_SLAB);
        BlockStateModelGenerator.BlockTexturePool SMOOTH_BLACK_SANDSTONE_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE);
        SMOOTH_BLACK_SANDSTONE_POOL.stairs(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS);
        SMOOTH_BLACK_SANDSTONE_POOL.slab(CoreAscensionBlocks.SMOOTH_BLACK_SANDSTONE_SLAB);
        BlockStateModelGenerator.BlockTexturePool SMOOTH_FROST_SANDSTONE_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.SMOOTH_FROST_SANDSTONE);
        SMOOTH_FROST_SANDSTONE_POOL.stairs(CoreAscensionBlocks.SMOOTH_FROST_SANDSTONE_STAIRS);
        SMOOTH_FROST_SANDSTONE_POOL.slab(CoreAscensionBlocks.SMOOTH_FROST_SANDSTONE_SLAB);
        BlockStateModelGenerator.BlockTexturePool SMOOTH_BONESANDSTONE_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.SMOOTH_BONESANDSTONE);
        SMOOTH_BONESANDSTONE_POOL.stairs(CoreAscensionBlocks.SMOOTH_BONESANDSTONE_STAIRS);
        SMOOTH_BONESANDSTONE_POOL.slab(CoreAscensionBlocks.SMOOTH_BONESANDSTONE_SLAB);
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
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.DIAMOND_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.BLIZZARACK);
        blockStateModelGenerator.registerSimpleCubeAll(CoreAscensionBlocks.OBSIDIAN_BRICKS);
        BlockStateModelGenerator.BlockTexturePool BLIZZARACK_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.BLIZZARACK_BRICKS);
        BlockStateModelGenerator.BlockTexturePool PETRIFIED_POOL = blockStateModelGenerator.registerCubeAllModelTexturePool(CoreAscensionBlocks.PETRIFIED_WOOD);
        PETRIFIED_POOL.wall(CoreAscensionBlocks.PETRIFIED_WOOD_WALL);
        BLIZZARACK_POOL.stairs(CoreAscensionBlocks.BLIZZARACK_BRICK_STAIRS);
        BLIZZARACK_POOL.slab(CoreAscensionBlocks.BLIZZARACK_BRICK_SLAB);
        BLIZZARACK_POOL.wall(CoreAscensionBlocks.BLIZZARACK_BRICK_WALL);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.FROST_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.CAKEWOOD_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.CACTUS_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.DARK_MATTER_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.GOLD_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.COBBLESTONE_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.ENTROPY_DOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.GLASS_DOOR);
        blockStateModelGenerator.registerTrapdoor(CoreAscensionBlocks.GLASS_TRAPDOOR);
        blockStateModelGenerator.registerDoor(CoreAscensionBlocks.LUMITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(CoreAscensionBlocks.ENTROPY_TRAPDOOR);
        blockStateModelGenerator.registerLog(CoreAscensionBlocks.ENTROPY_STEM).log(CoreAscensionBlocks.ENTROPY_STEM).wood(CoreAscensionBlocks.ENTROPY_HYPHAE);
        blockStateModelGenerator.registerLog(CoreAscensionBlocks.STRIPPED_ENTROPY_STEM).log(CoreAscensionBlocks.STRIPPED_ENTROPY_STEM).wood(CoreAscensionBlocks.STRIPPED_ENTROPY_HYPHAE);
    }

    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_HELMET, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_BOOTS, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_SWORD, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_AXE, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_HOE, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_SCYTHE, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_EXCAVATOR, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.SOLARIUM_HAMMER, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.FYRENDIUM_ROCK, Models.GENERATED);
        itemModelGenerator.register(CoreAscensionItems.ONYX, Models.GENERATED);
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
