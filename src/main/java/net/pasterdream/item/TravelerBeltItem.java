
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

public class TravelerBeltItem extends Item implements ICurioItem {
	public TravelerBeltItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID TELEPORTATIONCONSUME_UUID = UUID.fromString("e54ab0c4-1bb8-476e-bb61-e7cb6830c4d2");
	public static final AttributeModifier modifier0 = new AttributeModifier(TELEPORTATIONCONSUME_UUID, "pasterdream.teleportationConsume", -0.5F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7f\u666E\u901A \u2605"));
		list.add(Component.literal("\u00a77\u25aa \u00a79\u77ac\u8eab\u672f\u9971\u98df\u6d88\u8017-50%"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			return instance0.getModifier(modifier0.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			if (instance0.getModifier(modifier0.getId()) == null)
			instance0.addPermanentModifier(modifier0);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			instance0.removeModifier(modifier0.getId());
		}
	}
}
