package bee.bounty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class BountyWorldGen extends FabricDynamicRegistryProvider {


    public BountyWorldGen(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        entries.addAll(provider.lookupOrThrow(Registries.PLACED_FEATURE));
        entries.addAll(provider.lookupOrThrow(Registries.FEATURE));
    }

    @Override
    public String getName() {
        return "World Gendering";
    }
}
