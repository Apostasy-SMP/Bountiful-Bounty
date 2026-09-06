package bee.bounty.mixin;

import bee.bounty.registry.BountyBlocks;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @ModifyExpressionValue(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;defaultBlockState()Lnet/minecraft/world/level/block/state/BlockState;"), method = "createWitherRose")
    private BlockState createWitherRose(BlockState original) {

        if (this instanceof OwnableEntity ownableEntity && ownableEntity.getOwner() != null) {
            return BountyBlocks.TALL_WITHER_ROSE.defaultBlockState();
        }

        return original;
    }

    @ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;<init>(Lnet/minecraft/world/level/ItemLike;)V"), method = "createWitherRose")
    private ItemLike createWitherRose$itemstack(ItemLike itemLike) {

        if (this instanceof OwnableEntity ownableEntity && ownableEntity.getOwner() != null) {
            return BountyBlocks.TALL_WITHER_ROSE.asItem();
        }

        return itemLike;
    }

}
