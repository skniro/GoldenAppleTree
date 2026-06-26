package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import java.util.concurrent.CompletableFuture;


public class AgreeBlockTagGeneration extends FabricTagsProvider.BlockTagsProvider {
    public AgreeBlockTagGeneration(FabricPackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        builder(BlockTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.builtInRegistryHolder().key());
        builder(BlockItemTags.SAPLINGS.block())
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.builtInRegistryHolder().key())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.builtInRegistryHolder().key());
    }

}
