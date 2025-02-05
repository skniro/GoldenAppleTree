package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import com.skniro.golden_apple_tree.world.AppleTreePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(AgreeLootTableGenerator::new);
        pack.addProvider(AgreeModelProvider::new);
        pack.addProvider(AppleRecipeProvider::new);
        pack.addProvider(AgreeEnglishLanguageProvider::new);
        pack.addProvider(AgreeSimplifiedChineseLanguageProvider::new);
        pack.addProvider(AgreeItemTagGeneration::new);
        pack.addProvider(AgreeBlockTagGeneration::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, AppleTreeConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, AppleTreePlacedFeatures::bootstrap);
    }
}
