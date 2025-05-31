package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.api.registry.AgreeModelDatagenHelper;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class AgreeModelProvider extends FabricModelProvider {
    public AgreeModelProvider(FabricDataOutput dataGenerator){
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerFlowerPotPlant(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(GoldenAppleTreeBlocks.APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING,BlockStateModelGenerator.TintType.NOT_TINTED);

        AgreeModelDatagenHelper agreeModelDatagenHelper = new AgreeModelDatagenHelper(blockStateModelGenerator);
        agreeModelDatagenHelper.registerModLeaves(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
        agreeModelDatagenHelper.registerModLeaves(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES);
        agreeModelDatagenHelper.registerModLeaves(GoldenAppleTreeBlocks.APPLE_LEAVES);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GoldenAppleTreeBlocks.Apple_Tree_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
