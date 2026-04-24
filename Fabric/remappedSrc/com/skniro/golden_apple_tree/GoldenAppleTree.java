package com.skniro.golden_apple_tree;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoldenAppleTree implements ModInitializer {
    public static final String MOD_ID = "golden_apple_tree";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    public static final ResourceKey<CreativeModeTab> Golden_Apple_Group = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(MOD_ID, "golden_apple_tree_group"));

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Golden_Apple_Group, FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE))
                .title(Component.translatable("itemGroup.golden_apple_tree.golden_apple_tree_group"))
                .build()); // build() no longer registers by itself
        GoldenAppleTreeContent.registerBlock();
        GoldenAppleTreeContent.CreativeTab();
        GoldenAppleTreeContent.registerEvent();
    }
}
