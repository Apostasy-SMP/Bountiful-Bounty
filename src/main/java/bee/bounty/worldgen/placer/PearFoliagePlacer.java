package bee.bounty.worldgen.placer;

import bee.bounty.registry.BountyFoliagePlacerTypes;
import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PearFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PearFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((i) -> blobParts(i).apply(i, PearFoliagePlacer::new));
    protected final int height;

    protected static <P extends PearFoliagePlacer> Products.P3<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, Integer> blobParts(final RecordCodecBuilder.Instance<P> instance) {
        return foliagePlacerParts(instance).and(Codec.intRange(0, 16).fieldOf("height").forGetter((p) -> p.height));
    }

    public PearFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }


    @Override
    protected FoliagePlacerType<?> type() {
        return BountyFoliagePlacerTypes.PEAR_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int treeHeight, FoliageAttachment foliageAttachment, int foliageHeight, int leafRadius, int offset) {
        for (int yo = offset; yo >= offset - foliageHeight; --yo) {
            int currentRadius = leafRadius + (yo != offset && yo != offset - foliageHeight ? 1 : 0);
            this.placeLeavesRow(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, foliageAttachment.pos(), currentRadius, yo, foliageAttachment.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return this.height;
    }


    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        float offset = y < -2 && y > -7 ? 0.5f : 0f;
        return Mth.square((float) dx + 0.5F) + Mth.square((float) dz + 0.5F) > ((currentRadius - offset) * currentRadius);
    }
}
