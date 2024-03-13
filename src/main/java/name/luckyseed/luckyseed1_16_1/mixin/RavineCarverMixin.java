package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.gen.carver.RavineCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(RavineCarver.class)
public class RavineCarverMixin {
    @ModifyConstant(method = "carve(Lnet/minecraft/world/chunk/Chunk;Ljava/util/function/Function;Ljava/util/Random;IIIIILjava/util/BitSet;Lnet/minecraft/world/gen/ProbabilityConfig;)Z", constant = @Constant(intValue = 20))
    private int generateDeepRavines(int value) {
        return 10;
    }
}
