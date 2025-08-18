package com.skniro.golden_apple_tree;

import com.skniro.golden_apple_tree.event.GoldenAppleDispenserBehaviors;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoldenAppleTree implements ModInitializer {
    public static final String MOD_ID = "golden_apple_tree";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    public static final RegistryKey<ItemGroup> Golden_Apple_Group = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "golden_apple_tree_group"));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, Golden_Apple_Group, FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE))
                .displayName(Text.translatable("itemGroup.better_snowball.better_snowball_group"))
                .build()); // build() no longer registers by itself
        GoldenAppleTreeContent.registerBlock();
        GoldenAppleTreeContent.CreativeTab();
        GoldenAppleDispenserBehaviors.register();
    }
}
