
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.client.gui.StoneToolWorkbenchGuiScreen;
import net.wei_bai.technology.client.gui.Primitiveworks1GUIScreen;
import net.wei_bai.technology.client.gui.KnifestonetoolguiScreen;
import net.wei_bai.technology.client.gui.GetabilityguiScreen;
import net.wei_bai.technology.client.gui.ChooseLifeScreen;
import net.wei_bai.technology.client.gui.AwakeningcrystalguiScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TechnologyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TechnologyModMenus.STONE_TOOL_WORKBENCH_GUI, StoneToolWorkbenchGuiScreen::new);
			MenuScreens.register(TechnologyModMenus.GETABILITYGUI, GetabilityguiScreen::new);
			MenuScreens.register(TechnologyModMenus.KNIFESTONETOOLGUI, KnifestonetoolguiScreen::new);
			MenuScreens.register(TechnologyModMenus.AWAKENINGCRYSTALGUI, AwakeningcrystalguiScreen::new);
			MenuScreens.register(TechnologyModMenus.PRIMITIVEWORKS_1_GUI, Primitiveworks1GUIScreen::new);
			MenuScreens.register(TechnologyModMenus.CHOOSE_LIFE, ChooseLifeScreen::new);
		});
	}
}
