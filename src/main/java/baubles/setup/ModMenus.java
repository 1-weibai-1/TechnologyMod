package baubles.setup;


import baubles.api.TechnologyAPI;
import baubles.container.PlayerExpandedContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class
ModMenus {

    private static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TechnologyAPI.MOD_ID);

    public static final RegistryObject<MenuType<PlayerExpandedContainer>> PLAYER_TECHNOLOGY = MENUS.register("player_baubles",
            () -> IForgeMenuType.create((windowId, inv, data) -> new PlayerExpandedContainer(windowId, inv, !inv.player.level.isClientSide)));

    public static void init() {
        MENUS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
