package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import java.util.concurrent.CompletableFuture;


public class AgreeItemTagGeneration extends FabricTagsProvider.ItemTagsProvider {
    public AgreeItemTagGeneration(FabricPackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        builder(ItemTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.asItem().builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.asItem().builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.asItem().builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.APPLE_LEAVES.asItem().builtInRegistryHolder().key());
        builder(ItemTags.SAPLINGS)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.asItem().builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.asItem().builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.APPLE_SAPLING.asItem().builtInRegistryHolder().key());



    }

}
