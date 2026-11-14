package bee.bounty.worldgen.placer;

import bee.bounty.block.FruitLeavesBlock;
import bee.bounty.registry.BountyBlockStateProviderTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class FruitLeavesProvider extends BlockStateProvider {
    private final BlockState state;
    public static final MapCodec<FruitLeavesProvider> CODEC = BlockState.CODEC.fieldOf("state").xmap(FruitLeavesProvider::new, provider -> provider.state);

    public FruitLeavesProvider(Block block) {
        this.state = block.defaultBlockState();
    }

    public FruitLeavesProvider(BlockState state) {
        this.state = state;
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return BountyBlockStateProviderTypes.FRUIT_LEAVES_PROVIDER;
    }

    @Override
    public BlockState getState(RandomSource randomSource, BlockPos blockPos) {
        BlockState state1 = state;
        if (randomSource.nextBoolean()) state1 = state1.setValue(FruitLeavesBlock.MAX_GROWTH, randomSource.nextInt(3) == 0 ? randomSource.nextInt(3) : 0);
        return state1;
    }
}
