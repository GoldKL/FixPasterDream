package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class InsandBuffPr1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get()).getBaseValue() + 2));
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() - 0.03));
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
					.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getBaseValue() - 0.4));
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue() - 2));
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SKILLCD.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SKILLCD.get()).getBaseValue() + 1));
			((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getBaseValue() - 0.2));
			((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.BLOCK_REACH.get()).getBaseValue() - 0.2));
		}
	}
}
