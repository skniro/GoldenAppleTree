package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.api.registry.AgreeModelDatagenHelper;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class AgreeModelProvider extends FabricModelProvider {
    public AgreeModelProvider(FabricPackOutput dataGenerator){
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator){
        blockStateModelGenerator.createPlantWithDefaultItem(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING,BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createPlantWithDefaultItem(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING,BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createPlantWithDefaultItem(GoldenAppleTreeBlocks.APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING,BlockModelGenerators.PlantType.NOT_TINTED);

        AgreeModelDatagenHelper agreeModelDatagenHelper = new AgreeModelDatagenHelper(blockStateModelGenerator);
        agreeModelDatagenHelper.registerModLeaves(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
        agreeModelDatagenHelper.registerModLeaves(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES);
        agreeModelDatagenHelper.registerModLeaves(GoldenAppleTreeBlocks.APPLE_LEAVES);

        blockStateModelGenerator.family(GoldenAppleTreeBlocks.Apple_Tree_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }
}
