package bee.bounty.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class FruitLeavesBlock extends UntintedParticleLeavesBlock {
    public static final IntegerProperty GROWTH = IntegerProperty.create("growth", 0, 3);
    public static final IntegerProperty MAX_GROWTH = IntegerProperty.create("max_growth", 0, 3);
    private final Item fruit;

    public FruitLeavesBlock(Item fruit, float chance, Properties properties) {
        super(chance, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 1272863), properties);
        this.fruit = fruit;
        this.registerDefaultState(defaultBlockState().setValue(MAX_GROWTH, 3));
    }

    public Item getFruit() {
        return fruit;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(GROWTH);
        builder.add(MAX_GROWTH);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    public int getGrowthSpeed(BlockPos pos, Level level) {
        int speed = 100;
        for (Direction direction : Direction.values()) {
            int growth = level.getBlockState(pos.relative(direction)).getValueOrElse(GROWTH, 0) - 1;
            speed -= (int) (growth * 3.5);

        }
        return speed;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);

        if (state.getValue(PERSISTENT)) return;
        if (state.getValue(GROWTH) >= state.getValue(MAX_GROWTH)) return;
        boolean airNearby = false;
        for (Direction direction : Direction.values()) {
            BlockState state1 = level.getBlockState(pos.relative(direction));
            if (state1.canBeReplaced() || state1.isAir()) {
                airNearby = true;
                break;
            }
        }
        if (!airNearby) return;
        if (level.getBrightness(LightLayer.SKY, pos) < 10) return;

        if (random.nextInt(32) != 1) return;
        level.setBlockAndUpdate(pos, state.cycle(GROWTH));

    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos blockPos, Player player, BlockHitResult hitResult) {
        if (state.getValue(GROWTH) >= 2) {
            if (level instanceof ServerLevel serverLevel)
                serverLevel.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);

            Vec3 pos = hitResult.getLocation().relative(hitResult.getDirection(), 0.2);
            RandomSource random = RandomSource.create();
            ItemStack stack = fruit.getDefaultInstance();
            int amount = state.getValue(GROWTH) == 2 ? random.nextInt(0, 2) : random.nextInt(1, 4);
            stack.setCount(amount);
            ItemEntity entity = new ItemEntity(level, pos.x, pos.y, pos.z, stack);
            entity.setDeltaMovement(random.triangle(0.0F, 0.12), random.triangle(0.2, 0.12), random.triangle(0.0F, 0.12));
            level.addFreshEntity(entity);
            level.setBlockAndUpdate(blockPos, state.setValue(GROWTH, 0));
            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(state, level, blockPos, player, hitResult);
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        ParticleUtils.spawnParticleBelow(level, pos, random, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 1272863));
    }

    @Override
    protected List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        List<ItemStack> drops = super.getDrops(blockState, builder);
        drops.forEach(itemStack -> {
            if (itemStack.is(this.asItem())) {
                int growth = blockState.getValue(GROWTH);
                itemStack.set(DataComponents.ITEM_NAME, switch (growth) {
                    case 1 -> Component.translatable("growth_stage.flowering").append(itemStack.getItemName());
                    case 2 -> Component.translatable("growth_stage.unripe").append(itemStack.getItemName());
                    case 3 -> Component.translatable("growth_stage.ripe").append(itemStack.getItemName());
                    default -> itemStack.getItemName();
                });
            }
        });
        return drops;
    }
}
