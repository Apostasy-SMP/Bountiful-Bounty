package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.worldgen.placer.PearFoliagePlacer;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class BountyFoliagePlacerTypes {
    public static final FoliagePlacerType<PearFoliagePlacer> PEAR_FOLIAGE_PLACER = register("pear_foliage_placer", PearFoliagePlacer.CODEC);

    private static <P extends FoliagePlacer> FoliagePlacerType<P> register(final String name, final MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, BountifulBounty.id(name), new FoliagePlacerType<P>(codec));
    }

    public static void init() {
    }

}
