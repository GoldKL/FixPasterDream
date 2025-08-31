
package net.pasterdream.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class RedDew2RingItem extends Item implements ICurioItem {
	public RedDew2RingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}


	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7f\u666E\u901A \u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6700\u5927\u751F\u547D\u503C+1"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack stack) {
		if (!stack.getOrCreateTag().contains("modifier_uuid")) {
			stack.getOrCreateTag().putUUID("modifier_uuid", UUID.randomUUID());
		}
		return true;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (!stack.getOrCreateTag().contains("modifier_uuid")) {
			stack.getOrCreateTag().putUUID("modifier_uuid", UUID.randomUUID());
		}

		UUID uuid = stack.getOrCreateTag().getUUID("modifier_uuid");

		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			if (instance.getModifier(uuid) == null) {
				instance.addPermanentModifier(createModifier(uuid));
			}
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (!stack.getOrCreateTag().contains("modifier_uuid")) {
			stack.getOrCreateTag().putUUID("modifier_uuid", UUID.randomUUID());
		}

		UUID uuid = stack.getOrCreateTag().getUUID("modifier_uuid");

		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			instance.removeModifier(uuid);
			player.setHealth(player.getMaxHealth());
		}
	}

	private AttributeModifier createModifier(UUID uuid) {
		return new AttributeModifier(uuid, "generic.maxHealth", 3.0F, AttributeModifier.Operation.ADDITION);
	}
}
