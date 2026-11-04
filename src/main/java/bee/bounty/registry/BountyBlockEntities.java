package bee.bounty.registry;

import bee.bounty.BountifulBounty;
import bee.bounty.block.entity.BotanyTableBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BountyBlockEntities {

    public static final BlockEntityType<BotanyTableBlockEntity> BOTANY_TABLE = register("botany_table", BotanyTableBlockEntity::new, BountyBlocks.BOTANY_TABLE);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = BountifulBounty.id(name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }


}
