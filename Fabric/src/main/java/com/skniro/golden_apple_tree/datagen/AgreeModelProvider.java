package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.api.registry.AgreeModelDatagenHelper;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class AgreeModelProvider extends FabricModelProvider {
    public AgreeModelProvider(FabricDataOutput dataGenerator){
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerFlowerPotPlantAndItem(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING,BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING,BlockStateModelGenerator.CrossType.NOT_TINTED);

        AgreeModelDatagenHelper agreeModelDatagenHelper = new AgreeModelDatagenHelper(blockStateModelGenerator);
        agreeModelDatagenHelper.registerModLeavesBush(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES);
        agreeModelDatagenHelper.registerModLeavesBush(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES);

        blockStateModelGenerator.registerCubeAllModelTexturePool(GoldenAppleTreeBlocks.Apple_Tree_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
