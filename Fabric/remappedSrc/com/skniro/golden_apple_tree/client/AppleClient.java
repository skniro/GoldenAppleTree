package com.skniro.golden_apple_tree.client;

import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AppleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleTreeBlocks.Apple_Tree_LEAVES, RenderType.cutout());
    }
}