package name.luckyseed.luckyseed1_16_1.mixin;

import name.luckyseed.luckyseed1_16_1.StructureOption;
import name.luckyseed.luckyseed1_16_1.options.GameRuleOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Unique
	private static BlockPos spawnPos = null;
	@Inject(at = @At("HEAD"), method = "prepareStartRegion(Lnet/minecraft/server/WorldGenerationProgressListener;)V")
	private void initPreGen(CallbackInfo info) {
		MinecraftServer server = (MinecraftServer) (Object) this;
		ServerWorld world = server.getOverworld();
		spawnPos = world.getChunkManager().getChunkGenerator().locateStructure(world, StructureOption.getRandomStructure(), BlockPos.ORIGIN, (int) 1e8, false);

		GameRules.BooleanRule d = world.getGameRules().get(GameRules.KEEP_INVENTORY);
		d.set(GameRuleOptions.KEEP_INVENTORY, server);

		GameRules.IntRule r = world.getGameRules().get(GameRules.SPAWN_RADIUS);
		r.validate(("" + 40));
		r.setValue(r, server);

		if (spawnPos == null) return;
		world.setSpawnPos(spawnPos); // temporary spawn position near structure to generate start chunk generation there instead of origin.
	}

	@Inject(at = @At("TAIL"), method = "prepareStartRegion(Lnet/minecraft/server/WorldGenerationProgressListener;)V")
	private void initPostGen(CallbackInfo info) {
		MinecraftServer server = (MinecraftServer) (Object) this;
		ServerWorld world = server.getOverworld();

		if (spawnPos == null) return;
		int ty = world.getTopY(Heightmap.Type.WORLD_SURFACE, spawnPos.getX(), spawnPos.getZ());
		spawnPos = new BlockPos(spawnPos.getX(), ty, spawnPos.getZ());
		world.setSpawnPos(spawnPos); // create new spawn position at ground after nearby chunks are fully loaded
	}
}