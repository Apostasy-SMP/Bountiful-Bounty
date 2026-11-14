package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.item.CandyBasketItem;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.ArrayList;
import java.util.function.Function;

public class BountyItems {
    public static final ArrayList<Item> ITEMS = new ArrayList<>();

    //Natural

    public static final Item GREEN_APPLE = registerFood("green_apple", new FoodProperties(4, 1.5f, false));
    public static final Item LIME = registerFood("lime", new FoodProperties(2, 1f, true));
    public static final Item LEMON = registerFood("lemon", new FoodProperties(2, 1f, true));
    public static final Item ORANGE = registerFood("orange", new FoodProperties(5, 2f, false));
    public static final Item CHERRY = registerFood("cherry", new FoodProperties(3, 1f, false));
    public static final Item PEAR = registerFood("pear", new FoodProperties(4, 1f, false));
    public static final Item BLUE_BERRIES = register("blue_berries", p -> new BlockItem(BountyBlocks.BLUE_BERRY_BUSH, p.useBlockDescriptionPrefix()), new Item.Properties().useBlockDescriptionPrefix().food(new FoodProperties(5, 1f, false)));

    //Ingredients

    public static final Item CHOCOLATE_BAR = registerFood("chocolate_bar", new FoodProperties(5, 3f, true));

    //Pies

    public static final Item CHOCOLATE_PIE = registerFood("chocolate_pie", new FoodProperties(6, 2.1f, false));
    public static final Item GLOW_BERRY_PIE = registerFood("glow_berry_pie", new FoodProperties(6, 3.2f, false), defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 200))).build());
    public static final Item SWEET_BERRY_PIE = registerFood("sweet_berry_pie", new FoodProperties(6, 2.6f, false));
    public static final Item APPLE_PIE = registerFood("apple_pie", new FoodProperties(6, 4.5f, false));
    public static final Item LIME_PIE = registerFood("lime_pie", new FoodProperties(6, 3f, false));
    public static final Item LEMON_PIE = registerFood("lemon_pie", new FoodProperties(6, 3f, false));
    public static final Item CHERRY_PIE = registerFood("cherry_pie", new FoodProperties(4, 5f, false));
    public static final Item BLUE_BERRY_PIE = registerFood("blue_berry_pie", new FoodProperties(5, 3f, false));

    //Candy

    public static final Item CANDY_BASKET = register("candy_basket", CandyBasketItem::new, new Item.Properties().stacksTo(1));

    public static final Item GLOW_BERRY_CANDY = registerFood("glow_berry_candy", new FoodProperties(3, 0.5f, true), defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 100))).consumeSeconds(0.6f).build());
    public static final Item SWEET_BERRY_CANDY = registerFood("sweet_berry_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item APPLE_CANDY = registerFood("apple_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item GREEN_APPLE_CANDY = registerFood("green_apple_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item LIME_CANDY = registerFood("lime_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item LEMON_CANDY = registerFood("lemon_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item ORANGE_CANDY = registerFood("orange_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item PEAR_CANDY = registerFood("pear_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item CHERRY_CANDY = registerFood("cherry_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());
    public static final Item BLUE_BERRY_CANDY = registerFood("blue_berry_candy", new FoodProperties(3, 0.5f, true), defaultFood().consumeSeconds(0.6f).build());

    public static final Item CANDY_CORN = registerFood("candy_corn", new FoodProperties(3, 0.1f, true), defaultFood().consumeSeconds(0.6f).build());

    public static final Item LOLLIPOP = register("lollipop", Item::new, new Item.Properties()
            .attributes(ItemAttributeModifiers.builder()
                    .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 8.1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                    .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -3.1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                    .build())
            .durability(240).food(new FoodProperties(5, 2f, true)));
    //Baked goods

    public static final Item CHERRY_CHOCOLATE_COOKIE = registerFood("cherry_chocolate_cookie", new FoodProperties(3, 1.5f, true));
    public static final Item LEMON_COOKIE = registerFood("lemon_cookie", new FoodProperties(4, 1f, true));
    public static final Item BLUE_BERRY_COOKIE = registerFood("blue_berry_cookie", new FoodProperties(3, 1.5f, true));

    public static Item registerFood(String name, FoodProperties foodProperties, Consumable... consumable) {
        return register(name, Item::new, new Item.Properties().food(foodProperties, consumable.length > 0 ? consumable[0] : Consumables.DEFAULT_FOOD));
    }

    public static Item register(String name, Function<Item.Properties, Item> function, Item.Properties properties) {

        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, BountifulBounty.id(name));
        Item item = function.apply(properties.setId(key));
        ITEMS.add(item);
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void init() {
    }

    public static Consumable.Builder defaultFood() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.EAT).sound(SoundEvents.GENERIC_EAT).hasConsumeParticles(true);
    }

}
