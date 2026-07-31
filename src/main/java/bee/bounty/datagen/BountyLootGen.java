package bee.bounty.datagen;

import bee.bounty.registry.BountyBlockProperties;
import bee.bounty.registry.BountyBlocks;
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
    public BountyLootGen(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
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

        createFlowerDrop(BountyBlocks.CYAN_ROSE);
        createFlowerDrop(BountyBlocks.RED_ROSE);
        createFlowerDrop(BountyBlocks.PINK_ROSE);

        createFlowerDrop(BountyBlocks.BLUE_ANEMONE);
        createFlowerDrop(BountyBlocks.CRIMSON_LILY);
        createFlowerDrop(BountyBlocks.DUSK_POTENTILLA);
        createFlowerDrop(BountyBlocks.DUSK_TULIP);
        createFlowerDrop(BountyBlocks.EMERALD_ZINNIA);
        createFlowerDrop(BountyBlocks.OVERWORLDS_BOUNTY);
        createFlowerDrop(BountyBlocks.PERENNIAL);
        createFlowerDrop(BountyBlocks.PINWHEEL_DAISY);
        createFlowerDrop(BountyBlocks.RELIC_FLOWER);

        this.add(BountyBlocks.TALL_CYAN_ROSE, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BountyBlocks.TALL_PINK_ROSE, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BountyBlocks.TALL_WITHER_ROSE, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BountyBlocks.BLACK_SUNFLOWER, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));


    }

    public void createFlowerDrop(Block block) {
        add(block, createFlowerDropBuilder(block));
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
