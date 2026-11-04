package bee.bounty.datagen;

import bee.bounty.BountifulBounty;
import bee.bounty.block.FruitLeavesBlock;
import bee.bounty.registry.BountyBlockProperties;
import bee.bounty.registry.BountyBlocks;
import bee.bounty.registry.BountyItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;


public class BountyModelGen extends FabricModelProvider {

    public BountyModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        createVanillaFlowerBlock(Blocks.ALLIUM, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.ORANGE_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.PINK_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.RED_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.WHITE_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.DANDELION, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.POPPY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.BLUE_ORCHID, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.AZURE_BLUET, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.OXEYE_DAISY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.CORNFLOWER, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.LILY_OF_THE_VALLEY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createVanillaFlowerBlock(Blocks.WITHER_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);

        createFlowerBlock(BountyBlocks.RED_ROSE, BountyBlocks.POTTED_RED_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.CYAN_ROSE, BountyBlocks.POTTED_CYAN_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.PINK_ROSE, BountyBlocks.POTTED_PINK_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);

        createFlowerBlock(BountyBlocks.BLUE_ANEMONE, BountyBlocks.POTTED_BLUE_ANEMONE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.CRIMSON_LILY, BountyBlocks.POTTED_CRIMSON_LILY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_POTENTILLA, BountyBlocks.POTTED_DUSK_POTENTILLA, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_TULIP, BountyBlocks.POTTED_DUSK_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.EMERALD_ZINNIA, BountyBlocks.POTTED_EMERALD_ZINNIA, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.OVERWORLDS_BOUNTY, BountyBlocks.POTTED_OVERWORLDS_BOUNTY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.PERENNIAL, BountyBlocks.POTTED_PERENNIAL, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.PINWHEEL_DAISY, BountyBlocks.POTTED_PINWHEEL_DAISY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.RELIC_FLOWER, BountyBlocks.POTTED_RELIC_FLOWER, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);

        createFlowerBlock(BountyBlocks.DUSK_ZINNIA, BountyBlocks.POTTED_DUSK_ZINNIA, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_PERENNIAL, BountyBlocks.POTTED_DUSK_PERENNIAL, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_ALLIUM, BountyBlocks.POTTED_DUSK_ALLIUM, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_ORCHID, BountyBlocks.POTTED_DUSK_ORCHID, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_POPPY, BountyBlocks.POTTED_DUSK_POPPY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_CORNFLOWER, BountyBlocks.POTTED_DUSK_CORNFLOWER, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_LILY, BountyBlocks.POTTED_DUSK_LILY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_DANDELION, BountyBlocks.POTTED_DUSK_DANDELION, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_BLUET, BountyBlocks.POTTED_DUSK_BLUET, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_DAISY, BountyBlocks.POTTED_DUSK_DAISY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);


        blockModelGenerators.createDoublePlantWithDefaultItem(BountyBlocks.TALL_PINK_ROSE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createDoublePlantWithDefaultItem(BountyBlocks.TALL_CYAN_ROSE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createDoublePlantWithDefaultItem(BountyBlocks.TALL_WITHER_ROSE, BlockModelGenerators.PlantType.NOT_TINTED);
        createSunflower(blockModelGenerators, BountyBlocks.BLACK_SUNFLOWER);


        blockModelGenerators.family(BountyBlocks.FRUIT_BLOCK_FAMILY.getBaseBlock()).generateFor(BountyBlocks.FRUIT_BLOCK_FAMILY);

        blockModelGenerators.woodProvider(BountyBlocks.FRUIT_LOG).log(BountyBlocks.FRUIT_LOG).wood(BountyBlocks.FRUIT_WOOD);
        blockModelGenerators.woodProvider(BountyBlocks.STRIPPED_FRUIT_LOG).log(BountyBlocks.STRIPPED_FRUIT_LOG).wood(BountyBlocks.STRIPPED_FRUIT_WOOD);
        blockModelGenerators.createShelf(BountyBlocks.FRUIT_SHELF, BountyBlocks.STRIPPED_FRUIT_LOG);
        blockModelGenerators.createHangingSign(BountyBlocks.STRIPPED_FRUIT_WOOD, BountyBlocks.FRUIT_HANGING_SIGN, BountyBlocks.FRUIT_WALL_HANGING_SIGN);

        createLeaves(blockModelGenerators, BountyBlocks.APPLE_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.APPLE_SAPLING, BountyBlocks.POTTED_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        createLeaves(blockModelGenerators, BountyBlocks.GREEN_APPLE_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.GREEN_APPLE_SAPLING, BountyBlocks.POTTED_GREEN_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        createLeaves(blockModelGenerators, BountyBlocks.LIME_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.LIME_SAPLING, BountyBlocks.POTTED_LIME_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        createLeaves(blockModelGenerators, BountyBlocks.LEMON_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.LEMON_SAPLING, BountyBlocks.POTTED_LEMON_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        createLeaves(blockModelGenerators, BountyBlocks.ORANGE_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.ORANGE_SAPLING, BountyBlocks.POTTED_ORANGE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        createLeaves(blockModelGenerators, BountyBlocks.WHITE_CHERRY_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.WHITE_CHERRY_SAPLING, BountyBlocks.POTTED_WHITE_CHERRY_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        createLeaves(blockModelGenerators, BountyBlocks.PEAR_LEAVES);
        blockModelGenerators.createPlantWithDefaultItem(BountyBlocks.PEAR_SAPLING, BountyBlocks.POTTED_PEAR_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(BountyItems.GREEN_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LIME, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LEMON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.ORANGE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.CHERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.PEAR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(BountyItems.CHOCOLATE_BAR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(BountyItems.CHOCOLATE_PIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.SWEET_BERRY_PIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.GLOW_BERRY_PIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.APPLE_PIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LIME_PIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LEMON_PIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.CHERRY_PIE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(BountyItems.GLOW_BERRY_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.SWEET_BERRY_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.APPLE_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.GREEN_APPLE_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LIME_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LEMON_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.ORANGE_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.PEAR_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.CHERRY_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.CANDY_CORN, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(BountyItems.CHERRY_CHOCOLATE_COOKIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(BountyItems.LEMON_COOKIE, ModelTemplates.FLAT_ITEM);

    }

    private void createLeaves(BlockModelGenerators generators, Block block) {
        MultiVariant unmatured = plainVariant(TexturedModel.LEAVES.create(block, generators.modelOutput));
        MultiVariant growing = plainVariant(generators.createSuffixedVariant(block, "_growing", ModelTemplates.LEAVES, TextureMapping::cube));
        MultiVariant unripe = plainVariant(generators.createSuffixedVariant(block, "_unripe", ModelTemplates.LEAVES, TextureMapping::cube));
        MultiVariant ripe = plainVariant(generators.createSuffixedVariant(block, "_ripe", ModelTemplates.LEAVES, TextureMapping::cube));

        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(FruitLeavesBlock.GROWTH)
                        .select(0, unmatured)
                        .select(1, growing)
                        .select(2, unripe)
                        .select(3, ripe))
        );

    }

    private void createSunflower(BlockModelGenerators generators, Block block) {
        generators.registerSimpleFlatItemModel(block, "_front");
        MultiVariant topModel = plainVariant(ModelLocationUtils.getModelLocation(block, "_top"));
        MultiVariant bottomModel = plainVariant(
                generators.createSuffixedVariant(block, "_bottom", BlockModelGenerators.PlantType.NOT_TINTED.getCross(), TextureMapping::cross)
        );
        generators.createDoubleBlock(block, topModel, bottomModel);
    }


    public void createVanillaFlowerBlock(Block block, BlockModelGenerators generators, BlockModelGenerators.PlantType type) {

        MultiVariant variant1 = plainVariant(type.getCross().createWithSuffix(block, "_1", type.getTextureMapping(block), generators.modelOutput));
        MultiVariant variant2 = plainVariant(type.getCross().createWithSuffix(block, "_2", getFlowerTextureMapping(block, "_2"), generators.modelOutput));
        MultiVariant variant3 = plainVariant(type.getCross().createWithSuffix(block, "_3", getFlowerTextureMapping(block, "_3"), generators.modelOutput));
        MultiVariant variant4 = plainVariant(type.getCross().createWithSuffix(block, "_4", getFlowerTextureMapping(block, "_4"), generators.modelOutput));

        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BountyBlockProperties.SIZE)
                        .select(1, variant1)
                        .select(2, variant2)
                        .select(3, variant3)
                        .select(4, variant4))
        );


    }

    public void createFlowerBlock(Block block, Block potted, BlockModelGenerators generators, BlockModelGenerators.PlantType type) {

        MultiVariant variant1 = plainVariant(type.getCross().createWithSuffix(block, "_1", getFlowerTextureMapping(block, "_1"), generators.modelOutput));
        MultiVariant variant2 = plainVariant(type.getCross().createWithSuffix(block, "_2", getFlowerTextureMapping(block, "_2"), generators.modelOutput));
        MultiVariant variant3 = plainVariant(type.getCross().createWithSuffix(block, "_3", getFlowerTextureMapping(block, "_3"), generators.modelOutput));
        MultiVariant variant4 = plainVariant(type.getCross().createWithSuffix(block, "_4", getFlowerTextureMapping(block, "_4"), generators.modelOutput));
        MultiVariant pottedModel = plainVariant(type.getCrossPot().create(potted, getFlowerPotTextureMapping(block, "_1"), generators.modelOutput));
        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BountyBlockProperties.SIZE)
                        .select(1, variant1)
                        .select(2, variant2)
                        .select(3, variant3)
                        .select(4, variant4))
        );

        generators.blockStateOutput.accept(createSimpleBlock(potted, pottedModel));


        generators.registerSimpleItemModel(block.asItem(), ModelTemplates.FLAT_ITEM.create(block, getFlowerItemTextureMapping(block), generators.modelOutput));

    }

    public TextureMapping getFlowerTextureMapping(Block block, String suffix) {
        Identifier identifier = BountifulBounty.id(BuiltInRegistries.BLOCK.getKey(block).getPath()).withPrefix("block/").withSuffix(suffix);
        return TextureMapping.cross(identifier);
    }

    public TextureMapping getFlowerPotTextureMapping(Block block, String suffix) {
        Identifier identifier = BountifulBounty.id(BuiltInRegistries.BLOCK.getKey(block).getPath()).withPrefix("block/").withSuffix(suffix);
        return TextureMapping.plant(identifier);
    }

    public TextureMapping getFlowerItemTextureMapping(Block block) {
        Identifier identifier = BountifulBounty.id(BuiltInRegistries.BLOCK.getKey(block).getPath()).withPrefix("block/").withSuffix("_1");
        return TextureMapping.layer0(identifier);
    }


}
