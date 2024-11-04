package com.blah.coreascension.blockentity;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.blockentity.blockentities.PrismaerionFurnaceBlockEntity;
import com.blah.coreascension.blockentity.blockentities.ReinforcedChestBlockEntity;
import com.blah.coreascension.blockentity.blockentities.renderer.ReinforcedChestBlockEntityRenderer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class CoreAscensionBlockEntities {
    public static final BlockEntityType<ReinforcedChestBlockEntity> REINFORCED_CHEST_BLOCK_ENTITY = registerBlockEntity("reinforced_chest", FabricBlockEntityTypeBuilder.create(ReinforcedChestBlockEntity::new, CoreAscensionBlocks.REINFORCED_CHEST));
    public static final BlockEntityType<PrismaerionFurnaceBlockEntity> PRISMAERION_FURNACE_ENTITY = registerBlockEntity("prismaerion_furnace", FabricBlockEntityTypeBuilder.create(PrismaerionFurnaceBlockEntity::new, CoreAscensionBlocks.PRISMAERION_FURNACE));

    public static BlockEntityType registerBlockEntity(String name, FabricBlockEntityTypeBuilder blockEntityType){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoreAscension.MOD_ID, name), blockEntityType.build());
    }
    public static void RegisterBlockEntities() {
        CoreAscension.LOGGER.info("Registering BlockEntities for " + CoreAscension.MOD_ID);
    }
    public static void ClientBlockEntitiesRenderer(){
        BlockEntityRendererFactories.register(REINFORCED_CHEST_BLOCK_ENTITY, ReinforcedChestBlockEntityRenderer::new);
    }
}