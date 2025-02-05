package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class AgreeLootTableGenerator extends FabricBlockLootTableProvider {
    public AgreeLootTableGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generate() {
            addDrop(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,drops(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING));
            addDrop(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,drops(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING));

            addDrop(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES,leavesDrops(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES,GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,SAPLING_DROP_CHANCE));
            addDrop(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES,leavesDrops(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES,Blocks.OAK_SAPLING,SAPLING_DROP_CHANCE));
            addDrop(GoldenAppleTreeBlocks.Apple_Tree_LEAVES ,leavesDrops(GoldenAppleTreeBlocks.Apple_Tree_LEAVES, Blocks.OAK_SAPLING,SAPLING_DROP_CHANCE));
    }

    public static final float[] SAPLING_DROP_CHANCE = new float[]{0.028F, 0.0225F, 0.022333336F, 0.1F};
}
