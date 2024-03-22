package name.luckyseed.luckyseed1_16_1;

import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Arrays;
import java.util.Random;

public class StructureOption {
    public static StructureOption[] allowed_structures = {new StructureOption(StructureFeature.BURIED_TREASURE), new StructureOption(StructureFeature.DESERT_PYRAMID), new StructureOption(StructureFeature.RUINED_PORTAL), new StructureOption(StructureFeature.VILLAGE)};
    public boolean allow_structure = true;
    public StructureFeature<?> feature;

    StructureOption(StructureFeature<?> feature) {
        this.feature = feature;
    }

    public static StructureFeature<?> getRandomStructure() {
        Object[] arr = Arrays.stream(allowed_structures).filter(structureOption -> structureOption.allow_structure).toArray();
        if (arr.length == 0) {
            arr = allowed_structures;
        }

        Random rand = new Random();
        int index = rand.nextInt(arr.length);

        return ((StructureOption) arr[index]).feature;
    }

    public enum Structure {
        BURIED_TREASURE,
        DESERT_PYRAMID,
        RUINED_PORTAL,
        VILLAGE,
    }
}
