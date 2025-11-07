package com.skniro.golden_apple_tree.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.skniro.golden_apple_tree.block.init.LeafCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ShearsDispenseItemBehavior.class)
public class ShearsDispenserBehaviorMixin {

    @ModifyReturnValue(
            method = "tryShearBeehive",
            at = @At("TAIL")
    )
    private static boolean shearAppleLeaves(boolean original, @Local(argsOnly = true) BlockPos pos, @Local(argsOnly = true) ServerLevel world) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof LeafCropBlock leafCrop) {
            int age = state.getValue(LeafCropBlock.AGE);
            if (age > 1) {
                world.playSound(null, pos, SoundEvents.BEEHIVE_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                Block.popResource(world, pos, new ItemStack(leafCrop.fruitItem, 1));
                BlockState newState = state.setValue(LeafCropBlock.AGE, 1);
                world.setBlock(pos, newState, 2);
                world.gameEvent(null, GameEvent.SHEAR, pos);
                return true;
            }
        }
        return false;
    }
}