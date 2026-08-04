package bee.bounty.registry;

import bee.bounty.worldgen.WeightedBountyFlowerStateProvider;
import bee.creature.registry.BlockStateProviderOverrides;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class BountyBlockStateOverrides {

    public static void init() {

        BlockStateProviderOverrides.addOverride(Blocks.SUNFLOWER, BlockStateProvider.simple(BountyBlocks.BLACK_SUNFLOWER), 19);
        BlockStateProviderOverrides.addOverride(Blocks.PINK_TULIP, flowerProvider(Blocks.PINK_TULIP, BountyBlocks.DUSK_TULIP, 19));
        BlockStateProviderOverrides.addOverride(Blocks.ORANGE_TULIP, flowerProvider(Blocks.ORANGE_TULIP, BountyBlocks.DUSK_TULIP, 19));
        BlockStateProviderOverrides.addOverride(Blocks.RED_TULIP, flowerProvider(Blocks.RED_TULIP, BountyBlocks.DUSK_TULIP, 19));
        BlockStateProviderOverrides.addOverride(Blocks.BLUE_ORCHID, flowerProvider(Blocks.BLUE_ORCHID, BountyBlocks.DUSK_ORCHID, 10));
        BlockStateProviderOverrides.addOverride(Blocks.ALLIUM, flowerProvider(Blocks.ALLIUM, BountyBlocks.DUSK_ALLIUM, 10));
        BlockStateProviderOverrides.addOverride(Blocks.CORNFLOWER, flowerProvider(Blocks.CORNFLOWER, BountyBlocks.DUSK_CORNFLOWER, 10));
        BlockStateProviderOverrides.addOverride(Blocks.AZURE_BLUET, flowerProvider(Blocks.AZURE_BLUET, BountyBlocks.DUSK_BLUET, 10));
        BlockStateProviderOverrides.addOverride(Blocks.OXEYE_DAISY, flowerProvider(Blocks.OXEYE_DAISY, BountyBlocks.DUSK_DAISY, 10));
        BlockStateProviderOverrides.addOverride(Blocks.LILY_OF_THE_VALLEY, flowerProvider(Blocks.LILY_OF_THE_VALLEY, BountyBlocks.DUSK_LILY, 10));
        BlockStateProviderOverrides.addOverride(Blocks.DANDELION, flowerProvider(Blocks.DANDELION, BountyBlocks.DUSK_DANDELION, 15));
        BlockStateProviderOverrides.addOverride(Blocks.POPPY, flowerProvider(Blocks.POPPY, BountyBlocks.DUSK_POPPY, 15));

    }

    public static WeightedBountyFlowerStateProvider flowerProvider(Block override, Block dusk, int chance) {
        return new WeightedBountyFlowerStateProvider(WeightedList.<BlockState>builder().add(override.defaultBlockState(), chance).add(dusk.defaultBlockState()).build());
    }

}
