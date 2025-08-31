package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModMobEffects;
import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class JellyfishMudPr0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()) != null) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() - 3));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.WINDPROOF_BUFF.get(), 1200, 0));
	}
}
