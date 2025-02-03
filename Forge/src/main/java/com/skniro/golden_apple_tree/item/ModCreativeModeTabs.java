package com.skniro.golden_apple_tree.item;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoldenAppleTree.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Golden_Apple_Group= CREATIVE_MODE_TABS.register("golden_apple_tree_group",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE))
                    .title(Component.translatable("itemGroup.better_snowball.better_snowball_group"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(GoldenAppleTreeBlocks.Apple_Tree_LEAVES.get());
                        pOutput.accept(GoldenAppleTreeBlocks.Golden_APPLE_SAPLING.get());
                        pOutput.accept(GoldenAppleTreeBlocks.Golden_APPLE_LEAVES.get());
                        pOutput.accept(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_LEAVES.get());
                        pOutput.accept(GoldenAppleTreeBlocks.ENCHANTED_GOLDEN_APPLE_SAPLING.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
