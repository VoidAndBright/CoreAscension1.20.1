package com.blah.coreascension.enchantment;

import com.blah.coreascension.CoreAscension;
import com.blah.coreascension.enchantment.enchantments.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionEnchantments {
    public static Enchantment TELEKINESIS = RegisterEnchantment("telekinesis",new TelekinesisEnchantment());
    public static Enchantment MOLTEN_TOUCH = RegisterEnchantment("molten_touch",new MoltenTouchEnchantment());
    public static Enchantment STEPPING = RegisterEnchantment("stepping",new SteppingEnchantment());
    public static Enchantment EXPERIENCE_BOOST_TOOL= RegisterEnchantment("exp_boost_tool",new ExpBoostToolEnchantment());
    public static Enchantment REPELLING = RegisterEnchantment("repelling",new RepellingEnchantment());
    public static Enchantment RegisterEnchantment(String name,Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT, new Identifier(CoreAscension.MOD_ID, name), enchantment);
    }
    public static void RegisterEnchantments()
    {
        CoreAscension.LOGGER.info("Registering Enchantments for " + CoreAscension.MOD_ID);
    }
}
