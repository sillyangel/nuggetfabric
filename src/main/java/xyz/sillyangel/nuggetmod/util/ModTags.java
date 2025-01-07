package xyz.sillyangel.nuggetmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import xyz.sillyangel.nuggetmod.NuggetMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NUGGET_TOOL = createTag("needs_nugget_tool");
        public static final TagKey<Block> INCORRECT_FOR_NUGGET_TOOL = createTag("incorrect_for_nugget_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(NuggetMod.MOD_ID, name));
        }
    }

    public static class Items {
        // public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");




        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(NuggetMod.MOD_ID, name));
        }
    }
}
