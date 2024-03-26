package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.biome.BasaltDeltasBiome;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BasaltDeltasBiome.class)
public abstract class BasaltDeltasBiomeMixin {
    @Inject(at = @At("TAIL"), method = "<init>()V")
    private void modifyStructuresFeature(CallbackInfo ci) {
        BasaltDeltasBiome t = (BasaltDeltasBiome) (Object) this;
        t.addStructureFeature(DefaultBiomeFeatures.BASTION_REMNANT);
    }
}
