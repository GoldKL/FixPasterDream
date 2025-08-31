package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TerrorbeakPr1Procedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (((LivingEntity) sourceentity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > 0) {
			((LivingEntity) sourceentity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) sourceentity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() - 0.02));
		}
	}
}
