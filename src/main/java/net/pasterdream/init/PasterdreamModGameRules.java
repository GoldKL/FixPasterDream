
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pasterdream.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PasterdreamModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> RANDOMCOORDX = GameRules.register("randomCoordX", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(0));
	public static final GameRules.Key<GameRules.IntegerValue> RANDOMCOORDZ = GameRules.register("randomCoordZ", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(0));
	public static final GameRules.Key<GameRules.BooleanValue> PASTERDREAMDEBUGMODE = GameRules.register("pasterdreamDebugmode", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> PASTERDREAM_WIND_DIRECTION = GameRules.register("pasterdreamWindDirection", GameRules.Category.MISC, GameRules.IntegerValue.create(0));
}
