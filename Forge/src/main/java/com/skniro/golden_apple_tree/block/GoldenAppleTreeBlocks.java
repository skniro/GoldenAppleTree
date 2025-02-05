package com.skniro.golden_apple_tree.block;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import com.skniro.golden_apple_tree.item.AppleItems;
import com.skniro.golden_apple_tree.world.Tree.EnchantedGoldenAppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.GoldenAppleSaplingGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class GoldenAppleTreeBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoldenAppleTree.MOD_ID);

    //SAPLING
    public static final Supplier<Block> Golden_APPLE_SAPLING = registerBlock("golden_apple_sapling",
            ()-> new SaplingBlock(new GoldenAppleSaplingGenerator(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final Supplier<Block> ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlock("enchanted_golden_apple_sapling",
            ()-> new SaplingBlock(new EnchantedGoldenAppleSaplingGenerator(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //LEAVES
    public static final Supplier<Block> Golden_APPLE_LEAVES =registerBlock("golden_apple_leave",
            ()->  new LeafCropBlock(BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER), Items.GOLDEN_APPLE));
    public static final Supplier<Block> ENCHANTED_GOLDEN_APPLE_LEAVES =registerBlock("enchanted_golden_apple_leave",
            ()-> new LeafCropBlock(BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER), Items.ENCHANTED_GOLDEN_APPLE));
    public static final Supplier<Block> Apple_Tree_LEAVES =registerBlock("apple_tree_leave",
            ()->  new LeavesBlock(BlockBehaviour.Properties.of().noOcclusion() .mapColor(MapColor.NETHER)));

    //Potted Plant
    public static final Supplier<Block> POTTED_Golden_APPLE_SAPLING = registerBlockWithoutItem("potted_haste_apple_sapling",
            ()-> new FlowerPotBlock(Golden_APPLE_SAPLING.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion()));
    public static final Supplier<Block> POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlockWithoutItem("potted_enchanted_golden_apple_sapling",
            ()-> new FlowerPotBlock(ENCHANTED_GOLDEN_APPLE_SAPLING.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    private static <T extends Block> Supplier<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }
    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> Supplier<Item> registerBlockItem(String name, Supplier<T> block) {
        return AppleItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }


    public static void registerGoldenAppleTreeBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
