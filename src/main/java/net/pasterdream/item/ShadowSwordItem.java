
package net.pasterdream.item;

import net.pasterdream.procedures.ShadowSwordPr2Procedure;
import net.pasterdream.procedures.ShadowSwordPr1Procedure;
import net.pasterdream.procedures.ShadowSwordPr0Procedure;
import net.pasterdream.init.PasterdreamModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ShadowSwordItem extends SwordItem {
	public ShadowSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 1771;
			}

			public float getSpeed() {
				return 0f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PasterdreamModItems.NIGHTMARE_FUEL.get()));
			}
		}, 3, -2.4f, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ShadowSwordPr1Procedure.execute(entity.level(), entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u88AB\u52A8\uFF1A"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6301\u5251\u8005\u7684\u7CBE\u795E\u503C\u8D8A\u4F4E \u9020\u6210\u7684\u4F24\u5BB3\u8D8A\u9AD8"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6700\u9AD8+\u653B\u51FB\u529B\u500D\u738775% \u653B\u51FB\u901F\u5EA6+50%"));
		list.add(Component.literal("\u00A77\u25AA \u00A74\u5F53\u6CA1\u6709\u7CBE\u795E\u503C\u53EF\u4F9B\u6D88\u8017\u65F6 \u6325\u780D\u4F1A\u53CD\u566C\u81EA\u8EAB\u751F\u547D"));
		list.add(Component.literal("\u00A77\u25AA \u00A74\u75AF\u72C2\u5149\u73AF-3.6san/\u5206\u949F"));
		list.add(Component.literal("\u00A77\u00A7o-- \u68A6\u9B47\u6E10\u6E10\u53D8\u5F97\u5C16\u9510\uFF0C\u94F8\u6210\u4E86\u8FD9\u628A\u5229\u5251"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		ShadowSwordPr0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ShadowSwordPr2Procedure.execute(entity);
	}
}
