package xyz.sillyangel.nuggetmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import xyz.sillyangel.nuggetmod.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import xyz.sillyangel.nuggetmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.NUGGET_BLOCK)
                .add(ModBlocks.RAW_NUGGET_BLOCK)
                .add(ModBlocks.NUGGET_ORE)
                .add(ModBlocks.NUGGET_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NUGGET_DEEPSLATE_ORE)
                .add(ModBlocks.NUGGET_BLOCK)
                .add(ModBlocks.RAW_NUGGET_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NUGGET_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_NUGGET_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NUGGET_BLOCK);
    }
}