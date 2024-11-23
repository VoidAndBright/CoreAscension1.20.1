package com.blah.coreascension.block;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.block.fluid.CoreAscensionFluid;
import com.blah.coreascension.block.fluid.EndGasFluid;
import com.blah.coreascension.block.fluid.MoltenIceFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionFluids
{
    public static final FlowableFluid STILL_END_GAS = RegisterFluid("end_gas", new EndGasFluid.Still());
    public static final FlowableFluid FLOWING_END_GAS = RegisterFluid("flowing_end_gas", new EndGasFluid.Flowing());
    public static final FlowableFluid STILL_MOLTEN_ICE = RegisterFluid("molten_ice", new MoltenIceFluid.Still());
    public static final FlowableFluid FLOWING_MOLTEN_ICE = RegisterFluid("flowing_molten_ice", new MoltenIceFluid.Flowing());
    public static FlowableFluid RegisterFluid(String name, CoreAscensionFluid fluid){
        return Registry.register(Registries.FLUID, new Identifier(CoreAscension.MOD_ID, name), fluid);
    }
}
