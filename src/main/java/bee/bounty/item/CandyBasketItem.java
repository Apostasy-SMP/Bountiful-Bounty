package bee.bounty.item;

import bee.bounty.registry.BountyDataComponents;
import bee.bounty.registry.BountyTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class CandyBasketItem extends Item {
    public CandyBasketItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack itemStack, Slot slot, ClickAction clickAction, Player player) {
        return super.overrideStackedOnOther(itemStack, slot, clickAction, player);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {

        ItemStack stack = player.getItemInHand(interactionHand);
        CandyBasketContents contents = stack.getOrDefault(BountyDataComponents.CANDY_BASKET_CONTENTS, new CandyBasketContents());
        if (contents.contents().isEmpty()) return InteractionResult.FAIL;
        ItemStack candy = contents.contents().getFirst().copy();
        if (candy.isEmpty()) return InteractionResult.FAIL;

        contents.removeItem(0);
        stack.set(BountyDataComponents.CANDY_BASKET_CONTENTS, contents);
        for (int i = 0; i < candy.getCount(); i++) {
            throwItem(player, level, candy.copyWithCount(1));
        }
        player.playSound(SoundEvents.BUNDLE_DROP_CONTENTS);

        return InteractionResult.SUCCESS_SERVER;
    }

    public void throwItem(Player player, Level level, ItemStack item) {
        ItemEntity entity = new ItemEntity(level, player.getX(), player.getEyeY(), player.getZ(), item);
        entity.setDeltaMovement(player.getViewVector(1).scale(0.75).offsetRandom(level.random, 0.3f));
        entity.bounty$setMergeDelay(40);
        entity.setDefaultPickUpDelay();
        level.addFreshEntity(entity);
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack itemStack, ItemStack itemStack2, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess) {
        if (!itemStack2.is(BountyTags.CANDY) || itemStack.isEmpty() || itemStack2.isEmpty()) return super.overrideOtherStackedOnMe(itemStack, itemStack2, slot, clickAction, player, slotAccess);
        CandyBasketContents contents = itemStack.getOrDefault(BountyDataComponents.CANDY_BASKET_CONTENTS, new CandyBasketContents());

        if (clickAction.equals(ClickAction.PRIMARY)) {
            int originalCount = itemStack2.getCount();
            int leftover = contents.addItem(itemStack2);
            if (leftover > 0) {
                itemStack2.setCount(leftover);
            } else slotAccess.set(ItemStack.EMPTY);
            itemStack.set(BountyDataComponents.CANDY_BASKET_CONTENTS, contents);
            player.containerMenu.slotsChanged(player.getInventory());
            if (originalCount == leftover) {
                player.playSound(SoundEvents.BUNDLE_INSERT_FAIL);
            } else player.playSound(SoundEvents.BUNDLE_INSERT);
           return true;
        }

        if (clickAction.equals(ClickAction.SECONDARY) && itemStack2.isEmpty()) {
            ItemStack stack = contents.contents().getFirst().copy();
            if (stack.isEmpty()) return false;
            contents.removeItem(0);

            slotAccess.set(stack);
            player.playSound(SoundEvents.BUNDLE_REMOVE_ONE);
            itemStack.set(BountyDataComponents.CANDY_BASKET_CONTENTS, contents);
            player.containerMenu.slotsChanged(player.getInventory());
            return true;
        }

        return false;
    }
}
