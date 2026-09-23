package bee.bounty.datagen;

import bee.bounty.BountifulBounty;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class BountyTagGen extends FabricTagsProvider.BlockTagsProvider {
    public BountyTagGen(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        builder(BlockTags.SMALL_FLOWERS)
                .add(key("red_rose"))
                .add(key("cyan_rose"))
                .add(key("pink_rose"))
                .add(key("blue_anemone"))
                .add(key("crimson_lily"))
                .add(key("dusk_perennial"))
                .add(key("dusk_potentilla"))
                .add(key("dusk_tulip"))
                .add(key("dusk_zinnia"))
                .add(key("overworlds_bounty"))
                .add(key("perennial"))
                .add(key("dusk_daisy"))
                .add(key("relic_flower"))
                .add(key("pinwheel_daisy"))
                .add(key("dusk_orchid"))
                .add(key("dusk_poppy"))
                .add(key("dusk_allium"))
                .add(key("dusk_cornflower"))
                .add(key("dusk_bluet"))
                .add(key("dusk_lily"))
                .add(key("dusk_dandelion"));

        builder(BlockTags.FLOWERS)
                .add(key("tall_cyan_rose"))
                .add(key("tall_wither_rose"))
                .add(key("tall_pink_rose"))
                .add(key("black_sunflower"));
        

    }
    
    private static ResourceKey<Block> key(String s) {
        return ResourceKey.create(Registries.BLOCK, BountifulBounty.id(s));
    }
}
