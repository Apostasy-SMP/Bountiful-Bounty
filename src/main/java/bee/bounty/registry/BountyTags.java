package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class BountyTags {

    public static void init() {
    }

    public static final TagKey<Biome> CYAN_ROSES = registerBiomeTag("cyan_roses");
    public static final TagKey<Biome> RED_ROSES = registerBiomeTag("red_roses");
    public static final TagKey<Biome> PINK_ROSES = registerBiomeTag("pink_roses");
    public static final TagKey<Biome> PERENNIAL = registerBiomeTag("perennial");
    public static final TagKey<Biome> BLUE_ANEMONE = registerBiomeTag("blue_anemone");
    public static final TagKey<Biome> DUSK_POTENTILLA = registerBiomeTag("dusk_potentilla");

    public static final TagKey<Item> CANDY = TagKey.create(Registries.ITEM, BountifulBounty.id("candy"));
    public static final TagKey<Item> FRUIT = TagKey.create(Registries.ITEM, BountifulBounty.id("fruit"));

    public static final TagKey<Item> FRUIT_LOGS = TagKey.create(Registries.ITEM, BountifulBounty.id("fruit_logs"));

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, BountifulBounty.id(name));
    }

}
