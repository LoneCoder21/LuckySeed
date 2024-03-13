package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.OceanTemperatureLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OceanTemperatureLayer.class)
public class OceanTemperatureLayerMixin {
    @Inject(method = "sample(Lnet/minecraft/world/biome/layer/util/LayerRandomnessSource;II)I", at = @At("RETURN"), cancellable = true)
    private void injected(LayerRandomnessSource context, int x, int y, CallbackInfoReturnable<Integer> cir) {
        if (cir.getReturnValue() == Registry.BIOME.getRawId(Biomes.WARM_OCEAN)) {
            cir.setReturnValue(Registry.BIOME.getRawId(Biomes.DEEP_OCEAN));
        }
    }
}