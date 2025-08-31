
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

public class Hithard0RingItem extends Item implements ICurioItem {
	public Hithard0RingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID ATTACK_DAMAGE_UUID = UUID.fromString("b0d56098-8185-4a4b-b34c-978035c6c816");
	public static final AttributeModifier modifier = new AttributeModifier(ATTACK_DAMAGE_UUID, "generic.attackDamage", 0.5F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7f\u666E\u901A \u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u653B\u51FB\u529B+0.5"));
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
			AttributeInstance instance = player.getAttribute(Attributes.ATTACK_DAMAGE);
			if (instance.getModifier(modifier.getId()) == null)
			instance.addPermanentModifier(modifier);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.ATTACK_DAMAGE);
			instance.removeModifier(modifier.getId());
		}
	}
}
