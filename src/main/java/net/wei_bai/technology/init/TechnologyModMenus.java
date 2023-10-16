
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.world.inventory.StoneToolWorkbenchGuiMenu;
import net.wei_bai.technology.world.inventory.Primitiveworks1GUIMenu;
import net.wei_bai.technology.world.inventory.KnifestonetoolguiMenu;
import net.wei_bai.technology.world.inventory.GetabilityguiMenu;
import net.wei_bai.technology.world.inventory.ChooseLifeMenu;
import net.wei_bai.technology.world.inventory.AwakeningcrystalguiMenu;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TechnologyModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<StoneToolWorkbenchGuiMenu> STONE_TOOL_WORKBENCH_GUI = register("stone_tool_workbench_gui", (id, inv, extraData) -> new StoneToolWorkbenchGuiMenu(id, inv, extraData));
	public static final MenuType<GetabilityguiMenu> GETABILITYGUI = register("getabilitygui", (id, inv, extraData) -> new GetabilityguiMenu(id, inv, extraData));
	public static final MenuType<KnifestonetoolguiMenu> KNIFESTONETOOLGUI = register("knifestonetoolgui", (id, inv, extraData) -> new KnifestonetoolguiMenu(id, inv, extraData));
	public static final MenuType<AwakeningcrystalguiMenu> AWAKENINGCRYSTALGUI = register("awakeningcrystalgui", (id, inv, extraData) -> new AwakeningcrystalguiMenu(id, inv, extraData));
	public static final MenuType<Primitiveworks1GUIMenu> PRIMITIVEWORKS_1_GUI = register("primitiveworks_1_gui", (id, inv, extraData) -> new Primitiveworks1GUIMenu(id, inv, extraData));
	public static final MenuType<ChooseLifeMenu> CHOOSE_LIFE = register("choose_life", (id, inv, extraData) -> new ChooseLifeMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
