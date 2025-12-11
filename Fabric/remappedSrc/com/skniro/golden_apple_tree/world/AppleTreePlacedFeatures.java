package com.skniro.golden_apple_tree.world;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import java.util.List;

public class AppleTreePlacedFeatures {
    public static final ResourceKey<PlacedFeature> Golden_APPLE_TREE_PLACED = registerKey("golden_tree_placed");
    public static final ResourceKey<PlacedFeature> ENCHANTED_GOLDEN_APPLE_TREE_PLACED = registerKey("enchanted_golden_tree_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, Golden_APPLE_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(AppleTreeConfiguredFeatures.Golden_APPLE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), GoldenAppleTreeBlocks.Golden_APPLE_SAPLING));
        register(context, ENCHANTED_GOLDEN_APPLE_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(GoldenAppleTree.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                   Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}