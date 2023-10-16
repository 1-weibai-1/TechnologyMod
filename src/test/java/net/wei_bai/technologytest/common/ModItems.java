package net.wei_bai.technologytest.common;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wei_bai.technologytest.common.technologyitems.FlyAmulet;

public class ModItems {


    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"technologytest");



    public static final RegistryObject<Item> AMULET = ITEMS.register("amulet", () -> new FlyAmulet());

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


}
