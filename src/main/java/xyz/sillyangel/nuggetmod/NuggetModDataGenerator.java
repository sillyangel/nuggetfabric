package xyz.sillyangel.nuggetmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import xyz.sillyangel.nuggetmod.datagen.*;
import xyz.sillyangel.nuggetmod.trim.ModTrimMaterials;
import xyz.sillyangel.nuggetmod.trim.ModTrimPatterns;
import net.minecraft.registry.RegistryBuilder;
import xyz.sillyangel.nuggetmod.world.ModConfiguredFeatures;
import xyz.sillyangel.nuggetmod.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryKeys;

public class NuggetModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModRegistryDataGenerator::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModTrimPatterns::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}