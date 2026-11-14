package bee.bounty.mixin;

import bee.bounty.injection.ThrowableInterface;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin implements ThrowableInterface {

    @Unique int mergeDelay = 0;

    @WrapMethod(method = "isMergable")
    private boolean isMergeable(Operation<Boolean> original) {
        return bounty$getMergeDelay() == 0;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (mergeDelay > 0) mergeDelay--;
    }

    @Override
    public void bounty$setMergeDelay(int delay) {
        mergeDelay = delay;
    }

    @Override
    public int bounty$getMergeDelay() {
        return mergeDelay;
    }
}
