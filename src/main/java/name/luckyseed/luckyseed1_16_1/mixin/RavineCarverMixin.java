package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.gen.carver.Carver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Carver.class)
public class RavineCarverMixin {
    @Redirect(method = "carveRegion", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(II)I", ordinal = 1))
    private int deeperRavines(int a, int b) {
        return 5;
    }
}
