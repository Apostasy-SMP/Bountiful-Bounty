package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;

import java.util.concurrent.CompletableFuture;

public class BountyRecipeGen extends FabricRecipeProvider {
    public BountyRecipeGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {

                addFlowerDye(BountyBlocks.TALL_WITHER_ROSE, Items.BLACK_DYE);
                addFlowerDye(BountyBlocks.TALL_CYAN_ROSE, Items.CYAN_DYE);
                addFlowerDye(BountyBlocks.TALL_PINK_ROSE, Items.PINK_DYE);
                addFlowerDye(BountyBlocks.PINK_ROSE, Items.PINK_DYE);
                addFlowerDye(BountyBlocks.CYAN_ROSE, Items.CYAN_DYE);
                addFlowerDye(BountyBlocks.RED_ROSE, Items.RED_DYE);

                addFlowerDye(BountyBlocks.EMERALD_ZINNIA, Items.LIME_DYE);
                addFlowerDye(BountyBlocks.CRIMSON_LILY, Items.ORANGE_DYE);
                addFlowerDye(BountyBlocks.PERENNIAL, Items.PURPLE_DYE);
                addFlowerDye(BountyBlocks.PINWHEEL_DAISY, Items.MAGENTA_DYE);
                addFlowerDye(BountyBlocks.RELIC_FLOWER, Items.BROWN_DYE);
                addFlowerDye(BountyBlocks.OVERWORLDS_BOUNTY, Items.GREEN_DYE);
                addFlowerDye(BountyBlocks.DUSK_TULIP, Items.PURPLE_DYE);
                addFlowerDye(BountyBlocks.BLUE_ANEMONE, Items.BLUE_DYE);
                addFlowerDye(BountyBlocks.DUSK_POTENTILLA, Items.MAGENTA_DYE);

                addFlowerDye(BountyBlocks.DUSK_ZINNIA, Items.BROWN_DYE);
                addFlowerDye(BountyBlocks.DUSK_PERENNIAL, Items.ORANGE_DYE);
                addFlowerDye(BountyBlocks.DUSK_ORCHID, Items.ORANGE_DYE);
                addFlowerDye(BountyBlocks.DUSK_POPPY, Items.RED_DYE);
                addFlowerDye(BountyBlocks.DUSK_ALLIUM, Items.PINK_DYE);
                addFlowerDye(BountyBlocks.DUSK_CORNFLOWER, Items.RED_DYE);
                addFlowerDye(BountyBlocks.DUSK_BLUET, Items.MAGENTA_DYE);
                addFlowerDye(BountyBlocks.DUSK_DAISY, Items.PURPLE_DYE);
                addFlowerDye(BountyBlocks.DUSK_LILY, Items.GRAY_DYE);
                addFlowerDye(BountyBlocks.DUSK_DANDELION, Items.BLUE_DYE);


            }

            public void addFlowerDye(Block block, Item item) {
                int amount = block instanceof TallFlowerBlock ? 2 : 1;
                shapeless(RecipeCategory.MISC, item.getDefaultInstance().copyWithCount(amount))
                        .requires(block)
                        .unlockedBy(getHasName(item), has(ItemTags.FLOWERS))
                        .save(output, getItemName(item) + "_from_" + getItemName(block));
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe gen";
    }
}
