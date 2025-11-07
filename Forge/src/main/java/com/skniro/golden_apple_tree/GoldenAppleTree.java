package com.skniro.golden_apple_tree;

import com.mojang.logging.LogUtils;
import com.skniro.golden_apple_tree.block.GoldenAppleTreeBlocks;
import com.skniro.golden_apple_tree.event.GoldenAppleDispenserBehaviors;
import com.skniro.golden_apple_tree.item.AppleItems;
import com.skniro.golden_apple_tree.item.ModCreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GoldenAppleTree.MOD_ID)
public class GoldenAppleTree {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "golden_apple_tree";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public GoldenAppleTree(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        AppleItems.registerModItems(modEventBus);
        GoldenAppleTreeBlocks.registerGoldenAppleTreeBlocks(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
