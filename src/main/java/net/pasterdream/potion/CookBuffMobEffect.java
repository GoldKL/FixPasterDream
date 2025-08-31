
package net.pasterdream.potion;

import net.pasterdream.procedures.CookBuffPr0Procedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CookBuffMobEffect extends MobEffect {
	public CookBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1186157);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pasterdream.cook_buff";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CookBuffPr0Procedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
