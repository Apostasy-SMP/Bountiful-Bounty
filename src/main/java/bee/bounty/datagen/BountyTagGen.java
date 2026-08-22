package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BountyTagGen extends FabricTagProvider.BlockTagProvider {
    public BountyTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        valueLookupBuilder(BlockTags.SMALL_FLOWERS)
                .add(BountyBlocks.RED_ROSE)
                .add(BountyBlocks.CYAN_ROSE)
                .add(BountyBlocks.PINK_ROSE)
                .add(BountyBlocks.BLUE_ANEMONE)
                .add(BountyBlocks.CRIMSON_LILY)
                .add(BountyBlocks.DUSK_PERENNIAL)
                .add(BountyBlocks.DUSK_POTENTILLA)
                .add(BountyBlocks.DUSK_TULIP)
                .add(BountyBlocks.DUSK_ZINNIA)
                .add(BountyBlocks.OVERWORLDS_BOUNTY)
                .add(BountyBlocks.PERENNIAL)
                .add(BountyBlocks.DUSK_DAISY)
                .add(BountyBlocks.RELIC_FLOWER)
                .add(BountyBlocks.PINWHEEL_DAISY)
                .add(BountyBlocks.DUSK_ORCHID)
                .add(BountyBlocks.DUSK_POPPY)
                .add(BountyBlocks.DUSK_ALLIUM)
                .add(BountyBlocks.DUSK_CORNFLOWER)
                .add(BountyBlocks.DUSK_BLUET)
                .add(BountyBlocks.DUSK_LILY)
                .add(BountyBlocks.DUSK_DANDELION);

        valueLookupBuilder(BlockTags.FLOWERS)
                .add(BountyBlocks.TALL_CYAN_ROSE)
                .add(BountyBlocks.TALL_WITHER_ROSE)
                .add(BountyBlocks.TALL_PINK_ROSE)
                .add(BountyBlocks.BLACK_SUNFLOWER);


    }
}
