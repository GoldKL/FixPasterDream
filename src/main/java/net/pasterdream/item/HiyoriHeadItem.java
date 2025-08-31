
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

public class HiyoriHeadItem extends Item implements ICurioItem {
	public HiyoriHeadItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

    public static final UUID HEALTH_UUID = UUID.fromString("7db7368f-03bf-46cb-b7ae-ca8b2777f4f7");
	public static final AttributeModifier modifier = new AttributeModifier(HEALTH_UUID, "generic.maxHealth", 2.0F, AttributeModifier.Operation.ADDITION);
	public static final UUID LUCK_UUID = UUID.fromString("3759b227-3a53-48f9-bedd-67cb69ae28ae");
	public static final AttributeModifier modifier0 = new AttributeModifier(LUCK_UUID, "pasterdream.luck", 15.0F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7d\u53F2\u8BD7 \u2605\u2605\u2605\u2605\u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6700\u5927\u751F\u547D\u503C+2"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u5E78\u8FD0+15"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u7406\u667A\u5149\u73AF+0.96san/\u5206\u949F"));
		list.add(Component.literal("\u00A77\u00A7o-- \u56E0\u4E3A\u5E38\u89C4\u8131\u79BB \u6240\u4EE5creative"));

	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.LUCK.get());
			return instance.getModifier(modifier.getId()) == null
			&& instance0.getModifier(modifier0.getId()) == null ;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.LUCK.get());
			if (instance.getModifier(modifier.getId()) == null) instance.addPermanentModifier(modifier);
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.LUCK.get());
			instance.removeModifier(modifier.getId());
			instance0.removeModifier(modifier0.getId());
			player.setHealth(player.getMaxHealth());
		}
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		HiyoriHeadPr0Procedure.execute(slotContext.entity());
	}
}
