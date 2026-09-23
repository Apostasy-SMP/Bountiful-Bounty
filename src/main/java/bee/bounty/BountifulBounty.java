package bee.bounty;

import bee.bounty.registry.BountyBlockStateOverrides;
import bee.bounty.registry.BountyBlockStateProviderTypes;
import bee.bounty.registry.BountyBlocks;
import bee.bounty.registry.BountyTags;
import bee.bounty.worldgen.BountyPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.storage.loot.entries.LootItem;

public class BountifulBounty implements ModInitializer {
	public static final String MOD_ID = "bounty";


	@Override
	public void onInitialize() {

		BountyBlocks.init();
		BountyTags.init();
		BountyBlockStateProviderTypes.init();
		BountyBlockStateOverrides.init();

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(container -> {
			ResourceLoader.registerBuiltinPack(id("red_rose_bush_retexture"), container, Component.literal("Red Rose Bush Retexture"), PackActivationType.NORMAL);
		});

		LootTableEvents.MODIFY.register((resourceKey, builder, lootTableSource, provider) -> {

			if (resourceKey.identifier().getPath().contains("archaeology")) {
				builder.modifyPools(builder1 -> {
					builder1.add(LootItem.lootTableItem(BountyBlocks.RELIC_FLOWER).setWeight(3));
				});
			}

		});


		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(fabricItemGroupEntries -> {

			fabricItemGroupEntries.insertAfter(Blocks.SUNFLOWER, BountyBlocks.BLACK_SUNFLOWER);
			fabricItemGroupEntries.insertAfter(Blocks.PINK_TULIP, BountyBlocks.DUSK_TULIP);
			fabricItemGroupEntries.insertAfter(Blocks.ROSE_BUSH, BountyBlocks.TALL_WITHER_ROSE);
			fabricItemGroupEntries.insertAfter(BountyBlocks.TALL_WITHER_ROSE, BountyBlocks.TALL_PINK_ROSE);
			fabricItemGroupEntries.insertAfter(BountyBlocks.TALL_PINK_ROSE, BountyBlocks.TALL_CYAN_ROSE);

			fabricItemGroupEntries.insertAfter(Blocks.BLUE_ORCHID, BountyBlocks.DUSK_ORCHID);
			fabricItemGroupEntries.insertAfter(Blocks.ALLIUM, BountyBlocks.DUSK_ALLIUM);
			fabricItemGroupEntries.insertAfter(Blocks.CORNFLOWER, BountyBlocks.DUSK_CORNFLOWER);
			fabricItemGroupEntries.insertAfter(Blocks.AZURE_BLUET, BountyBlocks.DUSK_BLUET);
			fabricItemGroupEntries.insertAfter(Blocks.OXEYE_DAISY, BountyBlocks.DUSK_DAISY);
			fabricItemGroupEntries.insertAfter(Blocks.DANDELION, BountyBlocks.DUSK_DANDELION);
			fabricItemGroupEntries.insertAfter(Blocks.POPPY, BountyBlocks.DUSK_POPPY);
			fabricItemGroupEntries.insertAfter(Blocks.LILY_OF_THE_VALLEY, BountyBlocks.DUSK_LILY);

			fabricItemGroupEntries.insertAfter(BountyBlocks.DUSK_LILY, BountyBlocks.RED_ROSE);
			fabricItemGroupEntries.insertAfter(BountyBlocks.RED_ROSE, BountyBlocks.PINK_ROSE);
			fabricItemGroupEntries.insertAfter(BountyBlocks.PINK_ROSE, BountyBlocks.CYAN_ROSE);
			fabricItemGroupEntries.insertAfter(BountyBlocks.CYAN_ROSE, BountyBlocks.BLUE_ANEMONE);
			fabricItemGroupEntries.insertAfter(BountyBlocks.BLUE_ANEMONE, BountyBlocks.DUSK_POTENTILLA);
			fabricItemGroupEntries.insertAfter(BountyBlocks.DUSK_POTENTILLA, BountyBlocks.EMERALD_ZINNIA);
			fabricItemGroupEntries.insertAfter(BountyBlocks.EMERALD_ZINNIA, BountyBlocks.DUSK_ZINNIA);
			fabricItemGroupEntries.insertAfter(BountyBlocks.DUSK_ZINNIA, BountyBlocks.PERENNIAL);
			fabricItemGroupEntries.insertAfter(BountyBlocks.PERENNIAL, BountyBlocks.DUSK_PERENNIAL);
			fabricItemGroupEntries.insertAfter(BountyBlocks.DUSK_PERENNIAL, BountyBlocks.PINWHEEL_DAISY);
			fabricItemGroupEntries.insertAfter(BountyBlocks.PINWHEEL_DAISY, BountyBlocks.CRIMSON_LILY);
			fabricItemGroupEntries.insertAfter(BountyBlocks.CRIMSON_LILY, BountyBlocks.OVERWORLDS_BOUNTY);

			fabricItemGroupEntries.insertAfter(BountyBlocks.OVERWORLDS_BOUNTY, BountyBlocks.RELIC_FLOWER);

		});


		BiomeModifications.addFeature(
				BiomeSelectors.tag(BountyTags.RED_ROSES),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.RED_ROSES
		);

		BiomeModifications.addFeature(
				BiomeSelectors.tag(BountyTags.CYAN_ROSES),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.CYAN_ROSES
		);

		BiomeModifications.addFeature(
				BiomeSelectors.tag(BountyTags.PINK_ROSES),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.PINK_ROSES
		);

		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheNether(),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.OVERWORLD_BOUNTY
		);

		BiomeModifications.addFeature(
				biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.WARPED_FOREST),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.PINWHEEL_DAISY
		);

		BiomeModifications.addFeature(
				biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.CRIMSON_FOREST),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.CRIMSON_LILY
		);

		BiomeModifications.addFeature(
				BiomeSelectors.tag(ConventionalBiomeTags.IS_COLD_OVERWORLD),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.EMERALD_ZINNIA
		);

		BiomeModifications.addFeature(
				BiomeSelectors.tag(BountyTags.PERENNIAL),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.PERENNIAL
		);

		BiomeModifications.addFeature(
				BiomeSelectors.tag(BountyTags.BLUE_ANEMONE),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.BLUE_ANEMONE
		);

		BiomeModifications.addFeature(
				BiomeSelectors.tag(BountyTags.DUSK_POTENTILLA),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				BountyPlacedFeatures.DUSK_POTENTILLA
		);

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
