package com.blah.coreascension.entity;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.entity.entities.PorcupineEntity;
import com.blah.coreascension.entity.model.PorcupineModel;
import com.blah.coreascension.entity.renderers.PorcupineRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = RegisterEntity("porcupine", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new).dimensions(PorcupineEntity.getEntityDimensions()));

    public static <T extends MobEntity> EntityType<T> RegisterEntity(String name, FabricEntityTypeBuilder<T> EntityType)
    {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(CoreAscension.MOD_ID, name), EntityType.build());
    }

    public static void ClientRegisterEntities()
    {
        EntityRendererRegistry.register(PORCUPINE, PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CoreAscensionModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
    }

    public static void RegisterEntities()
    {
        FabricDefaultAttributeRegistry.register(PORCUPINE, PorcupineEntity.createPorcupineAttributes());
        CoreAscension.LOGGER.info("Registering Entities for " + CoreAscension.MOD_ID);
    }
}
