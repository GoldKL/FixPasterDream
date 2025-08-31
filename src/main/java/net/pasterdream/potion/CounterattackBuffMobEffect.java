
package net.pasterdream.potion;

import net.pasterdream.procedures.CounterattackBuffPr1Procedure;
import net.pasterdream.procedures.CounterattackBuffPr0Procedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CounterattackBuffMobEffect extends MobEffect {
	public CounterattackBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -7426603);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pasterdream.counterattack_buff";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		CounterattackBuffPr0Procedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		CounterattackBuffPr1Procedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
