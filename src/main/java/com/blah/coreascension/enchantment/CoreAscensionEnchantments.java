package com.blah.coreascension.enchantment;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.enchantment.effect.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionEnchantments
{
    public static Enchantment TELEKINESIS;
    public static Enchantment MOLTEN_TOUCH;
    public static Enchantment STEPPING;
    public static Enchantment EXPERIENCE_BOOST_TOOL;
    public static Enchantment REPELLING;

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
        STEPPING = Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(CoreAscension.MOD_ID, "stepping"),
                new SteppingEnchantment()
        );
        EXPERIENCE_BOOST_TOOL = Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(CoreAscension.MOD_ID, "exp_boost_tool"),
                new ExpBoostToolEnchantment()
        );
        REPELLING = Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(CoreAscension.MOD_ID, "repelling"),
                new RepellingEnchantment()
        );
    }
}
