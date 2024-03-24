package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Feature.class)

public class FeatureMixin {
    @ModifyVariable(method = "configure(Lnet/minecraft/world/gen/feature/FeatureConfig;)Lnet/minecraft/world/gen/feature/ConfiguredFeature;", at = @At("HEAD"), argsOnly = true)
    private FeatureConfig modifyPlacements(FeatureConfig value) {
        if (value == DefaultBiomeFeatures.MELON_PILE_CONFIG || value == DefaultBiomeFeatures.SNOW_PILE_CONFIG || value == DefaultBiomeFeatures.BLUE_ICE_PILE_CONFIG || value == DefaultBiomeFeatures.PUMPKIN_PILE_CONFIG) {
            return DefaultBiomeFeatures.HAY_PILE_CONFIG;
        }
        return value;
    }
}
