package com.blah.coreascension.effect;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.effect.effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionStatusEffects {
    public static final StatusEffect ICE_RESISTANCE = RegisterStatusEffect("ice_resistance", new IceResistancePotionEffect());
    public static final StatusEffect BUILDERS_CURSE =  RegisterStatusEffect("builders_curse", new BuildersCurseEffect());
    public static final StatusEffect FREEZING = RegisterStatusEffect("freezing", new FreezingEffect());
    public static final StatusEffect LONG_REPAIRING = RegisterStatusEffect("long_repairing", new LongRepairingPotionEffect());
    public static final StatusEffect REPAIRING = RegisterStatusEffect("repairing", new RepairingPotionEffect());
    public static final StatusEffect TERRESTRIAL = RegisterStatusEffect("terrestrial", new TerrestrialPotionEffect());
    public static final StatusEffect ICY = RegisterStatusEffect("icy", new IcyEffect());
    public static StatusEffect RegisterStatusEffect(String name,StatusEffect statusEffect)
    {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(CoreAscension.MOD_ID, name), statusEffect);
    }
    public static void RegisterStatusEffects()
    {
        CoreAscension.LOGGER.info("Registering Effects for " + CoreAscension.MOD_ID);
    }
}
