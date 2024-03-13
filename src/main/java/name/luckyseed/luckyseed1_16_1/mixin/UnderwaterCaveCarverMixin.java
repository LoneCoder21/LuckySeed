package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.gen.carver.UnderwaterCaveCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(UnderwaterCaveCarver.class)
public class UnderwaterCaveCarverMixin {
    @ModifyConstant(method = "carveAtPoint(Lnet/minecraft/world/gen/carver/Carver;Lnet/minecraft/world/chunk/Chunk;Ljava/util/BitSet;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos$Mutable;IIIIIIII)Z", constant = @Constant(intValue = 10))
    private static int increaseMagmaLayerHeight(int value) {
        return 25;
    }
}
