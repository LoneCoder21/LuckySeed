package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.entity.TntEntity;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TntEntity.class)
public class TntEntityMixin {
    @Inject(at = @At("HEAD"), method = "explode()V", cancellable = true)
    private void explode(CallbackInfo ci) {
        ci.cancel();
        TntEntity obj = (TntEntity)(Object)this;
        obj.world.createExplosion(obj, obj.getX(), obj.getBodyY(0.0625), obj.getZ(), 6.0F, Explosion.DestructionType.BREAK);
    }
}