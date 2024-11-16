package com.blah.coreascension.world.tree;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.mixin.FoliagePlacerTypeInvoker;
import com.blah.coreascension.world.tree.placers.TropicsFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CoreAscensionFoliagePlacerTypes {
    public static final FoliagePlacerType<?> TROPICS_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("tropics_foliage_placer", TropicsFoliagePlacer.CODEC);

    public static void RegisterFoliagePlacers()
    {
        CoreAscension.LOGGER.info("Registering Foliage Placer for " + CoreAscension.MOD_ID);
    }
}
