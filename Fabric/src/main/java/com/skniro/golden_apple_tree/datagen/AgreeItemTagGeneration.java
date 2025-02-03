package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;


public class AgreeItemTagGeneration extends FabricTagProvider<Item> {
    public AgreeItemTagGeneration(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(dataGenerator, RegistryKeys.ITEM, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.asItem())
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.asItem())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.asItem())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.asItem());



    }

}
