package com.blah.coreascension.world.tree;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.mixin.FoliagePlacerTypeInvoker;
import com.blah.coreascension.world.tree.custom.ChestnutFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class CoreAscensionFoliagePlacerTypes {
    public static final FoliagePlacerType<?> CHESTNUT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("chestnut_foliage_placer", ChestnutFoliagePlacer.CODEC);

    public static void RegisterFoliagePlacers() {
        CoreAscension.LOGGER.info("Registering Foliage Placer for " + CoreAscension.MOD_ID);
    }
}
