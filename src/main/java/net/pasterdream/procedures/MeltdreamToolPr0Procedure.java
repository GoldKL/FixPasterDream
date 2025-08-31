package net.pasterdream.procedures;

import net.pasterdream.init.PasterdreamModAttributes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

public class MeltdreamToolPr0Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (itemstack.getDamageValue() >= 1 && ((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() >= 0.01) {
				((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).setBaseValue((((LivingEntity) entity).getAttribute(PasterdreamModAttributes.MELTDREAMENERGY.get()).getBaseValue() - 0.01));
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(-1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}
