package com.skniro.golden_apple_tree.world;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class AppleTreeConfiguredFeatures {
    public static final ResourceKey<Feature> Golden_APPLE_TREE = registerKey("golden_apple_tree");
    public static final ResourceKey<Feature> ENCHANTED_GOLDEN_APPLE_TREE = registerKey("enchanted_golden_apple_tree");
    public static final ResourceKey<Feature> APPLE_TREE = registerKey("apple_tree");

    static WeightedList.Builder<BlockState> pool() {
        return WeightedList.builder();
    }

    public static void bootstrap(BootstrapContext<Feature> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<BlockStateProvider> blockStateProviders = context.lookup(Registries.BLOCK_STATE_PROVIDER);
        Holder<BlockStateProvider> belowTrunkProvider = blockStateProviders.getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);
        context.register(Golden_APPLE_TREE,
                new TreeFeature.Builder(
                        BlockStateProvider.of(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        new WeightedStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get().defaultBlockState(), 3).add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.get().defaultBlockState(), 1)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1),
                        belowTrunkProvider).build());
        context.register(ENCHANTED_GOLDEN_APPLE_TREE,
                new TreeFeature.Builder(
                        BlockStateProvider.of(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        new WeightedStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get().defaultBlockState(), 3).add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.get().defaultBlockState(), 1)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1),
                        belowTrunkProvider).build());

        context.register(APPLE_TREE,
                new TreeFeature.Builder(
                        BlockStateProvider.of(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        new WeightedStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get().defaultBlockState(), 3).add(GoldenAppleTreeBlocks.APPLE_LEAVES.get().defaultBlockState(), 1)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1),
                        belowTrunkProvider).build());
    }




    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name));
    }
}
