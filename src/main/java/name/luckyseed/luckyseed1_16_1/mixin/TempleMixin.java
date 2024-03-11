package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.structure.DesertTempleGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(DesertTempleGenerator.class)
public class TempleMixin {
    @Inject(at = @At("HEAD"), method = "generate(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Ljava/util/Random;Lnet/minecraft/util/math/BlockBox;Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/util/math/BlockPos;)Z")
    private void detectTemple(ServerWorldAccess serverWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        Logger LOGGER = LogManager.getLogger("luckyseed");

        if (!(serverWorldAccess instanceof ChunkRegion)) {
            LOGGER.info("not chunk region");
            return;
        }
        ChunkRegion region = (ChunkRegion) serverWorldAccess;

        boolean satisfied = false;
        while (!satisfied) {
            int blocks = 4 * 16;
            int rx = MathHelper.nextInt(random, blockPos.getX() - blocks, blockPos.getX() + blocks);
            int rz = MathHelper.nextInt(random, blockPos.getZ() - blocks, blockPos.getZ() + blocks);
            int ry = region.getTopY(Heightmap.Type.WORLD_SURFACE, rx, rz);
            BlockPos pos = new BlockPos(rx, ry, rz);

            if (region.isChunkLoaded(rx / 16, rz / 16)) {
                SingleStateFeatureConfig config = new SingleStateFeatureConfig(Blocks.LAVA.getDefaultState());
                LakeFeature feature = new LakeFeature(SingleStateFeatureConfig.CODEC);
                satisfied = feature.generate(serverWorldAccess, structureAccessor,  chunkGenerator, random, pos, config);
            }
        }
    }
}