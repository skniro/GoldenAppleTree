package com.skniro.golden_apple_tree.world;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class AppleTreeConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> Golden_APPLE_TREE = registerKey("golden_apple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_GOLDEN_APPLE_TREE = registerKey("enchanted_golden_apple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE = registerKey("apple_tree");

    static WeightedList.Builder<BlockState> pool() {
        return WeightedList.builder();
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> featureRegisterable) {
        register(featureRegisterable, Golden_APPLE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                new WeightedStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get().defaultBlockState(), 3).add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.get().defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        register(featureRegisterable, ENCHANTED_GOLDEN_APPLE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        new WeightedStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get().defaultBlockState(), 3).add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.get().defaultBlockState(), 1)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)).build());
        register(featureRegisterable, APPLE_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(4, 2, 0),
                        new WeightedStateProvider(pool().add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get().defaultBlockState(), 3).add(GoldenAppleTreeBlocks.APPLE_LEAVES.get().defaultBlockState(), 1)),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)).build());
    }




    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
