package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biome.class)
public class BiomeMixin {
    @Inject(at = @At("HEAD"), method = "addStructureFeature(Lnet/minecraft/world/gen/feature/ConfiguredStructureFeature;)V", cancellable = true)
    private void disableMonumentFeature(ConfiguredStructureFeature<?, ?> configuredStructureFeature, CallbackInfo ci) {
        if (configuredStructureFeature == DefaultBiomeFeatures.MONUMENT) {
            ci.cancel();
        }
    }
}