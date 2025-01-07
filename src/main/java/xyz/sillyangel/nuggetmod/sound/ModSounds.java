package xyz.sillyangel.nuggetmod.sound;

import xyz.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
//    public static final SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");
//
//    public static final SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
//    public static final SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
//    public static final SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
//    public static final SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
//    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");
//
//    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
//            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    public static final SoundEvent NUGGET_THEME = registerSoundEvent("nugget_theme");
    public static final RegistryKey<JukeboxSong> NUGGET_THEME_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(NuggetMod.MOD_ID, "nugget_theme"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(NuggetMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        NuggetMod.LOGGER.info("Registering Mod Sounds for " + NuggetMod.MOD_ID);
    }
}