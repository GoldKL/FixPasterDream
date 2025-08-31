
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

public class FourleafCloverCurioItem extends Item implements ICurioItem {
	public FourleafCloverCurioItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID HEALTH_UUID = UUID.fromString("055dac74-49cf-474c-9078-f658a61f7047");
	public static final AttributeModifier modifier0 = new AttributeModifier(HEALTH_UUID, "generic.maxHealth", 1.0F, AttributeModifier.Operation.ADDITION);
	public static final UUID LUCK_UUID = UUID.fromString("f723cde2-ecbf-45d1-b985-8670b2f00fd2");
	public static final AttributeModifier modifier1 = new AttributeModifier(LUCK_UUID, "pasterdream.luck", 6.0F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7a\u4F18\u79C0 \u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u5E78\u8FD0+6"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6700\u5927\u751F\u547D\u503C+1"));
		list.add(Component.literal("\u00A77\u00A7o\u54EA\u7247\u53F6\u5B50\u4EE3\u8868\u7740\u5E78\u8FD0\uFF1F"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.LUCK.get());
			return instance0.getModifier(modifier0.getId()) == null 
			&& instance1.getModifier(modifier1.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.LUCK.get());
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
			if (instance1.getModifier(modifier1.getId()) == null) instance1.addPermanentModifier(modifier1);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.LUCK.get());
			instance0.removeModifier(modifier0.getId());
			instance1.removeModifier(modifier1.getId());
			player.setHealth(player.getMaxHealth());
		}
	}
}
