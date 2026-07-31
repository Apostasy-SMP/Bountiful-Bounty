package bee.bounty.datagen;

import bee.bounty.BountifulBounty;
import bee.bounty.registry.BountyBlockProperties;
import bee.bounty.registry.BountyBlocks;
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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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

        createFlowerBlock(BountyBlocks.RED_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.CYAN_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.PINK_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);

        createFlowerBlock(BountyBlocks.BLUE_ANEMONE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.CRIMSON_LILY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_POTENTILLA, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.DUSK_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.EMERALD_ZINNIA, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.OVERWORLDS_BOUNTY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.PERENNIAL, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.PINWHEEL_DAISY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(BountyBlocks.RELIC_FLOWER, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);

        blockModelGenerators.createDoublePlantWithDefaultItem(BountyBlocks.TALL_PINK_ROSE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createDoublePlantWithDefaultItem(BountyBlocks.TALL_CYAN_ROSE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createDoublePlantWithDefaultItem(BountyBlocks.TALL_WITHER_ROSE, BlockModelGenerators.PlantType.NOT_TINTED);
        createSunflower(blockModelGenerators, BountyBlocks.BLACK_SUNFLOWER);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }

    private void createSunflower(BlockModelGenerators generators, Block block) {
        generators.registerSimpleFlatItemModel(block, "_front");
        MultiVariant topModel = plainVariant(ModelLocationUtils.getModelLocation(block, "_top"));
        MultiVariant bottomModel = plainVariant(
                generators.createSuffixedVariant(block, "_bottom", BlockModelGenerators.PlantType.NOT_TINTED.getCross(), TextureMapping::cross)
        );
        generators.createDoubleBlock(block, topModel, bottomModel);
    }



    public void createVanillaFlowerBlock(Block block, BlockModelGenerators generators, BlockModelGenerators.PlantType  type) {

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

    public void createFlowerBlock(Block block, BlockModelGenerators generators, BlockModelGenerators.PlantType  type) {

        MultiVariant variant1 = plainVariant(type.getCross().createWithSuffix(block, "_1", getFlowerTextureMapping(block, "_1"), generators.modelOutput));
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


        generators.registerSimpleItemModel(block.asItem(), ModelTemplates.FLAT_ITEM.create(block, getFlowerItemTextureMapping(block), generators.modelOutput));

    }

    public TextureMapping getFlowerTextureMapping(Block block, String suffix) {
        Identifier identifier = BountifulBounty.id(BuiltInRegistries.BLOCK.getKey(block).getPath()).withPrefix("block/").withSuffix(suffix);
        return TextureMapping.cross(identifier);
    }

    public TextureMapping getFlowerItemTextureMapping(Block block) {
        Identifier identifier = BountifulBounty.id(BuiltInRegistries.BLOCK.getKey(block).getPath()).withPrefix("block/").withSuffix("_1");
        return TextureMapping.layer0(identifier);
    }


}
