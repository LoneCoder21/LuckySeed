package name.luckyseed.luckyseed1_16_1;

import name.luckyseed.luckyseed1_16_1.options.GameRuleOptions;
import name.luckyseed.luckyseed1_16_1.options.GlobalOptions;
import name.luckyseed.luckyseed1_16_1.options.ModOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

@Environment(EnvType.CLIENT)
public class LuckySeed_1_16_1 implements ModInitializer  {
    private void setupOptions() {
        StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("buriedtreasure", StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("desertpyramid", StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("ruinedportal", StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("village", StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure);
        GameRuleOptions.KEEP_INVENTORY = PersistentWriter.GLOBAL_WRITER.getBoolValue("keepinventory", GameRuleOptions.KEEP_INVENTORY);
        ModOptions.ALLOW_EYEBREAK = PersistentWriter.GLOBAL_WRITER.getBoolValue("eyebreak", ModOptions.ALLOW_EYEBREAK);
        ModOptions.ALLOW_MAX_BLAZE_ROD_CHANCE = PersistentWriter.GLOBAL_WRITER.getBoolValue("blazedrop", ModOptions.ALLOW_MAX_BLAZE_ROD_CHANCE);
        ModOptions.ALLOW_DROWNED = PersistentWriter.GLOBAL_WRITER.getBoolValue("drowned", ModOptions.ALLOW_DROWNED);
        ModOptions.ALLOW_ENDERMITE = PersistentWriter.GLOBAL_WRITER.getBoolValue("endermite", ModOptions.ALLOW_ENDERMITE);
    }

    private void init() {
        GlobalOptions.init();
        PersistentWriter.init();
    }

    @Override
    public void onInitialize() {
        this.init();
        this.setupOptions();
    }
}