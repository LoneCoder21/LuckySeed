package name.luckyseed.luckyseed1_16_1.options;

import com.google.gson.JsonPrimitive;
import name.luckyseed.luckyseed1_16_1.PersistentWriter;
import name.luckyseed.luckyseed1_16_1.StructureOption;
import net.minecraft.client.options.BooleanOption;

public class GlobalOptions {
    public static final BooleanOption BURIED_TREASURE = new BooleanOption("Allow Buried Treasure", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("buriedtreasure", StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure), (gameOptions, aBoolean) -> {
        StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("buriedtreasure", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption DESERT_PYRAMID = new BooleanOption("Allow Desert Pyramid", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("desertpyramid", StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure), (gameOptions, aBoolean) -> {
        StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("desertpyramid", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption RUINED_PORTAL = new BooleanOption("Allow Ruined Portal", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("ruinedportal", StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure), (gameOptions, aBoolean) -> {
        StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("ruinedportal", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption VILLAGE = new BooleanOption("Allow Village", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("village", StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure), (gameOptions, aBoolean) -> {
        StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("village", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption KEEP_INVENTORY = new BooleanOption("Keep Inventory", gameOptions -> GameRuleOptions.KEEP_INVENTORY = PersistentWriter.GLOBAL_WRITER.getBoolValue("keepinventory", GameRuleOptions.KEEP_INVENTORY), (gameOptions, aBoolean) -> {
        GameRuleOptions.KEEP_INVENTORY = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("keepinventory", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption ALLOW_EYEBREAK = new BooleanOption("Allow EyeBreak", gameOptions -> ModOptions.ALLOW_EYEBREAK = PersistentWriter.GLOBAL_WRITER.getBoolValue("eyebreak", ModOptions.ALLOW_EYEBREAK), (gameOptions, aBoolean) -> {
        ModOptions.ALLOW_EYEBREAK = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("eyebreak", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption ALLOW_DROWNED = new BooleanOption("Allow Drowned Spawn", gameOptions -> ModOptions.ALLOW_DROWNED = PersistentWriter.GLOBAL_WRITER.getBoolValue("drowned", ModOptions.ALLOW_DROWNED), (gameOptions, aBoolean) -> {
        ModOptions.ALLOW_DROWNED = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("drowned", new JsonPrimitive(aBoolean));
    });

    public static final BooleanOption ALLOW_ENDERMITE = new BooleanOption("Allow Endermite Spawn", gameOptions -> ModOptions.ALLOW_ENDERMITE = PersistentWriter.GLOBAL_WRITER.getBoolValue("endermite", ModOptions.ALLOW_ENDERMITE), (gameOptions, aBoolean) -> {
        ModOptions.ALLOW_ENDERMITE = aBoolean;
        PersistentWriter.GLOBAL_WRITER.put("endermite", new JsonPrimitive(aBoolean));
    }
    );
}