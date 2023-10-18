package net.wei_bai.technology;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;

public class Overlays {

	public static HealthBar healthBar = new HealthBar();
	private static Minecraft minecraft;
	//public static GoodKarmaBar goodkarmabar = new GoodKarmaBar(minecraft);

	public static void registerOverlays() {
		OverlayRegistry.registerOverlayBelow(ForgeIngameGui.CHAT_PANEL_ELEMENT, "healthBar", Overlays.healthBar);
		//OverlayRegistry.registerOverlayTop("Good Karma Bar",Overlays.goodkarmabar);
	}

}
