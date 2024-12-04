package com.blah.coreascension.world.tree;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.mixin.FoliagePlacerTypeInvoker;
import com.blah.coreascension.world.tree.nontreeplacers.FrostingPlacer;
import com.blah.coreascension.world.tree.placers.*;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CoreAscensionFoliagePlacerTypes {
    public static final FoliagePlacerType<?> TROPICS_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("tropics_foliage_placer", TropicsFoliagePlacer.CODEC);
    public static final FoliagePlacerType<?> ENTROPY_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("entropy_foliage_placer", EntropyFoliagePlacer.CODEC);
    public static final FoliagePlacerType<?> POPSICLE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("popsicle_foliage_placer", PopsicleFoliagePlacer.CODEC);
    public static final FoliagePlacerType<?> GUMDROP_PLACER = FoliagePlacerTypeInvoker.callRegister("gumdrop_placer", GumdropPlacer.CODEC);
    public static final FoliagePlacerType<?> FROSTING_PLACER = FoliagePlacerTypeInvoker.callRegister("frosting_placer", FrostingPlacer.CODEC);



    public static void RegisterFoliagePlacers()
    {
        CoreAscension.LOGGER.info("Registering Foliage Placer for " + CoreAscension.MOD_ID);
    }
}
