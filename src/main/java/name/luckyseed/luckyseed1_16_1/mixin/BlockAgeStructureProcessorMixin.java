package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.structure.processor.BlockAgeStructureProcessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BlockAgeStructureProcessor.class)
public class BlockAgeStructureProcessorMixin {
    @ModifyConstant(method = "processObsidian(Ljava/util/Random;)Lnet/minecraft/block/BlockState;", constant = @Constant(floatValue = 0.15f))
    private float disableCryingObsidianAge(float value) {
        return 0.0F;
    }
}
