
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.pasterdream.init;

import net.pasterdream.potion.WindproofBuffMobEffect;
import net.pasterdream.potion.VulnerabilityBuffMobEffect;
import net.pasterdream.potion.TurnbackCloakBuffMobEffect;
import net.pasterdream.potion.TranceBuffMobEffect;
import net.pasterdream.potion.TeleportationBuffMobEffect;
import net.pasterdream.potion.TailwindBuffMobEffect;
import net.pasterdream.potion.SnowVowBuffMobEffect;
import net.pasterdream.potion.ShadowSpyonBuffMobEffect;
import net.pasterdream.potion.ShadowSilenceBuffMobEffect;
import net.pasterdream.potion.SculkArmorBuffMobEffect;
import net.pasterdream.potion.RestrainmoveBlockBuffMobEffect;
import net.pasterdream.potion.RestBuffMobEffect;
import net.pasterdream.potion.RapidReactionMobEffect;
import net.pasterdream.potion.MementoBuffMobEffect;
import net.pasterdream.potion.MachineWingEffectMobEffect;
import net.pasterdream.potion.LethargyBuffMobEffect;
import net.pasterdream.potion.InsandBuffMobEffect;
import net.pasterdream.potion.IceSpellBuffMobEffect;
import net.pasterdream.potion.GuardBlockBuffMobEffect;
import net.pasterdream.potion.GrailBuffMobEffect;
import net.pasterdream.potion.GoldenrodTeaBuffMobEffect;
import net.pasterdream.potion.FurySpellBuffMobEffect;
import net.pasterdream.potion.FondillusionBuffMobEffect;
import net.pasterdream.potion.FlareupBuffMobEffect;
import net.pasterdream.potion.ExpupBuffMobEffect;
import net.pasterdream.potion.EvasionCloakBuffMobEffect;
import net.pasterdream.potion.EvasionBuffMobEffect;
import net.pasterdream.potion.DyedreamupBuffMobEffect;
import net.pasterdream.potion.DyedreamPerfumeBuffMobEffect;
import net.pasterdream.potion.DyedreamArmorBuffMobEffect;
import net.pasterdream.potion.DreamwishBuffMobEffect;
import net.pasterdream.potion.DreamharpOfWandererBuffMobEffect;
import net.pasterdream.potion.DeadwindBuffMobEffect;
import net.pasterdream.potion.CounterattackBuffMobEffect;
import net.pasterdream.potion.CookBuffMobEffect;
import net.pasterdream.potion.ConfusionBuffMobEffect;
import net.pasterdream.potion.CloudmistBuffMobEffect;
import net.pasterdream.potion.CheerupBuffMobEffect;
import net.pasterdream.potion.BobojiBuffMobEffect;
import net.pasterdream.potion.BindBuffMobEffect;
import net.pasterdream.PasterdreamMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class PasterdreamModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PasterdreamMod.MODID);
	public static final RegistryObject<MobEffect> DREAMWISH_BUFF = REGISTRY.register("dreamwish_buff", () -> new DreamwishBuffMobEffect());
	public static final RegistryObject<MobEffect> DYEDREAMUP_BUFF = REGISTRY.register("dyedreamup_buff", () -> new DyedreamupBuffMobEffect());
	public static final RegistryObject<MobEffect> SCULK_ARMOR_BUFF = REGISTRY.register("sculk_armor_buff", () -> new SculkArmorBuffMobEffect());
	public static final RegistryObject<MobEffect> DYEDREAM_ARMOR_BUFF = REGISTRY.register("dyedream_armor_buff", () -> new DyedreamArmorBuffMobEffect());
	public static final RegistryObject<MobEffect> EXPUP_BUFF = REGISTRY.register("expup_buff", () -> new ExpupBuffMobEffect());
	public static final RegistryObject<MobEffect> TELEPORTATION_BUFF = REGISTRY.register("teleportation_buff", () -> new TeleportationBuffMobEffect());
	public static final RegistryObject<MobEffect> FONDILLUSION_BUFF = REGISTRY.register("fondillusion_buff", () -> new FondillusionBuffMobEffect());
	public static final RegistryObject<MobEffect> FLAREUP_BUFF = REGISTRY.register("flareup_buff", () -> new FlareupBuffMobEffect());
	public static final RegistryObject<MobEffect> RAPID_REACTION = REGISTRY.register("rapid_reaction", () -> new RapidReactionMobEffect());
	public static final RegistryObject<MobEffect> GRAIL_BUFF = REGISTRY.register("grail_buff", () -> new GrailBuffMobEffect());
	public static final RegistryObject<MobEffect> CONFUSION_BUFF = REGISTRY.register("confusion_buff", () -> new ConfusionBuffMobEffect());
	public static final RegistryObject<MobEffect> INSAND_BUFF = REGISTRY.register("insand_buff", () -> new InsandBuffMobEffect());
	public static final RegistryObject<MobEffect> TRANCE_BUFF = REGISTRY.register("trance_buff", () -> new TranceBuffMobEffect());
	public static final RegistryObject<MobEffect> LETHARGY_BUFF = REGISTRY.register("lethargy_buff", () -> new LethargyBuffMobEffect());
	public static final RegistryObject<MobEffect> CHEERUP_BUFF = REGISTRY.register("cheerup_buff", () -> new CheerupBuffMobEffect());
	public static final RegistryObject<MobEffect> REST_BUFF = REGISTRY.register("rest_buff", () -> new RestBuffMobEffect());
	public static final RegistryObject<MobEffect> COOK_BUFF = REGISTRY.register("cook_buff", () -> new CookBuffMobEffect());
	public static final RegistryObject<MobEffect> GUARD_BLOCK_BUFF = REGISTRY.register("guard_block_buff", () -> new GuardBlockBuffMobEffect());
	public static final RegistryObject<MobEffect> RESTRAINMOVE_BLOCK_BUFF = REGISTRY.register("restrainmove_block_buff", () -> new RestrainmoveBlockBuffMobEffect());
	public static final RegistryObject<MobEffect> GOLDENROD_TEA_BUFF = REGISTRY.register("goldenrod_tea_buff", () -> new GoldenrodTeaBuffMobEffect());
	public static final RegistryObject<MobEffect> SHADOW_SILENCE_BUFF = REGISTRY.register("shadow_silence_buff", () -> new ShadowSilenceBuffMobEffect());
	public static final RegistryObject<MobEffect> BOBOJI_BUFF = REGISTRY.register("boboji_buff", () -> new BobojiBuffMobEffect());
	public static final RegistryObject<MobEffect> MEMENTO_BUFF = REGISTRY.register("memento_buff", () -> new MementoBuffMobEffect());
	public static final RegistryObject<MobEffect> SNOW_VOW_BUFF = REGISTRY.register("snow_vow_buff", () -> new SnowVowBuffMobEffect());
	public static final RegistryObject<MobEffect> DYEDREAM_PERFUME_BUFF = REGISTRY.register("dyedream_perfume_buff", () -> new DyedreamPerfumeBuffMobEffect());
	public static final RegistryObject<MobEffect> SHADOW_SPYON_BUFF = REGISTRY.register("shadow_spyon_buff", () -> new ShadowSpyonBuffMobEffect());
	public static final RegistryObject<MobEffect> CLOUDMIST_BUFF = REGISTRY.register("cloudmist_buff", () -> new CloudmistBuffMobEffect());
	public static final RegistryObject<MobEffect> EVASION_BUFF = REGISTRY.register("evasion_buff", () -> new EvasionBuffMobEffect());
	public static final RegistryObject<MobEffect> TURNBACK_CLOAK_BUFF = REGISTRY.register("turnback_cloak_buff", () -> new TurnbackCloakBuffMobEffect());
	public static final RegistryObject<MobEffect> EVASION_CLOAK_BUFF = REGISTRY.register("evasion_cloak_buff", () -> new EvasionCloakBuffMobEffect());
	public static final RegistryObject<MobEffect> MACHINE_WING_EFFECT = REGISTRY.register("machine_wing_effect", () -> new MachineWingEffectMobEffect());
	public static final RegistryObject<MobEffect> COUNTERATTACK_BUFF = REGISTRY.register("counterattack_buff", () -> new CounterattackBuffMobEffect());
	public static final RegistryObject<MobEffect> DREAMHARP_OF_WANDERER_BUFF = REGISTRY.register("dreamharp_of_wanderer_buff", () -> new DreamharpOfWandererBuffMobEffect());
	public static final RegistryObject<MobEffect> FURY_SPELL_BUFF = REGISTRY.register("fury_spell_buff", () -> new FurySpellBuffMobEffect());
	public static final RegistryObject<MobEffect> ICE_SPELL_BUFF = REGISTRY.register("ice_spell_buff", () -> new IceSpellBuffMobEffect());
	public static final RegistryObject<MobEffect> VULNERABILITY_BUFF = REGISTRY.register("vulnerability_buff", () -> new VulnerabilityBuffMobEffect());
	public static final RegistryObject<MobEffect> TAILWIND_BUFF = REGISTRY.register("tailwind_buff", () -> new TailwindBuffMobEffect());
	public static final RegistryObject<MobEffect> DEADWIND_BUFF = REGISTRY.register("deadwind_buff", () -> new DeadwindBuffMobEffect());
	public static final RegistryObject<MobEffect> WINDPROOF_BUFF = REGISTRY.register("windproof_buff", () -> new WindproofBuffMobEffect());
	public static final RegistryObject<MobEffect> BIND_BUFF = REGISTRY.register("bind_buff", () -> new BindBuffMobEffect());
}
