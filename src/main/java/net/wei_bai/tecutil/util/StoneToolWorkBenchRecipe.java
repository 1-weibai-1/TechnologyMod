package net.wei_bai.tecutil.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.wei_bai.technology.TechnologyMod;

import javax.annotation.Nullable;

public class StoneToolWorkBenchRecipe implements Recipe<Container> {
    private  final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> input0,input1,input2;


    private StoneToolWorkBenchRecipe(ResourceLocation id, ItemStack output,
                                     NonNullList<Ingredient> input0,
                                     NonNullList<Ingredient> input1,
                                     NonNullList<Ingredient> input2) {
        this.id = id;
        this.output = output;
        this.input0 = input0;
        this.input1 = input1;
        this.input2 = input2;
    }

    public static NonNullList<Ingredient> getIngredients(ResourceLocation recipeId, NonNullList<Ingredient> recipeItems) {
        return recipeItems;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        return input0.get(0).test(ItemStack.EMPTY)&&
                input1.get(0).test(ItemStack.EMPTY)&&
                input2.get(0).test(ItemStack.EMPTY);
    }

    @Override
    public ItemStack assemble(Container p_44001_) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return TechnologyModRecipeType.INSTANCE;
    }

    public static class TechnologyModRecipeType implements RecipeType<StoneToolWorkBenchRecipe> {
        private TechnologyModRecipeType() { }
        public static final TechnologyModRecipeType INSTANCE = new TechnologyModRecipeType();
        public static final String ID = "st_workbench_recipe";

    }

    public static class Serializer implements RecipeSerializer<StoneToolWorkBenchRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(TechnologyMod.MODID, "st_workbench_recipe");

        @Override
        public StoneToolWorkBenchRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs0 = NonNullList.withSize(0, Ingredient.EMPTY);
            NonNullList<Ingredient> inputs1 = NonNullList.withSize(1, Ingredient.EMPTY);
            NonNullList<Ingredient> inputs2 = NonNullList.withSize(2, Ingredient.EMPTY);
            for (int i = 0; i < inputs0.size(); i++) {
                inputs0.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            for (int i = 0; i < inputs1.size(); i++) {
                inputs1.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            for (int i = 0; i < inputs2.size(); i++) {
                inputs2.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new  StoneToolWorkBenchRecipe(id, output, inputs0,inputs1,inputs2);
        }

        @Override
        public StoneToolWorkBenchRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            NonNullList<Ingredient> inputs0 = NonNullList.withSize(1, Ingredient.EMPTY);
            NonNullList<Ingredient> inputs1 = NonNullList.withSize(1, Ingredient.EMPTY);
            NonNullList<Ingredient> inputs2 = NonNullList.withSize(1, Ingredient.EMPTY);
            for (int i = 0; i < inputs0.size(); i++) {
                inputs0.set(i, Ingredient.fromNetwork(buffer));
            }
            for (int i = 0; i < inputs1.size(); i++) {
                inputs1.set(i, Ingredient.fromNetwork(buffer));
            }
            for (int i = 0; i < inputs2.size(); i++) {
                inputs2.set(i, Ingredient.fromNetwork(buffer));
            }
            ItemStack output = buffer.readItem();
            return new  StoneToolWorkBenchRecipe(id, output, inputs0, inputs1, inputs2);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, StoneToolWorkBenchRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }
            buffer.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType(){
            return Serializer.castClass(RecipeSerializer.class);
        }

        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }
    }

}
