package xyz.sillyangel.nuggetmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.sillyangel.nuggetmod.NuggetMod;

import java.util.List;

public class ModItems {
    public static final Item NUGGET = registerItem("nugget", new Item(new Item.Settings().food(ModFoodComponents.NUGGET)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("item.nuggetmod.nugget.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });


    public static final Item RAW_NUGGET = registerItem("raw_nugget", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NuggetMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NuggetMod.LOGGER.info("Registering Mod Items for " + NuggetMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(NUGGET);
            entries.add(RAW_NUGGET);
        });
    }
}