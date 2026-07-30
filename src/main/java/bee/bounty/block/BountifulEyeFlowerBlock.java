package bee.bounty.block;

import bee.bounty.registry.BountyBlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EyeblossomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BountifulEyeFlowerBlock extends EyeblossomBlock {
    public static final IntegerProperty SIZE = BountyBlockProperties.SIZE;

    public BountifulEyeFlowerBlock(Type type, Properties properties) {
        super(type, properties);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SIZE);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (itemStack.is(this.asItem()) && blockState.getValue(SIZE) < 4) {

            level.setBlockAndUpdate(blockPos, blockState.cycle(SIZE));
            player.playSound(blockState.getSoundType().getPlaceSound());
            itemStack.consume(1, player);

            return InteractionResult.SUCCESS;
        }

        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
