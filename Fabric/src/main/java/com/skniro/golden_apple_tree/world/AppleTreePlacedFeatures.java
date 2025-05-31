package com.skniro.golden_apple_tree.world;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class AppleTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> Golden_APPLE_TREE_PLACED = registerKey("golden_tree_placed");
    public static final RegistryKey<PlacedFeature> ENCHANTED_GOLDEN_APPLE_TREE_PLACED = registerKey("enchanted_golden_tree_placed");
    public static final RegistryKey<PlacedFeature> APPLE_TREE_PLACED = registerKey("apple_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, Golden_APPLE_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(AppleTreeConfiguredFeatures.Golden_APPLE_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), GoldenAppleTreeBlocks.Golden_APPLE_SAPLING));
        register(context, ENCHANTED_GOLDEN_APPLE_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING));
        register(context, APPLE_TREE_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(AppleTreeConfiguredFeatures.APPLE_TREE),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), GoldenAppleTreeBlocks.APPLE_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(GoldenAppleTree.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}