package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;

import java.util.concurrent.CompletableFuture;

public class BountyRecipeGen extends FabricRecipeProvider {


    public BountyRecipeGen(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {

                addFlowerDye(BountyBlocks.TALL_WITHER_ROSE, Items.DYE.black());
                addFlowerDye(BountyBlocks.TALL_CYAN_ROSE, Items.DYE.cyan());
                addFlowerDye(BountyBlocks.TALL_PINK_ROSE, Items.DYE.pink());
                addFlowerDye(BountyBlocks.PINK_ROSE, Items.DYE.pink());
                addFlowerDye(BountyBlocks.CYAN_ROSE, Items.DYE.cyan());
                addFlowerDye(BountyBlocks.RED_ROSE, Items.DYE.red());

                addFlowerDye(BountyBlocks.EMERALD_ZINNIA, Items.DYE.lime());
                addFlowerDye(BountyBlocks.CRIMSON_LILY, Items.DYE.orange());
                addFlowerDye(BountyBlocks.PERENNIAL, Items.DYE.purple());
                addFlowerDye(BountyBlocks.PINWHEEL_DAISY, Items.DYE.magenta());
                addFlowerDye(BountyBlocks.RELIC_FLOWER, Items.DYE.brown());
                addFlowerDye(BountyBlocks.OVERWORLDS_BOUNTY, Items.DYE.green());
                addFlowerDye(BountyBlocks.DUSK_TULIP, Items.DYE.purple());
                addFlowerDye(BountyBlocks.BLUE_ANEMONE, Items.DYE.blue());
                addFlowerDye(BountyBlocks.DUSK_POTENTILLA, Items.DYE.magenta());

                addFlowerDye(BountyBlocks.DUSK_ZINNIA, Items.DYE.brown());
                addFlowerDye(BountyBlocks.DUSK_PERENNIAL, Items.DYE.orange());
                addFlowerDye(BountyBlocks.DUSK_ORCHID, Items.DYE.orange());
                addFlowerDye(BountyBlocks.DUSK_POPPY, Items.DYE.red());
                addFlowerDye(BountyBlocks.DUSK_ALLIUM, Items.DYE.pink());
                addFlowerDye(BountyBlocks.DUSK_CORNFLOWER, Items.DYE.red());
                addFlowerDye(BountyBlocks.DUSK_BLUET, Items.DYE.magenta());
                addFlowerDye(BountyBlocks.DUSK_DAISY, Items.DYE.purple());
                addFlowerDye(BountyBlocks.DUSK_LILY, Items.DYE.gray());
                addFlowerDye(BountyBlocks.DUSK_DANDELION, Items.DYE.blue());


            }

            public void addFlowerDye(Block block, Item item) {
                int amount = block instanceof TallFlowerBlock ? 2 : 1;
                shapeless(RecipeCategory.MISC, new ItemStackTemplate(item, amount))
                        .requires(block)
                        .unlockedBy(getHasName(item), has(block))
                        .save(output, getItemName(item) + "_from_" + getItemName(block));
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe gen";
    }
}
