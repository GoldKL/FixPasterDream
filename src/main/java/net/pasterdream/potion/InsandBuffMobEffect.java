
package net.pasterdream.potion;

import net.pasterdream.procedures.InsandBuffPr2Procedure;
import net.pasterdream.procedures.InsandBuffPr1Procedure;
import net.pasterdream.procedures.InsandBuffPr0Procedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class InsandBuffMobEffect extends MobEffect {
	public InsandBuffMobEffect() {
		super(MobEffectCategory.HARMFUL, -14744315);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pasterdream.insand_buff";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		InsandBuffPr1Procedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		InsandBuffPr0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		InsandBuffPr2Procedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
