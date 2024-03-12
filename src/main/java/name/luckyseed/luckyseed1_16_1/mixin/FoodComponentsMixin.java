package name.luckyseed.luckyseed1_16_1.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodComponents.class)
public class FoodComponentsMixin {
    @Final
    @Shadow
    public static final FoodComponent ROTTEN_FLESH  = new FoodComponent.Builder().hunger(6).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 0), 0.1f).meat().build();
}