package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @ModifyConstant(method = "addOceanCarvers(Lnet/minecraft/world/biome/Biome;)V", constant = @Constant(floatValue = 0.02f))
    private static float increaseRavines(float value) {
        return 0.1F;
    }

    @Inject(at = @At("HEAD"), method = "addDungeons(Lnet/minecraft/world/biome/Biome;)V", cancellable = true)
    private static void addDungeons(Biome biome, CallbackInfo ci) {
        ci.cancel();
    }
}
