/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.pasterdream;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.pasterdream.data.PDBlockTagProvider;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.pasterdream.init.PasterdreamModTabs;
import net.pasterdream.init.PasterdreamModSounds;
import net.pasterdream.init.PasterdreamModPotions;
import net.pasterdream.init.PasterdreamModParticleTypes;
import net.pasterdream.init.PasterdreamModPaintings;
import net.pasterdream.init.PasterdreamModMobEffects;
import net.pasterdream.init.PasterdreamModMenus;
import net.pasterdream.init.PasterdreamModItems;
import net.pasterdream.init.PasterdreamModFluids;
import net.pasterdream.init.PasterdreamModFluidTypes;
import net.pasterdream.init.PasterdreamModEntities;
import net.pasterdream.init.PasterdreamModEnchantments;
import net.pasterdream.init.PasterdreamModBlocks;
import net.pasterdream.init.PasterdreamModBlockEntities;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod(PasterdreamMod.MODID)
public class PasterdreamMod {
	public static final Logger LOGGER = LogManager.getLogger(PasterdreamMod.class);
	public static final String MODID = "pasterdream";

	public PasterdreamMod() {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		PasterdreamModSounds.REGISTRY.register(bus);
		PasterdreamModBlocks.REGISTRY.register(bus);
		PasterdreamModBlockEntities.REGISTRY.register(bus);
		PasterdreamModItems.REGISTRY.register(bus);
		PasterdreamModEntities.REGISTRY.register(bus);
		PasterdreamModEnchantments.REGISTRY.register(bus);
		PasterdreamModTabs.REGISTRY.register(bus);

		PasterdreamModMobEffects.REGISTRY.register(bus);
		PasterdreamModPotions.REGISTRY.register(bus);
		PasterdreamModPaintings.REGISTRY.register(bus);
		PasterdreamModParticleTypes.REGISTRY.register(bus);

		PasterdreamModMenus.REGISTRY.register(bus);
		PasterdreamModFluids.REGISTRY.register(bus);
		PasterdreamModFluidTypes.REGISTRY.register(bus);
	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
	@SubscribeEvent
	public void gatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		boolean server = event.includeServer();
		generator.addProvider(server, new PDBlockTagProvider(packOutput, lookupProvider, existingFileHelper));

	}
}
