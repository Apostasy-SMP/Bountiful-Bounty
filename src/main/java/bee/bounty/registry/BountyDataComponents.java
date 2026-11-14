package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.item.CandyBasketContents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class BountyDataComponents {

    public static final DataComponentType<CandyBasketContents> CANDY_BASKET_CONTENTS = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE,
            BountifulBounty.id("candy_basket_contents"),
            DataComponentType.<CandyBasketContents>builder()
                    .persistent(CandyBasketContents.CODEC).build());

    public static void init() {}

}
