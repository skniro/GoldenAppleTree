package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import java.util.concurrent.CompletableFuture;


public class AgreeBlockTagGeneration extends FabricTagsProvider.BlockTagsProvider {
    public AgreeBlockTagGeneration(FabricPackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        valueLookupBuilder(BlockTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES)
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING)
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING);
    }

}
