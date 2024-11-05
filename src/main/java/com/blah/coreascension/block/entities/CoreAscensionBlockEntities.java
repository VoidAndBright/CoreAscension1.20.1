package com.blah.coreascension.block.entities;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.entities.renderer.ReinforcedChestBlockEntityRenderer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class CoreAscensionBlockEntities {
    public static final BlockEntityType<ReinforcedChestBlockEntity> REINFORCED_CHEST_BLOCK_ENTITY = registerBlockEntity("reinforced_chest", FabricBlockEntityTypeBuilder.create(ReinforcedChestBlockEntity::new, CoreAscensionBlocks.REINFORCED_CHEST));
    public static final BlockEntityType<PrismaeroFurnaceBlockEntity> PRISMAERO_FURNACE_BLOCK_ENTITY = registerBlockEntity("prismaero_furnace", FabricBlockEntityTypeBuilder.create(PrismaeroFurnaceBlockEntity::new, CoreAscensionBlocks.PRISMAERO_FURNACE));

    public static BlockEntityType registerBlockEntity(String name, FabricBlockEntityTypeBuilder blockEntityType){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoreAscension.MOD_ID, name), blockEntityType.build());
    }
    public static void RegisterBlockEntities() {
        CoreAscension.LOGGER.info("Registering Block Entities for " + CoreAscension.MOD_ID);
    }
    public static void ClientBlockEntitiesRenderer(){
        BlockEntityRendererFactories.register(REINFORCED_CHEST_BLOCK_ENTITY, ReinforcedChestBlockEntityRenderer::new);
    }
}