package bee.bounty.block;

import bee.bounty.registry.BountyBlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BountifulFlowerBlock extends FlowerBlock implements BonemealableBlock {
    public static final IntegerProperty SIZE = BountyBlockProperties.SIZE;
    public BountifulFlowerBlock(Holder<MobEffect> holder, float f, Properties properties) {
        super(holder, f, properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SIZE);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (itemStack.is(this.asItem()) && blockState.getValue(SIZE) < 4) {

            level.setBlockAndUpdate(blockPos, blockState.cycle(SIZE));
            player.playSound(blockState.getSoundType().getPlaceSound());
            itemStack.consume(1, player);

            return InteractionResult.SUCCESS;
        }

        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
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
        if (state.getValue(SIZE) < 4) {
            level.setBlockAndUpdate(pos, state.cycle(SIZE));
        } else {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), this.asItem().getDefaultInstance());
        }
        BoneMealItem.addGrowthParticles(level, pos, 30);
    }
}
