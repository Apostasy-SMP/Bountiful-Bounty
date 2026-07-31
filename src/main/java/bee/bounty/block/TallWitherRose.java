package bee.bounty.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TallWitherRose extends TallFlowerBlock {
    public TallWitherRose(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return super.mayPlaceOn(blockState, blockGetter, blockPos) || blockState.is(Blocks.NETHERRACK) || blockState.is(Blocks.SOUL_SAND) || blockState.is(Blocks.SOUL_SOIL);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        VoxelShape voxelShape = this.getShape(blockState, level, blockPos, CollisionContext.empty());
        Vec3 vec3 = voxelShape.bounds().getCenter();
        double d = (double)blockPos.getX() + vec3.x;
        double e = (double)blockPos.getZ() + vec3.z;

        for(int i = 0; i < 3; ++i) {
            if (randomSource.nextBoolean()) {
                level.addParticle(ParticleTypes.SMOKE, d + randomSource.nextDouble() / (double)5.0F, (double)blockPos.getY() + ((double)0.5F - randomSource.nextDouble()), e + randomSource.nextDouble() / (double)5.0F, 0.0F, 0.0F, 0.0F);
                level.addParticle(ParticleTypes.SMOKE, d + randomSource.nextDouble() / (double)5.0F, (double)blockPos.getY() + 1 + ((double)0.5F - randomSource.nextDouble()), e + randomSource.nextDouble() / (double)5.0F, 0.0F, 0.0F, 0.0F);
            }
        }

    }

    protected void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean bl) {
        if (level instanceof ServerLevel serverLevel) {
            if (level.getDifficulty() != Difficulty.PEACEFUL && entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo(serverLevel, level.damageSources().wither())) {
                    livingEntity.addEffect(this.getBeeInteractionEffect());
                }
            }
        }

    }

    public MobEffectInstance getBeeInteractionEffect() {
        return new MobEffectInstance(MobEffects.WITHER, 160);
    }
}
