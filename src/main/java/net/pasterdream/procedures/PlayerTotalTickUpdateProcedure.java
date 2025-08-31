package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModMobEffects;
import net.pasterdream.configuration.PasterdreamConfigCommonConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerTotalTickUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("pasterdream_player_total_tick_10") >= (double) PasterdreamConfigCommonConfiguration.PLAYER_TOTAL_TICK_UPDATE.get()) {
			entity.getPersistentData().putDouble("pasterdream_player_total_tick_10", 0);
			SanPr0Procedure.execute(world, entity);
			if ((entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(PasterdreamModMobEffects.WINDPROOF_BUFF.get())) == false) {
				WindDirectionPr1Procedure.execute(world, entity);
				WindDirectionPr2Procedure.execute(world, entity);
			}
		} else {
			entity.getPersistentData().putDouble("pasterdream_player_total_tick_10", (entity.getPersistentData().getDouble("pasterdream_player_total_tick_10") + 1));
		}
	}
}
