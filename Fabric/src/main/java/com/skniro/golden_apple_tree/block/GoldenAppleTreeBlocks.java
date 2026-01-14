package com.skniro.golden_apple_tree.block;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import com.skniro.golden_apple_tree.world.Tree.AppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.EnchantedGoldenAppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.GoldenAppleSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.logging.Logger;

public class GoldenAppleTreeBlocks {
    //SAPLING
    public static final Block Golden_APPLE_SAPLING = registerBlock("golden_apple_sapling",
            (settings)-> new SaplingBlock(GoldenAppleSaplingGenerator.GoldenAppleSapling,settings), AbstractBlock.Settings.copyShallow(Blocks.OAK_SAPLING));
    public static final Block ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlock("enchanted_golden_apple_sapling",
            (settings)-> new SaplingBlock(EnchantedGoldenAppleSaplingGenerator.EnchantedGoldenAppleSapling,settings), AbstractBlock.Settings.copyShallow(Blocks.OAK_SAPLING));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling",
            (settings)-> new SaplingBlock(AppleSaplingGenerator.AppleSapling,settings), AbstractBlock.Settings.copyShallow(Blocks.OAK_SAPLING));

    //LEAVES
    public static final Block Golden_APPLE_LEAVES =registerBlock("golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.GOLDEN_APPLE), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2F).sounds(BlockSoundGroup.GRASS).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    public static final Block ENCHANTED_GOLDEN_APPLE_LEAVES =registerBlock("enchanted_golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.ENCHANTED_GOLDEN_APPLE), AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DARK_GREEN).strength(0.2F).sounds(BlockSoundGroup.GRASS).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    public static final Block APPLE_LEAVES =registerBlock("apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.APPLE), AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DARK_GREEN).strength(0.2F).sounds(BlockSoundGroup.GRASS).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    public static final Block Apple_Tree_LEAVES =registerBlock("apple_tree_leave",
            (properties)-> new TintedParticleLeavesBlock(0.01F, properties), AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DARK_GREEN).strength(0.2F).sounds(BlockSoundGroup.GRASS).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));

    //Potted Plant
    public static final Block POTTED_Golden_APPLE_SAPLING = registerBlockWithoutItem("potted_haste_apple_sapling",
            (settings)-> new FlowerPotBlock(Golden_APPLE_SAPLING, settings), AbstractBlock.Settings.create().breakInstantly().nonOpaque());
    public static final Block POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlockWithoutItem("potted_enchanted_golden_apple_sapling",
            (settings)-> new FlowerPotBlock(ENCHANTED_GOLDEN_APPLE_SAPLING, settings), AbstractBlock.Settings.create().breakInstantly().nonOpaque());
    public static final Block POTTED_APPLE_SAPLING = registerBlockWithoutItem("potted_apple_sapling",
            (settings)-> new FlowerPotBlock(APPLE_SAPLING, settings), AbstractBlock.Settings.create().breakInstantly().nonOpaque());

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(keyOf(name)));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, keyOf(name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GoldenAppleTree.MOD_ID, name)),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GoldenAppleTree.MOD_ID, name)))));
    }

    private static Block registerBlockWithoutItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(keyOf(name)));
        return Registry.register(Registries.BLOCK, keyOf(name), block);
    }

    private static RegistryKey<Block> keyOf(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GoldenAppleTree.MOD_ID, name));
    }

    public static void registerGoldenAppleTreeBlocks() {
        Logger.getLogger("register mod blocks" + GoldenAppleTree.MOD_ID);
    }
}
