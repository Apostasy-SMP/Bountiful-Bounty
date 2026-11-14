package bee.bounty;

import bee.bounty.item.GrowthProperty;
import bee.bounty.registry.BountyBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.level.GrassColor;

public class BountifulBountyClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {

        RangeSelectItemModelProperties.ID_MAPPER.put(BountifulBounty.id("growth"), GrowthProperty.MAP_CODEC);
        ColorProviderRegistry.BLOCK.register((state, level, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.getDefaultColor();
            } else {
                return -1;
            }
        }, BountyBlocks.SCARLET_WILDFLOWERS, BountyBlocks.MIDNIGHT_WILDFLOWERS, BountyBlocks.FROSTY_WILDFLOWERS,
                BountyBlocks.ENCHANTED_WILDFLOWERS, BountyBlocks.DUSK_WILDFLOWERS);


        BlockRenderLayerMap.putBlock(BountyBlocks.TALL_PINK_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.TALL_WITHER_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.BLACK_SUNFLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.TALL_CYAN_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.CYAN_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.PINK_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.RED_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_POTENTILLA, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.OVERWORLDS_BOUNTY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.BLUE_ANEMONE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.CRIMSON_LILY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_TULIP, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.EMERALD_ZINNIA, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.PERENNIAL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.RELIC_FLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.PINWHEEL_DAISY, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_CYAN_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_PINK_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_RED_ROSE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_POTENTILLA, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_OVERWORLDS_BOUNTY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_BLUE_ANEMONE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_CRIMSON_LILY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_TULIP, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_EMERALD_ZINNIA, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_PERENNIAL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_RELIC_FLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_PINWHEEL_DAISY, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_DAISY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_ZINNIA, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_DANDELION, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_BLUET, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_PERENNIAL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_CORNFLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_ORCHID, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_LILY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_ALLIUM, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_POPPY, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_DAISY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.DUSK_ZINNIA, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_DANDELION, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_BLUET, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_PERENNIAL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_CORNFLOWER, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_ORCHID, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_LILY, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_ALLIUM, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BountyBlocks.POTTED_DUSK_POPPY, ChunkSectionLayer.CUTOUT);

		BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT,
				BountyBlocks.APPLE_LEAVES, BountyBlocks.APPLE_SAPLING, BountyBlocks.POTTED_APPLE_SAPLING,
				BountyBlocks.GREEN_APPLE_LEAVES, BountyBlocks.GREEN_APPLE_SAPLING, BountyBlocks.POTTED_GREEN_APPLE_SAPLING,
				BountyBlocks.LIME_LEAVES, BountyBlocks.LIME_SAPLING, BountyBlocks.POTTED_LIME_SAPLING,
				BountyBlocks.LEMON_LEAVES, BountyBlocks.LEMON_SAPLING, BountyBlocks.POTTED_LEMON_SAPLING,
				BountyBlocks.ORANGE_LEAVES, BountyBlocks.ORANGE_SAPLING, BountyBlocks.POTTED_ORANGE_SAPLING,
				BountyBlocks.WHITE_CHERRY_LEAVES, BountyBlocks.WHITE_CHERRY_SAPLING, BountyBlocks.POTTED_WHITE_CHERRY_SAPLING,
				BountyBlocks.PEAR_LEAVES, BountyBlocks.PEAR_SAPLING, BountyBlocks.POTTED_PEAR_SAPLING,
				BountyBlocks.FRUIT_FENCE, BountyBlocks.FRUIT_DOOR, BountyBlocks.FRUIT_FENCE_GATE,
				BountyBlocks.FRUIT_HANGING_SIGN, BountyBlocks.FRUIT_WALL_HANGING_SIGN, BountyBlocks.FRUIT_TRAPDOOR,
                BountyBlocks.BLUE_BERRY_BUSH, BountyBlocks.BLUE_BERRY_BUSH,

                BountyBlocks.HALO_FLOWER, BountyBlocks.POTTED_HALO_FLOWER,
                BountyBlocks.ANGEL_BLOSSOM, BountyBlocks.POTTED_ANGEL_BLOSSOM,
                BountyBlocks.FARLOW_LILY, BountyBlocks.POTTED_FARLOW_LILY,
                BountyBlocks.WHITE_CARNATION, BountyBlocks.POTTED_WHITE_CARNATION,
                BountyBlocks.RED_CARNATION, BountyBlocks.POTTED_RED_CARNATION,
                BountyBlocks.BLUE_CARNATION, BountyBlocks.POTTED_BLUE_CARNATION,
                BountyBlocks.YELLOW_CARNATION, BountyBlocks.POTTED_YELLOW_CARNATION,
                BountyBlocks.FOXGLOVE, BountyBlocks.POTTED_FOXGLOVE,
                BountyBlocks.GLACIAL_FOXGLOVE, BountyBlocks.POTTED_GLACIAL_FOXGLOVE,
                BountyBlocks.FLAME_LILY, BountyBlocks.POTTED_FLAME_LILY,
                BountyBlocks.VOID_LILY, BountyBlocks.POTTED_VOID_LILY,
                BountyBlocks.ZAP_LILY, BountyBlocks.POTTED_ZAP_LILY,
                BountyBlocks.FROST_LILY, BountyBlocks.POTTED_FROST_LILY,

                BountyBlocks.SCARLET_WILDFLOWERS, BountyBlocks.MIDNIGHT_WILDFLOWERS, BountyBlocks.FROSTY_WILDFLOWERS,
                BountyBlocks.ENCHANTED_WILDFLOWERS, BountyBlocks.DUSK_WILDFLOWERS);

    }
}
