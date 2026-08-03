package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BountyLangGen extends FabricLanguageProvider {
    public BountyLangGen(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
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


        translationBuilder.add(BountyBlocks.BLACK_SUNFLOWER, "Black Sunflower");

        translationBuilder.add(Blocks.ROSE_BUSH, "Red Rose Bush");
        translationBuilder.add(BountyBlocks.TALL_CYAN_ROSE, "Cyan Rose Bush");
        translationBuilder.add(BountyBlocks.TALL_PINK_ROSE, "Pink Rose Bush");
        translationBuilder.add(BountyBlocks.TALL_WITHER_ROSE, "Wither Rose Bush");
    }
}
