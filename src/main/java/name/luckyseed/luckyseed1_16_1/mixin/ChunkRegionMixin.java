package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkRegion.class)
public abstract class ChunkRegionMixin {
    @Shadow
    public abstract BlockState getBlockState(BlockPos pos);

    @Inject(at = @At("HEAD"), method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;II)Z", cancellable = true)
    private void disableChestOverride(BlockPos blockPos, BlockState state, int flags, int maxUpdateDepth, CallbackInfoReturnable<Boolean> cir) {
        BlockState bs = this.getBlockState(blockPos);
        if (bs.isOf(Blocks.CHEST)) {
            cir.setReturnValue(false);
        }
    }
}
