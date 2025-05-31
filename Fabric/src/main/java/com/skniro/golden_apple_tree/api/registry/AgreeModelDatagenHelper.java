package com.skniro.golden_apple_tree.api.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;

import static net.minecraft.client.data.BlockStateModelGenerator.createWeightedVariant;

public class AgreeModelDatagenHelper {
    private final BlockStateModelGenerator generator;

    public AgreeModelDatagenHelper(BlockStateModelGenerator generator) {
        this.generator = generator;
    }

    public void registerModLeaves(Block block) {
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block)
                .with(BlockStateVariantMap.models(Properties.AGE_2).generate(stage ->
                        createWeightedVariant(generator.createSubModel(block, "_stage" + stage, Models.CUBE_ALL, TextureMap::all)
                        )
                ))
        );
    }
}