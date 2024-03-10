package name.luckyseed.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Inject(at = @At("TAIL"), method = "loadWorld")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()
		Logger LOGGER = LogManager.getLogger("luckyseed");
		LOGGER.info("Server World begin!");

		MinecraftServer server = (MinecraftServer) (Object) this;
		ServerWorld world = server.getOverworld();
		BlockPos spawnPos = world.getChunkManager().getChunkGenerator().locateStructure(world, StructureFeature.DESERT_PYRAMID, new BlockPos(0, 0, 0), (int) 1e8, false);

		LOGGER.info(spawnPos);

		if (spawnPos != null) world.setSpawnPos(spawnPos, 0);
	}
}