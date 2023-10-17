package net.wei_bai.tecutil.util;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wei_bai.technology.TechnologyMod;


public class TechnologyModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE =
            DeferredRegister.create( ForgeRegistries.RECIPE_SERIALIZERS, TechnologyMod.MODID);


    public static final RegistryObject<RecipeSerializer<StoneToolWorkBenchRecipe>>
            STONE_TOOL_WORKBENCH_RECIPE =
            RECIPE.register
                    ("st_workbench_recipe",
                            () ->StoneToolWorkBenchRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        RECIPE.register(eventBus);
    }
}
