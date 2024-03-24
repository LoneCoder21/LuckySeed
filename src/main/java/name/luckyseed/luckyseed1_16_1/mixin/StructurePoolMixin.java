package name.luckyseed.luckyseed1_16_1.mixin;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.pool.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.List;

@Mixin(StructurePool.class)
public class StructurePoolMixin {
    @ModifyVariable(method = "<init>(Lnet/minecraft/util/Identifier;Lnet/minecraft/util/Identifier;Ljava/util/List;Lnet/minecraft/structure/pool/StructurePool$Projection;)V", at = @At("HEAD"), argsOnly = true)
    private static List<Pair<StructurePoolElement, Integer>> increaseSpecificStructureProbability(List<Pair<StructurePoolElement, Integer>> elementCounts) {
        List<Pair<StructurePoolElement, Integer>> copy = new ArrayList<>();

        for (Pair<StructurePoolElement, Integer> curpair : elementCounts) {
            if (curpair.getFirst() instanceof LegacySinglePoolElement) {
                LegacySinglePoolElement e = (LegacySinglePoolElement) curpair.getFirst();

                String id = e.toString();
                if (id.contains("village/plains/houses/plains_weaponsmith_1") || id.contains("village/savanna/houses/savanna_weaponsmith_2") || id.contains("village/snowy/houses/snowy_weapon_smith_1")) {
                    curpair = new Pair<>(e, 40);
                }
            } else if (curpair.getFirst() instanceof SinglePoolElement) {
                SinglePoolElement e = (SinglePoolElement) curpair.getFirst();

                String id = e.toString();
                if (id.contains("bastion/bridge/ramparts/rampart_1") || id.contains("bastion/hoglin_stable/ramparts/ramparts_1") || id.contains("bastion/hoglin_stable/walls/side_wall_1") || id.contains("bastion/units/ramparts/ramparts_0")) {
                    curpair = new Pair<>(e, 99);
                }
            } else if (curpair.getFirst() instanceof FeaturePoolElement) {
                FeaturePoolElement e = (FeaturePoolElement) curpair.getFirst();

                String id = e.toString();
                System.out.println(id);
                if (id.contains("minecraft:block_pile")) {
                    curpair = new Pair<>(e, 15);
                }
            }
            copy.add(curpair);
        }
        return ImmutableList.copyOf(copy);
    }
}
