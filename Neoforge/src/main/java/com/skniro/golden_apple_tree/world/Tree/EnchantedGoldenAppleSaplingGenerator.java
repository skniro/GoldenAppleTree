package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

public class EnchantedGoldenAppleSaplingGenerator {
    public static final TreeGrower EnchantedGoldenAppleSapling =
            new TreeGrower("enchanted_golden_apple_sapling",
                    WeightedList.of(AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE),
                    WeightedList.of(),
                    WeightedList.of(),
                    AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE);
    }