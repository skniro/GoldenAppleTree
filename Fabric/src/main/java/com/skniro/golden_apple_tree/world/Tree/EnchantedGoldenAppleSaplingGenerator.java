package com.skniro.golden_apple_tree.world.Tree;

import com.skniro.golden_apple_tree.world.AppleTreeConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class EnchantedGoldenAppleSaplingGenerator {
    public static final SaplingGenerator EnchantedGoldenAppleSapling =
            new SaplingGenerator("enchanted_golden_apple_sapling", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(AppleTreeConfiguredFeatures.ENCHANTED_GOLDEN_APPLE_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
    }