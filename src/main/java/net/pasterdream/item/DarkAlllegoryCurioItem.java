
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

public class DarkAlllegoryCurioItem extends Item implements ICurioItem {
	public DarkAlllegoryCurioItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}


	public static final UUID MAGICCD_UUID = UUID.fromString("c017c046-643b-4b28-a9a0-7e8134b54900");
	public static final AttributeModifier modifier0 = new AttributeModifier(MAGICCD_UUID, "pasterdream.magicCd", -0.1F, AttributeModifier.Operation.ADDITION);
	public static final UUID MAGIC_POWER_UUID = UUID.fromString("53c0c497-af95-43c7-9d82-46a5916dc442");
	public static final AttributeModifier modifier1 = new AttributeModifier(MAGIC_POWER_UUID, "pasterdream.magicPower", 1.0F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7b\u7CBE\u826F \u2605\u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u65BD\u6CD5\u51B7\u5374-10%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6CD5\u672F\u5F3A\u5EA6+1"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.MAGICCD.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.MAGICPOWER.get());
			return instance0.getModifier(modifier0.getId()) == null 
			&& instance1.getModifier(modifier1.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.MAGICCD.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.MAGICPOWER.get());
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
			if (instance1.getModifier(modifier1.getId()) == null) instance1.addPermanentModifier(modifier1);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.MAGICCD.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.MAGICPOWER.get());
			instance0.removeModifier(modifier0.getId());
			instance1.removeModifier(modifier1.getId());
		}
	}
}