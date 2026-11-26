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
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CandyBasketItem extends Item {
    public CandyBasketItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {

        ItemStack stack = player.getItemInHand(interactionHand);
        CandyBasketContents contents = stack.getOrDefault(BountyDataComponents.CANDY_BASKET_CONTENTS, new CandyBasketContents());
        if (contents.contents().isEmpty()) return InteractionResult.FAIL;
        List<ItemStack> candy = contents.getItemsToThrow(64);
        if (candy.isEmpty()) return InteractionResult.FAIL;

        stack.set(BountyDataComponents.CANDY_BASKET_CONTENTS, contents);
        for (ItemStack stack1 : candy) {
            for (int i = 0; i < stack1.getCount(); i++) {
                throwItem(player, level, stack1.copyWithCount(1));
            }
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
        if (itemStack.isEmpty()) return super.overrideOtherStackedOnMe(itemStack, itemStack2, slot, clickAction, player, slotAccess);
        if (clickAction.equals(ClickAction.PRIMARY) && itemStack2.is(BountyTags.CANDY)) {
            slotAccess.set(addItem(itemStack, itemStack2, player));
           return true;
        }

        if (clickAction.equals(ClickAction.SECONDARY) && itemStack2.isEmpty()) {
            ItemStack stack = takeItem(itemStack, player);
            if (stack.isEmpty()) {
                return false;
            }
            slotAccess.set(stack);
            return true;
        }

        return false;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack candyBasket, Slot slot, ClickAction clickAction, Player player) {
        ItemStack stack = slot.getItem();

        if (clickAction.equals(ClickAction.SECONDARY) && stack.isEmpty()) {
            ItemStack addition = takeItem(candyBasket, player);
            if (addition.isEmpty()) return false;

            slot.set(addition);
            return true;
        }

        if (clickAction.equals(ClickAction.PRIMARY) && stack.is(BountyTags.CANDY)) {
            slot.set(addItem(candyBasket, stack, player));
            return true;
        }
        return false;
    }

    public ItemStack addItem(ItemStack candyBasket, ItemStack addition, @Nullable Player player) {
        CandyBasketContents contents = candyBasket.getOrDefault(BountyDataComponents.CANDY_BASKET_CONTENTS, new CandyBasketContents());
        int originalCount = addition.getCount();
        int leftover = contents.addItem(addition);
        if (leftover > 0) {
            addition.setCount(leftover);
        } else addition = ItemStack.EMPTY;
        candyBasket.set(BountyDataComponents.CANDY_BASKET_CONTENTS, contents);

        if (player != null) {
            player.containerMenu.slotsChanged(player.getInventory());
            if (originalCount == leftover) {
                player.playSound(SoundEvents.BUNDLE_INSERT_FAIL);
            } else player.playSound(SoundEvents.BUNDLE_INSERT);
        }
        return addition;
    }

    public ItemStack takeItem(ItemStack candyBasket, @Nullable Player player) {
        CandyBasketContents contents = candyBasket.getOrDefault(BountyDataComponents.CANDY_BASKET_CONTENTS, new CandyBasketContents());

        ItemStack stack = contents.contents().getFirst().copy();
        if (stack.isEmpty()) return ItemStack.EMPTY;
        contents.removeItem(0);
        candyBasket.set(BountyDataComponents.CANDY_BASKET_CONTENTS, contents);

        if (player != null) {
            player.playSound(SoundEvents.BUNDLE_REMOVE_ONE);
            player.containerMenu.slotsChanged(player.getInventory());
        }

        return stack;
    }
}
