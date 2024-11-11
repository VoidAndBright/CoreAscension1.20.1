package com.blah.coreascension.block;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.entities.CatalyzerTableBlockEntity;
import com.blah.coreascension.block.entities.PrismaeroFurnaceBlockEntity;
import com.blah.coreascension.block.entities.ReinforcedChestBlockEntity;
import com.blah.coreascension.block.entities.renderer.ReinforcedChest;
import com.blah.coreascension.block.entities.renderer.ReinforcedChestBlockEntityRenderer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class CoreAscensionBlockEntities {
    public static final BlockEntityType<ReinforcedChestBlockEntity> REINFORCED_CHEST_BLOCK_ENTITY = registerBlockEntity("reinforced_chest", FabricBlockEntityTypeBuilder.create(ReinforcedChestBlockEntity::new, CoreAscensionBlocks.REINFORCED_CHEST));
    public static final BlockEntityType<PrismaeroFurnaceBlockEntity> PRISMAERO_FURNACE_BLOCK_ENTITY = registerBlockEntity("prismaero_furnace", FabricBlockEntityTypeBuilder.create(PrismaeroFurnaceBlockEntity::new, CoreAscensionBlocks.PRISMAERO_FURNACE));
    public static final BlockEntityType<CatalyzerTableBlockEntity> CATALYZER_TABLE_BLOCK_ENTITY = registerBlockEntity("catalyzer_table", FabricBlockEntityTypeBuilder.create(CatalyzerTableBlockEntity::new, CoreAscensionBlocks.CATALYZER_TABLE));

    public static <T extends BlockEntity> BlockEntityType<T>registerBlockEntity(String name, FabricBlockEntityTypeBuilder<T> blockEntityType){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoreAscension.MOD_ID, name), blockEntityType.build());
    }
    public static void RegisterBlockEntities() {
        CoreAscension.LOGGER.info("Registering Block Entities for " + CoreAscension.MOD_ID);
    }
    public static void ClientRegisterBlockEntitiesRenderer(){
        BlockEntityRendererFactories.register(REINFORCED_CHEST_BLOCK_ENTITY, ReinforcedChest::new);
    }
}