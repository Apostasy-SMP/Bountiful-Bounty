package bee.bounty.worldgen;

import bee.bounty.BountifulBounty;
import bee.bounty.registry.BountyBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class BountyConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_ROSES = createKey("red_roses");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYAN_ROSES = createKey("cyan_roses");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_ROSES = createKey("pink_roses");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD_ZINNIA = createKey("emerald_zinnia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_LILY = createKey("crimson_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PERENNIAL = createKey("perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINWHEEL_DAISY = createKey("pinwheel_daisy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BOUNTY = createKey("overworld_bounty");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ANEMONE = createKey("blue_anemone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DUSK_POTENTILLA = createKey("dusk_potentilla");



    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {



        FeatureUtils.register(context, RED_ROSES, Feature.FLOWER, grassPatch(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder()
                .add(BountyBlocks.RED_ROSE.defaultBlockState()).build()), 64));

        FeatureUtils.register(context, CYAN_ROSES, Feature.FLOWER, grassPatch(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().
                add(BountyBlocks.CYAN_ROSE.defaultBlockState()).add(BountyBlocks.TALL_CYAN_ROSE.defaultBlockState()).build()), 64));

        FeatureUtils.register(context, PINK_ROSES, Feature.FLOWER, grassPatch(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder()
                .add(BountyBlocks.PINK_ROSE.defaultBlockState()).add(BountyBlocks.TALL_PINK_ROSE.defaultBlockState()).build()), 64));


        FeatureUtils.register(context, PERENNIAL, Feature.FLOWER, grassPatch(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().
                add(BountyBlocks.PERENNIAL.defaultBlockState(), 12).add(BountyBlocks.DUSK_PERENNIAL.defaultBlockState()).build()), 64));

        FeatureUtils.register(context, EMERALD_ZINNIA, Feature.FLOWER, grassPatch(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().
                add(BountyBlocks.EMERALD_ZINNIA.defaultBlockState(), 12).add(BountyBlocks.DUSK_ZINNIA.defaultBlockState()).build()), 64));

        FeatureUtils.register(context, CRIMSON_LILY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new BountyFlowerStateProvider(BountyBlocks.CRIMSON_LILY))));
        FeatureUtils.register(context, PINWHEEL_DAISY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new BountyFlowerStateProvider(BountyBlocks.PINWHEEL_DAISY))));
        FeatureUtils.register(context, OVERWORLD_BOUNTY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new BountyFlowerStateProvider(BountyBlocks.OVERWORLDS_BOUNTY))));
        FeatureUtils.register(context, BLUE_ANEMONE, Feature.FLOWER, grassPatch(new BountyFlowerStateProvider(BountyBlocks.BLUE_ANEMONE), 64));
        FeatureUtils.register(context, DUSK_POTENTILLA, Feature.FLOWER, grassPatch(new BountyFlowerStateProvider(BountyBlocks.DUSK_POTENTILLA), 64));

    }



    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, BountifulBounty.id(name));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider blockStateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(blockStateProvider)));
    }
}
