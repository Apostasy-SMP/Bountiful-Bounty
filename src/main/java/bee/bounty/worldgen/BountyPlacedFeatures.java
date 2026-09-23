package bee.bounty.worldgen;

import bee.bounty.BountifulBounty;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.Collections;

public class BountyPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RED_ROSES = createKey("red_roses");
    public static final ResourceKey<PlacedFeature> CYAN_ROSES = createKey("cyan_roses");
    public static final ResourceKey<PlacedFeature> PINK_ROSES = createKey("pink_roses");

    public static final ResourceKey<PlacedFeature> EMERALD_ZINNIA = createKey("emerald_zinnia");
    public static final ResourceKey<PlacedFeature> CRIMSON_LILY = createKey("crimson_lily");
    public static final ResourceKey<PlacedFeature> PERENNIAL = createKey("perennial");
    public static final ResourceKey<PlacedFeature> PINWHEEL_DAISY = createKey("pinwheel_daisy");
    public static final ResourceKey<PlacedFeature> OVERWORLD_BOUNTY = createKey("overworld_bounty");
    public static final ResourceKey<PlacedFeature> BLUE_ANEMONE = createKey("blue_anemone");
    public static final ResourceKey<PlacedFeature> DUSK_POTENTILLA = createKey("dusk_potentilla");
    
    public static void configure(BootstrapContext<PlacedFeature> context) {

        HolderGetter<Feature> holderGetter = context.lookup(Registries.FEATURE);

        Holder<Feature> configuredRedRoses = holderGetter.getOrThrow(BountyConfiguredFeatures.RED_ROSES);
        Holder<Feature> configuredCyanRoses = holderGetter.getOrThrow(BountyConfiguredFeatures.CYAN_ROSES);
        Holder<Feature> configuredPinkRoses = holderGetter.getOrThrow(BountyConfiguredFeatures.PINK_ROSES);
        Holder<Feature> configuredEmeraldZinnia = holderGetter.getOrThrow(BountyConfiguredFeatures.EMERALD_ZINNIA);
        Holder<Feature> configuredCrimsonLily = holderGetter.getOrThrow(BountyConfiguredFeatures.CRIMSON_LILY);
        Holder<Feature> configuredPerennial = holderGetter.getOrThrow(BountyConfiguredFeatures.PERENNIAL);
        Holder<Feature> configuredOverworldBounty = holderGetter.getOrThrow(BountyConfiguredFeatures.OVERWORLD_BOUNTY);
        Holder<Feature> configuredBlueAnemone = holderGetter.getOrThrow(BountyConfiguredFeatures.BLUE_ANEMONE);
        Holder<Feature> configuredDuskPotentilla = holderGetter.getOrThrow(BountyConfiguredFeatures.DUSK_POTENTILLA);
        Holder<Feature> configuredPinwheel = holderGetter.getOrThrow(BountyConfiguredFeatures.PINWHEEL_DAISY);



        PlacementUtils.register(context, RED_ROSES, configuredRedRoses, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, CYAN_ROSES, configuredCyanRoses, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, PINK_ROSES, configuredPinkRoses, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PlacementUtils.register(context, EMERALD_ZINNIA, configuredEmeraldZinnia, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, CRIMSON_LILY, configuredCrimsonLily, PlacementUtils.FULL_RANGE);
        PlacementUtils.register(context, PINWHEEL_DAISY, configuredPinwheel, PlacementUtils.FULL_RANGE);
        PlacementUtils.register(context, PERENNIAL, configuredPerennial, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, OVERWORLD_BOUNTY, configuredOverworldBounty, PlacementUtils.FULL_RANGE, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), Collections.singletonList(Blocks.SOUL_SOIL))));
        PlacementUtils.register(context, BLUE_ANEMONE, configuredBlueAnemone, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(context, DUSK_POTENTILLA, configuredDuskPotentilla, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, BountifulBounty.id(name));
    }
}
