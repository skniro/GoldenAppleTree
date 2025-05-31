package com.skniro.golden_apple_tree.api.registry;

import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.state.property.Properties;

public class AgreeModelDatagenHelper {
    private final BlockStateModelGenerator generator;

    public AgreeModelDatagenHelper(BlockStateModelGenerator generator) {
        this.generator = generator;
    }

    public void registerModLeaves(Block block) {
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_2).register(stage ->
                        BlockStateVariant.create().put(VariantSettings.MODEL,
                                generator.createSubModel(block, "_stage" + stage, Models.CUBE_ALL, TextureMap::all)
                        )
                ))
        );
    }
}