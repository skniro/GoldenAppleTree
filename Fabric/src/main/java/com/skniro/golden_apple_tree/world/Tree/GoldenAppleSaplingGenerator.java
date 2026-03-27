package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import java.util.Optional;
import net.minecraft.world.level.block.grower.TreeGrower;

public class GoldenAppleSaplingGenerator {
    public static final TreeGrower GoldenAppleSapling =
            new TreeGrower("golden_apple_sapling", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(AppleTreeConfiguredFeatures.Golden_APPLE_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
    }