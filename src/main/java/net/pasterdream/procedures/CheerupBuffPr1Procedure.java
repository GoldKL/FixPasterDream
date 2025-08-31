package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class CheerupBuffPr1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get()).getBaseValue() + 0.1));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
				.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() - 0.005));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
				.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getBaseValue() - 0.05));
		((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SKILLCD.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SKILLCD.get()).getBaseValue() + 0.1));
	}
}
