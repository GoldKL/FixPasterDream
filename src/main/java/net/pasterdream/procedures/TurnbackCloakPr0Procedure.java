package net.pasterdream.procedures;

import net.minecraft.world.item.ItemStack;

public class TurnbackCloakPr0Procedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("cloak_cd") > 0) {
			itemstack.getOrCreateTag().putDouble("cloak_cd", (itemstack.getOrCreateTag().getDouble("cloak_cd") - 1));
		}
	}
}
