package xyz.sillyangel.nuggetmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import xyz.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModItems.NUGGET)
//                .add(ModItems.RAW_NUGGET)
//                .add(Items.COAL)
//                .add(Items.STICK)
//                .add(Items.APPLE);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.NUGGET_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.NUGGET_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.NUGGET_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.NUGGET_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.NUGGET_HOE);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NUGGET_HELMET)
                .add(ModItems.NUGGET_CHESTPLATE)
                .add(ModItems.NUGGET_LEGGINGS)
                .add(ModItems.NUGGET_BOOTS);
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.NUGGET);
        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.NUGGET_SMITHING_TEMPLATE);
    }
}