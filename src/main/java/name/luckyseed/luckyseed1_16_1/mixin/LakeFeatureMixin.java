package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.world.gen.feature.LakeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;

@Mixin(LakeFeature.class)
public class LakeFeatureMixin {
    @Redirect(method = "generate(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/SingleStateFeatureConfig;)Z", at = @At(value = "INVOKE", target = "java/util/Optional.isPresent ()Z"))
    private boolean injected(Optional instance) {
        return false;
    }
}
