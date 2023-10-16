
package net.wei_bai.technology.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.wei_bai.technology.procedures.VARAbility6Procedure;
import net.wei_bai.technology.procedures.VARAbility5Procedure;
import net.wei_bai.technology.procedures.VARAbility4Procedure;
import net.wei_bai.technology.procedures.VARAbility3Procedure;
import net.wei_bai.technology.procedures.VARAbility2Procedure;
import net.wei_bai.technology.procedures.VARAbility1Procedure;
import net.wei_bai.technology.procedures.VARAbility0Procedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class AbilityovoOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level;
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			if (true) {
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility0Procedure.execute(entity), posX + 135, posY + -13, -205);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility1Procedure.execute(entity), posX + 81, posY + -13, -205);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility2Procedure.execute(entity), posX + 27, posY + -13, -205);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility3Procedure.execute(entity), posX + -27, posY + -13, -205);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility4Procedure.execute(entity), posX + -81, posY + -13, -205);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility5Procedure.execute(entity), posX + -135, posY + -13, -205);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),

						VARAbility6Procedure.execute(entity), posX + -189, posY + -13, -205);
			}
		}
	}
}
