package bee.bounty.registry;

import bee.creature.registry.BlockStateProviderOverrides;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class BountyBlockStateOverrides {

    public static void init() {

        BlockStateProviderOverrides.addOverride(Blocks.SUNFLOWER, BountyBlocks.BLACK_SUNFLOWER.defaultBlockState(), 19);
        BlockStateProviderOverrides.addOverride(Blocks.PINK_TULIP, BountyBlocks.DUSK_TULIP.defaultBlockState(), 19);
        BlockStateProviderOverrides.addOverride(Blocks.ORANGE_TULIP, BountyBlocks.DUSK_TULIP.defaultBlockState(), 19);
        BlockStateProviderOverrides.addOverride(Blocks.RED_TULIP, BountyBlocks.DUSK_TULIP.defaultBlockState(), 19);
        BlockStateProviderOverrides.addOverride(Blocks.BLUE_ORCHID, BountyBlocks.DUSK_ORCHID.defaultBlockState(), 10);
        BlockStateProviderOverrides.addOverride(Blocks.ALLIUM, BountyBlocks.DUSK_ALLIUM.defaultBlockState(), 10);
        BlockStateProviderOverrides.addOverride(Blocks.CORNFLOWER, BountyBlocks.DUSK_CORNFLOWER.defaultBlockState(), 10);
        BlockStateProviderOverrides.addOverride(Blocks.AZURE_BLUET, BountyBlocks.DUSK_BLUET.defaultBlockState(), 10);
        BlockStateProviderOverrides.addOverride(Blocks.OXEYE_DAISY, BountyBlocks.DUSK_DAISY.defaultBlockState(), 10);
        BlockStateProviderOverrides.addOverride(Blocks.LILY_OF_THE_VALLEY, BountyBlocks.DUSK_LILY.defaultBlockState(), 10);
        BlockStateProviderOverrides.addOverride(Blocks.DANDELION, BountyBlocks.DUSK_DANDELION.defaultBlockState(), 15);
        BlockStateProviderOverrides.addOverride(Blocks.POPPY, BountyBlocks.DUSK_POPPY.defaultBlockState(), 15);

    }

}
