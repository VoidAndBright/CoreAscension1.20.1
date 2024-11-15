package com.blah.coreascension.enchantment;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.enchantment.effect.MoltenTouchEnchantment;
import com.blah.coreascension.enchantment.effect.TelekinesisEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionEnchantments
{
    public static Enchantment TELEKINESIS;
    public static Enchantment MOLTEN_TOUCH;

    public static void RegisterEnchantments()
    {
        MOLTEN_TOUCH = Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(CoreAscension.MOD_ID, "molten_touch"),
                new MoltenTouchEnchantment()
        );
        TELEKINESIS = Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(CoreAscension.MOD_ID, "telekinesis"),
                new TelekinesisEnchantment()
        );
    }
}
