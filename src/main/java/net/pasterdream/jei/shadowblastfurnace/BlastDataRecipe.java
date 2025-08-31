package net.pasterdream.jei.shadowblastfurnace;

import com.google.common.collect.Lists;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.pasterdream.init.PasterdreamModItems;

import java.util.List;

public class BlastDataRecipe {
    ItemStack item1;
    ItemStack item2;
    ItemStack item3;
    ItemStack item4;
    ItemStack item5;
    ItemStack item6;

    public BlastDataRecipe(Item item1, Item item2, Item item3, Item item4, Item item5, Item item6) {
        this.item1 = item1.getDefaultInstance();
        this.item2 = item2.getDefaultInstance();
        this.item3 = item3.getDefaultInstance();
        this.item4 = item4.getDefaultInstance();
        this.item5 = item5.getDefaultInstance();
        this.item6 = item6.getDefaultInstance();
    }

    public static List<BlastDataRecipe> build() {
        return Lists.newArrayList(
                // 申报食谱，目前的食谱要求6份物品
                create(PasterdreamModItems.RUST_BLACK_METAL_GRAIN.get(), PasterdreamModItems.NIGHTMARE_FUEL.get(), PasterdreamModItems.BLACKMETAL_GRAIN.get(), Items.AIR, PasterdreamModItems.SHADOW_LIQUID_BUCKET.get(), Items.BUCKET),
                create(Items.SKELETON_SKULL, PasterdreamModItems.NIGHTMARE_FUEL.get(), Items.WITHER_SKELETON_SKULL, Items.AIR, PasterdreamModItems.SHADOW_LIQUID_BUCKET.get(), Items.BUCKET),
                create(Items.ROSE_BUSH, PasterdreamModItems.NIGHTMARE_FUEL.get(), Items.WITHER_ROSE , Items.AIR, PasterdreamModItems.SHADOW_LIQUID_BUCKET.get(), Items.BUCKET),
                create(Items.STONE, Items.AIR, PasterdreamModItems.SHADOW_STONE.get() , Items.AIR, PasterdreamModItems.SHADOW_LIQUID_BUCKET.get(), Items.BUCKET),
                create(PasterdreamModItems.CLOUD.get(), Items.AIR, PasterdreamModItems.SHADOW_BLOCK.get() , Items.AIR, PasterdreamModItems.SHADOW_LIQUID_BUCKET.get(), Items.BUCKET)
        );
    }

    private static BlastDataRecipe create(Item ... items) {
        return new BlastDataRecipe(items[0], items[1], items[2], items[3], items[4], items[5]);
    }
}
