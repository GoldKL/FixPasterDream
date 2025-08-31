package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TerrorbeakPr0Procedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (((LivingEntity) sourceentity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 20) {
				((LivingEntity) sourceentity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) sourceentity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() + 7));
			}
		}
	}
}
