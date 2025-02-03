package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import java.util.concurrent.CompletableFuture;

public class AppleRecipeProvider extends FabricRecipeProvider {
    protected AppleRecipeProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }


    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.FOOD, GoldenAppleTreeBlocks.Golden_APPLE_SAPLING)
                        .pattern("AAA")
                        .pattern("ACA")
                        .pattern("AAA")
                        .define('A',Items.GOLDEN_APPLE)
                        .define('C',Blocks.OAK_SAPLING)
                        .unlockedBy(getHasName(Blocks.OAK_SAPLING),
                                has(Blocks.OAK_SAPLING))
                        .save(output);

                shaped(RecipeCategory.FOOD, GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING)
                        .pattern("EAB")
                        .pattern("GAC")
                        .pattern("FAD")
                        .define('A',Items.ENCHANTED_GOLDEN_APPLE)
                        .define('B',Items.TOTEM_OF_UNDYING)
                        .define('C',Items.DRAGON_BREATH)
                        .define('D',Items.SPONGE)
                        .define('E',Items.ELYTRA)
                        .define('F',Items.NETHER_STAR)
                        .define('G',Items.MACE)
                        .unlockedBy(getHasName(Items.ENCHANTED_GOLDEN_APPLE),
                                has(Items.ENCHANTED_GOLDEN_APPLE))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
