package com.blah.coreascension.sound;

import com.blah.coreascension.CoreAscension;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class CoreAscensionSounds
{
    public static final SoundEvent DARK_MATTER_WOOD_BREAK = registerSoundEvent("dark_matter_wood_break");
    public static final SoundEvent DARK_MATTER_WOOD_STEP = registerSoundEvent("dark_matter_wood_step");
    public static final SoundEvent DARK_MATTER_WOOD_PLACE = DARK_MATTER_WOOD_BREAK;
    public static final SoundEvent DARK_MATTER_WOOD_HIT = SoundEvents.BLOCK_WOOD_HIT;
    public static final SoundEvent DARK_MATTER_WOOD_FALL = DARK_MATTER_WOOD_STEP;

    public static final SoundEvent DARK_MATTER_STONE_BREAK = registerSoundEvent("dark_matter_stone_break");
    public static final SoundEvent DARK_MATTER_STONE_STEP = registerSoundEvent("dark_matter_stone_step");
    public static final SoundEvent DARK_MATTER_STONE_PLACE = DARK_MATTER_STONE_BREAK;
    public static final SoundEvent DARK_MATTER_STONE_HIT = SoundEvents.BLOCK_STONE_HIT;
    public static final SoundEvent DARK_MATTER_STONE_FALL = DARK_MATTER_STONE_STEP;

    public static final SoundEvent CACTUS_PLANKS_BREAK = registerSoundEvent("cactus_planks_break");
    public static final SoundEvent CACTUS_PLANKS_STEP = registerSoundEvent("cactus_planks_step");
    public static final SoundEvent CACTUS_PLANKS_PLACE = CACTUS_PLANKS_BREAK;
    public static final SoundEvent CACTUS_PLANKS_HIT = SoundEvents.BLOCK_WOOL_HIT;
    public static final SoundEvent CACTUS_PLANKS_FALL = CACTUS_PLANKS_HIT;


    public static final BlockSoundGroup DARK_MATTER_WOOD_SOUNDS = new BlockSoundGroup(1f, 1f,
            DARK_MATTER_WOOD_BREAK, DARK_MATTER_WOOD_STEP, DARK_MATTER_WOOD_PLACE,
            DARK_MATTER_WOOD_HIT, DARK_MATTER_WOOD_FALL);

    public static final BlockSoundGroup DARK_MATTER_STONE_SOUNDS = new BlockSoundGroup(1f, 1f,
            DARK_MATTER_STONE_BREAK, DARK_MATTER_STONE_STEP, DARK_MATTER_STONE_PLACE,
            DARK_MATTER_STONE_HIT, DARK_MATTER_STONE_FALL);

    public static final BlockSoundGroup CACTUS_PLANKS_SOUNDS = new BlockSoundGroup(1f, 1f,
            CACTUS_PLANKS_BREAK, CACTUS_PLANKS_STEP, CACTUS_PLANKS_PLACE,
            CACTUS_PLANKS_HIT, CACTUS_PLANKS_FALL);

    private static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = new Identifier(CoreAscension.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds()
    {
        CoreAscension.LOGGER.info("Registering Sounds for " + CoreAscension.MOD_ID);
    }
}
