
package net.pasterdream.potion;

import net.pasterdream.procedures.RestBuffPr0Procedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RestBuffMobEffect extends MobEffect {
	public RestBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3873025);
	}

	@Override
	public String getDescriptionId() {
		return "effect.pasterdream.rest_buff";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RestBuffPr0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
