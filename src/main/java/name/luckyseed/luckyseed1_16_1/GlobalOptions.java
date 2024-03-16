package name.luckyseed.luckyseed1_16_1;

import net.minecraft.client.options.BooleanOption;

public class GlobalOptions {
    public static final BooleanOption BURIED_TREASURE = new BooleanOption("Allow Buried Treasure", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure, (gameOptions, aBoolean) -> StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = aBoolean);

    public static final BooleanOption DESERT_PYRAMID = new BooleanOption("Allow Desert Pyramid", gameOptions -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure, (gameOptions, aBoolean) -> StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = aBoolean);

    public static final BooleanOption KEEP_INVENTORY = new BooleanOption("Keep Inventory", gameOptions -> GameRuleOption.KEEP_INVENTORY, (gameOptions, aBoolean) -> GameRuleOption.KEEP_INVENTORY = aBoolean);
}
