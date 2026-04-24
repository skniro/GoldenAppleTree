package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import com.skniro.golden_apple_tree.compat.jade.LeafCropBlockProgressProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class AgreeSimplifiedChineseLanguageProvider extends FabricLanguageProvider {
    public AgreeSimplifiedChineseLanguageProvider(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> registryLookup){
        super(dataGenerator,"zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {

        //SAPLING
        translationBuilder.add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,"金苹果树苗");
        translationBuilder.add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,"附魔金苹果树苗");
        translationBuilder.add(GoldenAppleTreeBlocks.APPLE_SAPLING,"苹果树苗");

        //LEAVES
        translationBuilder.add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES,"金苹果树叶");
        translationBuilder.add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES,"附魔金苹果树叶");
        translationBuilder.add(GoldenAppleTreeBlocks.APPLE_LEAVES,"苹果果实树叶");
        translationBuilder.add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES,"苹果树叶");

        //Potted Plant
        translationBuilder.add(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING,"金苹果盆栽");
        translationBuilder.add(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING,"附魔金苹果盆栽");
        translationBuilder.add(GoldenAppleTreeBlocks.POTTED_APPLE_SAPLING,"苹果盆栽");

        translationBuilder.add(GoldenAppleTree.Golden_Apple_Group,"金苹果树");

        translationBuilder.add("config.jade.plugin_golden_apple_tree.apple_progress", "苹果生长进度");
/*        // Load an existing language file.
        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/agree/lang/zh_cn.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }*/
    }
}
