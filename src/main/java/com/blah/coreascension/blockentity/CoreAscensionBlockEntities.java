package com.blah.coreascension.blockentity;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class CoreAscensionBlockEntities {
    public static final BlockEntityType<GemPolishingStationBlockEntity> GEM_POLISHING_STATION_BLOCK_ENTITY = registerBlockEntity("lmnkonmo", FabricBlockEntityTypeBuilder.create(GemPolishingStationBlockEntity::new, CoreAscensionBlocks.SAFE));

    public static BlockEntityType registerBlockEntity(String name, FabricBlockEntityTypeBuilder blockEntityType){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoreAscension.MOD_ID, name), blockEntityType.build());
    }
    public static void registerBlockEntities() {
        CoreAscension.LOGGER.info("Registering BlockEntities for " + CoreAscension.MOD_ID);
    }
}