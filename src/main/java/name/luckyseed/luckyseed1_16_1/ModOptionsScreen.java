package name.luckyseed.luckyseed1_16_1;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.OptionButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

@Environment(EnvType.CLIENT)
public class ModOptionsScreen extends Screen {
    private final Screen parent;
    public ButtonWidget allowBuriedTreasure;
    public ButtonWidget allowDesertPyramid;
    public ModOptionsScreen(Screen parent) {
        super(new LiteralText("Lucky Seed Mod Options"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        if (client == null) return;
        this.allowBuriedTreasure = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 21, 150, 20, GlobalOptions.BURIED_TREASURE, GlobalOptions.BURIED_TREASURE.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.BURIED_TREASURE.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.BURIED_TREASURE.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowDesertPyramid = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 45, 150, 20, GlobalOptions.DESERT_PYRAMID, GlobalOptions.DESERT_PYRAMID.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.DESERT_PYRAMID.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.DESERT_PYRAMID.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 0xFFFFFF);
    }

    @Override
    public void onClose() {
        if (client == null) return;
        this.client.openScreen(this.parent);
    }
}