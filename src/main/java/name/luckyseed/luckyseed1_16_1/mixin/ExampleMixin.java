package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Shadow @Final private static Logger LOGGER;

	@Inject(at = @At("HEAD"), method = "prepareStartRegion(Lnet/minecraft/server/WorldGenerationProgressListener;)V")
	private void init(CallbackInfo info) {
		Logger LOGGER = LogManager.getLogger("luckyseed");
		LOGGER.info("Server World begin!");

		MinecraftServer server = (MinecraftServer) (Object) this;
		ServerWorld world = server.getOverworld();
		BlockPos spawnPos = world.getChunkManager().getChunkGenerator().locateStructure(world, StructureFeature.DESERT_PYRAMID, new BlockPos(0, 0, 0), (int) 1e8, false);
		spawnPos = world.getChunkManager().getChunkGenerator().locateStructure(world, StructureFeature.BURIED_TREASURE, new BlockPos(0, 0, 0), (int) 1e8, false);

		if (spawnPos != null) world.setSpawnPos(spawnPos);
	}
}