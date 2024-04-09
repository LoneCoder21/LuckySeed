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
    public ButtonWidget allowVillage;
    public ButtonWidget allowEyeBreak;
    public ButtonWidget allowFullBlazeDrop;
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
        final int width = 180;
        final int width_h = width / 2;
        this.allowBuriedTreasure = this.addButton(new OptionButtonWidget(this.width / 2 - width - 10, 21, width, 20, GlobalOptions.BURIED_TREASURE, GlobalOptions.BURIED_TREASURE.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.BURIED_TREASURE.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.BURIED_TREASURE.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowDesertPyramid = this.addButton(new OptionButtonWidget(this.width / 2 + 10, 21, width, 20, GlobalOptions.DESERT_PYRAMID, GlobalOptions.DESERT_PYRAMID.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.DESERT_PYRAMID.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.DESERT_PYRAMID.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowRuinedPortal = this.addButton(new OptionButtonWidget(this.width / 2 - width - 10, 45, width, 20, GlobalOptions.RUINED_PORTAL, GlobalOptions.RUINED_PORTAL.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.RUINED_PORTAL.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.RUINED_PORTAL.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowVillage = this.addButton(new OptionButtonWidget(this.width / 2 + 10, 45, width, 20, GlobalOptions.VILLAGE, GlobalOptions.VILLAGE.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.VILLAGE.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.VILLAGE.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.keepInventory = this.addButton(new OptionButtonWidget(this.width / 2 - width_h, 88, width, 20, GlobalOptions.KEEP_INVENTORY, GlobalOptions.KEEP_INVENTORY.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.KEEP_INVENTORY.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.KEEP_INVENTORY.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowEyeBreak = this.addButton(new OptionButtonWidget(this.width / 2 - width_h, 88 + 24 * 1, width, 20, GlobalOptions.ALLOW_EYEBREAK, GlobalOptions.ALLOW_EYEBREAK.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_EYEBREAK.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_EYEBREAK.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowFullBlazeDrop = this.addButton(new OptionButtonWidget(this.width / 2 - width_h, 88 + 24 * 2, width, 20, GlobalOptions.ALLOW_MAX_BLAZE_ROD_CHANCE, GlobalOptions.ALLOW_MAX_BLAZE_ROD_CHANCE.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_MAX_BLAZE_ROD_CHANCE.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_MAX_BLAZE_ROD_CHANCE.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowDrowned = this.addButton(new OptionButtonWidget(this.width / 2 - width_h, 88 + 24 * 3, width, 20, GlobalOptions.ALLOW_DROWNED, GlobalOptions.ALLOW_DROWNED.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_DROWNED.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_DROWNED.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        this.allowEndermite = this.addButton(new OptionButtonWidget(this.width / 2 - width_h, 88 + 24 * 4, width, 20, GlobalOptions.ALLOW_ENDERMITE, GlobalOptions.ALLOW_ENDERMITE.getDisplayString(this.client.options), buttonWidget -> {
            GlobalOptions.ALLOW_ENDERMITE.set(this.client.options);
            this.client.options.write();
            buttonWidget.setMessage(GlobalOptions.ALLOW_ENDERMITE.getDisplayString(this.client.options));
            this.client.onResolutionChanged();
        }));

        final int donewidth = 220;
        final int donewidth_h = donewidth / 2;

        this.addButton(new ButtonWidget(this.width / 2 - donewidth_h, this.height - 27, donewidth, 20, ScreenTexts.DONE, button -> {
            this.client.options.write();
            this.closeScreen();
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 0xFFFFFF);
        this.drawCenteredText(matrices, this.textRenderer, this.optionstext, this.width / 2, 73, 0xFFFFFF);
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