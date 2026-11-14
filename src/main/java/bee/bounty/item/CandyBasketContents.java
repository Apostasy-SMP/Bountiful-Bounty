package bee.bounty.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record CandyBasketContents(ArrayList<ItemStack> contents) {
    public static final Codec<CandyBasketContents> CODEC = RecordCodecBuilder.create(i -> i.group(ItemStack.CODEC.listOf().fieldOf("contents").forGetter(CandyBasketContents::contents)).apply(i, l -> new CandyBasketContents(new ArrayList<>(l))));
    public static final int MAX_SIZE = 192;

    public CandyBasketContents() {
        this(new ArrayList<>());
    }

    public int getSize() {
        int size = 0;

        for (ItemStack stack : contents) {
            size += stack.getCount();
        }
        return size;
    }
    public int getRoom() {
        return MAX_SIZE - getSize();
    }

    public boolean hasRoom() {
        return getRoom() > 0;
    }

    public int addItem(ItemStack stack) {
        int room = getRoom();
        int count = stack.getCount();
        int leftOver = count - room;
        if (leftOver > 0) {
            int size = count - leftOver;
            if (size == 0) return leftOver;
            contents.add(stack.copyWithCount(size));
            return leftOver;
        } else contents.add(stack);

        return 0;
    }

    public int level() {
        return getSize() >= 128 ? 3 : getSize() >= 64 ? 2 : 1;
    }

    public List<ItemStack> getRandomItems(int amount) {
        ArrayList<ItemStack> stacks = new ArrayList<>();
        int count = 0;
        for (ItemStack stack : contents) {
            if (contents.isEmpty() || amount > count) return stacks;
            RandomSource random = RandomSource.create();
            int amountTaken = random.nextInt(stack.getCount() / 2, stack.getCount());
            stack.shrink(amountTaken);
            stacks.add(stack.copyWithCount(amountTaken));
            count += amountTaken;
        }
        return stacks;
    }

    public void removeItem(int pos) {
        contents.remove(pos);
    }

}
