package bee.bounty.worldgen;

import bee.bounty.BountifulBounty;
import bee.bounty.registry.BountyBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;

public class BountyConfiguredFeatures {

    public static final ResourceKey<Feature> RED_ROSES = createKey("red_roses");
    public static final ResourceKey<Feature> CYAN_ROSES = createKey("cyan_roses");
    public static final ResourceKey<Feature> PINK_ROSES = createKey("pink_roses");
    public static final ResourceKey<Feature> EMERALD_ZINNIA = createKey("emerald_zinnia");
    public static final ResourceKey<Feature> CRIMSON_LILY = createKey("crimson_lily");
    public static final ResourceKey<Feature> PERENNIAL = createKey("perennial");
    public static final ResourceKey<Feature> PINWHEEL_DAISY = createKey("pinwheel_daisy");
    public static final ResourceKey<Feature> OVERWORLD_BOUNTY = createKey("overworld_bounty");
    public static final ResourceKey<Feature> BLUE_ANEMONE = createKey("blue_anemone");
    public static final ResourceKey<Feature> DUSK_POTENTILLA = createKey("dusk_potentilla");



    public static void configure(BootstrapContext<Feature> context) {



        context.register(RED_ROSES, new SimpleBlockFeature(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder()
                .add(BountyBlocks.RED_ROSE.defaultBlockState()).build())));

        context.register(CYAN_ROSES, new SimpleBlockFeature(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().
                add(BountyBlocks.CYAN_ROSE.defaultBlockState()).add(BountyBlocks.TALL_CYAN_ROSE.defaultBlockState()).build())));

        context.register(PINK_ROSES, new SimpleBlockFeature(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder()
                .add(BountyBlocks.PINK_ROSE.defaultBlockState()).add(BountyBlocks.TALL_PINK_ROSE.defaultBlockState()).build())));


        context.register(PERENNIAL, new SimpleBlockFeature(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().
                add(BountyBlocks.PERENNIAL.defaultBlockState(), 12).add(BountyBlocks.DUSK_PERENNIAL.defaultBlockState()).build())));

        context.register(EMERALD_ZINNIA, new SimpleBlockFeature(new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().
                add(BountyBlocks.EMERALD_ZINNIA.defaultBlockState(), 12).add(BountyBlocks.DUSK_ZINNIA.defaultBlockState()).build())));


        context.register(CRIMSON_LILY, new SimpleBlockFeature(new BountyFlowerStateProvider(BountyBlocks.CRIMSON_LILY)));
        context.register(PINWHEEL_DAISY, new SimpleBlockFeature(new BountyFlowerStateProvider(BountyBlocks.PINWHEEL_DAISY)));
        context.register(OVERWORLD_BOUNTY, new SimpleBlockFeature(new BountyFlowerStateProvider(BountyBlocks.OVERWORLDS_BOUNTY)));
        context.register(BLUE_ANEMONE, new SimpleBlockFeature(new BountyFlowerStateProvider(BountyBlocks.BLUE_ANEMONE)));
        context.register(DUSK_POTENTILLA, new SimpleBlockFeature(new BountyFlowerStateProvider(BountyBlocks.DUSK_POTENTILLA)));

    }



    private static ResourceKey<Feature> createKey(String name) {
        return ResourceKey.create(Registries.FEATURE, BountifulBounty.id(name));
    }

}
