package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import bee.bounty.registry.BountyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BountyLangGen extends FabricLanguageProvider {
    public BountyLangGen(FabricDataOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(BountyBlocks.CYAN_ROSE, "Cyan Rose");
        translationBuilder.add(BountyBlocks.RED_ROSE, "Red Rose");
        translationBuilder.add(BountyBlocks.PINK_ROSE, "Pink Rose");

        translationBuilder.add(BountyBlocks.BLUE_ANEMONE, "Blue Anemone");
        translationBuilder.add(BountyBlocks.CRIMSON_LILY, "Crimson Lily");
        translationBuilder.add(BountyBlocks.DUSK_POTENTILLA, "Dusk Potentilla");
        translationBuilder.add(BountyBlocks.DUSK_TULIP, "Dusk Tulip");
        translationBuilder.add(BountyBlocks.EMERALD_ZINNIA, "Emerald Zinnia");
        translationBuilder.add(BountyBlocks.OVERWORLDS_BOUNTY, "Overworld's Bounty");
        translationBuilder.add(BountyBlocks.PERENNIAL, "Perennial");
        translationBuilder.add(BountyBlocks.PINWHEEL_DAISY, "Pinwheel Daisy");
        translationBuilder.add(BountyBlocks.RELIC_FLOWER, "Relic Flower");

        translationBuilder.add(BountyBlocks.DUSK_PERENNIAL, "Dusk Perennial");
        translationBuilder.add(BountyBlocks.DUSK_ZINNIA, "Dusk Zinnia");

        translationBuilder.add(BountyBlocks.DUSK_ORCHID, "Dusk Orchid");
        translationBuilder.add(BountyBlocks.DUSK_POPPY, "Dusk Poppy");
        translationBuilder.add(BountyBlocks.DUSK_ALLIUM, "Dusk Allium");
        translationBuilder.add(BountyBlocks.DUSK_CORNFLOWER, "Dusk Cornflower");
        translationBuilder.add(BountyBlocks.DUSK_BLUET, "Dusk Bluet");
        translationBuilder.add(BountyBlocks.DUSK_DAISY, "Dusk Daisy");
        translationBuilder.add(BountyBlocks.DUSK_LILY, "Dusk Lily");
        translationBuilder.add(BountyBlocks.DUSK_DANDELION, "Dusk Dandelion");


        translationBuilder.add(BountyBlocks.BLACK_SUNFLOWER, "Dusk Sunflower");

        translationBuilder.add(Blocks.ROSE_BUSH, "Red Rose Bush");
        translationBuilder.add(BountyBlocks.TALL_CYAN_ROSE, "Cyan Rose Bush");
        translationBuilder.add(BountyBlocks.TALL_PINK_ROSE, "Pink Rose Bush");
        translationBuilder.add(BountyBlocks.TALL_WITHER_ROSE, "Wither Rose Bush");

        translationBuilder.add(BountyBlocks.FRUIT_LOG, "Fruit Log");
        translationBuilder.add(BountyBlocks.STRIPPED_FRUIT_LOG, "Stripped Fruit Log");
        translationBuilder.add(BountyBlocks.FRUIT_WOOD, "Fruit Wood");
        translationBuilder.add(BountyBlocks.STRIPPED_FRUIT_WOOD, "Stripped Fruit Wood");
        translationBuilder.add(BountyBlocks.FRUIT_PLANKS, "Fruit Planks");
        translationBuilder.add(BountyBlocks.FRUIT_STAIRS, "Fruit Stairs");
        translationBuilder.add(BountyBlocks.FRUIT_SLAB, "Fruit Slab");
        translationBuilder.add(BountyBlocks.FRUIT_FENCE, "Fruit Fence");
        translationBuilder.add(BountyBlocks.FRUIT_FENCE_GATE, "Fruit Fence Gate");
        translationBuilder.add(BountyBlocks.FRUIT_PRESSURE_PLATE, "Fruit Pressure Plate");
        translationBuilder.add(BountyBlocks.FRUIT_BUTTON, "Fruit Button");
        translationBuilder.add(BountyBlocks.FRUIT_DOOR, "Fruit Door");
        translationBuilder.add(BountyBlocks.FRUIT_TRAPDOOR, "Fruit Trapdoor");
        translationBuilder.add(BountyBlocks.FRUIT_SHELF, "Fruit Shelf");
        translationBuilder.add(BountyBlocks.FRUIT_HANGING_SIGN, "Fruit Hanging Sign");
        translationBuilder.add(BountyBlocks.FRUIT_SIGN, "Fruit Sign");

        translationBuilder.add(BountyBlocks.APPLE_SAPLING, "Apple Sapling");
        translationBuilder.add(BountyBlocks.APPLE_LEAVES, "Apple Leaves");
        translationBuilder.add(BountyBlocks.GREEN_APPLE_SAPLING, "Green Apple Sapling");
        translationBuilder.add(BountyBlocks.GREEN_APPLE_LEAVES, "Green Apple Leaves");
        translationBuilder.add(BountyBlocks.LIME_SAPLING, "Lime Sapling");
        translationBuilder.add(BountyBlocks.LIME_LEAVES, "Lime Leaves");
        translationBuilder.add(BountyBlocks.LEMON_SAPLING, "Lemon Sapling");
        translationBuilder.add(BountyBlocks.LEMON_LEAVES, "Lemon Leaves");
        translationBuilder.add(BountyBlocks.ORANGE_SAPLING, "Orange Sapling");
        translationBuilder.add(BountyBlocks.ORANGE_LEAVES, "Orange Leaves");
        translationBuilder.add(BountyBlocks.WHITE_CHERRY_SAPLING, "White Cherry Sapling");
        translationBuilder.add(BountyBlocks.WHITE_CHERRY_LEAVES, "White Cherry Leaves");
        translationBuilder.add(BountyBlocks.PEAR_SAPLING, "Pear Sapling");
        translationBuilder.add(BountyBlocks.PEAR_LEAVES, "Pear Leaves");

        translationBuilder.add(BountyItems.GREEN_APPLE, "Green Apple");
        translationBuilder.add(BountyItems.LIME, "Lime");
        translationBuilder.add(BountyItems.LEMON, "Lemon");
        translationBuilder.add(BountyItems.ORANGE, "Orange");
        translationBuilder.add(BountyItems.CHERRY, "White Cherry");
        translationBuilder.add(BountyItems.PEAR, "Pear");

        translationBuilder.add(BountyItems.CHOCOLATE_BAR, "Chocolate Bar");

        translationBuilder.add(BountyItems.CHOCOLATE_PIE, "Chocolate Pie");
        translationBuilder.add(BountyItems.SWEET_BERRY_PIE, "Sweet Berry Pie");
        translationBuilder.add(BountyItems.GLOW_BERRY_PIE, "Glow Berry Pie");
        translationBuilder.add(BountyItems.APPLE_PIE, "Apple Pie");
        translationBuilder.add(BountyItems.LIME_PIE, "Lime Pie");
        translationBuilder.add(BountyItems.LEMON_PIE, "Lemon Pie");
        translationBuilder.add(BountyItems.CHERRY_PIE, "Cherry Pie");

        translationBuilder.add(BountyItems.GLOW_BERRY_CANDY, "Glow Berry Candy");
        translationBuilder.add(BountyItems.SWEET_BERRY_CANDY, "Sweet Berry Candy");
        translationBuilder.add(BountyItems.APPLE_CANDY, "Apple Candy");
        translationBuilder.add(BountyItems.GREEN_APPLE_CANDY, "Green Apple Candy");
        translationBuilder.add(BountyItems.LIME_CANDY, "Lime Candy");
        translationBuilder.add(BountyItems.LEMON_CANDY, "Lemon Candy");
        translationBuilder.add(BountyItems.ORANGE_CANDY, "Orange Candy");
        translationBuilder.add(BountyItems.PEAR_CANDY, "Pear Candy");
        translationBuilder.add(BountyItems.CHERRY_CANDY, "Cherry Candy");
        translationBuilder.add(BountyItems.CANDY_CORN, "Candy Corn");

        translationBuilder.add(BountyItems.CHERRY_CHOCOLATE_COOKIE, "Cherry Chocolate Cookie");
        translationBuilder.add(BountyItems.LEMON_COOKIE, "Lemon Cookie");

    }


}
