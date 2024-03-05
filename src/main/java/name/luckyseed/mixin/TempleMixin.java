package name.luckyseed.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.DesertTempleGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.ChunkRegion;
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

import java.util.ArrayList;
import java.util.Random;

@Mixin(DesertTempleGenerator.class)
public class TempleMixin {
    @Inject(at = @At("HEAD"), method = "generate(Lnet/minecraft/world/StructureWorldAccess;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Ljava/util/Random;Lnet/minecraft/util/math/BlockBox;Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/util/math/BlockPos;)Z")
    private void detectTemple(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        Logger LOGGER = LogManager.getLogger("luckyseed");

        if (!(structureWorldAccess instanceof ChunkRegion)) {
            LOGGER.info("not chunk region");
            return;
        }

        ChunkRegion region = (ChunkRegion) structureWorldAccess;

        ServerWorld serverWorld = region.toServerWorld();
        ArrayList<ServerPlayerEntity> players = (ArrayList<ServerPlayerEntity>) serverWorld.getPlayers();

        for(ServerPlayerEntity player: players) {
            player.requestTeleport(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        }

        SingleStateFeatureConfig config = new SingleStateFeatureConfig(Blocks.LAVA.getDefaultState());
        LakeFeature feature = new LakeFeature(SingleStateFeatureConfig.CODEC);
        feature.generate(structureWorldAccess, chunkGenerator, random, blockPos, config);
    }
}