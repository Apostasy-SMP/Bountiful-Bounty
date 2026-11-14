package bee.bounty.datagen;

import bee.bounty.registry.BountyBlocks;
import bee.bounty.registry.BountyItems;
import bee.bounty.registry.BountyTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.flag.FeatureFlags;
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
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipes) {
        return new RecipeProvider(registries, recipes) {
            @Override
            public void buildRecipes() {

                addFlowerDye(BountyBlocks.BLACK_SUNFLOWER, Items.BLACK_DYE);
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

                addFlowerDye(BountyBlocks.HALO_FLOWER, Items.YELLOW_DYE);
                addFlowerDye(BountyBlocks.ANGEL_BLOSSOM, Items.WHITE_DYE);
                addFlowerDye(BountyBlocks.FARLOW_LILY, Items.PINK_DYE);
                addFlowerDye(BountyBlocks.WHITE_CARNATION, Items.WHITE_DYE);
                addFlowerDye(BountyBlocks.RED_CARNATION, Items.RED_DYE);
                addFlowerDye(BountyBlocks.BLUE_CARNATION, Items.BLUE_DYE);
                addFlowerDye(BountyBlocks.YELLOW_CARNATION, Items.YELLOW_DYE);
                addFlowerDye(BountyBlocks.FOXGLOVE, Items.MAGENTA_DYE);
                addFlowerDye(BountyBlocks.GLACIAL_FOXGLOVE, Items.LIGHT_BLUE_DYE);
                addFlowerDye(BountyBlocks.FLAME_LILY, Items.ORANGE_DYE);
                addFlowerDye(BountyBlocks.VOID_LILY, Items.PURPLE_DYE);
                addFlowerDye(BountyBlocks.FROST_LILY, Items.CYAN_DYE);
                addFlowerDye(BountyBlocks.ZAP_LILY, Items.YELLOW_DYE);

                addFlowerDye(BountyBlocks.SCARLET_WILDFLOWERS, Items.RED_DYE);
                addFlowerDye(BountyBlocks.MIDNIGHT_WILDFLOWERS, Items.MAGENTA_DYE);
                addFlowerDye(BountyBlocks.FROSTY_WILDFLOWERS, Items.LIGHT_GRAY_DYE);
                addFlowerDye(BountyBlocks.ENCHANTED_WILDFLOWERS, Items.BLUE_DYE);
                addFlowerDye(BountyBlocks.DUSK_WILDFLOWERS, Items.BLACK_DYE);


                this.generateRecipes(BountyBlocks.FRUIT_BLOCK_FAMILY, FeatureFlags.VANILLA_SET);

                addCandyRecipe(BountyItems.GLOW_BERRY_CANDY, Items.GLOW_BERRIES);
                addCandyRecipe(BountyItems.SWEET_BERRY_CANDY, Items.SWEET_BERRIES);
                addCandyRecipe(BountyItems.APPLE_CANDY, Items.APPLE);
                addCandyRecipe(BountyItems.GREEN_APPLE_CANDY, BountyItems.GREEN_APPLE);
                addCandyRecipe(BountyItems.LIME_CANDY, BountyItems.LIME);
                addCandyRecipe(BountyItems.LEMON_CANDY, BountyItems.LEMON);
                addCandyRecipe(BountyItems.ORANGE_CANDY, BountyItems.ORANGE);
                addCandyRecipe(BountyItems.CHERRY_CANDY, BountyItems.CHERRY);
                addCandyRecipe(BountyItems.PEAR_CANDY, BountyItems.PEAR);
                addCandyRecipe(BountyItems.BLUE_BERRY_CANDY, BountyItems.PEAR);

                addPieRecipe(BountyItems.GLOW_BERRY_PIE, Items.GLOW_BERRIES);
                addPieRecipe(BountyItems.SWEET_BERRY_PIE, Items.SWEET_BERRIES);
                addPieRecipe(BountyItems.APPLE_PIE, Items.APPLE);
                addPieRecipe(BountyItems.LIME_PIE, BountyItems.LIME);
                addPieRecipe(BountyItems.LEMON_PIE, BountyItems.LEMON);
                addPieRecipe(BountyItems.CHERRY_PIE, BountyItems.CHERRY);
                addPieRecipe(BountyItems.BLUE_BERRY_PIE, BountyItems.CHERRY);

                shapeless(RecipeCategory.FOOD, BountyItems.CHOCOLATE_BAR, 3)
                        .requires(Items.COCOA_BEANS, 2)
                        .requires(Items.SUGAR)
                        .requires(Items.PAPER)
                        .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                        .save(output);

                shapeless(RecipeCategory.FOOD, BountyItems.CANDY_CORN, 16)
                        .requires(Items.SUGAR, 2)
                        .requires(Items.WHITE_DYE)
                        .requires(Items.ORANGE_DYE)
                        .requires(Items.YELLOW_DYE)
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .save(output);

                shapeless(RecipeCategory.FOOD, BountyItems.LEMON_COOKIE, 8)
                        .requires(Items.WHEAT, 2)
                        .requires(Items.SUGAR)
                        .requires(BountyItems.LEMON)
                        .unlockedBy(getHasName(BountyItems.LEMON), has(BountyItems.LEMON))
                        .save(output);


                shapeless(RecipeCategory.FOOD, BountyItems.BLUE_BERRY_COOKIE, 8)
                        .requires(Items.WHEAT, 2)
                        .requires(Items.SUGAR)
                        .requires(BountyItems.BLUE_BERRIES)
                        .unlockedBy(getHasName(BountyItems.BLUE_BERRIES), has(BountyItems.BLUE_BERRIES))
                        .save(output);

                shapeless(RecipeCategory.FOOD, BountyItems.CHERRY_CHOCOLATE_COOKIE, 8)
                        .requires(Items.WHEAT, 1)
                        .requires(BountyItems.CHOCOLATE_BAR)
                        .requires(BountyItems.CHERRY)
                        .unlockedBy(getHasName(BountyItems.CHERRY), has(BountyItems.CHERRY))
                        .save(output);

                shaped(RecipeCategory.TOOLS, BountyItems.LOLLIPOP)
                        .pattern(" s ")
                        .pattern(" fs")
                        .pattern("t  ")
                        .define('s', Items.SUGAR)
                        .define('f', BountyTags.FRUIT)
                        .define('t', Items.STICK)
                        .unlockedBy("has_fruit", has(BountyTags.FRUIT))
                        .save(output);

                planksFromLog(BountyBlocks.FRUIT_PLANKS, BountyTags.FRUIT_LOGS, 4);

                shelf(BountyBlocks.FRUIT_SHELF, BountyBlocks.STRIPPED_FRUIT_LOG);

                shapeless(RecipeCategory.TOOLS, BountyItems.CANDY_BASKET)
                        .requires(Items.PUMPKIN)
                        .requires(Items.PAPER)
                        .requires(Items.BOWL)
                        .unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN))
                        .save(output);
            }

            public void addPieRecipe(Item result, Item fruit) {
                shapeless(RecipeCategory.FOOD, result)
                        .requires(Items.SUGAR)
                        .requires(Items.EGG)
                        .requires(fruit)
                        .unlockedBy(getHasName(fruit), has(fruit))
                        .save(output);
            }

            public void addCandyRecipe(Item result, Item fruit) {
                shapeless(RecipeCategory.FOOD, result, 8)
                        .requires(fruit)
                        .requires(Items.PAPER)
                        .requires(Items.SUGAR)
                        .requires(Items.HONEYCOMB)
                        .unlockedBy(getHasName(fruit), has(fruit))
                        .save(output);
            }

            public void addFlowerDye(Block block, Item item) {
                int amount = block instanceof TallFlowerBlock ? 2 : 1;
                shapeless(RecipeCategory.MISC, item, amount)
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
