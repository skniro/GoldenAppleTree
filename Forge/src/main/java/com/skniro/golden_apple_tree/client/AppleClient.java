package com.skniro.golden_apple_tree.client;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GoldenAppleTree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AppleClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);

        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING.get(), ChunkSectionLayer.CUTOUT);

        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.APPLE_LEAVES.get(), ChunkSectionLayer.CUTOUT);
        ModItemBlockRenderTypes.setRenderLayer(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get(), ChunkSectionLayer.CUTOUT);
    }
}