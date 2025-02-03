package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class GoldenAppleSaplingGenerator {
    public static final SaplingGenerator GoldenAppleSapling =
            new SaplingGenerator("golden_apple_sapling", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(AppleTreeConfiguredFeatures.Golden_APPLE_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
    }