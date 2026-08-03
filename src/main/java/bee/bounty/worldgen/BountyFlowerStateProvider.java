package bee.bounty.worldgen;

import bee.bounty.block.BountifulFlowerBlock;
import bee.bounty.registry.BountyBlockStateProviderTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class BountyFlowerStateProvider extends BlockStateProvider {
    private final BlockState state;
    public static final MapCodec<BountyFlowerStateProvider> CODEC = BlockState.CODEC.fieldOf("state").xmap(BountyFlowerStateProvider::new, provider ->provider.state);

    public BountyFlowerStateProvider(Block block) {
        this.state = block.defaultBlockState();
    }

    public BountyFlowerStateProvider(BlockState state) {
        this.state = state;
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return BountyBlockStateProviderTypes.BOUNTY_FLOWER_PROVIDER;
    }

    @Override
    public BlockState getState(RandomSource randomSource, BlockPos blockPos) {
        int size = randomSource.nextInt(1, 3);

        if (state.hasProperty(BountifulFlowerBlock.SIZE)) return state.setValue(BountifulFlowerBlock.SIZE, size);

        return state;
    }
}
