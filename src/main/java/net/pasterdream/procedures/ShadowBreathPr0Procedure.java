package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ShadowBreathPr0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 60) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.hasModifier((new AttributeModifier(UUID.fromString("f52f9f3b-656e-4893-87e0-f5ae27023e8e"), "shadow_breath_0", 1, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.addPermanentModifier((new AttributeModifier(UUID.fromString("f52f9f3b-656e-4893-87e0-f5ae27023e8e"), "shadow_breath_0", 1, AttributeModifier.Operation.ADDITION)));
				}
			} else {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.removePermanentModifier((new AttributeModifier(UUID.fromString("f52f9f3b-656e-4893-87e0-f5ae27023e8e"), "shadow_breath_0", 1, AttributeModifier.Operation.ADDITION)).getId());
				}
			}
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 40) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.hasModifier((new AttributeModifier(UUID.fromString("8df45603-b1f5-4ea1-8079-b437b69a7090"), "shadow_breath_1", 2, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.addPermanentModifier((new AttributeModifier(UUID.fromString("8df45603-b1f5-4ea1-8079-b437b69a7090"), "shadow_breath_1", 2, AttributeModifier.Operation.ADDITION)));
				}
			} else {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.removePermanentModifier((new AttributeModifier(UUID.fromString("8df45603-b1f5-4ea1-8079-b437b69a7090"), "shadow_breath_1", 2, AttributeModifier.Operation.ADDITION)).getId());
				}
			}
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 20) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.hasModifier((new AttributeModifier(UUID.fromString("4d9bb555-5644-4848-a7be-63ac931561f1"), "shadow_breath_2", 3, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.addPermanentModifier((new AttributeModifier(UUID.fromString("4d9bb555-5644-4848-a7be-63ac931561f1"), "shadow_breath_2", 3, AttributeModifier.Operation.ADDITION)));
				}
			} else {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.removePermanentModifier((new AttributeModifier(UUID.fromString("4d9bb555-5644-4848-a7be-63ac931561f1"), "shadow_breath_2", 3, AttributeModifier.Operation.ADDITION)).getId());
				}
			}
		}
	}
}
