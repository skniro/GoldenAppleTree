package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class AppleRecipeProvider extends FabricRecipeProvider {
    protected AppleRecipeProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }


    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.FOOD, GoldenAppleTreeBlocks.Golden_APPLE_SAPLING)
                        .pattern("AAA")
                        .pattern("ACA")
                        .pattern("AAA")
                        .input('A',Items.GOLDEN_APPLE)
                        .input('C',Blocks.OAK_SAPLING)
                        .criterion(hasItem(Blocks.OAK_SAPLING),
                                conditionsFromItem(Blocks.OAK_SAPLING))
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING)
                        .pattern("EAB")
                        .pattern("GAC")
                        .pattern("FAD")
                        .input('A',Items.ENCHANTED_GOLDEN_APPLE)
                        .input('B',Items.TOTEM_OF_UNDYING)
                        .input('C',Items.DRAGON_BREATH)
                        .input('D',Items.SPONGE)
                        .input('E',Items.ELYTRA)
                        .input('F',Items.NETHER_STAR)
                        .input('G',Items.MACE)
                        .criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE),
                                conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
