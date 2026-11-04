package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.item.CandyBasketItem;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

import java.util.ArrayList;
import java.util.function.Function;

public class BountyItems {
    public static final ArrayList<Item> ITEMS = new ArrayList<>();

    //Natural

    public static final Item GREEN_APPLE = registerFood("green_apple", new FoodProperties(4, 0.5f, false));
    public static final Item LIME = registerFood("lime", new FoodProperties(2, 0.3f, true));
    public static final Item LEMON = registerFood("lemon", new FoodProperties(2, 0.3f, true));
    public static final Item ORANGE = registerFood("orange", new FoodProperties(5, 0.2f, false));
    public static final Item CHERRY = registerFood("cherry", new FoodProperties(3, 0.6f, false));
    public static final Item PEAR = registerFood("pear", new FoodProperties(4, 0.5f, false));

    //Ingredients

    public static final Item CHOCOLATE_BAR = registerFood("chocolate_bar", new FoodProperties(4, 1.2f, true));

    //Pies

    public static final Item CHOCOLATE_PIE = registerFood("chocolate_pie", new FoodProperties(9, 0.1f, false));
    public static final Item GLOW_BERRY_PIE = registerFood("glow_berry_pie", new FoodProperties(6, 0.75f, false));
    public static final Item SWEET_BERRY_PIE = registerFood("sweet_berry_pie", new FoodProperties(7, 0.3f, false));
    public static final Item APPLE_PIE = registerFood("apple_pie", new FoodProperties(7, 0.3f, false));
    public static final Item LIME_PIE = registerFood("lime_pie", new FoodProperties(5, 1f, false));
    public static final Item LEMON_PIE = registerFood("lemon_pie", new FoodProperties(6, 0.75f, false));
    public static final Item CHERRY_PIE = registerFood("cherry_pie", new FoodProperties(4, 1.2f, false));

    //Candy

    public static final Item CANDY_BASKET = register("candy_basket", CandyBasketItem::new, new Item.Properties().stacksTo(1));

    public static final Item GLOW_BERRY_CANDY = registerFood("glow_berry_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item SWEET_BERRY_CANDY = registerFood("sweet_berry_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item APPLE_CANDY = registerFood("apple_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item GREEN_APPLE_CANDY = registerFood("green_apple_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item LIME_CANDY = registerFood("lime_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item LEMON_CANDY = registerFood("lemon_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item ORANGE_CANDY = registerFood("orange_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item PEAR_CANDY = registerFood("pear_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item CHERRY_CANDY = registerFood("cherry_candy", new FoodProperties(2, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());

    public static final Item CANDY_CORN = registerFood("candy_corn", new FoodProperties(3, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());

    //Baked goods

    public static final Item CHERRY_CHOCOLATE_COOKIE = registerFood("cherry_chocolate_cookie", new FoodProperties(3, 0.2f, true));
    public static final Item LEMON_COOKIE = registerFood("lemon_cookie", new FoodProperties(4, 0.1f, true));

    public static Item registerFood(String name, FoodProperties foodProperties, Consumable... consumable) {
        return register(name, Item::new, new Item.Properties().food(foodProperties, consumable.length > 0 ? consumable[0] : Consumables.DEFAULT_FOOD));
    }

    public static Item register(String name, Function<Item.Properties, Item> function, Item.Properties properties) {

        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, BountifulBounty.id(name));
        Item item = function.apply(properties.setId(key).useBlockDescriptionPrefix());
        ITEMS.add(item);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void init() {
    }

    public static Consumable.Builder defaultFood() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.EAT).sound(SoundEvents.GENERIC_EAT).hasConsumeParticles(true);
    }

}
