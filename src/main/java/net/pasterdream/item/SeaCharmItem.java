
package net.pasterdream.item;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.pasterdream.init.PasterdreamModTabs;
import net.pasterdream.init.PasterdreamModAttributes;

import net.pasterdream.procedures.HiyoriHeadPr0Procedure;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.UUID;

public class SeaCharmItem extends Item implements ICurioItem {
	public SeaCharmItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID SWIM_SPEED_UUID = UUID.fromString("51284211-4ad4-497a-b588-cea181a65e15");
	public static final AttributeModifier modifier0 = new AttributeModifier(SWIM_SPEED_UUID, "generic.swimSpeed", 0.3F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7a\u4F18\u79C0 \u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6E38\u6CF3\u901F\u5EA6+30%"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(ForgeMod.SWIM_SPEED.get());
			return instance0.getModifier(modifier0.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(ForgeMod.SWIM_SPEED.get());
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(ForgeMod.SWIM_SPEED.get());
			instance0.removeModifier(modifier0.getId());
		}
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		HiyoriHeadPr0Procedure.execute(slotContext.entity());
	}
}
