
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

public class BobojiCurioItem extends Item implements ICurioItem {
	public BobojiCurioItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public static final UUID TELEPORTATIONCD_UUID = UUID.fromString("aacc6573-c216-4d94-a67b-e72377bbdd32");
	public static final AttributeModifier modifier0 = new AttributeModifier(TELEPORTATIONCD_UUID, "pasterdream.teleportationCd", -0.2F, AttributeModifier.Operation.ADDITION);
	public static final UUID TELEPORTATIONRANGE_UUID = UUID.fromString("a3cad91f-ed19-4ea5-a904-f65078ecf73e");
	public static final AttributeModifier modifier1 = new AttributeModifier(TELEPORTATIONRANGE_UUID, "pasterdream.teleportationConsume", 0.1F, AttributeModifier.Operation.ADDITION);
	public static final UUID TELEPORTATIONCONSUME_UUID = UUID.fromString("32144ee0-f98a-48cf-964e-3c6b19c89350");
	public static final AttributeModifier modifier2 = new AttributeModifier(TELEPORTATIONCONSUME_UUID, "pasterdream.teleportationConsume", -0.4F, AttributeModifier.Operation.ADDITION);
	public static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("7673dac1-b6fb-4ca0-90dd-fd3787c501e4");
	public static final AttributeModifier modifier3 = new AttributeModifier(MOVEMENT_SPEED_UUID, "generic.movementSpeed", 0.005F, AttributeModifier.Operation.ADDITION);


	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u54C1\u8D28\uFF1A\u00A7c\u4F20\u8BF4 \u2605\u2605\u2605\u2605\u2605\u2605\u2605"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u88C5\u5907\u9798\u7FC5\u65F6\u4E0D\u518D\u5EF6\u957F\u77AC\u8EAB\u672F\u51B7\u5374\u65F6\u95F4"));
		list.add(Component.literal("\u00a77\u25aa \u00a79\u4f7f\u7528\u77ac\u8eab\u672f\u65f6\u53ef\u4ee5\u57280.25\u79d2\u5185\u56de\u907f\u4e00\u6b21\u4f24\u5bb3"));
		list.add(Component.literal("\u00a77\u25aa \u00a79\u5982\u9644\u8fd1\u5b58\u5728\u73a9\u5bb6\u5219\u56de\u907f\u65f6\u95f4\u5c06\u5ef6\u957f\u4e00\u500d\u5e76\u5206\u4eab\u7ed9\u9644\u8fd1\u961f\u53cb"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u51B7\u5374\u65F6\u95F4-20%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u51B2\u523A\u8DDD\u79BB+10%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u77AC\u8EAB\u672F\u9971\u98DF\u6D88\u8017-40%"));
		list.add(Component.literal("\u00A77\u25AA \u00A79\u79FB\u52A8\u901F\u5EA6+5%"));
		list.add(Component.literal("\u00A77\u25AA \u00A7e\u77AC\u8EAB\u672F\u589E\u52A0\u97F3\u6548\u548C\u7C92\u5B50\u62D6\u5C3E"));
		list.add(Component.literal("\u00A77\u00A7o\u4EC5\u4EE5\u6B64\u732E\u7ED9\u66FE\u966A\u4F34\u6211\u7684\u5B83"));
		list.add(Component.literal("\u00A77\u00A7o-- \u4E00\u53EA\u540D\u4E3A\u5575\u5575\u9E21\u7684\u9EC4\u7EFF\u8272\u864E\u76AE\u9E66\u9E49"));
	}

	@Override
	public boolean canEquip(SlotContext context, ItemStack itemStack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONRANGE.get());
			AttributeInstance instance2 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance3 = player.getAttribute(Attributes.MOVEMENT_SPEED);
			return instance0.getModifier(modifier0.getId()) == null 
			&& instance1.getModifier(modifier1.getId()) == null
			&& instance2.getModifier(modifier2.getId()) == null
			&& instance3.getModifier(modifier3.getId()) == null;
		}
		return false;
	}

	@Override
	public void onEquip(SlotContext context, ItemStack prevStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONRANGE.get());
			AttributeInstance instance2 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance3 = player.getAttribute(Attributes.MOVEMENT_SPEED);
			if (instance0.getModifier(modifier0.getId()) == null) instance0.addPermanentModifier(modifier0);
			if (instance1.getModifier(modifier1.getId()) == null) instance1.addPermanentModifier(modifier1);
			if (instance2.getModifier(modifier2.getId()) == null) instance2.addPermanentModifier(modifier2);
			if (instance3.getModifier(modifier3.getId()) == null) instance3.addPermanentModifier(modifier3);
		}
	}

	@Override
	public void onUnequip(SlotContext context, ItemStack newStack, ItemStack stack) {
		if (context.entity() instanceof Player player) {
			AttributeInstance instance0 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance1 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONRANGE.get());
			AttributeInstance instance2 = player.getAttribute(PasterdreamModAttributes.TELEPORTATIONCONSUME.get());
			AttributeInstance instance3 = player.getAttribute(Attributes.MOVEMENT_SPEED);
			instance0.removeModifier(modifier0.getId());
			instance1.removeModifier(modifier1.getId());
			instance2.removeModifier(modifier2.getId());
			instance3.removeModifier(modifier3.getId());
		}
	}
}
