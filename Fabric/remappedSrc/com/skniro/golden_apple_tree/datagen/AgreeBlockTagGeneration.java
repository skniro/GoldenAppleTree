package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import java.util.concurrent.CompletableFuture;


public class AgreeBlockTagGeneration extends FabricTagProvider<Block> {
    public AgreeBlockTagGeneration(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, Registries.BLOCK, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(BlockTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES)
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
        tag(BlockTags.SAPLINGS)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING)
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING);
    }

}
