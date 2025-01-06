package xyz.sillyangel.nuggetmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import xyz.sillyangel.nuggetmod.NuggetMod;
import xyz.sillyangel.nuggetmod.block.ModBlocks;
import xyz.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> NUGGET_SMELTABLES = List.of(ModItems.RAW_NUGGET, ModBlocks.NUGGET_ORE,
                ModBlocks.NUGGET_DEEPSLATE_ORE);

        offerSmelting(exporter, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET, 0.25f, 200, "nugget");
        offerBlasting(exporter, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET, 0.25f, 100, "nugget");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.NUGGET, RecipeCategory.DECORATIONS, ModBlocks.NUGGET_BLOCK);

        // RAW_NUGGET_BLOCK
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_NUGGET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_NUGGET)
                .criterion(hasItem(ModItems.RAW_NUGGET), conditionsFromItem(ModItems.RAW_NUGGET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_NUGGET, 9)
                .input(ModBlocks.RAW_NUGGET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_NUGGET_BLOCK), conditionsFromItem(ModBlocks.RAW_NUGGET_BLOCK))
                .offerTo(exporter);

//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_NUGGET, 32)
//                .input(ModBlocks.MAGIC_BLOCK)
//                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
//                .offerTo(exporter, Identifier.of(NuggetMod.MOD_ID, "raw_nugget_from_magic_block"));
    }
}