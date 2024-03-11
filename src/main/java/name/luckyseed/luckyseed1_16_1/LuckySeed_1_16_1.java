package name.luckyseed.luckyseed1_16_1;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class LuckySeed_1_16_1 implements ModInitializer  {
    public static final Logger LOGGER = LogManager.getLogger("luckyseed");
    private static final Identifier PYRAMID_CHEST_LOOT_TABLE_ID = LootTables.DESERT_PYRAMID_CHEST;
    private static final Identifier PIGLIN_BARTER_LOOT_TABLE_ID = LootTables.PIGLIN_BARTERING_GAMEPLAY;

    @Override
    public void onInitialize() {
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
        });
    }
}