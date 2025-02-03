package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;


public class AgreeBlockTagGeneration extends FabricTagProvider<Block> {
    public AgreeBlockTagGeneration(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(dataGenerator, RegistryKeys.BLOCK, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES)
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING)
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING);
    }

}
