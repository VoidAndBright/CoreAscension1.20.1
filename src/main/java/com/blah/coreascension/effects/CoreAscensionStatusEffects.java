package com.blah.coreascension.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionStatusEffects
{
    public static final StatusEffect WARMTH = new WarmthPotionEffect();
    public static final StatusEffect BUILDERS_CURSE = new BuildersCurseEffect();
    public static final StatusEffect FREEZING = new FreezingEffect();
    public static final StatusEffect LONG_REPAIRING = new LongRepairingPotionEffect();
    public static final StatusEffect REPAIRING = new RepairingPotionEffect();
    public static final StatusEffect TERRESTRIAL = new TerrestrialPotionEffect();

    public static void RegisterStatusEffects()
    {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "ice_resistance"), WARMTH);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "builders_curse"), BUILDERS_CURSE);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "freezing"), FREEZING);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "long_repairing"), LONG_REPAIRING);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "repairing"), REPAIRING);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("coreascension", "terrestrial"), TERRESTRIAL);
    }
}
