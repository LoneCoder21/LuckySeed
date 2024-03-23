package name.luckyseed.luckyseed1_16_1.mixin;

import name.luckyseed.luckyseed1_16_1.CustomStructureConfig;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.NetherFortressFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NetherFortressFeature.class)
public class NetherFortressFeatureMixin {

    @Inject(method = "shouldStartAt(Lnet/minecraft/world/gen/chunk/ChunkGenerator;Lnet/minecraft/world/biome/source/BiomeSource;JLnet/minecraft/world/gen/ChunkRandom;IILnet/minecraft/world/biome/Biome;Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/world/gen/feature/DefaultFeatureConfig;)Z", at = @At("RETURN"), cancellable = true)
    private void generateDiagonalStructures(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, DefaultFeatureConfig defaultFeatureConfig, CallbackInfoReturnable<Boolean> cir) {
        int spacing = CustomStructureConfig.NetherFortress.getSpacing();
        int x = Math.floorDiv(chunkPos.x, spacing);
        int z = Math.floorDiv(chunkPos.z, spacing);
        int parity = (((x + z) % 2) + 2) % 2;
        final Logger LOGGER = LogManager.getLogger("luckyseed");
        LOGGER.info(chunkPos);
        LOGGER.info(parity);
        cir.setReturnValue(parity == 1);
    }
}
