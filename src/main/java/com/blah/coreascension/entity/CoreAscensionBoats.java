package com.blah.coreascension.entity;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.item.CoreAscensionItems;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class CoreAscensionBoats {
    public static final Identifier CEDAR_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "cedar_boat");
    public static final Identifier CEDAR_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "cedar_chest_boat");
    public static final RegistryKey<TerraformBoatType> CEDAR_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CEDAR_BOAT_ID);

    public static final Identifier TROPICS_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "tropics_boat");
    public static final Identifier TROPICS_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "tropics_chest_boat");
    public static final RegistryKey<TerraformBoatType> TROPICS_BOAT_KEY = TerraformBoatTypeRegistry.createKey(TROPICS_BOAT_ID);

    public static final Identifier DARK_MATTER_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "dark_matter_boat");
    public static final Identifier DARK_MATTER_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "dark_matter_chest_boat");
    public static final RegistryKey<TerraformBoatType> DARK_MATTER_BOAT_KEY = TerraformBoatTypeRegistry.createKey(DARK_MATTER_BOAT_ID);

    public static final Identifier CAKEWOOD_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "cakewood_boat");
    public static final Identifier CAKEWOOD_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "cakewood_chest_boat");
    public static final RegistryKey<TerraformBoatType> CAKEWOOD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CAKEWOOD_BOAT_ID);

    public static final Identifier WHITEWOOD_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "whitewood_boat");
    public static final Identifier WHITEWOOD_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "whitewood_chest_boat");
    public static final RegistryKey<TerraformBoatType> WHITEWOOD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(WHITEWOOD_BOAT_ID);

    public static final Identifier DREAD_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "dread_boat");
    public static final Identifier DREAD_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "dread_chest_boat");
    public static final RegistryKey<TerraformBoatType> DREAD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(DREAD_BOAT_ID);

    public static final Identifier ETHEREAL_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "ethereal_boat");
    public static final Identifier ETHEREAL_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "ethereal_chest_boat");
    public static final RegistryKey<TerraformBoatType> ETHEREAL_BOAT_KEY = TerraformBoatTypeRegistry.createKey(ETHEREAL_BOAT_ID);

    public static final Identifier CACTUS_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "cactus_boat");
    public static final Identifier CACTUS_CHEST_BOAT_ID = new Identifier(CoreAscension.MOD_ID, "cactus_chest_boat");
    public static final RegistryKey<TerraformBoatType> CACTUS_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CACTUS_BOAT_ID);

    public static void RegisterClientSideBoats()
    {
        TerraformBoatClientHelper.registerModelLayers(TROPICS_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(CEDAR_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(WHITEWOOD_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(CACTUS_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(DREAD_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(CAKEWOOD_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ETHEREAL_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(DARK_MATTER_BOAT_ID, false);
    }

    public static void registerBoats()
    {
        TerraformBoatType cedarBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.CEDAR_BOAT)
                .chestItem(CoreAscensionItems.CEDAR_CHEST_BOAT)
                .planks(CoreAscensionBlocks.CEDAR_PLANKS.asItem())
                .build();
        TerraformBoatType tropicsBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.TROPICS_BOAT)
                .chestItem(CoreAscensionItems.TROPICS_CHEST_BOAT)
                .planks(CoreAscensionBlocks.TROPICS_PLANKS.asItem())
                .build();
        TerraformBoatType cakewoodBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.CAKEWOOD_BOAT)
                .chestItem(CoreAscensionItems.CAKEWOOD_CHEST_BOAT)
                .planks(CoreAscensionBlocks.CAKEWOOD_PLANKS.asItem())
                .build();
        TerraformBoatType darkMatterBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.DARK_MATTER_BOAT)
                .chestItem(CoreAscensionItems.DARK_MATTER_CHEST_BOAT)
                .planks(CoreAscensionBlocks.DARK_MATTER_PLANKS.asItem())
                .build();
        TerraformBoatType whitewoodBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.WHITEWOOD_BOAT)
                .chestItem(CoreAscensionItems.WHITEWOOD_CHEST_BOAT)
                .planks(CoreAscensionBlocks.WHITEWOOD_PLANKS.asItem())
                .build();
        TerraformBoatType cactusBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.CACTUS_BOAT)
                .chestItem(CoreAscensionItems.CACTUS_CHEST_BOAT)
                .planks(CoreAscensionBlocks.CACTUS_PLANKS.asItem())
                .build();
        TerraformBoatType etherealBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.ETHEREAL_BOAT)
                .chestItem(CoreAscensionItems.ETHEREAL_CHEST_BOAT)
                .planks(CoreAscensionBlocks.ETHEREAL_PLANKS.asItem())
                .build();
        TerraformBoatType dreadBoat = new TerraformBoatType.Builder()
                .item(CoreAscensionItems.DREAD_BOAT)
                .chestItem(CoreAscensionItems.DREAD_CHEST_BOAT)
                .planks(CoreAscensionBlocks.DREAD_PLANKS.asItem())
                .build();


        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CEDAR_BOAT_KEY, cedarBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, TROPICS_BOAT_KEY, tropicsBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, WHITEWOOD_BOAT_KEY, whitewoodBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, DARK_MATTER_BOAT_KEY, darkMatterBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, ETHEREAL_BOAT_KEY, etherealBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, DREAD_BOAT_KEY, dreadBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CACTUS_BOAT_KEY, cactusBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CAKEWOOD_BOAT_KEY, cakewoodBoat);
    }
}
