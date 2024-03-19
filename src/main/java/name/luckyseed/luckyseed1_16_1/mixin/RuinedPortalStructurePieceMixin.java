package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.structure.RuinedPortalStructurePiece;
import net.minecraft.structure.processor.StructureProcessorRule;
import net.minecraft.structure.rule.AlwaysTrueRuleTest;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RuinedPortalStructurePiece.class)
public class RuinedPortalStructurePieceMixin {
    @Unique
    private final RuinedPortalStructurePiece.VerticalPlacement verticalPlacement;

    public RuinedPortalStructurePieceMixin(RuinedPortalStructurePiece.VerticalPlacement verticalPlacement) {
        this.verticalPlacement = verticalPlacement;
    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/structure/RuinedPortalStructurePiece$VerticalPlacement;Lnet/minecraft/structure/RuinedPortalStructurePiece$Properties;Lnet/minecraft/util/Identifier;Lnet/minecraft/structure/Structure;Lnet/minecraft/util/BlockRotation;Lnet/minecraft/util/BlockMirror;Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"), argsOnly = true)
    private static RuinedPortalStructurePiece.Properties modifyAirPockets(RuinedPortalStructurePiece.Properties y) {
        y.airPocket = true;
        return y;
    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/structure/RuinedPortalStructurePiece$VerticalPlacement;Lnet/minecraft/structure/RuinedPortalStructurePiece$Properties;Lnet/minecraft/util/Identifier;Lnet/minecraft/structure/Structure;Lnet/minecraft/util/BlockRotation;Lnet/minecraft/util/BlockMirror;Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"), argsOnly = true)
    private static RuinedPortalStructurePiece.VerticalPlacement modifyPlacementsCtor(RuinedPortalStructurePiece.VerticalPlacement verticalPlacement) {
        if (verticalPlacement == RuinedPortalStructurePiece.VerticalPlacement.IN_NETHER) return verticalPlacement;
        return RuinedPortalStructurePiece.VerticalPlacement.ON_LAND_SURFACE;
    }

    @ModifyVariable(method = "getHeightmapType(Lnet/minecraft/structure/RuinedPortalStructurePiece$VerticalPlacement;)Lnet/minecraft/world/Heightmap$Type;", at = @At("HEAD"), argsOnly = true)
    private static RuinedPortalStructurePiece.VerticalPlacement modifyPlacements(RuinedPortalStructurePiece.VerticalPlacement verticalPlacement) {
        if (verticalPlacement == RuinedPortalStructurePiece.VerticalPlacement.IN_NETHER) return verticalPlacement;
        return RuinedPortalStructurePiece.VerticalPlacement.ON_LAND_SURFACE;
    }

    @ModifyConstant(method = "processProperties(Lnet/minecraft/structure/Structure;Lnet/minecraft/util/math/BlockPos;)V", constant = @Constant(floatValue = 0.3f))
    private float keepGoldBlocks(float value) {
        return 0.0F;
    }

    @Inject(method = "createLavaReplacementRule()Lnet/minecraft/structure/processor/StructureProcessorRule;", at = @At("HEAD"), cancellable = true)
    private void removeSpringFeature(CallbackInfoReturnable<StructureProcessorRule> cir) {
        if (this.verticalPlacement != RuinedPortalStructurePiece.VerticalPlacement.ON_OCEAN_FLOOR) {
            cir.setReturnValue(new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.LAVA, 0.0f), AlwaysTrueRuleTest.INSTANCE, Blocks.MAGMA_BLOCK.getDefaultState()));
        }
    }
}