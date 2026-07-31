package bee.bounty.block;

import bee.bounty.registry.BountyBlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.WitherRoseBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BountifulWitherRoseBlock extends WitherRoseBlock implements BonemealableBlock {
    public static final IntegerProperty SIZE = BountyBlockProperties.SIZE;
    public BountifulWitherRoseBlock(Holder<MobEffect> holder, float f, Properties properties) {
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
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        if (blockState.getValue(SIZE) < 4) {
            serverLevel.setBlockAndUpdate(blockPos, blockState.cycle(SIZE));
        } else {
            Containers.dropItemStack(serverLevel, blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.asItem().getDefaultInstance());
        }
        BoneMealItem.addGrowthParticles(serverLevel, blockPos, 30);
    }

    protected void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean bl) {
        if (level instanceof ServerLevel serverLevel) {
            if (level.getDifficulty() != Difficulty.PEACEFUL && entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo(serverLevel, level.damageSources().wither())) {
                    livingEntity.addEffect(this.getBeeInteractionEffect(blockState));
                }
            }
        }

    }

    public MobEffectInstance getBeeInteractionEffect(BlockState state) {
        return new MobEffectInstance(MobEffects.WITHER, (int) (40 * (state.getValue(SIZE) * 0.5)) + 10);
    }
}
