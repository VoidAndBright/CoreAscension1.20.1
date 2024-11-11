package com.blah.coreascension.world.tree;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.mixin.TrunkPlacerTypeInvoker;
import com.blah.coreascension.world.tree.custom.ChestnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class CoreAscensionTrunkPlacerTypes {
    public static final TrunkPlacerType<?> CHESTNUT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("chestnut_trunk_placer", ChestnutTrunkPlacer.CODEC);

    public static void RegisterTrunkPlacers() {
        CoreAscension.LOGGER.info("Registering Trunk Placers for " + CoreAscension.MOD_ID);
    }
}
