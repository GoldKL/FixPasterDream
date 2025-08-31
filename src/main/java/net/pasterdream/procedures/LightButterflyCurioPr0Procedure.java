package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

public class LightButterflyCurioPr0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()) != null) {
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() >= 0.0002 && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, false, false));
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() - 0.0002));
			}
		}
	}
}
