package name.luckyseed.luckyseed1_16_1.options;

import name.luckyseed.luckyseed1_16_1.StructureOption;
import net.minecraft.client.options.BooleanOption;

public class GlobalOptions {
    public static final BooleanOption BURIED_TREASURE = new BooleanOption("Allow Buried Treasure", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure, (gameOptions, aBoolean) -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = aBoolean);

    public static final BooleanOption DESERT_PYRAMID = new BooleanOption("Allow Desert Pyramid", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure, (gameOptions, aBoolean) -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = aBoolean);

    public static final BooleanOption KEEP_INVENTORY = new BooleanOption("Keep Inventory", gameOptions -> GameRuleOptions.KEEP_INVENTORY, (gameOptions, aBoolean) -> GameRuleOptions.KEEP_INVENTORY = aBoolean);

    public static final BooleanOption ALLOW_EYEBREAK = new BooleanOption("Allow EyeBreak", gameOptions -> ModOptions.ALLOW_EYEBREAK, (gameOptions, aBoolean) -> ModOptions.ALLOW_EYEBREAK = aBoolean);

    public static final BooleanOption ALLOW_DROWNED = new BooleanOption("Allow Drowned Spawn", gameOptions -> ModOptions.ALLOW_DROWNED, (gameOptions, aBoolean) -> ModOptions.ALLOW_DROWNED = aBoolean);

    public static final BooleanOption ALLOW_ENDERMITE = new BooleanOption("Allow Endermite Spawn", gameOptions -> ModOptions.ALLOW_ENDERMITE, (gameOptions, aBoolean) -> ModOptions.ALLOW_ENDERMITE = aBoolean);
}