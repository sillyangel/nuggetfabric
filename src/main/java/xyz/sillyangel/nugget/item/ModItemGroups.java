package xyz.sillyangel.nugget.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import xyz.sillyangel.nugget.block.ModBlocks;
import xyz.sillyangel.nugget.NuggetMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup NUGGET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NuggetMod.MOD_ID, "nugget_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK))
                    .displayName(Text.translatable("creativetab.nuggetmod.nugget_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.NUGGET_BLOCK);
                        entries.add(ModBlocks.RAW_NUGGET_BLOCK);
                        entries.add(ModBlocks.NUGGET_ORE);
                        entries.add(ModBlocks.NUGGET_DEEPSLATE_ORE);
                    }).build());

    public static final ItemGroup NUGGET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NuggetMod.MOD_ID, "nugget_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NUGGET))
                    .displayName(Text.translatable("creativetab.nuggetmod.nugget_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.NUGGET);
                        entries.add(ModItems.RAW_NUGGET);

                        // Tool Set
                        entries.add(ModItems.NUGGET_SWORD);
                        entries.add(ModItems.NUGGET_PICKAXE);
                        entries.add(ModItems.NUGGET_AXE);
                        entries.add(ModItems.NUGGET_SHOVEL);
                        entries.add(ModItems.NUGGET_HOE);
                        // Armor
                        entries.add(ModItems.NUGGET_HELMET);
                        entries.add(ModItems.NUGGET_CHESTPLATE);
                        entries.add(ModItems.NUGGET_LEGGINGS);
                        entries.add(ModItems.NUGGET_BOOTS);
                    }).build());

    public static void registerItemGroups() {
        NuggetMod.LOGGER.info("Registering Item Groups for " + NuggetMod.MOD_ID);
    }
}
