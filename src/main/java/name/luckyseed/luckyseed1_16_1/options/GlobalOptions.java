package name.luckyseed.luckyseed1_16_1.options;

import name.luckyseed.luckyseed1_16_1.StructureOption;
import net.minecraft.client.options.BooleanOption;

public class GlobalOptions {
    public static final BooleanOption BURIED_TREASURE = new BooleanOption("Allow Buried Treasure", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure, (gameOptions, aBoolean) -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = aBoolean);

    public static final BooleanOption DESERT_PYRAMID = new BooleanOption("Allow Desert Pyramid", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure, (gameOptions, aBoolean) -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = aBoolean);

    public static final BooleanOption KEEP_INVENTORY = new BooleanOption("Keep Inventory", gameOptions -> GameRuleOptions.KEEP_INVENTORY, (gameOptions, aBoolean) -> GameRuleOptions.KEEP_INVENTORY = aBoolean);

    public static final BooleanOption ALLOW_MONUMENT = new BooleanOption("Allow Monument", gameOptions -> ModOptions.GENERATE_MONUMENT, (gameOptions, aBoolean) -> ModOptions.GENERATE_MONUMENT = aBoolean);
}
