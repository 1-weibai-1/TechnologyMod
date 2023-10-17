package net.wei_bai.tecutil.util;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.wei_bai.technology.TechnologyMod;
import net.wei_bai.technology.init.TechnologyModBlocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collections;

public class StoneToolWorkBenchRecipeJEI implements IRecipeCategory<StoneToolWorkBenchRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TechnologyMod.MODID, "stone_tool_workbench");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TechnologyMod.MODID, "technology:textures/screens/stone_tool_workbench_gui.png");

    public final IDrawable background;
    public final IDrawable icon;

    public StoneToolWorkBenchRecipeJEI(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 199);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(TechnologyModBlocks.STONETOOLWORKBENCH.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends StoneToolWorkBenchRecipe> getRecipeClass() {
        return StoneToolWorkBenchRecipe.class;
    }



    @Override
    public @NotNull Component getTitle() {
        return new TextComponent("Stone Tool Workbench");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull StoneToolWorkBenchRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT,23, 49).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,52, 21).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,52, 77).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT,121, 49).addItemStacks(Collections.singletonList(recipe.getResultItem()));
    }
}
