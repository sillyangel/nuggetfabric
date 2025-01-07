package xyz.sillyangel.nuggetmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
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

    // Tools

    public static final Item NUGGET_SWORD = registerItem("nugget_sword",
            new SwordItem(ModToolMaterials.NUGGET, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.NUGGET, 3, -2.4f))));
    public static final Item NUGGET_PICKAXE = registerItem("nugget_pickaxe",
            new PickaxeItem(ModToolMaterials.NUGGET, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.NUGGET, 1, -2.8f))));
    public static final Item NUGGET_SHOVEL = registerItem("nugget_shovel",
            new ShovelItem(ModToolMaterials.NUGGET, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.NUGGET, 1.5f, -3.0f))));
    public static final Item NUGGET_AXE = registerItem("nugget_axe",
            new AxeItem(ModToolMaterials.NUGGET, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.NUGGET, 6, -3.2f))));
    public static final Item NUGGET_HOE = registerItem("nugget_hoe",
            new HoeItem(ModToolMaterials.NUGGET, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.NUGGET, 0, -3f))));
    // Armor

    public static final Item NUGGET_HELMET = registerItem("nugget_helmet",
            new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item NUGGET_CHESTPLATE = registerItem("nugget_chestplate",
            new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item NUGGET_LEGGINGS = registerItem("nugget_leggings",
            new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item NUGGET_BOOTS = registerItem("nugget_boots",
            new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));
    public static final Item NUGGET_HORSE_ARMOR = registerItem("nugget_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));


    // Helper methods to register items
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