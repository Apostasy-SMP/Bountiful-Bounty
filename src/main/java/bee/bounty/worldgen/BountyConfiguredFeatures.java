package bee.bounty.worldgen;

import bee.bounty.BountifulBounty;
import bee.bounty.registry.BountyBlocks;
import bee.bounty.worldgen.placer.PearFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

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

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE = createKey("apple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_APPLE_TREE = createKey("fancy_apple_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_APPLE_TREE = createKey("green_apple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_GREEN_APPLE_TREE = createKey("fancy_green_apple_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_TREE = createKey("lime_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_LIME_TREE = createKey("fancy_lime_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREE = createKey("lemon_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_LEMON_TREE = createKey("fancy_lemon_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREE = createKey("orange_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ORANGE_TREE = createKey("fancy_orange_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_TREE = createKey("white_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CHERRY_TREE = createKey("fancy_white_cherry_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_TREE = createKey("pear_tree");

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


        FeatureUtils.register(context, APPLE_TREE, Feature.TREE, createFruit(BountyBlocks.APPLE_LEAVES).build());
        FeatureUtils.register(context, FANCY_APPLE_TREE, Feature.TREE, createFancyFruit(BountyBlocks.APPLE_LEAVES).build());

        FeatureUtils.register(context, GREEN_APPLE_TREE, Feature.TREE, createFruit(BountyBlocks.GREEN_APPLE_LEAVES).build());
        FeatureUtils.register(context, FANCY_GREEN_APPLE_TREE, Feature.TREE, createFancyFruit(BountyBlocks.GREEN_APPLE_LEAVES).build());

        FeatureUtils.register(context, LEMON_TREE, Feature.TREE, createFruit(BountyBlocks.LEMON_LEAVES).build());
        FeatureUtils.register(context, FANCY_LEMON_TREE, Feature.TREE, createFancyFruit(BountyBlocks.LEMON_LEAVES).build());

        FeatureUtils.register(context, LIME_TREE, Feature.TREE, createFruit(BountyBlocks.LIME_LEAVES).build());
        FeatureUtils.register(context, FANCY_LIME_TREE, Feature.TREE, createFancyFruit(BountyBlocks.LIME_LEAVES).build());

        FeatureUtils.register(context, ORANGE_TREE, Feature.TREE, createFruit(BountyBlocks.ORANGE_LEAVES).build());
        FeatureUtils.register(context, FANCY_ORANGE_TREE, Feature.TREE, createFancyFruit(BountyBlocks.ORANGE_LEAVES).build());

        FeatureUtils.register(context, CHERRY_TREE, Feature.TREE, createFruit(BountyBlocks.WHITE_CHERRY_LEAVES).build());
        FeatureUtils.register(context, FANCY_CHERRY_TREE, Feature.TREE, createFancyFruit(BountyBlocks.WHITE_CHERRY_LEAVES).build());

        FeatureUtils.register(context, PEAR_TREE, Feature.TREE, createPearTree(BountyBlocks.PEAR_LEAVES).build());

    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider blockStateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(blockStateProvider)));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(final Block log, final Block leaves, final int baseHeight, final int heightRandA, final int heightRandB, final int blobRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log)
                , new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB)
                , BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(blobRadius)
                , ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFruit(Block leaves) {
        return createStraightBlobTree(BountyBlocks.FRUIT_LOG, leaves, 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyFruit(Block leaves) {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BountyBlocks.FRUIT_LOG), new FancyTrunkPlacer(3, 8, 0), BlockStateProvider.simple(leaves), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(3)))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPearTree(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BountyBlocks.FRUIT_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(leaves),
                new PearFoliagePlacer(new WeightedListInt(WeightedList.<IntProvider>builder().add(ConstantInt.of(2), 3).add(ConstantInt.of(2), 1).build())
                        , ConstantInt.of(1)
                        , 5),
                new TwoLayersFeatureSize(1, 0, 1));
    }


    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, BountifulBounty.id(name));
    }

}
