package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.structure.RuinedPortalStructurePiece;
import net.minecraft.world.gen.feature.RuinedPortalFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(RuinedPortalFeature.class)
public class RuinedPortalFeatureMixin {
    @ModifyVariable(method = "method_27211(Ljava/util/Random;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Lnet/minecraft/structure/RuinedPortalStructurePiece$VerticalPlacement;ZIILnet/minecraft/util/math/BlockBox;)I", at = @At("HEAD"), argsOnly = true)
    private static boolean modifyAirPockets(boolean bl) {
        return true;
    }

    @ModifyVariable(method = "method_27211(Ljava/util/Random;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Lnet/minecraft/structure/RuinedPortalStructurePiece$VerticalPlacement;ZIILnet/minecraft/util/math/BlockBox;)I", at = @At("HEAD"), argsOnly = true)
    private static RuinedPortalStructurePiece.VerticalPlacement modifyPlacements(RuinedPortalStructurePiece.VerticalPlacement verticalPlacement) {
        if (verticalPlacement == RuinedPortalStructurePiece.VerticalPlacement.IN_NETHER) return verticalPlacement;
        return RuinedPortalStructurePiece.VerticalPlacement.ON_LAND_SURFACE;
    }
}