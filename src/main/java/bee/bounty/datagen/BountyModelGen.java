package bee.bounty.datagen;

import bee.bounty.BountifulBounty;
import bee.bounty.registry.BountyBlockProperties;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BountyModelGen extends FabricModelProvider {
    public BountyModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        createFlowerBlock(Blocks.ALLIUM, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.ORANGE_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.PINK_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.RED_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.WHITE_TULIP, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.DANDELION, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.POPPY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.BLUE_ORCHID, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.AZURE_BLUET, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.OXEYE_DAISY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.CORNFLOWER, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.LILY_OF_THE_VALLEY, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.OPEN_EYEBLOSSOM, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.CLOSED_EYEBLOSSOM, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.WITHER_ROSE, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
        createFlowerBlock(Blocks.TORCHFLOWER, blockModelGenerators, BlockModelGenerators.PlantType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }


    public void createFlowerBlock(Block block, BlockModelGenerators generators, BlockModelGenerators.PlantType  type) {

        MultiVariant variant1 = BlockModelGenerators.plainVariant(type.getCross().createWithSuffix(block, "_1", type.getTextureMapping(block), generators.modelOutput));
        MultiVariant variant2 = BlockModelGenerators.plainVariant(type.getCross().createWithSuffix(block, "_2", getFlowerTextureMapping(block, "_2"), generators.modelOutput));
        MultiVariant variant3 = BlockModelGenerators.plainVariant(type.getCross().createWithSuffix(block, "_3", getFlowerTextureMapping(block, "_3"), generators.modelOutput));
        MultiVariant variant4 = BlockModelGenerators.plainVariant(type.getCross().createWithSuffix(block, "_4", getFlowerTextureMapping(block, "_4"), generators.modelOutput));

        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BountyBlockProperties.SIZE)
                        .select(1, variant1)
                        .select(2, variant2)
                        .select(3, variant3)
                        .select(4, variant4))
        );


    }

    public TextureMapping getFlowerTextureMapping(Block block, String suffix) {
        Identifier identifier = BountifulBounty.id(BuiltInRegistries.BLOCK.getKey(block).getPath()).withPrefix("block/").withSuffix(suffix);
        return TextureMapping.cross(identifier);
    }


}
