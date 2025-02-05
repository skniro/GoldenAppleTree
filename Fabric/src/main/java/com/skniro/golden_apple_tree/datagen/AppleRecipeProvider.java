package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AppleRecipeProvider extends FabricRecipeProvider {
    protected AppleRecipeProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, GoldenAppleTreeBlocks.Golden_APPLE_SAPLING)
                .pattern("AAA")
                .pattern("ACA")
                .pattern("AAA")
                .input('A', Items.GOLDEN_APPLE)
                .input('C', Blocks.OAK_SAPLING)
                .criterion(hasItem(Blocks.OAK_SAPLING),
                        conditionsFromItem(Blocks.OAK_SAPLING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING)
                .pattern("EAB")
                .pattern("AAC")
                .pattern("FAD")
                .input('A', Items.ENCHANTED_GOLDEN_APPLE)
                .input('B', Items.TOTEM_OF_UNDYING)
                .input('C', Items.DRAGON_BREATH)
                .input('D', Items.SPONGE)
                .input('E', Items.ELYTRA)
                .input('F', Items.NETHER_STAR)
                .criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE),
                        conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
                .offerTo(exporter);
    }
}
