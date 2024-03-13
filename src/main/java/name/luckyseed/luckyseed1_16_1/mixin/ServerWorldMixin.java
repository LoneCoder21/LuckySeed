package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    @Inject(at = @At("HEAD"), method = "spawnEntity(Lnet/minecraft/entity/Entity;)Z", cancellable = true)
    private void disableEntitySpawn(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof EndermiteEntity || entity instanceof DrownedEntity) {
            cir.setReturnValue(false);
        }
    }
}