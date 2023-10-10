package eu.ansquare.starr.items.testing;

import eu.ansquare.starr.superdude.SuperDudes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SetSuperTypeTesterItem extends Item {
	public SetSuperTypeTesterItem(Settings settings) {
		super(settings);
	}
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
		if(!world.isClient()){
			SuperDudes.applyToPlayer(user, SuperDudes.TEST_SUPER_DUDE);
		}
		return TypedActionResult.success(user.getStackInHand(hand));
	}
}
