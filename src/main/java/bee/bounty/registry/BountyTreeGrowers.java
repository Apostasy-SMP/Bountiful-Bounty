package bee.bounty.registry;

import bee.bounty.worldgen.BountyConfiguredFeatures;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class BountyTreeGrowers {

    public static final TreeGrower APPLE = new TreeGrower("apple", Optional.empty(), Optional.of(BountyConfiguredFeatures.APPLE_TREE), Optional.empty());
    public static final TreeGrower GREEN_APPLE = new TreeGrower("green_apple", Optional.empty(), Optional.of(BountyConfiguredFeatures.GREEN_APPLE_TREE), Optional.empty());
    public static final TreeGrower LIME = new TreeGrower("lime", Optional.empty(), Optional.of(BountyConfiguredFeatures.LIME_TREE), Optional.empty());
    public static final TreeGrower LEMON = new TreeGrower("lemon", Optional.empty(), Optional.of(BountyConfiguredFeatures.LEMON_TREE), Optional.empty());
    public static final TreeGrower ORANGE = new TreeGrower("orange", Optional.empty(), Optional.of(BountyConfiguredFeatures.ORANGE_TREE), Optional.empty());
    public static final TreeGrower CHERRY = new TreeGrower("cherry", Optional.empty(), Optional.of(BountyConfiguredFeatures.CHERRY_TREE), Optional.empty());
    public static final TreeGrower PEAR = new TreeGrower("pear", Optional.empty(), Optional.of(BountyConfiguredFeatures.PEAR_TREE), Optional.empty());

}
