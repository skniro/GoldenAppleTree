package com.skniro.golden_apple_tree.block;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import com.skniro.golden_apple_tree.item.AppleItems;
import com.skniro.golden_apple_tree.world.Tree.AppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.EnchantedGoldenAppleSaplingGenerator;
import com.skniro.golden_apple_tree.world.Tree.GoldenAppleSaplingGenerator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class GoldenAppleTreeBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoldenAppleTree.MOD_ID);

    //SAPLING
    public static final RegistryObject<Block> Golden_APPLE_SAPLING = registerBlock("golden_apple_sapling",
            (settings)-> new SaplingBlock(GoldenAppleSaplingGenerator.GoldenAppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));
    public static final RegistryObject<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            (settings)-> new SaplingBlock(AppleSaplingGenerator.AppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));
    public static final RegistryObject<Block> ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlock("enchanted_golden_apple_sapling",
            (settings)-> new SaplingBlock(EnchantedGoldenAppleSaplingGenerator.EnchantedGoldenAppleSapling,settings), BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING));

    //LEAVES
    public static final RegistryObject<Block> Golden_APPLE_LEAVES =registerBlock("golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.GOLDEN_APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final RegistryObject<Block> ENCHANTED_GOLDEN_APPLE_LEAVES =registerBlock("enchanted_golden_apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.ENCHANTED_GOLDEN_APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final RegistryObject<Block> APPLE_LEAVES =registerBlock("apple_leave",
            (settings)-> new LeafCropBlock(settings, Items.APPLE), BlockBehaviour.Properties.of().noOcclusion().mapColor(MapColor.NETHER));
    public static final RegistryObject<Block> Apple_Tree_LEAVES =registerBlock("apple_tree_leave",
            (properties)-> new TintedParticleLeavesBlock(0.01F, properties), BlockBehaviour.Properties.of().noOcclusion() .mapColor(MapColor.NETHER));

    //Potted Plant
    public static final RegistryObject<Block> POTTED_Golden_APPLE_SAPLING = registerBlockWithoutItem("potted_haste_apple_sapling",
            (settings)-> new FlowerPotBlock(Golden_APPLE_SAPLING.get(), settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());
    public static final RegistryObject<Block> POTTED_APPLE_SAPLING = registerBlockWithoutItem("potted_apple_sapling",
            (settings)-> new FlowerPotBlock(APPLE_SAPLING.get(), settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());
    public static final RegistryObject<Block> POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING = registerBlockWithoutItem("potted_enchanted_golden_apple_sapling",
            (settings)-> new FlowerPotBlock(ENCHANTED_GOLDEN_APPLE_SAPLING.get(), settings), BlockBehaviour.Properties.of().instabreak().noOcclusion());

    public static <B extends Block> RegistryObject<Block> register(String name, Function<BlockBehaviour.Properties, ? extends B> func, BlockBehaviour.Properties props) {
        return BLOCKS.register(name, () -> {
            return (Block)func.apply(props.setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name))));
        });
    }

    private static <B extends Block> RegistryObject<Block> registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, ? extends B> block, BlockBehaviour.Properties properties) {
        RegistryObject<Block> register = register(name, block, properties.setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name))));
        return register;
    }

    private static <B extends Block> RegistryObject<Block> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> block, BlockBehaviour.Properties properties) {
        RegistryObject<Block> bRegistryObject = registerBlockWithoutItem(name, block, properties);
        registerBlockItem(name, bRegistryObject);
        return bRegistryObject;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block) {
        return AppleItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name)))));
    }

    public static void registerGoldenAppleTreeBlocks(BusGroup eventBus) {
        BLOCKS.register(eventBus);
    }
}
