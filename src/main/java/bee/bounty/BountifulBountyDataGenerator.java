package bee.bounty;

import bee.bounty.datagen.BountyLootGen;
import bee.bounty.datagen.BountyModelGen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BountifulBountyDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BountyModelGen::new);
		pack.addProvider(BountyLootGen::new);

	}
}
