
package net.pasterdream.item;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.pasterdream.init.PasterdreamModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.UUID;

public class Health0NecklaceItem extends Item implements ICurioItem {
	public Health0NecklaceItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID HEALTH_UUID = UUID.fromString("997f84d7-f1c0-46ec-9337-5db4733b30ed");
	public static final AttributeModifier modifier = new AttributeModifier(HEALTH_UUID, "generic.maxHealth", 2.0F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7a\u4F18\u79C0 \u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6700\u5927\u751F\u547D\u503C+2"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			return instance.getModifier(modifier.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			if (instance.getModifier(modifier.getId()) == null)
			instance.addPermanentModifier(modifier);
		}
	} 

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			instance.removeModifier(modifier.getId());
			player.setHealth(player.getMaxHealth());
		}
	}
}
