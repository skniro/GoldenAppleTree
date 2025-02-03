package com.skniro.golden_apple_tree;


import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class GoldenAppleTreeContent {
    public static void registerBlock(){
        GoldenAppleTreeBlocks.registerGoldenAppleTreeBlocks();
    }

    public static void CreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(GoldenAppleTree.Golden_Apple_Group).register(content -> {
            content.add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES);
            content.add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING);
            content.add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
            content.add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES);
            content.add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING);
        });




    }
}

