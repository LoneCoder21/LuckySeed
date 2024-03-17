package name.luckyseed.luckyseed1_16_1.mixin;

import name.luckyseed.luckyseed1_16_1.options.ModOptions;
import net.minecraft.entity.EyeOfEnderEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EyeOfEnderEntity.class)
public class EyeofEnderEntityMixin {
    @Shadow
    private boolean dropsItem;

    @Inject(method = "moveTowards(Lnet/minecraft/util/math/BlockPos;)V", at = @At("TAIL"))
    private void disableEyeBreak(BlockPos pos, CallbackInfo ci) {
        if (!ModOptions.ALLOW_EYEBREAK)
            this.dropsItem = true;
    }
}