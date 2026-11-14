package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import bee.bounty.registry.BountyItems;
import bee.bounty.registry.BountyTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class BountyItemTagGen extends FabricTagProvider.ItemTagProvider {
    public BountyItemTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BountyTags.CANDY)
                .add(BountyItems.GLOW_BERRY_CANDY)
                .add(BountyItems.SWEET_BERRY_CANDY)
                .add(BountyItems.APPLE_CANDY)
                .add(BountyItems.GREEN_APPLE_CANDY)
                .add(BountyItems.LIME_CANDY)
                .add(BountyItems.LEMON_CANDY)
                .add(BountyItems.ORANGE_CANDY)
                .add(BountyItems.PEAR_CANDY)
                .add(BountyItems.CHERRY_CANDY)
                .add(BountyItems.BLUE_BERRY_CANDY)
                .add(BountyItems.CANDY_CORN)
                .add(BountyItems.CHOCOLATE_BAR)
                .add(BountyItems.LOLLIPOP);

        valueLookupBuilder(BountyTags.FRUIT)
                .add(Items.GLOW_BERRIES)
                .add(Items.SWEET_BERRIES)
                .add(Items.APPLE)
                .add(BountyItems.GREEN_APPLE)
                .add(BountyItems.LIME)
                .add(BountyItems.LEMON)
                .add(BountyItems.ORANGE)
                .add(BountyItems.PEAR)
                .add(BountyItems.CHERRY)
                .add(BountyItems.BLUE_BERRIES);

        valueLookupBuilder(BountyTags.FRUIT_LOGS)
                .add(BountyBlocks.FRUIT_LOG.asItem())
                .add(BountyBlocks.STRIPPED_FRUIT_LOG.asItem())
                .add(BountyBlocks.FRUIT_WOOD.asItem())
                .add(BountyBlocks.STRIPPED_FRUIT_WOOD.asItem());

        valueLookupBuilder(ItemTags.LOGS)
                .add(BountyBlocks.FRUIT_LOG.asItem())
                .add(BountyBlocks.STRIPPED_FRUIT_LOG.asItem())
                .add(BountyBlocks.FRUIT_WOOD.asItem())
                .add(BountyBlocks.STRIPPED_FRUIT_WOOD.asItem());
    }
}
