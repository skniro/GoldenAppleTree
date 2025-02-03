package com.skniro.golden_apple_tree.api.registry;

import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class AgreeModelDatagenHelper {
    private final BlockModelGenerators generator;

    public AgreeModelDatagenHelper(BlockModelGenerators generator) {
        this.generator = generator;
    }

    public void registerModLeavesBush(Block block) {
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(BlockStateProperties.AGE_2).generate(stage ->
                        Variant.variant().with(VariantProperties.MODEL,
                                generator.createSuffixedVariant(block, "_stage" + stage, ModelTemplates.CUBE_ALL, TextureMapping::cube)
                        )
                ))
        );
    }
}