package bee.bounty.mixin;

import bee.bounty.registry.BountyItems;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Consumable.class)
public abstract class ConsumableMixin {

    @WrapOperation(method = "onConsume", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;consume(ILnet/minecraft/world/entity/LivingEntity;)V"))
    private void onConsume(ItemStack instance, int i, LivingEntity livingEntity, Operation<Void> original) {
        if (instance.is(BountyItems.LOLLIPOP)) {
            InteractionHand hand = livingEntity instanceof Player player ? player.getUsedItemHand() : InteractionHand.MAIN_HAND;
            instance.hurtAndBreak(20, livingEntity, hand);
        } else original.call(instance, i, livingEntity);
    }

}
