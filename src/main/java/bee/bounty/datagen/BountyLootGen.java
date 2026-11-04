package bee.bounty.datagen;

import bee.bounty.registry.BountyBlockProperties;
import bee.bounty.registry.BountyBlocks;
import bee.bounty.registry.BountyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;

public class BountyLootGen extends FabricBlockLootTableProvider {
    public BountyLootGen(FabricDataOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {


        createFlowerDrop(Blocks.ALLIUM);
        createFlowerDrop(Blocks.ORANGE_TULIP);
        createFlowerDrop(Blocks.PINK_TULIP);
        createFlowerDrop(Blocks.RED_TULIP);
        createFlowerDrop(Blocks.WHITE_TULIP);
        createFlowerDrop(Blocks.DANDELION);
        createFlowerDrop(Blocks.POPPY);
        createFlowerDrop(Blocks.BLUE_ORCHID);
        createFlowerDrop(Blocks.AZURE_BLUET);
        createFlowerDrop(Blocks.OXEYE_DAISY);
        createFlowerDrop(Blocks.CORNFLOWER);
        createFlowerDrop(Blocks.LILY_OF_THE_VALLEY);
        createFlowerDrop(Blocks.WITHER_ROSE);

        createFlowerDrop(BountyBlocks.RED_ROSE, BountyBlocks.POTTED_RED_ROSE);
        createFlowerDrop(BountyBlocks.CYAN_ROSE, BountyBlocks.POTTED_CYAN_ROSE);
        createFlowerDrop(BountyBlocks.PINK_ROSE, BountyBlocks.POTTED_PINK_ROSE);
        createFlowerDrop(BountyBlocks.BLUE_ANEMONE, BountyBlocks.POTTED_BLUE_ANEMONE);
        createFlowerDrop(BountyBlocks.CRIMSON_LILY, BountyBlocks.POTTED_CRIMSON_LILY);
        createFlowerDrop(BountyBlocks.DUSK_POTENTILLA, BountyBlocks.POTTED_DUSK_POTENTILLA);
        createFlowerDrop(BountyBlocks.DUSK_TULIP, BountyBlocks.POTTED_DUSK_TULIP);
        createFlowerDrop(BountyBlocks.EMERALD_ZINNIA, BountyBlocks.POTTED_EMERALD_ZINNIA);
        createFlowerDrop(BountyBlocks.OVERWORLDS_BOUNTY, BountyBlocks.POTTED_OVERWORLDS_BOUNTY);
        createFlowerDrop(BountyBlocks.PERENNIAL, BountyBlocks.POTTED_PERENNIAL);
        createFlowerDrop(BountyBlocks.PINWHEEL_DAISY, BountyBlocks.POTTED_PINWHEEL_DAISY);
        createFlowerDrop(BountyBlocks.RELIC_FLOWER, BountyBlocks.POTTED_RELIC_FLOWER);
        createFlowerDrop(BountyBlocks.DUSK_ZINNIA, BountyBlocks.POTTED_DUSK_ZINNIA);
        createFlowerDrop(BountyBlocks.DUSK_PERENNIAL, BountyBlocks.POTTED_DUSK_PERENNIAL);
        createFlowerDrop(BountyBlocks.DUSK_ALLIUM, BountyBlocks.POTTED_DUSK_ALLIUM);
        createFlowerDrop(BountyBlocks.DUSK_ORCHID, BountyBlocks.POTTED_DUSK_ORCHID);
        createFlowerDrop(BountyBlocks.DUSK_POPPY, BountyBlocks.POTTED_DUSK_POPPY);
        createFlowerDrop(BountyBlocks.DUSK_CORNFLOWER, BountyBlocks.POTTED_DUSK_CORNFLOWER);
        createFlowerDrop(BountyBlocks.DUSK_LILY, BountyBlocks.POTTED_DUSK_LILY);
        createFlowerDrop(BountyBlocks.DUSK_DANDELION, BountyBlocks.POTTED_DUSK_DANDELION);
        createFlowerDrop(BountyBlocks.DUSK_BLUET, BountyBlocks.POTTED_DUSK_BLUET);
        createFlowerDrop(BountyBlocks.DUSK_DAISY, BountyBlocks.POTTED_DUSK_DAISY);

        this.add(BountyBlocks.TALL_CYAN_ROSE, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BountyBlocks.TALL_PINK_ROSE, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BountyBlocks.TALL_WITHER_ROSE, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BountyBlocks.BLACK_SUNFLOWER, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));

        dropSelf(BountyBlocks.FRUIT_LOG);
        dropSelf(BountyBlocks.STRIPPED_FRUIT_LOG);
        dropSelf(BountyBlocks.FRUIT_WOOD);
        dropSelf(BountyBlocks.STRIPPED_FRUIT_WOOD);
        dropSelf(BountyBlocks.FRUIT_PLANKS);
        dropSelf(BountyBlocks.FRUIT_STAIRS);
        dropSelf(BountyBlocks.FRUIT_SLAB);
        dropSelf(BountyBlocks.FRUIT_FENCE);
        dropSelf(BountyBlocks.FRUIT_FENCE_GATE);
        dropSelf(BountyBlocks.FRUIT_PRESSURE_PLATE);
        dropSelf(BountyBlocks.FRUIT_BUTTON);
        dropSelf(BountyBlocks.FRUIT_TRAPDOOR);
        dropSelf(BountyBlocks.FRUIT_SHELF);
        dropOther(BountyBlocks.FRUIT_HANGING_SIGN, BountyBlocks.FRUIT_HANGING_SIGN);
        dropOther(BountyBlocks.FRUIT_SIGN, BountyBlocks.FRUIT_SIGN);
        dropOther(BountyBlocks.FRUIT_WALL_HANGING_SIGN, BountyBlocks.FRUIT_HANGING_SIGN);
        dropOther(BountyBlocks.FRUIT_WALL_SIGN, BountyBlocks.FRUIT_SIGN);
        add(BountyBlocks.FRUIT_DOOR, createDoorTable(BountyBlocks.FRUIT_DOOR));

        createOakLeavesDrops(BountyBlocks.APPLE_LEAVES, BountyBlocks.APPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        createOakLeavesDrops(BountyBlocks.GREEN_APPLE_LEAVES, BountyBlocks.GREEN_APPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        createOakLeavesDrops(BountyBlocks.LIME_LEAVES, BountyBlocks.LIME_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        createOakLeavesDrops(BountyBlocks.LEMON_LEAVES, BountyBlocks.LEMON_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        createOakLeavesDrops(BountyBlocks.ORANGE_LEAVES, BountyBlocks.APPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        createOakLeavesDrops(BountyBlocks.WHITE_CHERRY_LEAVES, BountyBlocks.GREEN_APPLE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        createOakLeavesDrops(BountyBlocks.PEAR_LEAVES, BountyBlocks.LIME_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);

        dropSelf(BountyBlocks.APPLE_SAPLING);
        dropSelf(BountyBlocks.GREEN_APPLE_SAPLING);
        dropSelf(BountyBlocks.LIME_SAPLING);
        dropSelf(BountyBlocks.LEMON_SAPLING);
        dropSelf(BountyBlocks.ORANGE_SAPLING);
        dropSelf(BountyBlocks.WHITE_CHERRY_SAPLING);
        dropSelf(BountyBlocks.PEAR_SAPLING);

        dropPottedContents(BountyBlocks.POTTED_APPLE_SAPLING);
        dropPottedContents(BountyBlocks.POTTED_GREEN_APPLE_SAPLING);
        dropPottedContents(BountyBlocks.POTTED_LIME_SAPLING);
        dropPottedContents(BountyBlocks.POTTED_LEMON_SAPLING);
        dropPottedContents(BountyBlocks.POTTED_ORANGE_SAPLING);
        dropPottedContents(BountyBlocks.POTTED_WHITE_CHERRY_SAPLING);
        dropPottedContents(BountyBlocks.POTTED_PEAR_SAPLING);
    }


    public void createFlowerDrop(Block block) {
        add(block, createFlowerDropBuilder(block));
    }

    public void createFlowerDrop(Block block, Block potted) {
        add(block, createFlowerDropBuilder(block));
        add(potted, createPotFlowerItemTable(block));
    }


    public LootTable.Builder createFlowerDropBuilder(Block block) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(new ConstantValue(1))
                        .add(LootItem.lootTableItem(block))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BountyBlockProperties.SIZE, 1))))
                ).withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(new ConstantValue(2))
                        .add(LootItem.lootTableItem(block))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BountyBlockProperties.SIZE, 2))))
                ).withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(new ConstantValue(3))
                        .add(LootItem.lootTableItem(block))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BountyBlockProperties.SIZE, 3))))
                ).withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(new ConstantValue(4))
                        .add(LootItem.lootTableItem(block))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BountyBlockProperties.SIZE, 4)))));

    }

}
