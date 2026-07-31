package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BountyTags {

    public static void init() {}

    public static final TagKey<Biome> CYAN_ROSES = registerBiomeTag("cyan_roses");
    public static final TagKey<Biome> RED_ROSES = registerBiomeTag("red_roses");
    public static final TagKey<Biome> PINK_ROSES = registerBiomeTag("pink_roses");

    public static final TagKey<Biome> PERENNIAL = registerBiomeTag("perennial");
    public static final TagKey<Biome> BLUE_ANEMONE = registerBiomeTag("blue_anemone");
    public static final TagKey<Biome> DUSK_POTENTILLA = registerBiomeTag("dusk_potentilla");

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, BountifulBounty.id(name));
    }

}
