
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

public class CarapaxCharmItem extends Item implements ICurioItem {
	public CarapaxCharmItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("2c5819a9-794c-4b46-803e-966ae56c55c9");
	public static final AttributeModifier modifier = new AttributeModifier(MOVEMENT_SPEED_UUID, "generic.movementSpeed", -0.008F, AttributeModifier.Operation.ADDITION);
	public static final UUID ARMOR_UUID = UUID.fromString("9d414944-d593-4e51-b772-cfe163f26f17");
	public static final AttributeModifier modifier0 = new AttributeModifier(ARMOR_UUID, "generic.armor", 2.0F, AttributeModifier.Operation.ADDITION);
	public static final UUID ARMOR_TOUGHNESS_UUID = UUID.fromString("73ad191c-4d7e-4852-9016-7d33e523e3f5");
	public static final AttributeModifier modifier1 = new AttributeModifier(ARMOR_TOUGHNESS_UUID, "generic.armorThoughness", 1.0F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7a\u4F18\u79C0 \u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u62A4\u7532\u503C+2"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u76D4\u7532\u97E7\u6027+1"));
		list.add(Component.literal("\u00A77\u25AA \u00A74\u79FB\u52A8\u901F\u5EA6-8%"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance0 = player.getAttribute(Attributes.ARMOR);
			AttributeInstance instance1 = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
			return instance.getModifier(modifier.getId()) == null 
			&& instance0.getModifier(modifier0.getId()) == null
			&& instance1.getModifier(modifier1.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance0 = player.getAttribute(Attributes.ARMOR);
			AttributeInstance instance1 = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
			if (instance.getModifier(modifier.getId()) == null) instance.addPermanentModifier(modifier);
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
			if (instance1.getModifier(modifier1.getId()) == null) instance1.addPermanentModifier(modifier1);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance0 = player.getAttribute(Attributes.ARMOR);
			AttributeInstance instance1 = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
			instance.removeModifier(modifier.getId());
			instance0.removeModifier(modifier0.getId());
			instance1.removeModifier(modifier1.getId());
		}
	}
}