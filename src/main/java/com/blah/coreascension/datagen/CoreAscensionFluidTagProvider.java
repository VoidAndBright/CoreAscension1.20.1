package com.blah.coreascension.datagen;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.block.CoreAscensionFluids;
import com.blah.coreascension.utils.CoreAscensionTags;
import com.blah.coreascension.utils.FabricTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class CoreAscensionFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public CoreAscensionFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }
    
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(FluidTags.WATER)
                .add(CoreAscensionFluids.STILL_MOLTEN_ICE)
                .add(CoreAscensionFluids.FLOWING_MOLTEN_ICE);
    }
}
