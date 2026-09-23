package bee.bounty.worldgen;

import bee.bounty.block.BountifulFlowerBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BountyFlowerStateProvider implements BlockStateProvider {
    private final BlockState state;
    public static final MapCodec<BountyFlowerStateProvider> CODEC = BlockState.CODEC.fieldOf("state").xmap(BountyFlowerStateProvider::new, provider ->provider.state);

    public BountyFlowerStateProvider(Block block) {
        this.state = block.defaultBlockState();
    }

    public BountyFlowerStateProvider(BlockState state) {
        this.state = state;
    }


    @Override
    public MapCodec<? extends BlockStateProvider> codec() {
        return CODEC;
    }

    @Override
    public BlockState getState(LevelAccessor level, RandomSource random, BlockPos pos) {
        int size = random.nextInt(1, 3);

        if (state.hasProperty(BountifulFlowerBlock.SIZE)) return state.setValue(BountifulFlowerBlock.SIZE, size);

        return state;    }
}
