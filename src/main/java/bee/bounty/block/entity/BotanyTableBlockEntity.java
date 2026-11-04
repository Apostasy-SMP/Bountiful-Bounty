package bee.bounty.block.entity;

import bee.bounty.registry.BountyBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class BotanyTableBlockEntity extends BlockEntity implements MenuProvider {
    public BotanyTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BountyBlockEntities.BOTANY_TABLE, blockPos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }
}
