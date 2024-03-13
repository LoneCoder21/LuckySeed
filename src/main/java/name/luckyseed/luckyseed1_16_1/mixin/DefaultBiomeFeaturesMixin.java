package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @ModifyConstant(method = "addOceanCarvers(Lnet/minecraft/world/biome/Biome;)V", constant = @Constant(floatValue = 0.02f))
    private static float increaseRavines(float value) {
        return 0.1F;
    }
}
