package com.skniro.golden_apple_tree.block;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import com.skniro.golden_apple_tree.world.Tree.EnchantedGoldenAppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.GoldenAppleSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import java.util.function.Function;
import java.util.logging.Logger;

public class GoldenAppleTreeBlocks {
    //SAPLING
    public static final Block Golden_APPLE_SAPLING = registerBlock("golden_apple_sapling",
            (settings)-> new SaplingBlock(GoldenAppleSaplingGenerator.GoldenAppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));
    public static final Block ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlock("enchanted_golden_apple_sapling",
            (settings)-> new SaplingBlock(EnchantedGoldenAppleSaplingGenerator.EnchantedGoldenAppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));

    //LEAVES
    public static final Block Golden_APPLE_LEAVES =registerBlock("golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.GOLDEN_APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final Block ENCHANTED_GOLDEN_APPLE_LEAVES =registerBlock("enchanted_golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.ENCHANTED_GOLDEN_APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final Block Apple_Tree_LEAVES =registerBlock("apple_tree_leave",
            LeavesBlock::new, BlockBehaviour.Properties.of().noOcclusion() .mapColor(MapColor.NETHER));

    //Potted Plant
    public static final Block POTTED_Golden_APPLE_SAPLING = registerBlockWithoutItem("potted_haste_apple_sapling",
            (settings)-> new FlowerPotBlock(Golden_APPLE_SAPLING, settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());
    public static final Block POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlockWithoutItem("potted_enchanted_golden_apple_sapling",
            (settings)-> new FlowerPotBlock(ENCHANTED_GOLDEN_APPLE_SAPLING, settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = (Block)factory.apply(settings.setId(keyOf(name)));
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, keyOf(name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name)),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name)))));
    }

    private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = (Block)factory.apply(settings.setId(keyOf(name)));
        return Registry.register(BuiltInRegistries.BLOCK, keyOf(name), block);
    }

    private static ResourceKey<Block> keyOf(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name));
    }

    public static void registerGoldenAppleTreeBlocks() {
        Logger.getLogger("register mod blocks" + GoldenAppleTree.MOD_ID);
    }
}
