package com.blah.coreascension.entity;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.entity.entities.mobs.PorcupineEntity;
import com.blah.coreascension.entity.entities.projectiles.bolt.*;
import com.blah.coreascension.entity.entities.projectiles.shuriken.*;
import com.blah.coreascension.entity.model.PorcupineModel;
import com.blah.coreascension.entity.model.SkyderModel;
import com.blah.coreascension.entity.renderers.PorcupineRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = RegisterEntity("porcupine", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new).dimensions(PorcupineEntity.getDimensions()));

    public static final EntityType<RubyBoltEntity> RUBY_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "ruby_bolt"),
            FabricEntityTypeBuilder.<RubyBoltEntity>create(SpawnGroup.MISC, RubyBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<CitrineBoltEntity> CITRINE_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "citrine_bolt"),
            FabricEntityTypeBuilder.<CitrineBoltEntity>create(SpawnGroup.MISC, CitrineBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<TopazBoltEntity> TOPAZ_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "topaz_bolt"),
            FabricEntityTypeBuilder.<TopazBoltEntity>create(SpawnGroup.MISC, TopazBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<EmeraldBoltEntity> EMERALD_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "emerald_bolt"),
            FabricEntityTypeBuilder.<EmeraldBoltEntity>create(SpawnGroup.MISC, EmeraldBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<DiamondBoltEntity> DIAMOND_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "diamond_bolt"),
            FabricEntityTypeBuilder.<DiamondBoltEntity>create(SpawnGroup.MISC, DiamondBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<SapphireBoltEntity> SAPPHIRE_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "sapphire_bolt"),
            FabricEntityTypeBuilder.<SapphireBoltEntity>create(SpawnGroup.MISC, SapphireBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<AmethystBoltEntity> AMETHYST_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "amethyst_bolt"),
            FabricEntityTypeBuilder.<AmethystBoltEntity>create(SpawnGroup.MISC, AmethystBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<BlahBoltEntity> BLAH_BOLT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "blah_bolt"),
            FabricEntityTypeBuilder.<BlahBoltEntity>create(SpawnGroup.MISC, BlahBoltEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<FrostShurikenEntity> FROST_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "frost_shuriken"),
            FabricEntityTypeBuilder.<FrostShurikenEntity>create(SpawnGroup.MISC, FrostShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<IronShurikenEntity> IRON_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "iron_shuriken"),
            FabricEntityTypeBuilder.<IronShurikenEntity>create(SpawnGroup.MISC, IronShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<GoldShurikenEntity> GOLD_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "gold_shuriken"),
            FabricEntityTypeBuilder.<GoldShurikenEntity>create(SpawnGroup.MISC, GoldShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<UraniumShurikenEntity> URANIUM_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "uranium_shuriken"),
            FabricEntityTypeBuilder.<UraniumShurikenEntity>create(SpawnGroup.MISC, UraniumShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<TadaniteShurikenEntity> TADANITE_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "tadanite_shuriken"),
            FabricEntityTypeBuilder.<TadaniteShurikenEntity>create(SpawnGroup.MISC, TadaniteShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<LumiteShurikenEntity> LUMITE_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "lumite_shuriken"),
            FabricEntityTypeBuilder.<LumiteShurikenEntity>create(SpawnGroup.MISC, LumiteShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<DiamondShurikenEntity> DIAMOND_SHURIKEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CoreAscension.MOD_ID, "diamond_shuriken"),
            FabricEntityTypeBuilder.<DiamondShurikenEntity>create(SpawnGroup.MISC, DiamondShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static <T extends MobEntity> EntityType<T> RegisterEntity(String name, FabricEntityTypeBuilder<T> EntityType)
    {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(CoreAscension.MOD_ID, name), EntityType.build());
    }

    public static void ClientRegisterEntities()
    {
        EntityRendererRegistry.register(RUBY_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(CITRINE_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TOPAZ_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EMERALD_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(DIAMOND_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(SAPPHIRE_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(AMETHYST_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BLAH_BOLT, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(FROST_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(IRON_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(GOLD_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(DIAMOND_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(URANIUM_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(TADANITE_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(LUMITE_SHURIKEN, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(PORCUPINE, PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CoreAscensionModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CoreAscensionModelLayers.SKYDER, SkyderModel::getTexturedModelData);
    }

    public static void RegisterEntities()
    {
        FabricDefaultAttributeRegistry.register(PORCUPINE, PorcupineEntity.createAttributes());
        CoreAscension.LOGGER.info("Registering Entities for " + CoreAscension.MOD_ID);
    }
}
