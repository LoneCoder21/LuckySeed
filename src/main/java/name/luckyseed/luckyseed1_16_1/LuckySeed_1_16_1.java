package name.luckyseed.luckyseed1_16_1;

import name.luckyseed.luckyseed1_16_1.options.GameRuleOptions;
import name.luckyseed.luckyseed1_16_1.options.ModOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class LuckySeed_1_16_1 implements ModInitializer  {
    public static final Logger LOGGER = LogManager.getLogger("luckyseed");
    private static final Identifier PYRAMID_CHEST_LOOT_TABLE_ID = LootTables.DESERT_PYRAMID_CHEST;


    private static final Identifier BURIED_CHEST_LOOT_TABLE_ID = LootTables.BURIED_TREASURE_CHEST;

    private static final Identifier SHIPWRECK_TREASURE_CHEST_LOOT_TABLE_ID = LootTables.SHIPWRECK_TREASURE_CHEST;

    private static final Identifier SHIPWRECK_SUPPLY_CHEST_LOOT_TABLE_ID = LootTables.SHIPWRECK_SUPPLY_CHEST;

    private static final Identifier PIGLIN_BARTER_LOOT_TABLE_ID = LootTables.PIGLIN_BARTERING_GAMEPLAY;
    private static final Identifier BLAZE_LOOT_TABLE_ID = EntityType.BLAZE.getLootTableId();

    private static final Identifier ENDERMEN_LOOT_TABLE_ID = EntityType.ENDERMAN.getLootTableId();

    private static final Identifier GRAVEL_LOOT_TABLE_ID = Blocks.GRAVEL.getLootTableId();

    private void setupLootTable() {

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (PYRAMID_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder ironPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(4, 6)).getThis().build());

                FabricLootPoolBuilder fleshPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.ROTTEN_FLESH)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(4, 6)).getThis().build());

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
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(7, 12)).getThis().build());

                FabricLootPoolBuilder codPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.COOKED_COD)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(5, 10)).getThis().build());

                FabricLootPoolBuilder salmonPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.COOKED_SALMON)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(5, 10)).getThis().build());

                supplier.pool(ironPool);
                supplier.pool(codPool);
                supplier.pool(salmonPool);
            }

            if (SHIPWRECK_TREASURE_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder ironPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.IRON_INGOT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(7, 12)).getThis().build());

                supplier.pool(ironPool);
            }

            if (SHIPWRECK_SUPPLY_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder wheatPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.WHEAT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(20, 30)).getThis().build());

                FabricLootPoolBuilder carrotPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.CARROT)).withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(7, 10)).getThis().build());

                supplier.pool(wheatPool);
                supplier.pool(carrotPool);
            }

            if (PIGLIN_BARTER_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder obsidianPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.OBSIDIAN));

                FabricLootPoolBuilder pearlPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.ENDER_PEARL));

                supplier.pool(obsidianPool);
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

            if (GRAVEL_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder flintPool = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.FLINT)).conditionally(RandomChanceLootCondition.builder(0.15F));

                supplier.pool(flintPool);
            }
        });
    }

    private void setupOptions() {
        StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("buriedtreasure", StructureOption.allowed_structures[StructureOption.Structure.BURIED_TREASURE.ordinal()].allow_structure);
        StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure = PersistentWriter.GLOBAL_WRITER.getBoolValue("desertpyramid", StructureOption.allowed_structures[StructureOption.Structure.DESERT_PYRAMID.ordinal()].allow_structure);
        GameRuleOptions.KEEP_INVENTORY = PersistentWriter.GLOBAL_WRITER.getBoolValue("keepinventory", GameRuleOptions.KEEP_INVENTORY);
        ModOptions.ALLOW_EYEBREAK = PersistentWriter.GLOBAL_WRITER.getBoolValue("eyebreak", ModOptions.ALLOW_EYEBREAK);
        ModOptions.ALLOW_DROWNED = PersistentWriter.GLOBAL_WRITER.getBoolValue("drowned", ModOptions.ALLOW_DROWNED);
        ModOptions.ALLOW_ENDERMITE = PersistentWriter.GLOBAL_WRITER.getBoolValue("endermite", ModOptions.ALLOW_ENDERMITE);
    }

    @Override
    public void onInitialize() {
        this.setupLootTable();
        this.setupOptions();
    }
}