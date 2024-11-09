package com.blah.coreascension.world.tree;

import com.blah.coreascension.CoreAscension;

import com.blah.coreascension.mixin.TrunkPlacerTypeInvoker;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class CoreAscensionTrunkPlacerTypes {
    public static final TrunkPlacerType<?> TROPICS_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("tropics_trunk_placer", TropicsTrunkPlacer.CODEC);

    public static void register() {
        CoreAscension.LOGGER.info("Registering Trunk Placers for " + CoreAscension.MOD_ID);
    }
}
