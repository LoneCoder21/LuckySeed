package name.luckyseed.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.SpringFeature;
import net.minecraft.world.gen.feature.SpringFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = SpringFeature.class)
public class SpringFeatureMixin {
    @Inject(method = "generate(Lnet/minecraft/world/StructureWorldAccess;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/SpringFeatureConfig;)Z", at = @At("HEAD"), cancellable = true)
    private void removeSpringFeature(StructureWorldAccess structureWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, SpringFeatureConfig springFeatureConfig, CallbackInfoReturnable<Boolean> cir) {
        if (springFeatureConfig.state == Fluids.LAVA.getDefaultState() && springFeatureConfig.validBlocks.size() == 1 && springFeatureConfig.validBlocks.contains(Blocks.NETHERRACK)) {
            cir.setReturnValue(false);
        }
    }
}