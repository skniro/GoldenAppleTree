package com.skniro.golden_apple_tree.client;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AppleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.APPLE_SAPLING, ChunkSectionLayer.CUTOUT);

        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING, ChunkSectionLayer.CUTOUT);

        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.APPLE_LEAVES, ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Apple_Tree_LEAVES, ChunkSectionLayer.CUTOUT);
    }
}