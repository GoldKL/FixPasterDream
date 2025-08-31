
package net.pasterdream.potion;

import net.pasterdream.procedures.DreamharpOfWandererBuffPr2Procedure;
import net.pasterdream.procedures.DreamharpOfWandererBuffPr1Procedure;
import net.pasterdream.procedures.DreamharpOfWandererBuffPr0Procedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DreamharpOfWandererBuffMobEffect extends MobEffect {
	public DreamharpOfWandererBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1934926);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pasterdream.dreamharp_of_wanderer_buff";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		DreamharpOfWandererBuffPr0Procedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DreamharpOfWandererBuffPr2Procedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		DreamharpOfWandererBuffPr1Procedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
