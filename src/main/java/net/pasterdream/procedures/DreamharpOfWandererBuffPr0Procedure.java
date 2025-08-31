package net.pasterdream.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.UUID;

public class DreamharpOfWandererBuffPr0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
				.hasModifier((new AttributeModifier(UUID.fromString("95b26210-5417-4712-87ee-3874156c134b"), "dreamharp_of_wanderer_buff_0", 4, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.addPermanentModifier((new AttributeModifier(UUID.fromString("95b26210-5417-4712-87ee-3874156c134b"), "dreamharp_of_wanderer_buff_0", 4, AttributeModifier.Operation.ADDITION)));
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
				.hasModifier((new AttributeModifier(UUID.fromString("21dd6b3c-526f-473e-b64b-8637908fe5d5"), "dreamharp_of_wanderer_buff_1", 0.001, AttributeModifier.Operation.ADDITION)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.addPermanentModifier((new AttributeModifier(UUID.fromString("21dd6b3c-526f-473e-b64b-8637908fe5d5"), "dreamharp_of_wanderer_buff_1", 0.001, AttributeModifier.Operation.ADDITION)));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0));
	}
}
