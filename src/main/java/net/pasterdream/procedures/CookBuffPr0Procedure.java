package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModMobEffects;
import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class CookBuffPr0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()) != null) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PasterdreamModMobEffects.COOK_BUFF.get()) ? _livEnt.getEffect(PasterdreamModMobEffects.COOK_BUFF.get()).getAmplifier() : 0) == 0) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() + 0.001));
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PasterdreamModMobEffects.COOK_BUFF.get()) ? _livEnt.getEffect(PasterdreamModMobEffects.COOK_BUFF.get()).getAmplifier() : 0) == 1) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() + 0.002));
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PasterdreamModMobEffects.COOK_BUFF.get()) ? _livEnt.getEffect(PasterdreamModMobEffects.COOK_BUFF.get()).getAmplifier() : 0) >= 2) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() + 0.003));
			}
		}
	}
}
