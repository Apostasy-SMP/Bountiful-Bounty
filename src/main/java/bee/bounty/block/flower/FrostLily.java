package bee.bounty.block.flower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FrostLily extends BountifulFlowerBlock{
    public FrostLily(Holder<MobEffect> holder, float f, Properties properties) {
        super(holder, f, properties);
    }

    @Override
    protected void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean bl) {
        super.entityInside(blockState, level, blockPos, entity, insideBlockEffectApplier, bl);
        insideBlockEffectApplier.apply(InsideBlockEffectType.FREEZE);
    }
}
