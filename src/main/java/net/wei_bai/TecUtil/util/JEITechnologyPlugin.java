package net.wei_bai.TecUtil.util;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.wei_bai.technology.TechnologyMod;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITechnologyPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TechnologyMod.MODID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                StoneToolWorkBenchRecipeJEI(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level.getRecipeManager());
        List<StoneToolWorkBenchRecipe> recipes =rm.getAllRecipesFor(StoneToolWorkBenchRecipe.TechnologyModRecipeType.INSTANCE);
        registration.addRecipes(new RecipeType<>(StoneToolWorkBenchRecipeJEI.UID, StoneToolWorkBenchRecipe.class), recipes);
    }

}
