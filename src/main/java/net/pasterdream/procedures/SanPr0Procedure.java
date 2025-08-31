package net.pasterdream.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.pasterdream.init.PasterdreamModMobEffects;
import net.pasterdream.init.PasterdreamModItems;
import net.pasterdream.init.PasterdreamModAttributes;
import net.pasterdream.configuration.PasterdreamConfigCommonConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

public class SanPr0Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PasterdreamConfigCommonConfiguration.LOW_SAN_DEBUFF.get() == true && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > -100 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.INSAND_BUFF.get(), 20, 2, false, false));
			}
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > 1 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 10) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.INSAND_BUFF.get(), 20, 1, false, false));
			}
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > 10 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 20) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.INSAND_BUFF.get(), 20, 0, false, false));
			}
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > 20 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 40) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.TRANCE_BUFF.get(), 20, 0, false, false));
			}
			if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > 40 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() <= 60) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.LETHARGY_BUFF.get(), 20, 0, false, false));
			}
		}
		if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() >= (double) PasterdreamConfigCommonConfiguration.CHEERUP_BUFF_THRESHOLD_VALUE.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.CHEERUP_BUFF.get(), 20, 0, false, false));
		}
		if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() > 100) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue(100);
		}
		if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() < 0) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue(0);
		}
		if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() > 100) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).setBaseValue(100);
		}
		if (((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() < 0) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).setBaseValue(0);
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(PasterdreamModItems.WHITE_FLOWER_BODY.get(), lv).isPresent() : false == true) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue(((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue());
		} else {
			if ((entity.level().dimension()) == Level.OVERWORLD && (world instanceof Level _lvl34 && _lvl34.isDay()) == false) {
				if (PasterdreamConfigCommonConfiguration.OVERWORLD_NIGHT_LOWERS_SAN.get() == true) {
					((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() - 0.004));
				}
			}
			if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("pasterdream:lamp_shadow_world")))) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() - 0.01));
			}
			if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("pasterdream:aaroncos_arena_world")))) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() - 0.04));
			}
		}
		if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("pasterdream:dyedream_world")))) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() + 0.02));
		}
		if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("pasterdream:wind_journey_world")))) {
			((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.SAN.get()).getBaseValue() + 0.005));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PasterdreamModMobEffects.CLOUDMIST_BUFF.get(), 200, 0, false, false));
		}
	}
}
