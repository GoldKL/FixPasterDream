
package net.pasterdream.item;

import net.pasterdream.procedures.Buncake6Pr0Procedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Buncake6Item extends Item {
	public Buncake6Item() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.7f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 16;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u98DF\u7528\u540E\u83B7\u5F97\u6548\u679C:"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u751F\u547D\u6062\u590DI (0:10)"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6599\u7406I (1:00)"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Buncake6Pr0Procedure.execute(world, x, y, z, entity, itemstack);
		return retval;
	}
}
