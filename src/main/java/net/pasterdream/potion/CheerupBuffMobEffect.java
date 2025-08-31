
package net.pasterdream.potion;

import net.pasterdream.procedures.CheerupBuffPr1Procedure;
import net.pasterdream.procedures.CheerupBuffPr0Procedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CheerupBuffMobEffect extends MobEffect {
	public CheerupBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -33158);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pasterdream.cheerup_buff";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		CheerupBuffPr0Procedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		CheerupBuffPr1Procedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
