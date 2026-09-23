package bee.bounty.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.EyeblossomBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DuplicatingFlowerBlock extends EyeblossomBlock implements BonemealableBlock {

    public DuplicatingFlowerBlock(EyeblossomBlock.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {

        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), this.asItem().getDefaultInstance());

        BoneMealItem.addGrowthParticles(level, pos, 30);
    }
}
