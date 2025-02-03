package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class AgreeEnglishLanguageProvider extends FabricLanguageProvider {
    public AgreeEnglishLanguageProvider(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> registryLookup){
        super(dataGenerator, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        //SAPLING
        translationBuilder.add(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING,"Golden Apple Sapling");
        translationBuilder.add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING,"Enchanted Golden Apple Sapling");


        //LEAVES
        translationBuilder.add(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES,"Golden Apple Leaves");
        translationBuilder.add(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES,"Enchanted Golden Apple Leaves");
        translationBuilder.add(GoldenAppleTreeBlocks.Apple_Tree_LEAVES,"Apple Tree Leaves");

        //Potted Plant
        translationBuilder.add(GoldenAppleTreeBlocks.POTTED_Golden_APPLE_SAPLING,"Potted Golden Apple Sapling");
        translationBuilder.add(GoldenAppleTreeBlocks.POTTED_ENCHANTED_GOLDEN_APPLE_SAPLING,"Potted Enchanted Golden Apple Sapling");

        translationBuilder.add(GoldenAppleTree.Golden_Apple_Group,"Golden apple tree");


/*        // Load an existing language file.
        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/agree/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }*/
    }
}
