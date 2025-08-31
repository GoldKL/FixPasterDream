
package net.pasterdream.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.pasterdream.procedures.ShadowBreathPr0Procedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ShadowBreathItem extends Item implements ICurioItem {
	public ShadowBreathItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7b\u7CBE\u826F \u2605\u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u5728\u7CBE\u795E\u503C\u5206\u522B\u4F4E\u4E8E60/40/20\u65F6"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u589E\u52A01/2/4\u70B9\u653B\u51FB\u529B"));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		ShadowBreathPr0Procedure.execute(slotContext.entity());
	}
}
