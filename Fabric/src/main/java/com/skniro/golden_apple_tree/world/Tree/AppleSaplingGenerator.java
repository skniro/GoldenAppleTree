package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import java.util.Optional;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

public class AppleSaplingGenerator {
    public static final TreeGrower AppleSapling =
            new TreeGrower("apple_sapling",
                    WeightedList.of(AppleTreeConfiguredFeatures.APPLE_TREE),
                    WeightedList.of(),
                    WeightedList.of(),
                    AppleTreeConfiguredFeatures.APPLE_TREE);
    }