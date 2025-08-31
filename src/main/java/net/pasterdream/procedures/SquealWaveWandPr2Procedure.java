package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class SquealWaveWandPr2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() >= 0.01 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() >= 0.02
				|| (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false);
	}
}
