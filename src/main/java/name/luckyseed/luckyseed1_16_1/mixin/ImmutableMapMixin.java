package name.luckyseed.luckyseed1_16_1.mixin;

import com.google.common.collect.ImmutableMap;
import name.luckyseed.luckyseed1_16_1.CustomStructureConfig;
import net.minecraft.world.gen.feature.BastionRemnantFeature;
import net.minecraft.world.gen.feature.NetherFortressFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = ImmutableMap.Builder.class, remap = false)
public class ImmutableMapMixin {
    @ModifyArgs(method = "put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;", at = @At(value = "INVOKE", target = "com/google/common/collect/ImmutableMap.entryOf (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMapEntry;"))
    private void changeStructureRates(Args args) {
        if(args.get(0) instanceof BastionRemnantFeature) {
            args.set(1, CustomStructureConfig.BastionRemnant);
        }

        if(args.get(0) instanceof NetherFortressFeature) {
            args.set(1, CustomStructureConfig.NetherFortress);
        }
    }
}