package bee.bounty.item;

import bee.bounty.block.FruitLeavesBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.Broken;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BlockItemStateProperties;
import org.jspecify.annotations.Nullable;

public record GrowthProperty() implements RangeSelectItemModelProperty {
    public static final MapCodec<GrowthProperty> MAP_CODEC = MapCodec.unit(new GrowthProperty());
    @Override
    public float get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable ItemOwner itemOwner, int i) {
        if (!(itemStack.getItem() instanceof BlockItem item && item.getBlock().defaultBlockState().hasProperty(FruitLeavesBlock.GROWTH))) return 0;
        BlockItemStateProperties blockState = itemStack.get(DataComponents.BLOCK_STATE);
        return blockState != null ? blockState.get(FruitLeavesBlock.GROWTH) : 0;
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return MAP_CODEC;
    }
}
