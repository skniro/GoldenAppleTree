package com.skniro.golden_apple_tree.client;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = GoldenAppleTree.MOD_ID, value = Dist.CLIENT)
public class AppleClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.APPLE_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get(), ChunkSectionLayer.CUTOUT);
    }
}