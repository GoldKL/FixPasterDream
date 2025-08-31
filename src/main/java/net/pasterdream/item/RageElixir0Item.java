
package net.pasterdream.item;

import net.pasterdream.procedures.RageElixir0Pr0Procedure;
import net.pasterdream.init.PasterdreamModItems;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RageElixir0Item extends Item {
	public RageElixir0Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u996E\u7528\u540E\u83B7\u5F97\u6548\u679C:"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u57FA\u7840\u653B\u51FB\u901F\u5EA6+0.1"));
		list.add(Component.literal("\u00A7e\u6B64\u6548\u679C\u5C06\u6C38\u7EED\u5B58\u5728\uFF0C\u76F4\u81F3\u6B7B\u4EA1"));
		list.add(Component.literal("\u00A7b\u540C\u7C7B\u7075\u836F\u6548\u679C\u53D6\u6700\u9AD8(\u4E0D\u53E0\u52A0)"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(PasterdreamModItems.ELIXIR_BOTTLE.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		RageElixir0Pr0Procedure.execute(world, x, y, z, entity);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}
