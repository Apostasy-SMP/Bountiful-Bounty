package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.block.BountifulFlowerBlock;
import bee.bounty.block.NetherFlowerBlock;
import bee.bounty.block.OverworldsBountyBlock;
import bee.bounty.block.TallWitherRose;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class BountyBlocks {

    public static final Block RED_ROSE = register("red_rose", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block CYAN_ROSE = register("cyan_rose", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_CYAN), true);
    public static final Block PINK_ROSE = register("pink_rose", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_PINK), true);
    public static final Block BLUE_ANEMONE = register("blue_anemone", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block CRIMSON_LILY = register("crimson_lily", properties -> new NetherFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_POTENTILLA = register("dusk_potentilla", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_TULIP = register("dusk_tulip", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block EMERALD_ZINNIA = register("emerald_zinnia", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block OVERWORLDS_BOUNTY = register("overworlds_bounty", properties -> new OverworldsBountyBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block PERENNIAL = register("perennial", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block PINWHEEL_DAISY = register("pinwheel_daisy", properties -> new NetherFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block RELIC_FLOWER = register("relic_flower", properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);

    public static final Block POTTED_RED_ROSE = register("potted_red_rose", properties -> new FlowerPotBlock(RED_ROSE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_CYAN_ROSE = register("potted_cyan_rose", properties -> new FlowerPotBlock(CYAN_ROSE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).mapColor(MapColor.COLOR_CYAN), false);
    public static final Block POTTED_PINK_ROSE = register("potted_pink_rose", properties -> new FlowerPotBlock(PINK_ROSE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).mapColor(MapColor.COLOR_PINK), false);
    public static final Block POTTED_BLUE_ANEMONE = register("potted_blue_anemone", properties -> new FlowerPotBlock(BLUE_ANEMONE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_CRIMSON_LILY = register("potted_crimson_lily", properties -> new FlowerPotBlock(CRIMSON_LILY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_POTENTILLA = register("potted_dusk_potentilla", properties -> new FlowerPotBlock(DUSK_POTENTILLA, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_TULIP = register("potted_dusk_tulip", properties -> new FlowerPotBlock(DUSK_TULIP, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_EMERALD_ZINNIA = register("potted_emerald_zinnia", properties -> new FlowerPotBlock(EMERALD_ZINNIA, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_OVERWORLDS_BOUNTY = register("potted_overworlds_bounty", properties -> new FlowerPotBlock(OVERWORLDS_BOUNTY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_PERENNIAL = register("potted_perennial", properties -> new FlowerPotBlock(PERENNIAL, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_PINWHEEL_DAISY = register("potted_pinwheel_daisy", properties -> new FlowerPotBlock(PINWHEEL_DAISY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_RELIC_FLOWER = register("potted_relic_flower", properties -> new FlowerPotBlock(RELIC_FLOWER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);


    public static final Block TALL_WITHER_ROSE = register("tall_wither_rose", TallWitherRose::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_BLACK), true);
    public static final Block TALL_CYAN_ROSE = register("tall_cyan_rose", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_CYAN), true);
    public static final Block TALL_PINK_ROSE = register("tall_pink_rose", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_PINK), true);
    public static final Block BLACK_SUNFLOWER = register("black_sunflower", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER).mapColor(MapColor.COLOR_BLACK), true);



    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, BountifulBounty.id(name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, BountifulBounty.id(name));
    }

    public static void init() {
    }

}
