package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class GoldenAppleSaplingGenerator extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return AppleTreeConfiguredFeatures.Golden_APPLE_TREE;
    }
}