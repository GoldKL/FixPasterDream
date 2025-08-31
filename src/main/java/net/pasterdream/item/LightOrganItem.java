
package net.pasterdream.item;

import net.pasterdream.procedures.LightOrganPr0Procedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class LightOrganItem extends Item {
	public LightOrganItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u98DF\u7528\u540E\u83B7\u5F97\u6548\u679C:"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u53D1\u5149I (0:05)"));
		list.add(Component.literal("\u00A77\u25AA \u00A74\u7CBE\u795E\u503C\u6D88\u8017 san -1"));
		list.add(Component.literal("\u00A77\u00A7o\u9ECF\u7CCA\u7CCA\u7684\u6C41\u6DB2\u7167\u4EAE\u4E86\u4F60\u7684\u53E3\u8154"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		LightOrganPr0Procedure.execute(entity);
		return retval;
	}
}
