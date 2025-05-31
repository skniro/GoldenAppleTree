package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class AppleSaplingGenerator {
    public static final SaplingGenerator AppleSapling =
            new SaplingGenerator("apple_sapling", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(AppleTreeConfiguredFeatures.APPLE_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
    }