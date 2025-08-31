package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

public class LegendDragonHornIceCreamPr0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("legend_dragon_horn_ice_cream") != true) {
			entity.getPersistentData().putBoolean("legend_dragon_horn_ice_cream", true);
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.LUCK.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.LUCK.get()).getBaseValue() + 10));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7e\u5473\u9053\u6709\u4E9B\u719F\u6089\uFF0C\u597D\u50CF\u662F\u6765\u81EA\u96EA\u6CEA\u5BD2..."), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7e\u7B49\u7B49\uFF1F"), false);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SNOWFLAKE, x, (y + 3), z, 128, 2, 0.5, 2, 1);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u4F60\u5DF2\u7ECF\u54C1\u5C1D\u8FC7\u8FD9\u4E2A\u51B0\u6DC7\u6DCB\u7684\u5473\u9053\u4E86"), false);
		}
	}
}
