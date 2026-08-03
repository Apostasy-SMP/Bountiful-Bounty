package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.worldgen.BountyFlowerStateProvider;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class BountyBlockStateProviderTypes {

    public static final BlockStateProviderType<BountyFlowerStateProvider> BOUNTY_FLOWER_PROVIDER = register("bounty_flower_provider", BountyFlowerStateProvider.CODEC);

    private static <P extends BlockStateProvider> BlockStateProviderType<P> register(String string, MapCodec<P> mapCodec) {
        return Registry.register(BuiltInRegistries.BLOCKSTATE_PROVIDER_TYPE, BountifulBounty.id(string), new BlockStateProviderType<P>(mapCodec));
    }

    public static void init() {}


}
