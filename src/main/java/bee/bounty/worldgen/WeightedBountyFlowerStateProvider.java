package bee.bounty.worldgen;

import bee.bounty.block.BountifulFlowerBlock;
import bee.bounty.registry.BountyBlockStateProviderTypes;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class WeightedBountyFlowerStateProvider extends BlockStateProvider {
    private final WeightedList<BlockState> weightedList;
    public static final MapCodec<WeightedBountyFlowerStateProvider> CODEC = WeightedList.nonEmptyCodec(BlockState.CODEC).fieldOf("state").xmap(WeightedBountyFlowerStateProvider::new, provider ->provider.weightedList);


    public WeightedBountyFlowerStateProvider(WeightedList<BlockState> weightedList) {
        this.weightedList = weightedList;
    }

    private static DataResult<WeightedStateProvider> create(WeightedList<BlockState> weightedList) {
        return weightedList.isEmpty() ? DataResult.error(() -> "WeightedStateProvider with no states") : DataResult.success(new WeightedStateProvider(weightedList));
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return BountyBlockStateProviderTypes.BOUNTY_FLOWER_PROVIDER;
    }

    @Override
    public BlockState getState(RandomSource randomSource, BlockPos blockPos) {
        int size = randomSource.nextInt(1, 3);

        BlockState state = weightedList.getRandomOrThrow(randomSource);

        if (state.hasProperty(BountifulFlowerBlock.SIZE)) return state.setValue(BountifulFlowerBlock.SIZE, size);

        return state;
    }
}
