package com.skniro.golden_apple_tree.client;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AppleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.APPLE_SAPLING, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.APPLE_LEAVES, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(GoldenAppleTreeBlocks.Apple_Tree_LEAVES, BlockRenderLayer.CUTOUT);
    }
}