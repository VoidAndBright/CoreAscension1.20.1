package com.blah.coreascension.block.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionFluids
{
    public static final FlowableFluid STILL_END_GAS = Registry.register(Registries.FLUID, new Identifier("coreascension", "end_gas"), new EndGasFluid.Still());
    public static final FlowableFluid FLOWING_END_GAS = Registry.register(Registries.FLUID, new Identifier("coreascension", "flowing_end_gas"), new EndGasFluid.Flowing());
    public static final FlowableFluid STILL_MOLTEN_ICE = Registry.register(Registries.FLUID, new Identifier("coreascension", "molten_ice"), new MoltenIceFluid.Still());
    public static final FlowableFluid FLOWING_MOLTEN_ICE = Registry.register(Registries.FLUID, new Identifier("coreascension", "flowing_molten_ice"), new MoltenIceFluid.Flowing());
}
