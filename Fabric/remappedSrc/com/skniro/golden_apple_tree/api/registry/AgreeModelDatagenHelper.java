package com.skniro.golden_apple_tree.api.registry;

import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class AgreeModelDatagenHelper {
    private final BlockModelGenerators generator;

    public AgreeModelDatagenHelper(BlockModelGenerators generator) {
        this.generator = generator;
    }

    public void registerModLeaves(Block block) {
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.AGE_2).generate(stage ->
                        plainVariant(generator.createSuffixedVariant(block, "_stage" + stage, ModelTemplates.CUBE_ALL, TextureMapping::cube)
                        )
                ))
        );
    }
}