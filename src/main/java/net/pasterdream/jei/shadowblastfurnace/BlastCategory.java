package net.pasterdream.jei.shadowblastfurnace;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.pasterdream.PasterdreamMod;
import net.pasterdream.init.PasterdreamModItems;

public final class BlastCategory implements IRecipeCategory<BlastDataRecipe> {
    public static final RecipeType<BlastDataRecipe> BLAST_DATA_RECIPE_RECIPE_TYPE = RecipeType.create(PasterdreamMod.MODID, "dark_blast_recipe", BlastDataRecipe.class);
    private final IGuiHelper helper;

    public BlastCategory(IGuiHelper helper) {
        this.helper = helper;
    }

    @Override
    public RecipeType<BlastDataRecipe> getRecipeType() {
        return BLAST_DATA_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("暗影高炉");
    }

    @Override
    public IDrawable getBackground() {
        // 渲染背景
        return helper.createDrawable(new ResourceLocation(PasterdreamMod.MODID, "textures/screens/shadow_blast_furnace_jei.png"), 0, 0, 128, 103);
    }

    @Override
    public IDrawable getIcon() {
        // 影响上方的贴图，可以渲染物品也可以渲染一个自定义的图片
        return helper.createDrawableItemStack(PasterdreamModItems.SHADOW_BLAST_FURNACE.get().getDefaultInstance());
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BlastDataRecipe recipe, IFocusGroup group) {
        /**
         * INPUT: 原料
         * OUTPUT: 产出物语
         * CATALYST: 燃料
         * READONLY: 只读
         */
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 5)       .addItemStack(recipe.item1);
        builder.addSlot(RecipeIngredientRole.CATALYST, 1, 50)   .addItemStack(recipe.item2);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 37, 86)     .addItemStack(recipe.item3);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 73, 86)     .addItemStack(recipe.item4);
        builder.addSlot(RecipeIngredientRole.CATALYST, 109, 5)  .addItemStack(recipe.item5);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 109, 50)   .addItemStack(recipe.item6);
    }
}
