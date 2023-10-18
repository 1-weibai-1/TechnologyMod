
package net.wei_bai.technology.client.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.wei_bai.technology.network.TechnologyModVariables;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class HealthbarsOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (!entity.getAbilities().instabuild ) {
				Font font=Minecraft.getInstance().font;
				String player_name= entity.getDisplayName().getString();
				int bar = (int) (entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_bar;
				String text1 =(entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_name ;
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						0,  0,
						0, 0,
						230, 53,
						230, 53);
				//font.width(player_name)

				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_name_zhon.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						6,  0,
						0, 0,
						font.width(player_name)+2, 23,
						100, 23);
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_name_you.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						6+ font.width(player_name)+2,  0,
						0, 0,
						6, 23,
						6, 23);

				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_shenming.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						(font.width(player_name)+17),  0,
						0, 0,
						183, 23,
						183, 23);
				//修为
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0_01z.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						0,  25,
						0, 0,
						6, 19,
						6, 19);
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0_01y.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						font.width(text1)+6,  25,
						0, 0,
						6, 19,
						6, 19);
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0_01.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						6,  25,
						0, 0,
						font.width(text1), 19,
						79, 19);
				//修为
				//修为名称
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0_02_2.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						font.width(text1)+17, 27,
						0,0,
						125, 17,
						125, 17);
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0_02_1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						font.width(text1)+17, 27,
						0,0,
						bar, 17,
						125, 17);
				RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/gui/main_hud_0_02.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(),
						font.width(text1)+16, 25,
						0,0,
						127, 19,
						127, 19);
				//修为名称
				Minecraft.getInstance().font.draw(event.getMatrixStack(), text1, (font.width(text1)+6)-font.width(text1), 30.5F, 0);

				Minecraft.getInstance().font.draw(event.getMatrixStack(), player_name, 7, 7.5F, 0);

			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
