package eu.ansquare.starr.mixin;

import eu.ansquare.starr.items.wearable.TwoStateWearable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {
	@Shadow
	@Final
	public DefaultedList<Slot> slots;

	@Inject(method = "internalOnSlotClick", at = @At("HEAD"), cancellable = true)
	private void toggleItem(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
		if (slotIndex >= 0 && slotIndex < this.slots.size()) {
			if (button == 1) {
				Slot slot = this.slots.get(slotIndex);
				ItemStack stack = slot.getStack();
				if (stack.getItem() instanceof TwoStateWearable wearable) {
					boolean isSneaking = actionType == SlotActionType.QUICK_MOVE;
					wearable.toggleState(stack, isSneaking);
					ci.cancel();
				}
			}
		}
	}
}