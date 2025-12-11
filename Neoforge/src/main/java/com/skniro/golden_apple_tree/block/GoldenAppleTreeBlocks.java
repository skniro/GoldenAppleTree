package com.skniro.golden_apple_tree.block;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import com.skniro.golden_apple_tree.item.AppleItems;
import com.skniro.golden_apple_tree.world.Tree.AppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.EnchantedGoldenAppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.GoldenAppleSaplingGenerator;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class GoldenAppleTreeBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GoldenAppleTree.MOD_ID);

    //SAPLING
    public static final Supplier<Block> Golden_APPLE_SAPLING = registerBlock("golden_apple_sapling",
            (settings)-> new SaplingBlock(GoldenAppleSaplingGenerator.GoldenAppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));
    public static final Supplier<Block> ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlock("enchanted_golden_apple_sapling",
            (settings)-> new SaplingBlock(EnchantedGoldenAppleSaplingGenerator.EnchantedGoldenAppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));
    public static final Supplier<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            (settings)-> new SaplingBlock(AppleSaplingGenerator.AppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));

    //LEAVES
    public static final Supplier<Block> Golden_APPLE_LEAVES =registerBlock("golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.GOLDEN_APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final Supplier<Block> ENCHANTED_GOLDEN_APPLE_LEAVES =registerBlock("enchanted_golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.ENCHANTED_GOLDEN_APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final Supplier<Block> APPLE_LEAVES =registerBlock("apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final Supplier<Block> Apple_Tree_LEAVES =registerBlock("apple_tree_leave",
            (properties)-> new TintedParticleLeavesBlock(0.01F, properties), BlockBehaviour.Properties.of().noOcclusion() .mapColor(MapColor.NETHER));

    //Potted Plant
    public static final Supplier<Block> POTTED_Golden_APPLE_SAPLING = registerBlockWithoutItem("potted_haste_apple_sapling",
            (settings)-> new FlowerPotBlock(Golden_APPLE_SAPLING.get(), settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());
    public static final Supplier<Block> POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlockWithoutItem("potted_enchanted_golden_apple_sapling",
            (settings)-> new FlowerPotBlock(ENCHANTED_GOLDEN_APPLE_SAPLING.get(), settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());
    public static final Supplier<Block> POTTED_APPLE_SAPLING = registerBlockWithoutItem("potted_apple_sapling",
            (settings)-> new FlowerPotBlock(APPLE_SAPLING.get(), settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());

    private static <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> block, BlockBehaviour.Properties properties) {
        DeferredBlock<B> bDeferredBlock = registerBlockWithoutItem(name, block, properties);
        registerBlockItem(name, bDeferredBlock);
        return bDeferredBlock;
    }

    private static <B extends Block> DeferredBlock<B> registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, ? extends B> block, BlockBehaviour.Properties properties) {
        DeferredBlock<B> register = BLOCKS.registerBlock(name, block, properties.setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name))));
        return register;
    }

    private static <B extends Block> DeferredBlock<B> registerBlockWithoutItemWithEmpty(String name, Function<BlockBehaviour.Properties, ? extends B> block, BlockBehaviour.Properties properties) {
        DeferredBlock<B> register = registerBlockWithoutItem(name, block, properties);
        return register;
    }

    private static <T extends Block> Holder<Item> registerBlockItem(String name, DeferredBlock<T> block) {
        return AppleItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(),
                new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name)))));
    }

    public static void registerGoldenAppleTreeBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
