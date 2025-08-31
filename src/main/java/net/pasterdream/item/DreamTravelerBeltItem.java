
package net.pasterdream.item;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.pasterdream.init.PasterdreamModTabs;
import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.UUID;

public class DreamTravelerBeltItem extends Item implements ICurioItem {
	public DreamTravelerBeltItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("90b8eab4-a72e-4182-9129-690bbd6495f9");
	public static final AttributeModifier modifier = new AttributeModifier(MOVEMENT_SPEED_UUID, "generic.movementSpeed", 0.003F, AttributeModifier.Operation.ADDITION);
	public static final UUID TELEPORTATIONCD_UUID = UUID.fromString("54fe729a-ac7d-4985-8c91-9bf70562e890");
	public static final AttributeModifier modifier0 = new AttributeModifier(TELEPORTATIONCD_UUID, "pasterdream.teleportationCd", -0.1F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7b\u7CBE\u826F \u2605\u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u79FB\u52A8\u901F\u5EA6+3%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u51B7\u5374\u65F6\u95F4-10%"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get());
			return instance.getModifier(modifier.getId()) == null 
			&& instance0.getModifier(modifier0.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get());
			if (instance.getModifier(modifier.getId()) == null) instance.addPermanentModifier(modifier);
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get());
			instance.removeModifier(modifier.getId());
			instance0.removeModifier(modifier0.getId());
		}
	}
}