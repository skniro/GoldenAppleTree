package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;
import java.util.concurrent.CompletableFuture;


public class AgreeLootTableGenerator extends FabricBlockLootTableProvider {
    public AgreeLootTableGenerator(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataGenerator, registryLookup);
    }

    @Override
    public void generate() {
            add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,createSingleItemTable(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING));
            add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,createSingleItemTable(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING));

            add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES,createLeavesDrops(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES,GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,NORMAL_LEAVES_SAPLING_CHANCES));
            add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES,createLeavesDrops(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES,Blocks.OAK_SAPLING,NORMAL_LEAVES_SAPLING_CHANCES));
            add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES ,createLeavesDrops(GoldenAppleTreeBlocks.Apple_Tree_LEAVES, Blocks.OAK_SAPLING,NORMAL_LEAVES_SAPLING_CHANCES));
    }

    public static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.028F, 0.0225F, 0.022333336F, 0.1F};
}
