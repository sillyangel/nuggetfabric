package xyz.sillyangel.nuggetmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import xyz.sillyangel.nuggetmod.block.ModBlocks;
import xyz.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    // Blocks are generated here
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_NUGGET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_DEEPSLATE_ORE);
    }
    // Items are generated here
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NUGGET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NUGGET_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NUGGET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NUGGET_BOOTS));

        itemModelGenerator.register(ModItems.NUGGET_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_MUSIC_DISC, Models.GENERATED);

    }
}