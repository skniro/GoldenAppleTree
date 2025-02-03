package com.skniro.golden_apple_tree.datagen;

import com.skniro.golden_apple_tree.GoldenAppleTree;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModWorldGenerator extends FabricDynamicRegistryProvider {
    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        // HERE GOES FUTURE WORLD GEN!
        entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
    }

    @Override
    public String getName() {
        return GoldenAppleTree.MOD_ID;
    }
}