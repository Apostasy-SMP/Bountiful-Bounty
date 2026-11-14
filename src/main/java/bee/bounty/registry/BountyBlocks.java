package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.block.*;
import bee.bounty.block.flower.*;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

import static bee.bounty.registry.BountyItems.ITEMS;

public class BountyBlocks {

    public static final Block HALO_FLOWER = registerFlower("halo_flower", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_HALO_FLOWER = registerPottedFlower("potted_halo_flower", HALO_FLOWER);
    public static final Block ANGEL_BLOSSOM = registerFlower("angel_blossom", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_ANGEL_BLOSSOM = registerPottedFlower("potted_angel_blossom", ANGEL_BLOSSOM);
    public static final Block FARLOW_LILY = registerFlower("farlow_lily", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_FARLOW_LILY = registerPottedFlower("potted_farlow_lily", FARLOW_LILY);
    public static final Block WHITE_CARNATION = registerFlower("white_carnation", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_WHITE_CARNATION = registerPottedFlower("potted_white_carnation", WHITE_CARNATION);
    public static final Block RED_CARNATION = registerFlower("red_carnation", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_RED_CARNATION = registerPottedFlower("potted_red_carnation", RED_CARNATION);
    public static final Block BLUE_CARNATION = registerFlower("blue_carnation", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_BLUE_CARNATION = registerPottedFlower("potted_blue_carnation", BLUE_CARNATION);
    public static final Block YELLOW_CARNATION = registerFlower("yellow_carnation", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_YELLOW_CARNATION = registerPottedFlower("potted_yellow_carnation", YELLOW_CARNATION);
    public static final Block FOXGLOVE = registerFlower("foxglove", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_FOXGLOVE = registerPottedFlower("potted_foxglove", FOXGLOVE);
    public static final Block GLACIAL_FOXGLOVE = registerFlower("glacial_foxglove", MobEffects.HEALTH_BOOST, 1);
    public static final Block POTTED_GLACIAL_FOXGLOVE = registerPottedFlower("potted_glacial_foxglove", GLACIAL_FOXGLOVE);

    public static final Block FLAME_LILY = registerCompostable("flame_lily", properties -> new FlameLilyBlock(MobEffects.FIRE_RESISTANCE, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block POTTED_FLAME_LILY = registerPottedFlower("potted_flame_lily", FLAME_LILY);
    public static final Block VOID_LILY = registerCompostable("void_lily", properties -> new VoidLily(MobEffects.FIRE_RESISTANCE, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block POTTED_VOID_LILY = registerPottedFlower("potted_void_lily", VOID_LILY);
    public static final Block ZAP_LILY = registerCompostable("zap_lily", properties -> new ZapLily(MobEffects.FIRE_RESISTANCE, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block POTTED_ZAP_LILY = registerPottedFlower("potted_zap_lily", ZAP_LILY);
    public static final Block FROST_LILY = registerCompostable("frost_lily", properties -> new FrostLily(MobEffects.BLINDNESS, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block POTTED_FROST_LILY = registerPottedFlower("potted_frost_lily", FROST_LILY);

    public static final Block SCARLET_WILDFLOWERS = registerCompostable("scarlet_wildflowers", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WILDFLOWERS), true);
    public static final Block MIDNIGHT_WILDFLOWERS = registerCompostable("midnight_wildflowers", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WILDFLOWERS), true);
    public static final Block FROSTY_WILDFLOWERS = registerCompostable("frosty_wildflowers", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WILDFLOWERS), true);
    public static final Block ENCHANTED_WILDFLOWERS = registerCompostable("enchanted_wildflowers", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WILDFLOWERS), true);
    public static final Block DUSK_WILDFLOWERS = registerCompostable("dusk_wildflowers", FlowerBedBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WILDFLOWERS), true);

    public static final Block RED_ROSE = registerCompostable("red_rose", properties -> new BountifulFlowerBlock(MobEffects.HEALTH_BOOST, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block CYAN_ROSE = registerCompostable("cyan_rose", properties -> new BountifulFlowerBlock(MobEffects.LEVITATION, 2.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_CYAN), true);
    public static final Block PINK_ROSE = registerCompostable("pink_rose", properties -> new BountifulFlowerBlock(MobEffects.OOZING, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).mapColor(MapColor.COLOR_PINK), true);
    public static final Block BLUE_ANEMONE = registerCompostable("blue_anemone", properties -> new BountifulFlowerBlock(MobEffects.CONDUIT_POWER, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block CRIMSON_LILY = registerCompostable("crimson_lily", properties -> new NetherFlowerBlock(MobEffects.UNLUCK, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_POTENTILLA = registerCompostable("dusk_potentilla", properties -> new BountifulFlowerBlock(MobEffects.WIND_CHARGED, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_TULIP = registerCompostable("dusk_tulip", properties -> new BountifulFlowerBlock(MobEffects.INFESTED, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block EMERALD_ZINNIA = registerCompostable("emerald_zinnia", properties -> new BountifulFlowerBlock(MobEffects.HEALTH_BOOST, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block OVERWORLDS_BOUNTY = registerCompostable("overworlds_bounty", properties -> new OverworldsBountyBlock(MobEffects.TRIAL_OMEN, 2.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block PERENNIAL = registerCompostable("perennial", properties -> new BountifulFlowerBlock(MobEffects.GLOWING, 7.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block PINWHEEL_DAISY = registerCompostable("pinwheel_daisy", properties -> new NetherFlowerBlock(MobEffects.SPEED, 7.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block RELIC_FLOWER = registerCompostable("relic_flower", properties -> new BountifulFlowerBlock(MobEffects.LUCK, 25.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);

    public static final Block DUSK_PERENNIAL = registerCompostable("dusk_perennial", properties -> new BountifulFlowerBlock(MobEffects.HUNGER, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_ZINNIA = registerCompostable("dusk_zinnia", properties -> new BountifulFlowerBlock(MobEffects.HEALTH_BOOST, 3.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_ORCHID = registerCompostable("dusk_orchid", properties -> new BountifulFlowerBlock(MobEffects.SATURATION, 5.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_POPPY = registerCompostable("dusk_poppy", properties -> new BountifulFlowerBlock(MobEffects.INSTANT_DAMAGE, 1.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_ALLIUM = registerCompostable("dusk_allium", properties -> new BountifulFlowerBlock(MobEffects.HASTE, 3.5F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_CORNFLOWER = registerCompostable("dusk_cornflower", properties -> new BountifulFlowerBlock(MobEffects.MINING_FATIGUE, 3.5F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_BLUET = registerCompostable("dusk_bluet", properties -> new BountifulFlowerBlock(MobEffects.SLOW_FALLING, 2.0F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_DAISY = registerCompostable("dusk_daisy", properties -> new BountifulFlowerBlock(MobEffects.BAD_OMEN, 1.2F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_LILY = registerCompostable("dusk_lily", properties -> new BountifulFlowerBlock(MobEffects.LEVITATION, 3.1F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    public static final Block DUSK_DANDELION = registerCompostable("dusk_dandelion", properties -> new BountifulFlowerBlock(MobEffects.LUCK, 0.35F, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);

    public static final Block POTTED_DUSK_ALLIUM = register("potted_dusk_allium", properties -> new FlowerPotBlock(DUSK_ALLIUM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_CORNFLOWER = register("potted_dusk_cornflower", properties -> new FlowerPotBlock(DUSK_CORNFLOWER, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_LILY = register("potted_dusk_lily", properties -> new FlowerPotBlock(DUSK_LILY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_DANDELION = register("potted_dusk_dandelion", properties -> new FlowerPotBlock(DUSK_DANDELION, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_BLUET = register("potted_dusk_bluet", properties -> new FlowerPotBlock(DUSK_BLUET, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_DAISY = register("potted_dusk_daisy", properties -> new FlowerPotBlock(DUSK_DAISY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_ORCHID = register("potted_dusk_orchid", properties -> new FlowerPotBlock(DUSK_ORCHID, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_POPPY = register("potted_dusk_poppy", properties -> new FlowerPotBlock(DUSK_POPPY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_ZINNIA = register("potted_dusk_zinnia", properties -> new FlowerPotBlock(DUSK_ZINNIA, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    public static final Block POTTED_DUSK_PERENNIAL = register("potted_dusk_perennial", properties -> new FlowerPotBlock(DUSK_PERENNIAL, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);


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


    public static final Block TALL_WITHER_ROSE = registerCompostable("tall_wither_rose", TallWitherRose::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_BLACK), true);
    public static final Block TALL_CYAN_ROSE = registerCompostable("tall_cyan_rose", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_CYAN), true);
    public static final Block TALL_PINK_ROSE = registerCompostable("tall_pink_rose", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ROSE_BUSH).mapColor(MapColor.COLOR_PINK), true);
    public static final Block BLACK_SUNFLOWER = registerCompostable("black_sunflower", TallFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER).mapColor(MapColor.COLOR_BLACK), true);

    // Fruits

    public static final Block APPLE_LEAVES = registerCompostable("apple_leaves", p -> new FruitLeavesBlock(Items.APPLE, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block APPLE_SAPLING = registerCompostable("apple_sapling", p -> new SaplingBlock(BountyTreeGrowers.APPLE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_APPLE_SAPLING = register("potted_apple_sapling", p -> new FlowerPotBlock(APPLE_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block GREEN_APPLE_LEAVES = registerCompostable("green_apple_leaves", p -> new FruitLeavesBlock(BountyItems.GREEN_APPLE, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block GREEN_APPLE_SAPLING = registerCompostable("green_apple_sapling", p -> new SaplingBlock(BountyTreeGrowers.GREEN_APPLE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_GREEN_APPLE_SAPLING = register("potted_green_apple_sapling", p -> new FlowerPotBlock(GREEN_APPLE_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block LIME_LEAVES = registerCompostable("lime_leaves", p -> new FruitLeavesBlock(BountyItems.LIME, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block LIME_SAPLING = registerCompostable("lime_sapling", p -> new SaplingBlock(BountyTreeGrowers.LIME, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_LIME_SAPLING = register("potted_lime_sapling", p -> new FlowerPotBlock(LIME_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block LEMON_LEAVES = registerCompostable("lemon_leaves", p -> new FruitLeavesBlock(BountyItems.LEMON, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block LEMON_SAPLING = registerCompostable("lemon_sapling", p -> new SaplingBlock(BountyTreeGrowers.LEMON, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_LEMON_SAPLING = register("potted_lemon_sapling", p -> new FlowerPotBlock(LEMON_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block ORANGE_LEAVES = registerCompostable("orange_leaves", p -> new FruitLeavesBlock(BountyItems.ORANGE, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block ORANGE_SAPLING = registerCompostable("orange_sapling", p -> new SaplingBlock(BountyTreeGrowers.ORANGE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_ORANGE_SAPLING = register("potted_orange_sapling", p -> new FlowerPotBlock(ORANGE_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block WHITE_CHERRY_LEAVES = registerCompostable("white_cherry_leaves", p -> new FruitLeavesBlock(BountyItems.CHERRY, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block WHITE_CHERRY_SAPLING = registerCompostable("white_cherry_sapling", p -> new SaplingBlock(BountyTreeGrowers.CHERRY, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_WHITE_CHERRY_SAPLING = register("white_potted_cherry_sapling", p -> new FlowerPotBlock(WHITE_CHERRY_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block PEAR_LEAVES = registerCompostable("pear_leaves", p -> new FruitLeavesBlock(BountyItems.PEAR, 0.01f, p), leavesProperties(SoundType.GRASS), true);
    public static final Block PEAR_SAPLING = registerCompostable("pear_sapling", p -> new SaplingBlock(BountyTreeGrowers.PEAR, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true);
    public static final Block POTTED_PEAR_SAPLING = register("potted_pear_sapling", p -> new FlowerPotBlock(PEAR_SAPLING, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);

    public static final Block BLUE_BERRY_BUSH = register("blue_berry_bush", BlueBerryBushBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).noCollision(), false);
    public static final Block POTTED_BLUE_BERRY_BUSH = register("potted_blue_berry_bush", p -> new FlowerPotBlock(BLUE_BERRY_BUSH, p), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT), false);


    //Fruit wood set

    public static final BlockSetType FRUIT_BLOCK_SET_TYPE = new BlockSetType("fruit");
    public static final WoodType FRUIT_WOOD_TYPE = new WoodTypeBuilder().register(BountifulBounty.id("fruit"), FRUIT_BLOCK_SET_TYPE);


    public static final Block FRUIT_LOG = register("fruit_log", RotatedPillarBlock::new, logProperties(MapColor.WOOD, MapColor.WOOD, SoundType.WOOD), true);
    public static final Block STRIPPED_FRUIT_LOG = register("stripped_fruit_log", RotatedPillarBlock::new, logProperties(MapColor.WOOD, MapColor.WOOD, SoundType.WOOD), true);
    public static final Block FRUIT_WOOD = register("fruit_wood", RotatedPillarBlock::new, logProperties(MapColor.WOOD, MapColor.WOOD, SoundType.WOOD), true);
    public static final Block STRIPPED_FRUIT_WOOD = register("stripped_fruit_wood", RotatedPillarBlock::new, logProperties(MapColor.WOOD, MapColor.WOOD, SoundType.WOOD), true);

    public static final Block FRUIT_PLANKS = register("fruit_planks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), true);
    public static final Block FRUIT_STAIRS = register("fruit_stairs", p -> new StairBlock(FRUIT_PLANKS.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS), true);
    public static final Block FRUIT_SLAB = register("fruit_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB), true);
    public static final Block FRUIT_FENCE = register("fruit_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE), true);
    public static final Block FRUIT_FENCE_GATE = register("fruit_fence_gate", p -> new FenceGateBlock(FRUIT_WOOD_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE), true);
    public static final Block FRUIT_PRESSURE_PLATE = register("fruit_pressure_plate", p -> new PressurePlateBlock(FRUIT_BLOCK_SET_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), true);
    public static final Block FRUIT_BUTTON = register("fruit_button", p -> new ButtonBlock(FRUIT_BLOCK_SET_TYPE, 30, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), true);
    public static final Block FRUIT_DOOR = register("fruit_door", p -> new DoorBlock(FRUIT_BLOCK_SET_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR), true);
    public static final Block FRUIT_TRAPDOOR = register("fruit_trapdoor", p -> new TrapDoorBlock(FRUIT_BLOCK_SET_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR), true);
    public static final Block FRUIT_SHELF = register("fruit_shelf", ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR), true);
    public static final Block FRUIT_WALL_HANGING_SIGN = register("fruit_wall_hanging_sign", p -> new WallHangingSignBlock(FRUIT_WOOD_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), false);
    public static final Block FRUIT_HANGING_SIGN = register("fruit_hanging_sign", p -> new CeilingHangingSignBlock(FRUIT_WOOD_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), false);
    public static final Block FRUIT_WALL_SIGN = register("fruit_wall_sign", p -> new WallSignBlock(FRUIT_WOOD_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), false);
    public static final Block FRUIT_SIGN = register("fruit_sign", p -> new StandingSignBlock(FRUIT_WOOD_TYPE, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN), false);
    public static final Item FRUIT_SIGN_ITEM = BountyItems.register("fruit_sign", p -> new StandingAndWallBlockItem(BountyBlocks.FRUIT_SIGN, BountyBlocks.FRUIT_WALL_SIGN, Direction.DOWN, p.useBlockDescriptionPrefix()), new Item.Properties().useBlockDescriptionPrefix());
    public static final Item FRUIT_HANGING_SIGN_ITEM = BountyItems.register("fruit_hanging_sign", p -> new HangingSignItem(BountyBlocks.FRUIT_HANGING_SIGN, BountyBlocks.FRUIT_WALL_HANGING_SIGN, p.useBlockDescriptionPrefix()), new Item.Properties().useBlockDescriptionPrefix());

    public static final BlockFamily FRUIT_BLOCK_FAMILY =
            new BlockFamily.Builder(FRUIT_PLANKS)
                    .stairs(FRUIT_STAIRS)
                    .slab(FRUIT_SLAB)
                    .fence(FRUIT_FENCE)
                    .fenceGate(FRUIT_FENCE_GATE)
                    .pressurePlate(FRUIT_PRESSURE_PLATE)
                    .button(FRUIT_BUTTON)
                    .door(FRUIT_DOOR)
                    .trapdoor(FRUIT_TRAPDOOR)
                    .sign(FRUIT_SIGN, FRUIT_WALL_SIGN)
                    .recipeGroupPrefix("wooden")
                    .recipeUnlockedBy("has_planks")
                    .getFamily();


    //Table

    public static final Block BOTANY_TABLE = register("botany_table", BotanyTableBlock::new, BlockBehaviour.Properties.of(), true);

    //Plant variants



    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
            ITEMS.add(blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static Block registerFlower(String name, Holder<MobEffect> effect, float duration) {
        return registerCompostable(name, p -> new BountifulFlowerBlock(effect, duration, p), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY), true);
    }

    private static Block registerPottedFlower(String name, Block block) {
        return register(name, p -> new FlowerPotBlock(block, p), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM), false);
    }

    private static Block registerCompostable(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            CompostingChanceRegistry.INSTANCE.add(blockItem, 0.5f);
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
            ITEMS.add(blockItem);
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

    public static BlockBehaviour.Properties leavesProperties(final SoundType soundType) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(soundType).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never).ignitedByLava().isRedstoneConductor(Blocks::never);
    }

    public static BlockBehaviour.Properties logProperties(final MapColor topColor, final MapColor sideColor, final SoundType soundType) {
        return BlockBehaviour.Properties.of().mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(soundType).ignitedByLava();
    }

}
