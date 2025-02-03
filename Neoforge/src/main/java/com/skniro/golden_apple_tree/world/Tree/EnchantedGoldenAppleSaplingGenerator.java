package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import java.util.Optional;
import net.minecraft.world.level.block.grower.TreeGrower;

public class EnchantedGoldenAppleSaplingGenerator {
    public static final TreeGrower EnchantedGoldenAppleSapling =
            new TreeGrower("enchanted_golden_apple_sapling", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
    }