
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

public class FeatherNecklaceItem extends Item implements ICurioItem {
	public FeatherNecklaceItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}


	public static final UUID TELEPORTATIONCD_UUID = UUID.fromString("c017c046-643b-4b28-a9a0-7e8134b54900");
	public static final AttributeModifier modifier0 = new AttributeModifier(TELEPORTATIONCD_UUID, "pasterdream.teleportationCd", -0.05F, AttributeModifier.Operation.ADDITION);
	public static final UUID TELEPORTATIONRANGE_UUID = UUID.fromString("53c0c497-af95-43c7-9d82-46a5916dc442");
	public static final AttributeModifier modifier1 = new AttributeModifier(TELEPORTATIONRANGE_UUID, "pasterdream.teleportationConsume", 0.2F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7a\u4F18\u79C0 \u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u51B2\u523A\u8DDD\u79BB+20%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u51B7\u5374\u65F6\u95F4-5%"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONRANGE.get());
			return instance0.getModifier(modifier0.getId()) == null 
			&& instance1.getModifier(modifier1.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONRANGE.get());
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
			if (instance1.getModifier(modifier1.getId()) == null) instance1.addPermanentModifier(modifier1);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONRANGE.get());
			instance0.removeModifier(modifier0.getId());
			instance1.removeModifier(modifier1.getId());
		}
	}
}