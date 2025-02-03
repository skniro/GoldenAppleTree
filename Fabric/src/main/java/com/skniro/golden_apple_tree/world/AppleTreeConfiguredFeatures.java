package com.skniro.golden_apple_tree.world;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class AppleTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> Golden_APPLE_TREE = registerKey("golden_apple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENCHANTED_GOLDEN_APPLE_TREE = registerKey("enchanted_golden_apple_tree");

    static DataPool.Builder<BlockState> pool() {
        return DataPool.builder();
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        register(featureRegisterable, Golden_APPLE_TREE, Feature.TREE,
                new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedBlockStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.getDefaultState(), 3).add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.getDefaultState(), 1)),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        register(featureRegisterable, ENCHANTED_GOLDEN_APPLE_TREE, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        new WeightedBlockStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.getDefaultState(), 3).add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.getDefaultState(), 1)),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)).build());
    }




    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(GoldenAppleTree.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
