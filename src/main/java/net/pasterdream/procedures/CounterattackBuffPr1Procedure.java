package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class CounterattackBuffPr1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
				.removePermanentModifier((new AttributeModifier(UUID.fromString("96dce1cb-768c-49f6-a6c9-ad92d5e554d7"), "counterattack_buff_0", 3, AttributeModifier.Operation.ADDITION)).getId());
		((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SKILLMULTIPLIER.get())
				.removePermanentModifier((new AttributeModifier(UUID.fromString("4011fe09-28db-475d-8a99-59ef70aa1cca"), "counterattack_buff_1", 0.5, AttributeModifier.Operation.ADDITION)).getId());
	}
}
