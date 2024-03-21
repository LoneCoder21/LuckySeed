package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RandomBlockMatchRuleTest.class)
public class RandomBlockMatchRuleTestMixin {
    @Mutable
    @Shadow
    @Final
    private float probability;

    @Inject(method = "<init>(Lnet/minecraft/block/Block;F)V", at = @At("TAIL"))
    private void modifyBastionGoldBlockRule(Block block, float f, CallbackInfo ci) {
        if (block == Blocks.GOLD_BLOCK) {
            this.probability = 0.0F;
        }
    }
}
