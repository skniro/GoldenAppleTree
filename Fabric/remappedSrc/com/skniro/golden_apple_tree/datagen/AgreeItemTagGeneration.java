package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import java.util.concurrent.CompletableFuture;


public class AgreeItemTagGeneration extends FabricTagProvider<Item> {
    public AgreeItemTagGeneration(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, Registries.ITEM, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(ItemTags.LEAVES)
                .add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.asItem())
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.asItem())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.asItem());
        tag(ItemTags.SAPLINGS)
                .add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.asItem())
                .add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.asItem());



    }

}
