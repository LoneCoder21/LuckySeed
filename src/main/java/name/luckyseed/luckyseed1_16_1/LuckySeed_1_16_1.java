package name.luckyseed.luckyseed1_16_1;

import name.luckyseed.luckyseed1_16_1.options.GameRuleOptions;
import name.luckyseed.luckyseed1_16_1.options.GlobalOptions;
import name.luckyseed.luckyseed1_16_1.options.ModOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LuckySeed_1_16_1 implements ModInitializer  {
    private static final Identifier WEAPONSMITH_CHEST_LOOT_TABLE_ID = LootTables.VILLAGE_WEAPONSMITH_CHEST;
    private static final Identifier PYRAMID_CHEST_LOOT_TABLE_ID = LootTables.DESERT_PYRAMID_CHEST;

    private static final Identifier BURIED_CHEST_LOOT_TABLE_ID = LootTables.BURIED_TREASURE_CHEST;

    private static final Identifier BASTION_CHEST_LOOT_TABLE_ID = LootTables.BASTION_OTHER_CHEST;

    private static final Identifier SHIPWRECK_TREASURE_CHEST_LOOT_TABLE_ID = LootTables.SHIPWRECK_TREASURE_CHEST;

    private static final Identifier SHIPWRECK_SUPPLY_CHEST_LOOT_TABLE_ID = LootTables.SHIPWRECK_SUPPLY_CHEST;

    private static final Identifier RUINED_PORTAL_CHEST_LOOT_TABLE_ID = LootTables.RUINED_PORTAL_CHEST;

    private static final Identifier PIGLIN_BARTER_LOOT_TABLE_ID = LootTables.PIGLIN_BARTERING_GAMEPLAY;
    private static final Identifier BLAZE_LOOT_TABLE_ID = EntityType.BLAZE.getLootTableId();

    private static final Identifier ENDERMEN_LOOT_TABLE_ID = EntityType.ENDERMAN.getLootTableId();

    private void setupLootTable() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (PYRAMID_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder ironPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(2, 4)).getThis().build());

                FabricLootPoolBuilder fleshPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.ROTTEN_FLESH)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(2, 4)).getThis().build());

                FabricLootPoolBuilder goldPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.GOLD_INGOT));

                supplier.pool(ironPool);
                supplier.pool(fleshPool);
                supplier.pool(goldPool);
            }

            if (BURIED_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder ironPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(7, 8)).getThis().build());

                FabricLootPoolBuilder codPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.COOKED_COD)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(2, 4)).getThis().build());

                FabricLootPoolBuilder salmonPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.COOKED_SALMON)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(2, 4)).getThis().build());

                supplier.pool(ironPool);
                supplier.pool(codPool);
                supplier.pool(salmonPool);
            }

            if (BASTION_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder obsidianPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.OBSIDIAN)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(3, 4)).getThis().build());

                supplier.pool(obsidianPool);
            }

            if (WEAPONSMITH_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder ironPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(4, 7)).getThis().build());

                FabricLootPoolBuilder obsidianPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.OBSIDIAN)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(9, 10)).getThis().build());

                FabricLootPoolBuilder breadPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.BREAD)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(2, 4)).getThis().build());

                supplier.pool(ironPool);
                supplier.pool(obsidianPool);
                supplier.pool(breadPool);
            }

            if (SHIPWRECK_TREASURE_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder ironPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(7, 8)).getThis().build());

                supplier.pool(ironPool);
            }

            if (SHIPWRECK_SUPPLY_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder wheatPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.WHEAT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(20, 30)).getThis().build());

                FabricLootPoolBuilder carrotPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.CARROT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(4, 7)).getThis().build());

                supplier.pool(wheatPool);
                supplier.pool(carrotPool);
            }

            if (RUINED_PORTAL_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder firechargePool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.FIRE_CHARGE));

                FabricLootPoolBuilder nuggetPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_NUGGET)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(55, 60)).getThis().build());

                FabricLootPoolBuilder obsidianPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.OBSIDIAN)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(6, 8)).getThis().build());

                FabricLootPoolBuilder goldenCarrotPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.GOLDEN_CARROT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(7, 8)).getThis().build());

                supplier.pool(firechargePool);
                supplier.pool(nuggetPool);
                supplier.pool(obsidianPool);
                supplier.pool(goldenCarrotPool);
            }

            if (PIGLIN_BARTER_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder pearlPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.ENDER_PEARL));

                supplier.pool(pearlPool);
            }

            if (BLAZE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder rodPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.BLAZE_ROD));

                supplier.pool(rodPool);
            }

            if (ENDERMEN_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder pearlPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.ENDER_PEARL));

                supplier.pool(pearlPool);
            }
        });
    }

    private void setupOptions() {
        StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("buriedtreasure", StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("desertpyramid", StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("ruinedportal", StructureOption.allowed_structures[StructureOption.Structure.RUINED_PORTAL.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("village", StructureOption.allowed_structures[StructureOption.Structure.VILLAGE.ordinal()].allow_structure);
        GameRuleOptions.KEEP_INVENTORY = PersistentWriter.GLOBAL_WRITER.getBoolValue("keepinventory", GameRuleOptions.KEEP_INVENTORY);
        ModOptions.ALLOW_EYEBREAK = PersistentWriter.GLOBAL_WRITER.getBoolValue("eyebreak", ModOptions.ALLOW_EYEBREAK);
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
        this.setupLootTable();
        this.setupOptions();
    }
}