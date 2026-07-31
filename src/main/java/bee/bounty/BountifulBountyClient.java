package bee.bounty;

import bee.bounty.registry.BountyBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class BountifulBountyClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
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



	}
}
