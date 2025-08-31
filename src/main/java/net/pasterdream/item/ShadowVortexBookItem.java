
package net.pasterdream.item;

import net.pasterdream.procedures.ShadowVortexBookPr1Procedure;
import net.pasterdream.procedures.ShadowVortexBookPr0Procedure;
import net.pasterdream.entity.ShadowVortexBookProjectileEntity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ShadowVortexBookItem extends Item {
	public ShadowVortexBookItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0f;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7e\u6697\u5F71\u6CD5\u672F"));
		list.add(Component.literal("\u00A77\u6F5C\u884C\u91CA\u653E\u6280\u80FD\u547D\u4E2D\u540E\u5C06\u5728\u843D\u70B9\u5C55\u5F00\u6697\u5F71\u65CB\u6DA1"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u5BF9\u6697\u5F71\u65CB\u6DA1\u8303\u56F4\u5185\u7684\u6240\u6709\u654C\u4EBA\u9020\u6210\u4F24\u5BB3\u5E76\u51CF\u901F"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u5982\u91CA\u653E\u6697\u5F71\u65CB\u6DA1\u5C06\u4F7F\u6D88\u8017\u548C\u51B7\u5374\u63D0\u5347\u81F3(10-\u6CD5\u672F\u5F3A\u5EA6)\u500D"));
		list.add(Component.literal("\u00A77\u25AA \u00A74\u878D\u68A6\u80FD\u91CF\u6D88\u8017\uFF1A0.01"));
		list.add(Component.literal("\u00A77\u25AA \u00A74\u7CBE\u795E\u503C\u6D88\u8017\uFF1A0.05"));
		list.add(Component.literal("\u00A72\u6CD5\u672F\u4F24\u5BB3\uFF1A12"));
		list.add(Component.literal("\u00A72\u6CD5\u7403\u52A8\u80FD\uFF1A0.7"));
		list.add(Component.literal("\u00A72\u65BD\u6CD5\u51B7\u5374\uFF1A1.2\u79D2"));
		list.add(Component.literal("\u00A72\u65BD\u6CD5\u6D88\u8017\uFF1A\u00A7f\u9B54\u6CD5\u77F3"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = InteractionResultHolder.success(entity.getItemInHand(hand));
		entity.startUsingItem(hand);
		return ar;
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (ShadowVortexBookPr1Procedure.execute(entity)) {
				ItemStack stack = ProjectileWeaponItem.getHeldProjectile(entity, e -> e.getItem() == ShadowVortexBookProjectileEntity.PROJECTILE_ITEM.getItem());
				if (stack == ItemStack.EMPTY) {
					for (int i = 0; i < player.getInventory().items.size(); i++) {
						ItemStack teststack = player.getInventory().items.get(i);
						if (teststack != null && teststack.getItem() == ShadowVortexBookProjectileEntity.PROJECTILE_ITEM.getItem()) {
							stack = teststack;
							break;
						}
					}
				}
				if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
					ShadowVortexBookProjectileEntity projectile = ShadowVortexBookProjectileEntity.shoot(world, entity, world.getRandom());
					itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
					if (player.getAbilities().instabuild) {
						projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					} else {
						if (stack.isDamageableItem()) {
							if (stack.hurt(1, world.getRandom(), player)) {
								stack.shrink(1);
								stack.setDamageValue(0);
								if (stack.isEmpty())
									player.getInventory().removeItem(stack);
							}
						} else {
							stack.shrink(1);
							if (stack.isEmpty())
								player.getInventory().removeItem(stack);
						}
					}
					ShadowVortexBookPr0Procedure.execute(world, entity, stack);
				}
			}
		}
	}
}
