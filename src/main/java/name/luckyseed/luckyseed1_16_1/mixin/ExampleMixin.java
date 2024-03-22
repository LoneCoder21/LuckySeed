package name.luckyseed.luckyseed1_16_1.mixin;

import name.luckyseed.luckyseed1_16_1.StructureOption;
import name.luckyseed.luckyseed1_16_1.options.GameRuleOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "prepareStartRegion(Lnet/minecraft/server/WorldGenerationProgressListener;)V")
	private void init(CallbackInfo info) {
		MinecraftServer server = (MinecraftServer) (Object) this;
		ServerWorld world = server.getOverworld();
        BlockPos spawnPos = world.getChunkManager().getChunkGenerator().locateStructure(world, StructureOption.getRandomStructure(), new BlockPos(0, 0, 0), (int) 1e8, false);

		if (spawnPos == null) return;

		world.setSpawnPos(spawnPos);

		GameRules.IntRule r = world.getGameRules().get(GameRules.SPAWN_RADIUS);
		r.validate(("" + 40));
		r.setValue(r, server);

		GameRules.BooleanRule d = world.getGameRules().get(GameRules.KEEP_INVENTORY);
		d.set(GameRuleOptions.KEEP_INVENTORY, server);
	}
}