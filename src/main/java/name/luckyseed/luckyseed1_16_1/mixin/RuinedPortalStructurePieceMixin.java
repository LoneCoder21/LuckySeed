package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.structure.RuinedPortalStructurePiece;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(RuinedPortalStructurePiece.class)
public class RuinedPortalStructurePieceMixin {
    @ModifyVariable(method = "<init>(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/structure/RuinedPortalStructurePiece$VerticalPlacement;Lnet/minecraft/structure/RuinedPortalStructurePiece$Properties;Lnet/minecraft/util/Identifier;Lnet/minecraft/structure/Structure;Lnet/minecraft/util/BlockRotation;Lnet/minecraft/util/BlockMirror;Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"), argsOnly = true)
    private static RuinedPortalStructurePiece.Properties modifyAirPockets(RuinedPortalStructurePiece.Properties y) {
        y.airPocket = true;
        return y;
    }
}