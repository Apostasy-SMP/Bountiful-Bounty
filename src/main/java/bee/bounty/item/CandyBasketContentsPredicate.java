package bee.bounty.item;

import bee.bounty.registry.BountyDataComponents;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.predicates.DataComponentPredicate;

public record CandyBasketContentsPredicate(int level) implements DataComponentPredicate {
    public static final Codec<CandyBasketContentsPredicate> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.INT.fieldOf("level").forGetter(CandyBasketContentsPredicate::level)
    ).apply(i, CandyBasketContentsPredicate::new));

    @Override
    public boolean matches(DataComponentGetter dataComponentGetter) {
        return dataComponentGetter.getOrDefault(BountyDataComponents.CANDY_BASKET_CONTENTS, new CandyBasketContents()).level() == level;
    }
}
