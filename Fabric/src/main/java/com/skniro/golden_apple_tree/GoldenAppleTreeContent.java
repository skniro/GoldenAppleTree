package com.skniro.golden_apple_tree;


import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import com.skniro.golden_apple_tree.event.GoldenAppleDispenserBehaviors;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class GoldenAppleTreeContent {
    public static void registerBlock(){
        GoldenAppleTreeBlocks.registerGoldenAppleTreeBlocks();
    }

    public static void registerEvent(){
        GoldenAppleDispenserBehaviors.register();
    }

    public static void CreativeTab() {
        CreativeModeTabEvents.modifyOutputEvent(GoldenAppleTree.Golden_Apple_Group).register(content -> {
            content.accept(GoldenAppleTreeBlocks.Apple_Tree_LEAVES);
            content.accept(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING);
            content.accept(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
            content.accept(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES);
            content.accept(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING);
            content.accept(GoldenAppleTreeBlocks.APPLE_LEAVES);
            content.accept(GoldenAppleTreeBlocks.APPLE_SAPLING);
        });
    }
}

