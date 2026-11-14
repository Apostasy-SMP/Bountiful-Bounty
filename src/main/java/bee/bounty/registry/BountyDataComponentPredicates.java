package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.item.CandyBasketContentsPredicate;
import net.minecraft.core.Registry;
import net.minecraft.core.component.predicates.DataComponentPredicate;
import net.minecraft.core.registries.BuiltInRegistries;

public class BountyDataComponentPredicates {

    public static final DataComponentPredicate.Type<CandyBasketContentsPredicate> CANDY_BASKET_CONTENTS_FILLED_LEVEL = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_PREDICATE_TYPE,
            BountifulBounty.id("candy_basket_contents_filled_level"),
            new DataComponentPredicate.ConcreteType<>(CandyBasketContentsPredicate.CODEC)
    );

    public static void init() {}

}
