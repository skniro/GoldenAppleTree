package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import java.util.Optional;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

public class GoldenAppleSaplingGenerator {
    public static final TreeGrower GoldenAppleSapling =
            new TreeGrower("golden_apple_sapling",
                    WeightedList.of(AppleTreeConfiguredFeatures.Golden_APPLE_TREE),
                    WeightedList.of(),
                    WeightedList.of(),
                    AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE);
    }