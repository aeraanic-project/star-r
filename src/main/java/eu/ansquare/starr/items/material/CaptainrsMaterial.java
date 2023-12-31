package eu.ansquare.starr.items.material;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CaptainrsMaterial implements ArmorMaterial {
	@Override
	public int getDurability(ArmorItem.ArmorSlot slot) {
		return 10000;
	}

	@Override
	public int getProtection(ArmorItem.ArmorSlot slot) {
		return 1;
	}

	@Override
	public int getEnchantability() {
		return 1;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.DIAMOND);
	}

	@Override
	public String getName() {
		return "captain_rs";
	}

	@Override
	public float getToughness() {
		return 0;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}
}
