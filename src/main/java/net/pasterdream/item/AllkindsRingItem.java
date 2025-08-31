
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

public class AllkindsRingItem extends Item implements ICurioItem {
	public AllkindsRingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID HEALTH_UUID = UUID.fromString("0673e4be-d230-11ed-8917-325096b39f47");
	public static final AttributeModifier modifier = new AttributeModifier(HEALTH_UUID, "generic.maxHealth", 4.0F, AttributeModifier.Operation.ADDITION);
    public static final UUID ATTACK_DAMAGE_UUID = UUID.fromString("0673e536-d230-11ed-8130-325096b39f47");
	public static final AttributeModifier modifier0 = new AttributeModifier(ATTACK_DAMAGE_UUID, "generic.attackDamage", 2.0F, AttributeModifier.Operation.ADDITION);
	public static final UUID ATTACK_SPEED_UUID = UUID.fromString("0673e5a4-d230-11ed-8bb0-325096b39f47");
	public static final AttributeModifier modifier1 = new AttributeModifier(ATTACK_SPEED_UUID, "generic.attackSpeed", 0.1F, AttributeModifier.Operation.ADDITION);
	public static final UUID ENTITY_REACH_UUID = UUID.fromString("0673e608-d230-11ed-8948-325096b39f47");
	public static final AttributeModifier modifier2 = new AttributeModifier(ENTITY_REACH_UUID, "generic.entityReach", 0.2F, AttributeModifier.Operation.ADDITION);
	public static final UUID BLOCK_REACH_UUID = UUID.fromString("0673e66c-d230-11ed-aa81-325096b39f47");
	public static final AttributeModifier modifier3 = new AttributeModifier(BLOCK_REACH_UUID, "generic.blockReach", 0.5F, AttributeModifier.Operation.ADDITION);
	public static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("0673e6c6-d230-11ed-9244-325096b39f47");
	public static final AttributeModifier modifier4 = new AttributeModifier(MOVEMENT_SPEED_UUID, "generic.movementSpeed", 0.005F, AttributeModifier.Operation.ADDITION);
	public static final UUID SKILLCD_UUID = UUID.fromString("0673e734-d230-11ed-8007-325096b39f47");
	public static final AttributeModifier modifier5 = new AttributeModifier(SKILLCD_UUID, "pasterdream.skillCd", -0.05F, AttributeModifier.Operation.ADDITION);
	public static final UUID SKILLMULTIPLIER_UUID = UUID.fromString("0673e798-d230-11ed-b8cb-325096b39f47");
	public static final AttributeModifier modifier6 = new AttributeModifier(SKILLMULTIPLIER_UUID, "pasterdream.skillMultiplier", 0.05F, AttributeModifier.Operation.ADDITION);
	public static final UUID TELEPORTATIONCD_UUID = UUID.fromString("54d5eebc-06cc-4ada-87a5-c04247da2506");
	public static final AttributeModifier modifier7 = new AttributeModifier(TELEPORTATIONCD_UUID, "pasterdream.teleportationCd", -0.05F, AttributeModifier.Operation.ADDITION);

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7c\u4F20\u8BF4 \u2605\u2605\u2605\u2605\u2605\u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6700\u5927\u751F\u547D\u503C+4"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u8FD1\u6218\u653B\u51FB\u529B+2"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u653B\u51FB\u901F\u5EA6+0.1"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u653B\u51FB\u8DDD\u79BB+0.2"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u89E6\u53CA\u534A\u5F84+0.5"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u79FB\u52A8\u901F\u5EA6+5%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6280\u80FD\u51B7\u5374-5%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u6218\u6280\u4F24\u5BB3\u500D\u7387+5%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u51B7\u5374-5%"));
		list.add(Component.literal("\u00A77\u00A7o\u805A\u4E07\u8C61\u4E4B\u529B \u94F8\u4EE5\u6B64\u6212"));
		list.add(Component.literal("\u00A77\u00A7o-- \u65AF\u5353\u8D1D\u8389\u25AA\u9EDB\u6B27\u6069"));

	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance0 = player.getAttribute(Attributes.ATTACK_DAMAGE);
			AttributeInstance instance1 = player.getAttribute(Attributes.ATTACK_SPEED);
			AttributeInstance instance2 = player.getAttribute(ForgeMod.ENTITY_REACH.get());
			AttributeInstance instance3 = player.getAttribute(ForgeMod.BLOCK_REACH.get());
			AttributeInstance instance4 = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance5 = player.getAttribute(PasterdreamModAttributes.SKILLCD.get());
			AttributeInstance instance6 = player.getAttribute(PasterdreamModAttributes.SKILLMULTIPLIER.get());
			AttributeInstance instance7 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get());
			return instance.getModifier(modifier.getId()) == null 
			&& instance0.getModifier(modifier0.getId()) == null 
			&& instance1.getModifier(modifier1.getId()) == null
			&& instance2.getModifier(modifier2.getId()) == null
			&& instance3.getModifier(modifier3.getId()) == null
			&& instance4.getModifier(modifier4.getId()) == null
			&& instance5.getModifier(modifier5.getId()) == null
			&& instance6.getModifier(modifier6.getId()) == null
			&& instance7.getModifier(modifier7.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance0 = player.getAttribute(Attributes.ATTACK_DAMAGE);
			AttributeInstance instance1 = player.getAttribute(Attributes.ATTACK_SPEED);
			AttributeInstance instance2 = player.getAttribute(ForgeMod.ENTITY_REACH.get());
			AttributeInstance instance3 = player.getAttribute(ForgeMod.BLOCK_REACH.get());
			AttributeInstance instance4 = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance5 = player.getAttribute(PasterdreamModAttributes.SKILLCD.get());
			AttributeInstance instance6 = player.getAttribute(PasterdreamModAttributes.SKILLMULTIPLIER.get());
			AttributeInstance instance7 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get());
			if (instance.getModifier(modifier.getId()) == null) instance.addPermanentModifier(modifier);
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
			if (instance1.getModifier(modifier1.getId()) == null) instance1.addPermanentModifier(modifier1);
			if (instance2.getModifier(modifier2.getId()) == null) instance2.addPermanentModifier(modifier2);
			if (instance3.getModifier(modifier3.getId()) == null) instance3.addPermanentModifier(modifier3);
			if (instance4.getModifier(modifier4.getId()) == null) instance4.addPermanentModifier(modifier4);
			if (instance5.getModifier(modifier5.getId()) == null) instance5.addPermanentModifier(modifier5);
			if (instance6.getModifier(modifier6.getId()) == null) instance6.addPermanentModifier(modifier6);
			if (instance7.getModifier(modifier7.getId()) == null) instance7.addPermanentModifier(modifier7);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance = player.getAttribute(Attributes.MAX_HEALTH);
			AttributeInstance instance0 = player.getAttribute(Attributes.ATTACK_DAMAGE);
			AttributeInstance instance1 = player.getAttribute(Attributes.ATTACK_SPEED);
			AttributeInstance instance2 = player.getAttribute(ForgeMod.ENTITY_REACH.get());
			AttributeInstance instance3 = player.getAttribute(ForgeMod.BLOCK_REACH.get());
			AttributeInstance instance4 = player.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance instance5 = player.getAttribute(PasterdreamModAttributes.SKILLCD.get());
			AttributeInstance instance6 = player.getAttribute(PasterdreamModAttributes.SKILLMULTIPLIER.get());
			AttributeInstance instance7 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCD.get());
			instance.removeModifier(modifier.getId());
			instance0.removeModifier(modifier0.getId());
			instance1.removeModifier(modifier1.getId());
			instance2.removeModifier(modifier2.getId());
			instance3.removeModifier(modifier3.getId());
			instance4.removeModifier(modifier4.getId());
			instance5.removeModifier(modifier5.getId());
			instance6.removeModifier(modifier6.getId());
			instance7.removeModifier(modifier7.getId());
			player.setHealth(player.getMaxHealth());
		}
	}
}