package bee.bounty.block;

import bee.bounty.block.entity.BotanyTableBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class BotanyTableBlock extends BaseEntityBlock {
    public BotanyTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(BotanyTableBlock::new);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {

        if (level.getBlockEntity(blockPos) instanceof BotanyTableBlockEntity entity) {
            player.openMenu(entity);
            return InteractionResult.SUCCESS;
        }

        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }
}
