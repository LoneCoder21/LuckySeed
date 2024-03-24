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
        if (configuredStructureFeature == DefaultBiomeFeatures.MONUMENT || configuredStructureFeature == DefaultBiomeFeatures.DESERT_RUINED_PORTAL || configuredStructureFeature == DefaultBiomeFeatures.SWAMP_RUINED_PORTAL || configuredStructureFeature == DefaultBiomeFeatures.OCEAN_RUINED_PORTAL || configuredStructureFeature == DefaultBiomeFeatures.COLD_OCEAN_RUIN || configuredStructureFeature == DefaultBiomeFeatures.WARM_OCEAN_RUIN || configuredStructureFeature == DefaultBiomeFeatures.DESERT_VILLAGE || configuredStructureFeature == DefaultBiomeFeatures.TAIGA_VILLAGE || configuredStructureFeature == DefaultBiomeFeatures.MESA_MINESHAFT || configuredStructureFeature == DefaultBiomeFeatures.NORMAL_MINESHAFT) {
            ci.cancel();
        }
    }
}