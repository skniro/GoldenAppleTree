package com.skniro.golden_apple_tree;

import com.mojang.logging.LogUtils;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import com.skniro.golden_apple_tree.item.AppleItems;
import com.skniro.golden_apple_tree.item.ModCreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(GoldenAppleTree.MOD_ID)
public class GoldenAppleTree {
    public static final String MOD_ID = "golden_apple_tree";
    private static final Logger LOGGER = LogUtils.getLogger();


    public GoldenAppleTree(IEventBus modEventBus) {

        modEventBus.addListener(this::commonSetup);

        AppleItems.registerModItems(modEventBus);
        GoldenAppleTreeBlocks.registerGoldenAppleTreeBlocks(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
//        GoldenAppleDispenserBehaviors.register();
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
