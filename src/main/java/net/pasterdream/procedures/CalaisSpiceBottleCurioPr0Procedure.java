package net.pasterdream.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.pasterdream.init.PasterdreamModItems;
import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CalaisSpiceBottleCurioPr0Procedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(PasterdreamModItems.CALAIS_SPICE_BOTTLE_CURIO.get(), lv).isPresent() : false == true) && itemstack.getItem().isEdible()) {
			entity.getPersistentData().putDouble("calais_spice_bottle_random", (Mth.nextInt(RandomSource.create(), 1, 14)));
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") <= 3) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue()
						+ ((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 0.1));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 6) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 7) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 8) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 9) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") == 10) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
			if (entity.getPersistentData().getDouble("calais_spice_bottle_random") >= 11) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,
							(int) (((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0)) * 40), 0));
			}
		}
	}
}
