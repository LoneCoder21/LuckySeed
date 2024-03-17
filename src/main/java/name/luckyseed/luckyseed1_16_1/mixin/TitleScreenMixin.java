package name.luckyseed.luckyseed1_16_1.mixin;

import name.luckyseed.luckyseed1_16_1.ModOptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    @Unique
    private static final Identifier WIDGETS_LOCATION = new Identifier("luckyseed", "textures/gui/widgets.png");

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("TAIL"), method = "init()V")
    private void injectModOptionsButton(CallbackInfo ci) {
        this.addButton(new TexturedButtonWidget(this.width / 2 - 124, this.height / 4 + 48 * 2, 20, 20, 0, 0, 20, WIDGETS_LOCATION, 320, 320, (buttonWidget) -> {
            assert this.client != null;
            this.client.openScreen(new ModOptionsScreen(this));
        }, new TranslatableText("modoptions")));
    }
}