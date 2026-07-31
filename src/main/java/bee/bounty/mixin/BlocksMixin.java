package bee.bounty.mixin;

import bee.bounty.block.BountifulFlowerBlock;
import bee.bounty.block.BountifulWitherRoseBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.function.Function;

@Mixin(Blocks.class)
public abstract class BlocksMixin {


	@ModifyVariable(at = @At("HEAD"), method = "register(Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;", argsOnly = true)
	private static Function<BlockBehaviour.Properties, Block> init(Function<BlockBehaviour.Properties, Block> value, String id) {

		return switch (id) {
			case "red_tulip", "pink_tulip", "white_tulip", "orange_tulip" -> properties -> new BountifulFlowerBlock(MobEffects.WEAKNESS, 7.0F, properties);
            case "dandelion", "blue_orchid" -> properties -> new BountifulFlowerBlock(MobEffects.SATURATION, 0.35F, properties);
			case "poppy" -> properties -> new BountifulFlowerBlock(MobEffects.NIGHT_VISION, 5.0F, properties);
			case "allium" -> properties -> new BountifulFlowerBlock(MobEffects.FIRE_RESISTANCE, 3.0F, properties);
			case "azure_bluet" -> properties -> new BountifulFlowerBlock(MobEffects.BLINDNESS, 11.0F, properties);
			case "oxeye_daisy" -> properties -> new BountifulFlowerBlock(MobEffects.REGENERATION, 7.0F, properties);
			case "cornflower" -> properties -> new BountifulFlowerBlock(MobEffects.JUMP_BOOST, 5.0F, properties);
			case "lily_of_the_valley" -> properties -> new BountifulFlowerBlock(MobEffects.POISON, 11.0F, properties);
			case "wither_rose" -> properties -> new BountifulWitherRoseBlock(MobEffects.WITHER, 7.0F, properties);
			default -> value;
		};
	}
}