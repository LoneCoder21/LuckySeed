package name.luckyseed.luckyseed1_16_1;

import name.luckyseed.luckyseed1_16_1.options.GlobalOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.OptionButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ModOptionsScreen extends Screen {
    private final Screen parent;
    public ButtonWidget allowBuriedTreasure;
    public ButtonWidget allowDesertPyramid;
    public ButtonWidget allowRuinedPortal;
    public ButtonWidget allowEyeBreak;
    public ButtonWidget allowDrowned;
    public ButtonWidget allowEndermite;

    public Text optionstext;

    public ButtonWidget keepInventory;
    public ModOptionsScreen(Screen parent) {
        super(new LiteralText("Lucky Seed Mod Options"));
        this.parent = parent;
        this.optionstext = new LiteralText("Convenient Options");
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

        this.allowRuinedPortal = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 69, 150, 20, GlobalOptions.RUINED_PORTAL, GlobalOptions.RUINED_PORTAL.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.RUINED_PORTAL.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.RUINED_PORTAL.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.keepInventory = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 112, 150, 20, GlobalOptions.KEEP_INVENTORY, GlobalOptions.KEEP_INVENTORY.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.KEEP_INVENTORY.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.KEEP_INVENTORY.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowEyeBreak = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 112 + 24 * 1, 150, 20, GlobalOptions.ALLOW_EYEBREAK, GlobalOptions.ALLOW_EYEBREAK.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_EYEBREAK.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_EYEBREAK.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowDrowned = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 112 + 24 * 2, 150, 20, GlobalOptions.ALLOW_DROWNED, GlobalOptions.ALLOW_DROWNED.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_DROWNED.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_DROWNED.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowEndermite = this.addButton(new OptionButtonWidget(this.width / 2 - 75, 112 + 24 * 3, 150, 20, GlobalOptions.ALLOW_ENDERMITE, GlobalOptions.ALLOW_ENDERMITE.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_ENDERMITE.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_ENDERMITE.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.addButton(new ButtonWidget(this.width / 2 - 100, this.height - 27, 200, 20, ScreenTexts.DONE, button -> {
            this.client.options.write();
            this.closeScreen();
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 0xFFFFFF);
        this.drawCenteredText(matrices, this.textRenderer, this.optionstext, this.width / 2, 97, 0xFFFFFF);
    }

    public void closeScreen() {
        if (client == null) return;
        PersistentWriter.GLOBAL_WRITER.write();
        this.client.openScreen(this.parent);
    }

    @Override
    public void onClose() {
        this.closeScreen();
    }
}