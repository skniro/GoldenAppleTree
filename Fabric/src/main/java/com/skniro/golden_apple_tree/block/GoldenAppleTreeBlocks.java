package com.skniro.golden_apple_tree.block;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import com.skniro.golden_apple_tree.world.Tree.EnchantedGoldenAppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.GoldenAppleSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.logging.Logger;

public class GoldenAppleTreeBlocks {
    //SAPLING
    public static final Block Golden_APPLE_SAPLING = registerBlock("golden_apple_sapling",
             new SaplingBlock(GoldenAppleSaplingGenerator.GoldenAppleSapling, AbstractBlock.Settings.copyShallow(Blocks.OAK_SAPLING)));
    public static final Block ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlock("enchanted_golden_apple_sapling",
             new SaplingBlock(EnchantedGoldenAppleSaplingGenerator.EnchantedGoldenAppleSapling, AbstractBlock.Settings.copyShallow(Blocks.OAK_SAPLING)));

    //LEAVES
    public static final Block Golden_APPLE_LEAVES =registerBlock("golden_apple_leave",
             new LeafCropBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DARK_RED), Items.GOLDEN_APPLE));
    public static final Block ENCHANTED_GOLDEN_APPLE_LEAVES =registerBlock("enchanted_golden_apple_leave",
             new LeafCropBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DARK_RED), Items.ENCHANTED_GOLDEN_APPLE));
    public static final Block Apple_Tree_LEAVES =registerBlock("apple_tree_leave",
            new LeavesBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DARK_RED)));

    //Potted Plant
    public static final Block POTTED_Golden_APPLE_SAPLING = registerBlockWithoutItem("potted_haste_apple_sapling",
            new FlowerPotBlock(Golden_APPLE_SAPLING, AbstractBlock.Settings.create().breakInstantly().nonOpaque()));
    public static final Block POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlockWithoutItem("potted_enchanted_golden_apple_sapling",
            new FlowerPotBlock(ENCHANTED_GOLDEN_APPLE_SAPLING, AbstractBlock.Settings.create().breakInstantly().nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GoldenAppleTree.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(GoldenAppleTree.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(GoldenAppleTree.MOD_ID, name), block);
    }

    public static void registerGoldenAppleTreeBlocks() {
        Logger.getLogger("register mod blocks" + GoldenAppleTree.MOD_ID);
    }
}
