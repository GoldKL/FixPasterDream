package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class DyedreamPopsiclePr0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() + 0.18));
		if (entity.isOnFire()) {
			entity.setSecondsOnFire((int) (entity.getRemainingFireTicks() / 20 - 5));
		}
	}
}
